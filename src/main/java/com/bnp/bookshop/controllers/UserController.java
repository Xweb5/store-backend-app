package com.bnp.bookshop.controllers;

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/users")
public class UserController {

  @CrossOrigin()
  @GetMapping("/login")
  Boolean checkValidUser() {
    return true;
  }


}