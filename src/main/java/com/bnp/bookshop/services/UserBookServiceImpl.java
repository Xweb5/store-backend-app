package com.bnp.bookshop.services;

import com.bnp.bookshop.entity.UserBook;
import com.bnp.bookshop.entity.UserBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBookServiceImpl implements UserBookService{

    private final UserBookRepository userBookRepository;

    public UserBookServiceImpl(UserBookRepository userBookRepository) {
        this.userBookRepository = userBookRepository;
    }

    @Override
    public List<UserBook> saveAll(List<UserBook> bookList) {
        return userBookRepository.saveAll(bookList);
    }
}
