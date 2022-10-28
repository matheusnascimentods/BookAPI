package br.com.LibraryAPI.exception.Exceptions;

import javax.persistence.EntityNotFoundException;

public class PublisherNotFoundException extends EntityNotFoundException {

    public PublisherNotFoundException(Long id) {
        super(String.format("Não existe nenhuma editora de id %s", id));
    }
}
