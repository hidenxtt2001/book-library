package com.nxhung.bookservice.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookRequestDto {
    @Size(min = 3,max = 20,message = "Name must greater than 3")
    @NotEmpty(message = "Name must not be empty")
    @NotNull(message = "Name must not be null")
    private String name;
    @Size(min = 3,max = 20,message = "Author name must greater than 3")
    @NotEmpty(message = "Author name must not be empty")
    @NotNull(message = "Author name must not be null")
    private String authorName;
}
