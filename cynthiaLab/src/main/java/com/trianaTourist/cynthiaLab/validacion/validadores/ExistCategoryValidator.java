package com.trianaTourist.cynthiaLab.validacion.validadores;

import com.trianaTourist.cynthiaLab.repo.POIRepository;
import com.trianaTourist.cynthiaLab.validacion.anotaciones.ExistCategory;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistCategoryValidator implements ConstraintValidator<ExistCategory, String> {

    @Autowired
    private POIRepository poiRepository;

    private String categoria;
    private boolean resp;

    @Override
    public void initialize(ExistCategory constraintAnnotation) {
        this.categoria = constraintAnnotation.categoria();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Object categoriaValue = PropertyAccessorFactory.forBeanPropertyAccess(categoria).getPropertyValue(categoria);
        this.resp = false;
        poiRepository.findAll().forEach(p->{
            if(!p.getCategoria().equals(categoriaValue))
                this.resp = true;
        });
        return resp;
    }
}
