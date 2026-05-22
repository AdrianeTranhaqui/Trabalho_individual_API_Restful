package org.serratec.cursos.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.serratec.cursos.Domain.Curso;
import org.serratec.cursos.Domain.Professor;
import org.serratec.cursos.Exception.ResourceNotFoundException;
import org.serratec.cursos.Repository.CursoRepository;
import org.serratec.cursos.Repository.ProfessorRepository;
import org.serratec.cursos.dto.Request.CursoRequestDTO;
import org.serratec.cursos.dto.Response.CursoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public List<CursoResponseDTO> listarTodos() {
        return cursoRepository.findAll()
                .stream()
                .map(CursoResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public CursoResponseDTO buscarPorId(Long id) {
        Optional<Curso> optional = cursoRepository.findById(id);
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Curso não encontrado com id: " + id);
        }
        return CursoResponseDTO.fromEntity(optional.get());
    }

    public CursoResponseDTO criar(CursoRequestDTO dto) {
        Optional<Professor> optProf = professorRepository.findById(dto.getProfessorId());
        if (!optProf.isPresent()) {
            throw new ResourceNotFoundException("Professor não encontrado com id: " + dto.getProfessorId());
        }
        Curso curso = new Curso();
        curso.setNome(dto.getNome());
        curso.setDescricao(dto.getDescricao());
        curso.setCargaHoraria(dto.getCargaHoraria());
        curso.setDataInicio(dto.getDataInicio());
        curso.setDataFim(dto.getDataFim());
        curso.setPreco(dto.getPreco());
        curso.setProfessor(optProf.get());
        return CursoResponseDTO.fromEntity(cursoRepository.save(curso));
    }

    public CursoResponseDTO atualizar(Long id, CursoRequestDTO dto) {
        Optional<Curso> optional = cursoRepository.findById(id);
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Curso não encontrado com id: " + id);
        }
        Optional<Professor> optProf = professorRepository.findById(dto.getProfessorId());
        if (!optProf.isPresent()) {
            throw new ResourceNotFoundException("Professor não encontrado com id: " + dto.getProfessorId());
        }
        Curso curso = optional.get();
        curso.setNome(dto.getNome());
        curso.setDescricao(dto.getDescricao());
        curso.setCargaHoraria(dto.getCargaHoraria());
        curso.setDataInicio(dto.getDataInicio());
        curso.setDataFim(dto.getDataFim());
        curso.setPreco(dto.getPreco());
        curso.setProfessor(optProf.get());
        return CursoResponseDTO.fromEntity(cursoRepository.save(curso));
    }

    public void deletar(Long id) {
        if (!cursoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Curso não encontrado com id: " + id);
        }
        cursoRepository.deleteById(id);
    }
}
