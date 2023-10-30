package com.nxhung.bookservice.mappers;

import com.nxhung.bookservice.dtos.BookRequestDto;
import com.nxhung.bookservice.dtos.BookResponseDto;
import com.nxhung.bookservice.entities.BookEntity;

public abstract class BookMapper {
    public static BookEntity fromDto(BookRequestDto requestDto) {
        return BookEntity.builder()
                .name(requestDto.getName())
                .authorName(requestDto.getAuthorName())
                .build();
    }

    public static BookResponseDto toDto(BookEntity entity) {
        return BookResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .authorName(entity.getAuthorName())
                .isReady(entity.getIsReady())
                .build();
    }
}
