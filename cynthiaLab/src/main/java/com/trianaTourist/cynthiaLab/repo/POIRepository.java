package com.trianaTourist.cynthiaLab.repo;

import com.trianaTourist.cynthiaLab.model.POI;
import org.springframework.data.jpa.repository.JpaRepository;

public interface POIRepository extends JpaRepository<POI, Long> {

    boolean existsByCategoria(String categoria);
    boolean existsByLocation(String location);
}
