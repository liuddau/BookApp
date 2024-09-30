package com.example.BookApp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Books")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column
    private int year;

    @Column
    private String author;

    @Column
    private double rating;

}
