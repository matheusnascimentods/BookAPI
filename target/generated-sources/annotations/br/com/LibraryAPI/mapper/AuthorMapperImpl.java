package br.com.LibraryAPI.mapper;

import br.com.LibraryAPI.dto.AuthorDTO;
import br.com.LibraryAPI.model.Author;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-10T21:48:38-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Azul Systems, Inc.)"
)
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public AuthorDTO toDTO(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDTO authorDTO = new AuthorDTO();

        authorDTO.setId( author.getId() );
        authorDTO.setName( author.getName() );
        authorDTO.setAge( author.getAge() );

        return authorDTO;
    }

    @Override
    public Author toModel(AuthorDTO authorDTO) {
        if ( authorDTO == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( authorDTO.getId() );
        author.setName( authorDTO.getName() );
        author.setAge( authorDTO.getAge() );

        return author;
    }
}
