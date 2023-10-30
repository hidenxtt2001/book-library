package com.nxhung.bookservice.controller;

import com.nxhung.bookservice.dtos.BookQueryParams;
import com.nxhung.bookservice.dtos.BookRequestDto;
import com.nxhung.bookservice.dtos.BookResponseDto;
import com.nxhung.bookservice.service.BookService;
import com.nxhung.common.dtos.BaseResponseDto;
import com.nxhung.common.dtos.NoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books/v1")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/{id}")
    protected ResponseEntity<BaseResponseDto<BookResponseDto>> getBookDetailById(@PathVariable("id") Long id) {
        var book = bookService.getBookDetailById(id);
        var response = BaseResponseDto.<BookResponseDto>builder()
                .success(true)
                .status(HttpStatus.OK)
                .data(book)
                .build();
        return response.toResponseEntity();
    }


    @GetMapping
    protected ResponseEntity<BaseResponseDto<List<BookResponseDto>>> getAllBookByCondition(BookQueryParams params) {
        var books = bookService.getAllBook(params);
        var response = BaseResponseDto.<List<BookResponseDto>>builder()
                .success(true)
                .status(HttpStatus.OK)
                .data(books)
                .build();
        return response.toResponseEntity();
    }

    @PostMapping
    protected ResponseEntity<BaseResponseDto<NoResponseDto>> addNewBook(@RequestBody BookRequestDto requestDto) {
        bookService.addNewBook(requestDto);
        var response = BaseResponseDto.<NoResponseDto>builder()
                .success(true)
                .status(HttpStatus.CREATED)
                .build();
        return response.toResponseEntity();
    }
}
