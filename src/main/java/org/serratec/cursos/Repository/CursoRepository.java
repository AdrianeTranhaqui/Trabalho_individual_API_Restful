package org.serratec.cursos.Repository;

import java.util.List;

import org.serratec.cursos.Domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByProfessorId(Long professorId);
    boolean existsByNome(String nome);
}
