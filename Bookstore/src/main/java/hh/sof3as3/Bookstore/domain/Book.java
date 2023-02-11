package hh.sof3as3.Bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// atribuutit
	private Long id;
	private String title;
	private String author;
	@Column(name="publishing_year")
	private Integer year;
	private String isbn;
	private Integer price;
	
	// konstruktorit
	public Book() {
		
	}
	
	public Book(String title, String author, Integer year, String isbn, Integer price) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}

	
	
	// setterit
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	
	
	// getterit

	public String getTitle() {
		return title;
	}

	public Long getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public Integer getYear() {
		return year;
	}

	public String getIsbn() {
		return isbn;
	}

	public Integer getPrice() {
		return price;
	}

	// toString
	@Override
	public String toString() {
		return "title=" + title + ", author=" + author + ", year=" + year + 
				", isbn=" + isbn + ", price=" + price;
	}
	
	
}
