package com.bnp.bookshop.exception;

public class BookNotFoundException extends RuntimeException {

  BookNotFoundException(Long id) {
    super("Could not find book " + id);
  }
}