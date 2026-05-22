package org.serratec.cursos.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.serratec.cursos.Domain.Aluno;
import org.serratec.cursos.Exception.DuplicateEntryException;
import org.serratec.cursos.Exception.ResourceNotFoundException;
import org.serratec.cursos.Repository.AlunoRepository;
import org.serratec.cursos.dto.Request.AlunoRequestDTO;
import org.serratec.cursos.dto.Response.AlunoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoResponseDTO> listarTodos() {
        return alunoRepository.findAll()
        		.stream()
                .map(AlunoResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public AlunoResponseDTO buscarPorId(Long id) {
        Optional<Aluno> optional = alunoRepository.findById(id);
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Aluno não encontrado com id: " + id);
        }
        return AlunoResponseDTO.fromEntity(optional.get());
    }

    public AlunoResponseDTO criar(AlunoRequestDTO dto) {
        if (alunoRepository.existsByEmail(dto.getEmail())) {
            throw new DuplicateEntryException("Já existe um aluno cadastrado com o e-mail: " + dto.getEmail());
        }
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setTelefone(dto.getTelefone());
        aluno.setDataNascimento(dto.getDataNascimento());
        return AlunoResponseDTO.fromEntity(alunoRepository.save(aluno));
    }

    public AlunoResponseDTO atualizar(Long id, AlunoRequestDTO dto) {
        Optional<Aluno> optional = alunoRepository.findById(id);
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Aluno não encontrado com id: " + id);
        }
        Aluno aluno = optional.get();
        if (!aluno.getEmail().equals(dto.getEmail()) && alunoRepository.existsByEmail(dto.getEmail())) {
            throw new DuplicateEntryException("Já existe um aluno cadastrado com o e-mail: " + dto.getEmail());
        }
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setTelefone(dto.getTelefone());
        aluno.setDataNascimento(dto.getDataNascimento());
        return AlunoResponseDTO.fromEntity(alunoRepository.save(aluno));
    }

    public void deletar(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Aluno não encontrado com id: " + id);
        }
        alunoRepository.deleteById(id);
    }
}
