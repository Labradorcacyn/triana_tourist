package com.trianaTourist.cynthiaLab.repo;

import com.trianaTourist.cynthiaLab.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    boolean existsByName(String name);
}

