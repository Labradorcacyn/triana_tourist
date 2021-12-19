package com.trianaTourist.cynthiaLab.repo;

import com.trianaTourist.cynthiaLab.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {

    boolean existsByName(String name);
}
