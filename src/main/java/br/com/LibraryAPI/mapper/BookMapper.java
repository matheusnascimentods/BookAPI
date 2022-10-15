package br.com.LibraryAPI.mapper;

import br.com.LibraryAPI.dto.BookRequestDTO;
import br.com.LibraryAPI.dto.BookResponseDTO;
import br.com.LibraryAPI.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INTANCE = Mappers.getMapper(BookMapper.class);

    public Book toModel(BookRequestDTO requestDTO);
    public BookResponseDTO toDTO(Book book);

}
