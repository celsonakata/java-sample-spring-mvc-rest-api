package br.com.nkt3.samples.springmvc.service;

import java.util.List;

import br.com.nkt3.samples.springmvc.exception.ServiceException;
import br.com.nkt3.samples.springmvc.model.Book;

public interface SpringMvcService {

	public List<Book> getBooks() throws ServiceException;
	
	public Book getBook(Long id) throws ServiceException;
	
	public Book insertBook(Book book) throws ServiceException;
	
	public Book updateBook(Book book) throws ServiceException;
	
	public void deleteBook(Long id) throws ServiceException;
}
