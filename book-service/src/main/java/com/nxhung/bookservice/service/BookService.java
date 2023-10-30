package com.nxhung.bookservice.service;

import com.nxhung.bookservice.dtos.BookQueryParams;
import com.nxhung.bookservice.dtos.BookRequestDto;
import com.nxhung.bookservice.dtos.BookResponseDto;
import com.nxhung.common.dtos.BaseResponseDto;
import com.nxhung.common.dtos.PagingQueryParams;
import com.nxhung.common.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {
    /**
     * Get book detail by id
     *
     * @param id id of book
     * @return Book detail if it is found in datasource
     * @throws ResourceNotFoundException if not exist any book has this id
     */
    BookResponseDto getBookDetailById(Long id) throws ResourceNotFoundException;

    /**
     * Add new book to datasource
     *
     * @param request book information
     */
    void addNewBook(BookRequestDto request);

    /**
     * Get all books
     *
     * @param params contain query condition to get books
     * @param pageable size of page
     * @return list of book match query params condition
     */
    List<BookResponseDto> getAllBook(BookQueryParams params, PagingQueryParams pageable);

}
