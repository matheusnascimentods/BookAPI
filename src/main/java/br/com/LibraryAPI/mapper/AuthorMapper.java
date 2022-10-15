package br.com.LibraryAPI.mapper;

import br.com.LibraryAPI.dto.AuthorDTO;
import br.com.LibraryAPI.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
    public AuthorDTO toDTO(Author author);
    public Author toModel(AuthorDTO authorDTO);

}
