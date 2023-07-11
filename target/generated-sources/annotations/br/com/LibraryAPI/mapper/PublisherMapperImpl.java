package br.com.LibraryAPI.mapper;

import br.com.LibraryAPI.dto.PublisherDTO;
import br.com.LibraryAPI.model.Publisher;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-10T21:48:38-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Azul Systems, Inc.)"
)
public class PublisherMapperImpl implements PublisherMapper {

    @Override
    public PublisherDTO toDTO(Publisher publisher) {
        if ( publisher == null ) {
            return null;
        }

        PublisherDTO publisherDTO = new PublisherDTO();

        publisherDTO.setId( publisher.getId() );
        publisherDTO.setName( publisher.getName() );

        return publisherDTO;
    }

    @Override
    public Publisher toModel(PublisherDTO publisherDTO) {
        if ( publisherDTO == null ) {
            return null;
        }

        Publisher publisher = new Publisher();

        publisher.setId( publisherDTO.getId() );
        publisher.setName( publisherDTO.getName() );

        return publisher;
    }
}
