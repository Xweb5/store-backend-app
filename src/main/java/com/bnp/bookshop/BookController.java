package com.bnp.bookshop;

import java.util.ArrayList;
import java.util.List;

import com.bnp.bookshop.dto.BookDto;
import com.bnp.bookshop.entity.*;
import com.bnp.bookshop.mapper.BookMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/bookshop/v1/books")
public class BookController {

  private final BookMapper bookMapper;
  private final BookRepository repository;
  private final UserBookRepository userBookRepository;
  private final UsersRepository usersRepository;

  BookController(BookRepository repository,
                 UsersRepository userBookRepository,
                 BookMapper bookMapper,
                 UserBookRepository userBookRepository1) {
    this.repository = repository;
    this.bookMapper = bookMapper;
    this.usersRepository = userBookRepository;
    this.userBookRepository = userBookRepository1;
  }

  @CrossOrigin()
  @GetMapping({"/", ""})
  List<BookDto> retrieveBooks() {

    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username = ((UserDetails)principal).getUsername();

    List<Book> books = repository.findAll();
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
      userBook.setBook(repository.findById(bookDto.getId()).get());
      userBook.setUser(usersRepository.findByUsername(username));
      userBook.setItems(bookDto.getItems());
      listToPersist.add(userBook);
    });
    return userBookRepository.saveAll(listToPersist);
  }


}