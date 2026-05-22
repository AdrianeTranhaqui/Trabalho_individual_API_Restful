package org.serratec.cursos.Repository;

import java.util.List;

import org.serratec.cursos.Domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    List<Matricula> findByAlunoId(Long alunoId);
    List<Matricula> findByCursoId(Long cursoId);
    boolean existsByAlunoIdAndCursoId(Long alunoId, Long cursoId);
}
