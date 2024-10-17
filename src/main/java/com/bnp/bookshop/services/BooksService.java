package com.bnp.bookshop.services;

import com.bnp.bookshop.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BooksService {
    Optional<Book> findById(Long id);

    List<Book> findAll();
}
