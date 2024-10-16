package com.bnp.bookshop;

import java.util.ArrayList;
import java.util.List;

import com.bnp.bookshop.dto.BookDto;
import com.bnp.bookshop.entity.Book;
import com.bnp.bookshop.entity.BookRepository;
import com.bnp.bookshop.entity.UserBook;
import com.bnp.bookshop.entity.UserBookRepository;
import com.bnp.bookshop.mapper.BookMapper;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/bookshop/v1/books")
public class BookController {

  private final BookMapper bookMapper;
  private final BookRepository repository;
  //private final UserBookRepository userBookRepository;
  private final UserBookRepository usersRepository;

  BookController(BookRepository repository,
                 UserBookRepository userBookRepository,
                 BookMapper bookMapper) {
    this.repository = repository;
    this.bookMapper = bookMapper;
    this.usersRepository = userBookRepository;
  }


  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping({"/", ""})
  List<BookDto> retrieveBooks() {
    List<Book> books = repository.findAll();
    return bookMapper.toDtoList(books);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @PostMapping({"/", ""})
  List<UserBook> saveOrders(@RequestBody List<BookDto> bookList) {

    List<UserBook> listToPersist = new ArrayList<>();
    bookList.forEach(bookDto -> {
      UserBook userBook = new UserBook();
      userBook.setBook(repository.findById(bookDto.getId()).get());
      userBook.setItems(bookDto.getItems());
      listToPersist.add(userBook);
    });
    return usersRepository.saveAll(listToPersist);
  }


}