package com.trianaTourist.cynthiaLab.validacion.validadores;

import com.trianaTourist.cynthiaLab.repo.RouteRepository;
import com.trianaTourist.cynthiaLab.validacion.anotaciones.UniqueName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {
    @Autowired
    private RouteRepository repository;

    @Override
    public void initialize(UniqueName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String route, ConstraintValidatorContext constraintValidatorContext) {
        if(repository == null){
            return true;
        }
        return StringUtils.hasText(route) && !repository.existsByName(route);
    }
}
