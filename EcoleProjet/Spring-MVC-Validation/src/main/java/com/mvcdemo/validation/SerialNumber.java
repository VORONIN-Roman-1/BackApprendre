package com.mvcdemo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = SerialNumberConstraintValidator.class)
@Target( {ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SerialNumber {
    // définir le serialNumber par défaut
    public String value() default "xyz";
    //définir le message par défaut
    public String message() default "serialNumber incorrect";
    //groupe par défaut
    public Class<?>[] groups() default {}; //collection vide
    //payload par défaut
    public Class<? extends Payload>[] payload() default {};
}
