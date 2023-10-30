package com.nxhung.bookservice.dtos;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Builder
public class BookResponseDto {
    private Long id;
    private String name;
    private String authorName;
    private Boolean isReady;
}
