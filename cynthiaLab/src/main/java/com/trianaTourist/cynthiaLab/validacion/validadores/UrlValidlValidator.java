package com.trianaTourist.cynthiaLab.validacion.validadores;

import com.trianaTourist.cynthiaLab.validacion.anotaciones.UrlValid;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UrlValidlValidator implements ConstraintValidator<UrlValid, String> {

    private String photoCover;
    private String photo2;
    private String photo3;

    @Override
    public void initialize(UrlValid constraintAnnotation) {
        this.photoCover = constraintAnnotation.coverPhoto();
        this.photo2 = constraintAnnotation.photo2();
        this.photo3 = constraintAnnotation.photo3();
    }

    @Override
    public boolean isValid(String url, ConstraintValidatorContext constraintValidatorContext) {

        Object photoCoverValue = PropertyAccessorFactory.forBeanPropertyAccess(url).getPropertyValue(photoCover);
        Object photo2Value = PropertyAccessorFactory.forBeanPropertyAccess(url).getPropertyValue(photo2);
        Object photo3Value = PropertyAccessorFactory.forBeanPropertyAccess(url).getPropertyValue(photo3);

        if(photoCoverValue.equals(photo2Value) || photoCoverValue.equals(photo3Value) && photo2Value.equals(photo3Value)){
            return true;
        }else return false;
    }
}
