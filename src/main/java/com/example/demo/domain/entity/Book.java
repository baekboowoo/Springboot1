package com.example.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
//@Table(name = "tbl_book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 100)
    private Long bookcode;
    @Column(length = 255)
    private String bookname;
    @Column(length = 150)
    private String publisher;
    @Column()
    private String isbn;
}
