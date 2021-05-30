package com.sha.demo.repository;

import com.sha.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sa
 * @date 16.05.2021
 * @time 17:38
 */
public interface IBookRepository extends JpaRepository<Book, Long>
{
}
