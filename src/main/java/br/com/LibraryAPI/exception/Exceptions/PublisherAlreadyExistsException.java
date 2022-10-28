package br.com.LibraryAPI.exception.Exceptions;

import javax.persistence.EntityExistsException;

public class PublisherAlreadyExistsException extends EntityExistsException {

    public PublisherAlreadyExistsException(String name) {

        super(String.format("A editora %s já existe!", name));

    }

}
