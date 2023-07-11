package br.com.LibraryAPI.mapper;

import br.com.LibraryAPI.dto.AuthorDTO;
import br.com.LibraryAPI.dto.BookRequestDTO;
import br.com.LibraryAPI.dto.BookResponseDTO;
import br.com.LibraryAPI.dto.PublisherDTO;
import br.com.LibraryAPI.model.Author;
import br.com.LibraryAPI.model.Book;
import br.com.LibraryAPI.model.Publisher;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-10T21:48:38-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Azul Systems, Inc.)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public Book toModel(BookRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( requestDTO.getId() );
        book.setTitle( requestDTO.getTitle() );
        book.setDescription( requestDTO.getDescription() );
        if ( requestDTO.getPages() != null ) {
            book.setPages( requestDTO.getPages().intValue() );
        }
        if ( requestDTO.getChapters() != null ) {
            book.setChapters( requestDTO.getChapters().intValue() );
        }

        return book;
    }

    @Override
    public BookResponseDTO toDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookResponseDTO bookResponseDTO = new BookResponseDTO();

        bookResponseDTO.setId( book.getId() );
        bookResponseDTO.setTitle( book.getTitle() );
        bookResponseDTO.setDescription( book.getDescription() );
        bookResponseDTO.setPages( (long) book.getPages() );
        bookResponseDTO.setChapters( (long) book.getChapters() );
        bookResponseDTO.setAuthor( authorToAuthorDTO( book.getAuthor() ) );
        bookResponseDTO.setPublisher( publisherToPublisherDTO( book.getPublisher() ) );

        return bookResponseDTO;
    }

    protected AuthorDTO authorToAuthorDTO(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDTO authorDTO = new AuthorDTO();

        authorDTO.setId( author.getId() );
        authorDTO.setName( author.getName() );
        authorDTO.setAge( author.getAge() );

        return authorDTO;
    }

    protected PublisherDTO publisherToPublisherDTO(Publisher publisher) {
        if ( publisher == null ) {
            return null;
        }

        PublisherDTO publisherDTO = new PublisherDTO();

        publisherDTO.setId( publisher.getId() );
        publisherDTO.setName( publisher.getName() );

        return publisherDTO;
    }
}
