package hh.sof3as3.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	// Näyttää taulujen datan consolessa
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book bookOne = new Book("Revelation Space", "Alastair Reynolds", 2000, "978 0 575 08309 7", 20.0);
			Book bookTwo = new Book("The Dune", "Frank Herbert", 1965, "978 0 340 96019 6", 30.0);
		
			repository.save(bookOne);
			repository.save(bookTwo);
			
			log.info("show all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		
		};
	}

}
