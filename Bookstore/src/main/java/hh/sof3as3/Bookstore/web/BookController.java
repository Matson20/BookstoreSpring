package hh.sof3as3.Bookstore.web;


//import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

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
	
	 
}
