package br.com.LibraryAPI.exception.Exceptions;

import javax.persistence.EntityExistsException;

public class BookAlreadyExistsException extends EntityExistsException {

    public BookAlreadyExistsException(String title) {

        super(String.format("O livro %s já existe!", title));

    }

}
