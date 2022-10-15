package br.com.LibraryAPI.dto;

import br.com.LibraryAPI.model.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor @NoArgsConstructor @Data
public class PublisherDTO {

    private long id;

    @NotNull @NotEmpty @Size(max = 205)
    private String name;

    public PublisherDTO(Publisher publisher) {

        this.id = publisher.getId();
        this.name = publisher.getName();

    }

    public Publisher modelToBook() {

        Publisher publisher = new Publisher(this.name);
        publisher.setId(this.id);

        return publisher;

    }

}
