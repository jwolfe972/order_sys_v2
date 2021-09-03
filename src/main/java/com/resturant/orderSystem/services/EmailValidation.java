package com.resturant.orderSystem.services;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
@Service
public class EmailValidation implements Predicate<String> {
    @Override
    public boolean test(String s) {

        // TODO: Regex pattern
        return true;
    }
}
