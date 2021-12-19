package com.trianaTourist.cynthiaLab.validacion.anotaciones;

import com.trianaTourist.cynthiaLab.validacion.validadores.POICheckValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = POICheckValidator.class)
public @interface POICheck {
    String message() default "{poi.repeat}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String idRoute();
    String idPOI();

}
