package com.bnp.bookshop.mapper;

import com.bnp.bookshop.dto.BookDto;
import com.bnp.bookshop.entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class BookMapper {

    private final ModelMapper modelMapper;

    public BookMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BookDto toDto(Book book) {
        return modelMapper.map(book, BookDto.class);
    }

    public List<BookDto> toDtoList(List<Book> products) {
        return products.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }


    public Book fromDto(BookDto bookDto) {

        return modelMapper.map(bookDto, Book.class);
    }

}