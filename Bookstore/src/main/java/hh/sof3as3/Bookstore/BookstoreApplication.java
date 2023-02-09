package hh.sof3as3.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book bookOne = new Book("Revelation Space", "Alastair Reynolds", 2000, "978 0 575 08309 7", 20);
			Book bookTwo = new Book("The Dune", "Frank Herbert", 1956, "978 0 340 96019 6", 30);
		
			repository.save(bookOne);
			repository.save(bookTwo);
		
		};
	}

}
