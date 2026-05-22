package org.serratec.cursos.Repository;

import java.util.Optional;

import org.serratec.cursos.Domain.PerfilSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilSocialRepository extends JpaRepository<PerfilSocial, Long> {
    Optional<PerfilSocial> findByAlunoId(Long alunoId);
    boolean existsByAlunoId(Long alunoId);
}
