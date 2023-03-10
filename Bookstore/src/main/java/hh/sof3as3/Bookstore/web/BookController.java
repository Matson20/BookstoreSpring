package hh.sof3as3.Bookstore.web;


//import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.BookRepository;
import hh.sof3as3.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository crepository;

	
	@RequestMapping(value="/booklist")
	public String getBooks(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	

	// RESTful get all books
	@GetMapping(value="/books")
	public @ResponseBody List<Book> getBooks() {
		return (List<Book>) repository.findAll();
	}

	// RESTful find book by ID
	@GetMapping(value="/books/{id}")
	public @ResponseBody Optional<Book> findBookREST(@PathVariable("id") Long bookId) {
		return repository.findById(bookId);
	}

	// RESTful add new book
	@PostMapping("/books")
	public @ResponseBody Book addNewBook(@RequestBody Book book) {
		return repository.save(book);
	}
	
	// Delete Book
	 @GetMapping(value = "/delete/{id}")
	    public String deleteStudent(@PathVariable("id") Long bookId, Model model) {
	    	repository.deleteById(bookId);
	        return "redirect:../booklist";
	    }

	 // Add new book
	@RequestMapping(value = "/add")
		public String addBook(Model model) {
			model.addAttribute("book", new Book());
			model.addAttribute("categories", crepository.findAll());
			return "addbook";
		}
	
	// Save the new book
	@PostMapping("/save")
		public String savebook(Book book) {
			repository.save(book);
			return "redirect:booklist";
	}
	
	// Edit book
	@GetMapping(value = "/edit/{id}")
		public String editBook(@PathVariable("id") Long bookId, Model model) {
			model.addAttribute("book", repository.findById(bookId));
			model.addAttribute("categories", crepository.findAll());
			return "editbook";
	}
	
	@RequestMapping("/login")
		public String login() {
			return "login";
		}
	 
}
