package br.com.LibraryAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data @AllArgsConstructor @NoArgsConstructor
public class BookRequestDTO {

    private long id;

    @NotNull @NotEmpty @Size(max = 225)
    private String title;

    @NotNull @NotEmpty @Size(max = 550)
    private String description;

    @NotNull @Max(3000)
    private Long pages;

    @NotNull @Max(200)
    private Long chapters;

    @NotNull
    private Long authorId;

    @NotNull
    private Long publisherId;

}
