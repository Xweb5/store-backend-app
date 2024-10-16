package com.bnp.bookshop.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@Entity
public class Users {

  private @Id Long id;

  private String username;
  private String password;

  @OneToMany(mappedBy = "user")
  private Set<UserBook> userBooks;


}