package com.trianaTourist.cynthiaLab.validacion.anotaciones;

import com.trianaTourist.cynthiaLab.validacion.validadores.LocatedValidValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = LocatedValidValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LocatedValid {

    String message() default "{estacionServicio.mapsEqual.validate}";

    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
    String location();
}
