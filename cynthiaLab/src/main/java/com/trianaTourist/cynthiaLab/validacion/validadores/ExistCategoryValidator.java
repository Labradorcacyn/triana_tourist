package com.trianaTourist.cynthiaLab.validacion.validadores;

import com.trianaTourist.cynthiaLab.repo.CategoriaRepository;
import com.trianaTourist.cynthiaLab.validacion.anotaciones.ExistCategory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistCategoryValidator implements ConstraintValidator<ExistCategory, Long> {

    @Autowired
    private CategoriaRepository categoriaRepository;


    @Override
    public void initialize(ExistCategory constraintAnnotation) {}

    @Override
    public boolean isValid(Long s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && categoriaRepository.existsById(s);
    }
}
