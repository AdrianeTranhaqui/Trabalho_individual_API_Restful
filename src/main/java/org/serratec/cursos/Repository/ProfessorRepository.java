package org.serratec.cursos.Repository;

import java.util.Optional;

import org.serratec.cursos.Domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Optional<Professor> findByEmail(String email);
    boolean existsByEmail(String email);
}
