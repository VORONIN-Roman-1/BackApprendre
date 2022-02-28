package com.mvcdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SerialNumberConstraintValidator implements ConstraintValidator<SerialNumber, String> {
        private String serialNumberPrefix;
    @Override
    public void initialize(SerialNumber unSerialNumber) {
        serialNumberPrefix = unSerialNumber.value();
    }

    @Override
    public boolean isValid(String leSerialNumber, ConstraintValidatorContext context) {
        boolean result ;
        if(leSerialNumber !=null)
            result= leSerialNumber.startsWith(serialNumberPrefix);
        else
            result = true;
        return  result;
    }
}
