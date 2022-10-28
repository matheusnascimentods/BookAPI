package br.com.LibraryAPI.exception.Exceptions;

import javax.persistence.EntityNotFoundException;

public class AuthorNotFoundException extends EntityNotFoundException {

    public AuthorNotFoundException(Long id) { super(String.format("Não existe nenhum autor com id %s", id)); }

}
