package org.serratec.cursos.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.serratec.cursos.Domain.Aluno;
import org.serratec.cursos.Domain.Curso;
import org.serratec.cursos.Domain.Matricula;
import org.serratec.cursos.Exception.DuplicateEntryException;
import org.serratec.cursos.Exception.ResourceNotFoundException;
import org.serratec.cursos.Repository.AlunoRepository;
import org.serratec.cursos.Repository.CursoRepository;
import org.serratec.cursos.Repository.MatriculaRepository;
import org.serratec.cursos.dto.Request.MatriculaRequestDTO;
import org.serratec.cursos.dto.Response.MatriculaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public List<MatriculaResponseDTO> listarTodos() {
        return matriculaRepository.findAll()
                .stream()
                .map(MatriculaResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public MatriculaResponseDTO buscarPorId(Long id) {
        Optional<Matricula> optional = matriculaRepository.findById(id);
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Matrícula não encontrada com id: " + id);
        }
        return MatriculaResponseDTO.fromEntity(optional.get());
    }

    public MatriculaResponseDTO criar(MatriculaRequestDTO dto) {
        if (matriculaRepository.existsByAlunoIdAndCursoId(dto.getAlunoId(), dto.getCursoId())) {
            throw new DuplicateEntryException("Aluno já está matriculado neste curso.");
        }
        Optional<Aluno> optAluno = alunoRepository.findById(dto.getAlunoId());
        if (!optAluno.isPresent()) {
            throw new ResourceNotFoundException("Aluno não encontrado com id: " + dto.getAlunoId());
        }
        Optional<Curso> optCurso = cursoRepository.findById(dto.getCursoId());
        if (!optCurso.isPresent()) {
            throw new ResourceNotFoundException("Curso não encontrado com id: " + dto.getCursoId());
        }
        Matricula matricula = new Matricula();
        matricula.setAluno(optAluno.get());
        matricula.setCurso(optCurso.get());
        if (dto.getStatus() != null) {
            matricula.setStatus(dto.getStatus());
        }
        return MatriculaResponseDTO.fromEntity(matriculaRepository.save(matricula));
    }

    public MatriculaResponseDTO atualizar(Long id, MatriculaRequestDTO dto) {
        Optional<Matricula> optional = matriculaRepository.findById(id);
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Matrícula não encontrada com id: " + id);
        }
        Optional<Aluno> optAluno = alunoRepository.findById(dto.getAlunoId());
        if (!optAluno.isPresent()) {
            throw new ResourceNotFoundException("Aluno não encontrado com id: " + dto.getAlunoId());
        }
        Optional<Curso> optCurso = cursoRepository.findById(dto.getCursoId());
        if (!optCurso.isPresent()) {
            throw new ResourceNotFoundException("Curso não encontrado com id: " + dto.getCursoId());
        }
        Matricula matricula = optional.get();
        matricula.setAluno(optAluno.get());
        matricula.setCurso(optCurso.get());
        if (dto.getStatus() != null) {
            matricula.setStatus(dto.getStatus());
        }
        return MatriculaResponseDTO.fromEntity(matriculaRepository.save(matricula));
    }

    public void deletar(Long id) {
        if (!matriculaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Matrícula não encontrada com id: " + id);
        }
        matriculaRepository.deleteById(id);
    }
}
