package com.bnp.bookshop.services;

import com.bnp.bookshop.entity.Users;
import com.bnp.bookshop.entity.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Users findByUsername(String userName) {
        return usersRepository.findByUsername(userName);
    }
}
