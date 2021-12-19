package com.trianaTourist.cynthiaLab.validacion.anotaciones;

import com.trianaTourist.cynthiaLab.validacion.validadores.UrlValidlValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UrlValidlValidator.class)
public @interface UrlValid {

    String message () default "{POI.url.valid}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String coverPhoto();

    String photo2();

    String photo3();

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        UrlValid[] value();
    }
}
