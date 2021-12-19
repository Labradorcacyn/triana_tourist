package com.trianaTourist.cynthiaLab.validacion.anotaciones;
import com.trianaTourist.cynthiaLab.validacion.validadores.UniqueNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueNameValidator.class)
@Documented
public @interface UniqueName {

    String message () default "{POI.route.unique}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
