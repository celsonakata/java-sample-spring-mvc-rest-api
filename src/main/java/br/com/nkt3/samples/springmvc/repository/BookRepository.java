package br.com.nkt3.samples.springmvc.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.nkt3.samples.springmvc.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
