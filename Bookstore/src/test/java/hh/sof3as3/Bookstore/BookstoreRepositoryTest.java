package hh.sof3as3.Bookstore;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3as3.Bookstore.domain.BookRepository;
import hh.sof3as3.Bookstore.domain.CategoryRepository;
import hh.sof3as3.Bookstore.domain.UserRepository;

import hh.sof3as3.Bookstore.domain.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookstoreRepositoryTest {

    @Autowired
    private BookRepository brepository;
    @Autowired
    private CategoryRepository crepository;
    @Autowired
    private UserRepository urepository;

    @Test // testing UserRepo to search user
    public void findByUserName() {
        User user = urepository.findByUsername("user");
        assertThat(user.getUsername()).isEqualTo("user");
    }

    @Test // testing saving new book
    public void createNewBook() {
    	Book book = new Book("Dark Matter", "Blake Crouch", 2016 , "978-1-4472-9756", 12.99, crepository.findByName("Sci-fi"));
        brepository.save(book);
        assertThat(book.getId()).isNotNull();
    	
    }  

    @Test // testing deleting new book. First created two books an saved them, so that I can assure that there is 4 books in total. After deleting one of the new books there should be 3 remaining.
    public void DeleteBook() {
    	Book book1 = new Book("Dark Matter", "Blake Crouch", 2016 , "978-1-4472-9756", 12.99, crepository.findByName("Sci-fi"));
        Book book2 = new Book("Dark Matter", "Blake Crouch", 2016 , "978-1-4472-9756", 12.99, crepository.findByName("Sci-fi"));
        brepository.save(book1);
        brepository.save(book2);
        brepository.deleteById(book1.getId());
        assertThat(brepository.count()).isEqualTo(3);
    	
    }  
    
}
