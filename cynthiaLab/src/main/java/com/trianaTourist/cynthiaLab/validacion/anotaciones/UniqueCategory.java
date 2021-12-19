package com.trianaTourist.cynthiaLab.validacion.anotaciones;

import com.trianaTourist.cynthiaLab.validacion.validadores.UniqueCategoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueCategoryValidator.class)
@Documented
public @interface UniqueCategory {

    String message () default "{POI.categoria.unique}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
