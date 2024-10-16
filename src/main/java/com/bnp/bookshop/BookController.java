package com.bnp.bookshop;

import java.util.List;

import com.bnp.bookshop.dto.BookDto;
import com.bnp.bookshop.entity.Book;
import com.bnp.bookshop.entity.BookRepository;
import com.bnp.bookshop.mapper.BookMapper;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/bookshop/v1/books")
public class BookController {

  private final BookMapper bookMapper;
  private final BookRepository repository;

  BookController(BookRepository repository,
                 BookMapper bookMapper) {
    this.repository = repository;
    this.bookMapper = bookMapper;
  }


  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping({"/", ""})
  List<BookDto> retrieveBooks() {
    List<Book> books = repository.findAll();
    return bookMapper.toDtoList(books);
  }


}