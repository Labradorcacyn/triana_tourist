package com.trianaTourist.cynthiaLab.validacion.validadores;

import com.trianaTourist.cynthiaLab.repo.CategoriaRepository;
import com.trianaTourist.cynthiaLab.repo.POIRepository;
import com.trianaTourist.cynthiaLab.validacion.anotaciones.UniqueCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCategoryValidator implements ConstraintValidator<UniqueCategory, String> {

    @Autowired
    private CategoriaRepository repository;

    @Override
    public void initialize(UniqueCategory constraintAnnotation) {
    }

    @Override
    public boolean isValid(String categoria, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(categoria) && !repository.existsByName(categoria);
    }
}
