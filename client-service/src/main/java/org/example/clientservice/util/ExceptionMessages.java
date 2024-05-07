package org.example.clientservice.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ExceptionMessages {

    public static final String CLIENT_NOT_FOUND = "Client with id '%s' not  found";
    public static final String CLIENT_ALREADY_EXIST_WITH_PHONE = "Client with phone '%s' already exist";
    public static final String CLIENT_ALREADY_EXIST_WITH_EMAIL = "Client with email '%s' already exist";
}
