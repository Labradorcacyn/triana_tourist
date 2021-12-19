package com.trianaTourist.cynthiaLab.validacion.validadores;

import com.trianaTourist.cynthiaLab.validacion.anotaciones.UrlValid;
import org.springframework.beans.PropertyAccessorFactory;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UrlValidValidator implements ConstraintValidator<UrlValid, Object> {

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
    public boolean isValid(Object url, ConstraintValidatorContext constraintValidatorContext) {

        String photoCoverValue = (String) PropertyAccessorFactory.forBeanPropertyAccess(url).getPropertyValue(photoCover);
        String photo2Value = (String) PropertyAccessorFactory.forBeanPropertyAccess(url).getPropertyValue(photo2);
        String photo3Value = (String) PropertyAccessorFactory.forBeanPropertyAccess(url).getPropertyValue(photo3);

        if(photoCoverValue == null)
            return true;

        if(photoCoverValue.equals(photo2Value) || photoCoverValue.equals(photo3Value) || photo2Value.equals(photo3Value)){
            return false;
        }else return true;
    }
}
