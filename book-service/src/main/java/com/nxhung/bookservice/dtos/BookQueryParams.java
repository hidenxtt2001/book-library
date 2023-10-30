package com.nxhung.bookservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookQueryParams {
    private Boolean isReady;
    private String name;
    private String authorName;
}
