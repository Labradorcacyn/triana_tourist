package com.trianaTourist.cynthiaLab.validacion.anotaciones;

import com.trianaTourist.cynthiaLab.validacion.validadores.UrlValidValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UrlValidValidator.class)
public @interface UrlValid {

    String message () default "{POI.url.valid}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String coverPhoto();

    String photo2();

    String photo3();
}
