package de.ait.validators.impl;

import de.ait.validators.NameValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class NameLengthValidatorImpl implements NameValidator {

    private final int minLength;

    public NameLengthValidatorImpl(@Value("${min.name.length}") Integer minLength) {

        this.minLength = minLength;
    }

    @Override
    public void validate(String name) {
        if (name.length() < minLength) {
            throw new IllegalArgumentException("Название слишком короткое");
        }
    }
}
