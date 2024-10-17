package com.bnp.bookshop.controllers;

import java.util.ArrayList;
import java.util.List;

import com.bnp.bookshop.dto.BookDto;
import com.bnp.bookshop.entity.*;
import com.bnp.bookshop.mapper.BookMapper;
import com.bnp.bookshop.services.BooksService;
import com.bnp.bookshop.services.UserBookService;
import com.bnp.bookshop.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/books")
public class BookController {

  private final BookMapper bookMapper;
  private final BooksService booksService;
  private final UserBookService userBookService;
  private final UserService userService;

  BookController(BooksService booksService,
                 UserService userService,
                 BookMapper bookMapper,
                 UserBookService userBookService) {
    this.booksService = booksService;
    this.bookMapper = bookMapper;
    this.userService = userService;
    this.userBookService = userBookService;
  }

  @CrossOrigin()
  @GetMapping({"/", ""})
  List<BookDto> retrieveBooks() {

    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username = ((UserDetails)principal).getUsername();

    List<Book> books = booksService.findAll();
    return bookMapper.toDtoList(books);
  }

  @CrossOrigin()
  @PostMapping({"/", ""})
  List<UserBook> saveOrders(@RequestBody List<BookDto> bookList) {

    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username = ((UserDetails)principal).getUsername();

    List<UserBook> listToPersist = new ArrayList<>();
    bookList.forEach(bookDto -> {
      UserBook userBook = new UserBook();
      userBook.setBook(booksService.findById(bookDto.getId()).get());
      userBook.setUser(userService.findByUsername(username));
      userBook.setItems(bookDto.getItems());
      listToPersist.add(userBook);
    });
    return userBookService.saveAll(listToPersist);
  }


}