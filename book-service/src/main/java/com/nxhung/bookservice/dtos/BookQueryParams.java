package com.nxhung.bookservice.dtos;

import com.nxhung.common.dtos.PagingQueryParams;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookQueryParams {
    private Boolean isReady = true;
    private String name;
    private String authorName;
}
