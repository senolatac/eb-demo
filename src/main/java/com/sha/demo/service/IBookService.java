package com.sha.demo.service;

import com.sha.demo.model.Book;

import java.util.List;

/**
 * @author sa
 * @date 16.05.2021
 * @time 17:40
 */
public interface IBookService
{
    Book saveBook(Book book);

    void deleteBook(Long id);

    List<Book> findAllBooks();
}
