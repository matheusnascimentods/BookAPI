package br.com.LibraryAPI.exception.Exceptions;

import javax.persistence.EntityNotFoundException;

public class BookNotFoundException extends EntityNotFoundException {

    public BookNotFoundException(Long id) { super(String.format("Não existe nenhum livro com o id %s", id)); }

}
