package br.com.nkt3.samples.springmvc.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@ToString(exclude = "id")
public class Book {

	public Book() { }
	
	@Id
	@Getter private Long id;
	
	@Getter @Setter private String title;
	
	@Getter @Setter private String description;

	@Getter @Setter private String author;

	@Getter @Setter private String edition;

	@Getter @Setter private Integer pages;

	@Getter @Setter private LocalDate launchDate;

	@Getter @Setter private String status;

	@Getter @Setter private String publisher;
}
