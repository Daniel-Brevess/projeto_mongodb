package org.danielbreves.workshopmongo.service.exception;

public class UserNotFoundException extends RuntimeException
{
    public UserNotFoundException(String message)
    {
        super(message);
    }
}
