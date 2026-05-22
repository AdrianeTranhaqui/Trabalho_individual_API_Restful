package org.serratec.cursos.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.serratec.cursos.Domain.Aluno;
import org.serratec.cursos.Domain.PerfilSocial;
import org.serratec.cursos.Exception.DuplicateEntryException;
import org.serratec.cursos.Exception.ResourceNotFoundException;
import org.serratec.cursos.Repository.AlunoRepository;
import org.serratec.cursos.Repository.PerfilSocialRepository;
import org.serratec.cursos.dto.Request.PerfilSocialRequestDTO;
import org.serratec.cursos.dto.Response.PerfilSocialResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilSocialService {

    @Autowired
    private PerfilSocialRepository perfilSocialRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    public List<PerfilSocialResponseDTO> listarTodos() {
        return perfilSocialRepository.findAll()
                .stream()
                .map(PerfilSocialResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public PerfilSocialResponseDTO buscarPorId(Long id) {
        Optional<PerfilSocial> optional = perfilSocialRepository.findById(id);
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Perfil social não encontrado com id: " + id);
        }
        return PerfilSocialResponseDTO.fromEntity(optional.get());
    }

    public PerfilSocialResponseDTO criar(PerfilSocialRequestDTO dto) {
        if (perfilSocialRepository.existsByAlunoId(dto.getAlunoId())) {
            throw new DuplicateEntryException("Já existe um perfil social para o aluno com id: " + dto.getAlunoId());
        }
        Optional<Aluno> optAluno = alunoRepository.findById(dto.getAlunoId());
        if (!optAluno.isPresent()) {
            throw new ResourceNotFoundException("Aluno não encontrado com id: " + dto.getAlunoId());
        }
        PerfilSocial perfil = new PerfilSocial();
        perfil.setRendaFamiliar(dto.getRendaFamiliar());
        perfil.setEscolaridade(dto.getEscolaridade());
        perfil.setAluno(optAluno.get());
        return PerfilSocialResponseDTO.fromEntity(perfilSocialRepository.save(perfil));
    }

    public PerfilSocialResponseDTO atualizar(Long id, PerfilSocialRequestDTO dto) {
        Optional<PerfilSocial> optional = perfilSocialRepository.findById(id);
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Perfil social não encontrado com id: " + id);
        }
        Optional<Aluno> optAluno = alunoRepository.findById(dto.getAlunoId());
        if (!optAluno.isPresent()) {
            throw new ResourceNotFoundException("Aluno não encontrado com id: " + dto.getAlunoId());
        }
        PerfilSocial perfil = optional.get();
        perfil.setRendaFamiliar(dto.getRendaFamiliar());
        perfil.setEscolaridade(dto.getEscolaridade());
        perfil.setAluno(optAluno.get());
        return PerfilSocialResponseDTO.fromEntity(perfilSocialRepository.save(perfil));
    }

    public void deletar(Long id) {
        if (!perfilSocialRepository.existsById(id)) {
            throw new ResourceNotFoundException("Perfil social não encontrado com id: " + id);
        }
        perfilSocialRepository.deleteById(id);
    }
}
