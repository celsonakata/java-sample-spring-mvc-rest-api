package br.com.nkt3.samples.springmvc.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.nkt3.samples.springmvc.exception.ServiceException;
import br.com.nkt3.samples.springmvc.model.Book;
import br.com.nkt3.samples.springmvc.service.SpringMvcService;

@RestController
@RequestMapping("/book")
public class SpringMvcController {

	@Autowired
	private SpringMvcService service;
	
	@GetMapping("")
	public @ResponseBody List<Book> getBooks() {
		try {
			return service.getBooks();
			
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Book getBook(@PathVariable Long id) {
		try {
			return service.getBook(id);
			
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Book insertBook(@Valid @RequestBody Book book) {
		try {
			return service.insertBook(book);
			
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}

	@PutMapping("")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody Book updateBook(@Valid @RequestBody Book book) {
		try {
			return service.updateBook(book);
			
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public @ResponseBody void deleteBook(@PathVariable Long id) {
		try {
			service.deleteBook(id);
			
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}
}
