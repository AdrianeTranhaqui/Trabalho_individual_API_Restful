package org.serratec.cursos.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.serratec.cursos.Domain.Professor;
import org.serratec.cursos.Exception.DuplicateEntryException;
import org.serratec.cursos.Exception.ResourceNotFoundException;
import org.serratec.cursos.Repository.ProfessorRepository;
import org.serratec.cursos.dto.Request.ProfessorRequestDTO;
import org.serratec.cursos.dto.Response.ProfessorResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<ProfessorResponseDTO> listarTodos() {
        return professorRepository.findAll()
                .stream()
                .map(ProfessorResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public ProfessorResponseDTO buscarPorId(Long id) {
        Optional<Professor> optional = professorRepository.findById(id);
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Professor não encontrado com id: " + id);
        }
        return ProfessorResponseDTO.fromEntity(optional.get());
    }

    public ProfessorResponseDTO criar(ProfessorRequestDTO dto) {
        if (professorRepository.existsByEmail(dto.getEmail())) {
            throw new DuplicateEntryException("Já existe um professor cadastrado com o e-mail: " + dto.getEmail());
        }
        Professor professor = new Professor();
        professor.setNome(dto.getNome());
        professor.setEmail(dto.getEmail());
        professor.setEspecialidade(dto.getEspecialidade());
        professor.setTelefone(dto.getTelefone());
        return ProfessorResponseDTO.fromEntity(professorRepository.save(professor));
    }

    public ProfessorResponseDTO atualizar(Long id, ProfessorRequestDTO dto) {
        Optional<Professor> optional = professorRepository.findById(id);
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Professor não encontrado com id: " + id);
        }
        Professor professor = optional.get();
        if (!professor.getEmail().equals(dto.getEmail()) && professorRepository.existsByEmail(dto.getEmail())) {
            throw new DuplicateEntryException("Já existe um professor cadastrado com o e-mail: " + dto.getEmail());
        }
        professor.setNome(dto.getNome());
        professor.setEmail(dto.getEmail());
        professor.setEspecialidade(dto.getEspecialidade());
        professor.setTelefone(dto.getTelefone());
        return ProfessorResponseDTO.fromEntity(professorRepository.save(professor));
    }

    public void deletar(Long id) {
        if (!professorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Professor não encontrado com id: " + id);
        }
        professorRepository.deleteById(id);
    }
}
