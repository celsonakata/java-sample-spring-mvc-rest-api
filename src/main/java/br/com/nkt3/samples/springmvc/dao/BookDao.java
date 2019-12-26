package br.com.nkt3.samples.springmvc.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.nkt3.samples.springmvc.model.Book;

public interface BookDao extends CrudRepository<Book, Long> {
}
