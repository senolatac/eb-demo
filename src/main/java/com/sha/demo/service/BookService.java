package com.sha.demo.service;

import com.sha.demo.model.Book;
import com.sha.demo.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author sa
 * @date 16.05.2021
 * @time 17:40
 */
@Service
public class BookService implements IBookService
{
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Book saveBook(Book book)
    {
        book.setCreateTime(LocalDateTime.now());
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id)
    {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAllBooks()
    {
        return bookRepository.findAll();
    }
}
