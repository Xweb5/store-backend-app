package com.bnp.bookshop.services;

import com.bnp.bookshop.entity.UserBook;

import java.util.List;

public interface UserBookService {

    List<UserBook>  saveAll(List<UserBook> bookList);
}
