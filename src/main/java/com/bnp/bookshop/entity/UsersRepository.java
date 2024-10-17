package com.bnp.bookshop.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);

    Optional<Users> findByUsernameAndPassword(String username, String password);
}