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
public class Book {

  private @Id Long id;

  private String title;
  private String author;
  private Double price;

  @OneToMany(mappedBy = "book")
  private Set<UserBook> userBooks;


}