package com.bnp.bookshop;

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/bookshop/v1/users")
public class UserController {

  @CrossOrigin()
  @GetMapping("/login")
  Boolean checkValidUser() {
    return true;
  }


}