package com.nxhung.bookservice.service.impl;

import com.nxhung.bookservice.dtos.BookQueryParams;
import com.nxhung.bookservice.dtos.BookRequestDto;
import com.nxhung.bookservice.dtos.BookResponseDto;
import com.nxhung.bookservice.entities.BookEntity;
import com.nxhung.bookservice.mappers.BookMapper;
import com.nxhung.bookservice.repository.BookRepository;
import com.nxhung.bookservice.service.BookService;
import com.nxhung.common.dtos.PagingQueryParams;
import com.nxhung.common.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public BookResponseDto getBookDetailById(Long id) {
        var bookFind = bookRepository.findById(id);
        if (bookFind.isEmpty()) {
            throw new ResourceNotFoundException("Book resource not found");
        }
        return BookMapper.toDto(bookFind.get());
    }

    @Override
    public void addNewBook(BookRequestDto request) {
        var book = BookMapper.fromDto(request);
        book = bookRepository.save(book);
        log.info("Add new book with id : {}", book.getId());
    }

    @Override
    public List<BookResponseDto> getAllBook(BookQueryParams params, PagingQueryParams pageable) {
        Page<BookEntity> books;
        var paramsProcess = params;
        if (paramsProcess == null) {
            paramsProcess = new BookQueryParams();
        }
        books = bookRepository.getBookByQueryParams(paramsProcess, pageable);
        return books.stream().map(BookMapper::toDto).toList();
    }
}
