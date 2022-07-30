package com.example.netflixprojext.errorHandling;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
