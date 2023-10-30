package com.nxhung.common.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.SortedMapType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagingQueryParams implements Pageable {
    @Builder.Default
    private int size = 10;
    @Builder.Default
    private int page = 1;
    @Builder.Default
    private Sort sort = Sort.unsorted();

    @Override
    public int getPageNumber() {
        return page - 1;
    }

    @Override
    public int getPageSize() {
        return size;
    }

    @Override
    public long getOffset() {
        return (long) getPageNumber() * getPageSize();
    }

    @Override
    public Sort getSort() {
        return this.sort;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public Pageable withPage(int pageNumber) {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
