package com.trianaTourist.cynthiaLab.service;

import com.trianaTourist.cynthiaLab.model.Route;
import com.trianaTourist.cynthiaLab.repo.RouteRepository;
import com.trianaTourist.cynthiaLab.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class RouteService extends BaseService<Route, Long, RouteRepository> {
}
