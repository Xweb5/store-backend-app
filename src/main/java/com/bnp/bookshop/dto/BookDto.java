package com.bnp.bookshop.dto;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@EqualsAndHashCode
@Setter
@Getter
@ToString
public class BookDto {

  private Long id;

  private String title;
  private String author;
  private Double price;


}