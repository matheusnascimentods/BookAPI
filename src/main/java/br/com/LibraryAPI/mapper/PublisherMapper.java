package br.com.LibraryAPI.mapper;

import br.com.LibraryAPI.dto.PublisherDTO;
import br.com.LibraryAPI.model.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublisherMapper {

    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    public PublisherDTO toDTO(Publisher publisher);
    public Publisher toModel(PublisherDTO publisherDTO);

}
