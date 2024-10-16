package com.bnp.bookshop.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@Entity
public class UserBook {

  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private @Id Long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private Users user;

  @ManyToOne
  @JoinColumn(name = "book_id")
  private Book book;

  private Integer items;


}