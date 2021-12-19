package com.trianaTourist.cynthiaLab.validacion.validadores;

import com.trianaTourist.cynthiaLab.repo.POIRepository;
import com.trianaTourist.cynthiaLab.validacion.anotaciones.LocatedValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LocatedValidValidator implements ConstraintValidator<LocatedValid, String> {
    private String location;

    @Autowired
    private POIRepository poiRepository;

    @Override
    public void initialize(LocatedValid constraintAnnotation) {location = constraintAnnotation.location();}

    @Override
    public boolean isValid(String o, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(o) && !poiRepository.existsByLocation(o);
    }

}
