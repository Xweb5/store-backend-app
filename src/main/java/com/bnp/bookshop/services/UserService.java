package com.bnp.bookshop.services;

import com.bnp.bookshop.entity.Users;

public interface UserService {

    Users findByUsername(String userName);
}
