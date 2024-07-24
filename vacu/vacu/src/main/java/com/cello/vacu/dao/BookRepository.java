package com.cello.vacu.dao;

import com.cello.vacu.Model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {
    public Book findById(int id);

}
