package org.cf.gerenciadordeprojetos.repositories;

import org.cf.gerenciadordeprojetos.models.ProjetoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<ProjetoModel, Long> {
}
