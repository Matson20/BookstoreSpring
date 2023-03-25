package hh.sof3as3.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.BookRepository;
import hh.sof3as3.Bookstore.domain.Category;
import hh.sof3as3.Bookstore.domain.CategoryRepository;
import hh.sof3as3.Bookstore.domain.User;
import hh.sof3as3.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	// Näyttää taulujen datan consolessa
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			/*
			Book bookOne = new Book("Revelation Space", "Alastair Reynolds", 2000, "978 0 575 08309 7", 20.0);
			Book bookTwo = new Book("The Dune", "Frank Herbert", 1965, "978 0 340 96019 6", 30.0);
			repository.save(bookOne);
			repository.save(bookTwo);
			*/

			Category category1 = new Category("Sci-fi");
			crepository.save(category1);
			Category category2 = new Category("Horror");
			crepository.save(category2);

			brepository.save(new Book("Revelation Space", "Alastair Reynolds", 2000, "978 0 575 08309 7", 20.0, category1));
			brepository.save(new Book("The Dune", "Frank Herbert", 1965, "978 0 340 96019 6", 30.0, category1));

			//demo users in database
			User user1 = new User("user","$2a$10$vvcYoSlxEEMK/M3IH/a42OZQzlzkXOQFa1A.DFCc.c.8JhqPxpj6C", "userU@user.com","USER");
			User user2 = new User("admin","$2a$10$OqwXY/OoUAbPDhpajRI5QecfAocwIZfoMr7pr0nzCkK1CtaABJq.W","adminA@admin.com","ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("show all categories");
			for (Category category : crepository.findAll()) {
				log.info(category.toString());
			}

			log.info("show all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		
		};
	}

}
