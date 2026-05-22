package org.serratec.cursos.Controller;

import java.util.List;
import org.serratec.cursos.Service.MatriculaService;
import org.serratec.cursos.dto.Request.MatriculaRequestDTO;
import org.serratec.cursos.dto.Response.MatriculaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/matriculas")
@Tag(name = "Matrículas", description = "Operações relacionadas às matrículas de alunos em cursos")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    @Operation(summary = "Listar matrículas", description = "Retorna a lista de todas as matrículas")
    public ResponseEntity<List<MatriculaResponseDTO>> listarTodos() {
        return ResponseEntity.ok(matriculaService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar matrícula por ID", description = "Retorna os dados de uma matrícula específica")
    public ResponseEntity<MatriculaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(matriculaService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Criar matrícula", description = "Matricula um aluno em um curso")
    public ResponseEntity<MatriculaResponseDTO> criar(@Valid @RequestBody MatriculaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(matriculaService.criar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar matrícula", description = "Atualiza os dados de uma matrícula existente")
    public ResponseEntity<MatriculaResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody MatriculaRequestDTO dto) {
        return ResponseEntity.ok(matriculaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Cancelar matrícula", description = "Remove uma matrícula da plataforma")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        matriculaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
