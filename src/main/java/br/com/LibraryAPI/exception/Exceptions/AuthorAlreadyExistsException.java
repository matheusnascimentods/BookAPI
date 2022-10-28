package br.com.LibraryAPI.exception.Exceptions;

import javax.persistence.EntityExistsException;

public class AuthorAlreadyExistsException extends EntityExistsException {

    public AuthorAlreadyExistsException(String name) {

        super(String.format("O autor %s já existe!", name));

    }

}
