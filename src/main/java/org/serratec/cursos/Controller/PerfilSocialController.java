package org.serratec.cursos.Controller;

import java.net.URI;
import java.util.List;
import org.serratec.cursos.Service.PerfilSocialService;
import org.serratec.cursos.dto.Request.PerfilSocialRequestDTO;
import org.serratec.cursos.dto.Response.PerfilSocialResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/perfis-sociais")
@Tag(name = "Perfis Sociais", description = "Operações relacionadas ao perfil social dos alunos")
public class PerfilSocialController {

    @Autowired
    private PerfilSocialService perfilSocialService;

    @GetMapping
    @Operation(summary = "Listar perfis sociais", description = "Retorna a lista de todos os perfis sociais")
    public ResponseEntity<List<PerfilSocialResponseDTO>> listarTodos() {
        return ResponseEntity.ok(perfilSocialService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar perfil por ID", description = "Retorna os dados de um perfil social específico")
    public ResponseEntity<PerfilSocialResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(perfilSocialService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Criar perfil social", description = "Cria o perfil social de um aluno")
    public ResponseEntity<PerfilSocialResponseDTO> criar(@Valid @RequestBody PerfilSocialRequestDTO dto) {
    	PerfilSocialResponseDTO response = perfilSocialService.criar(dto);
    	
    	URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar perfil social", description = "Atualiza o perfil social de um aluno")
    public ResponseEntity<PerfilSocialResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody PerfilSocialRequestDTO dto) {
        return ResponseEntity.ok(perfilSocialService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover perfil social", description = "Remove o perfil social de um aluno")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        perfilSocialService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}