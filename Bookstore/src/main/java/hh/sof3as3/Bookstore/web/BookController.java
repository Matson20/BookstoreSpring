package hh.sof3as3.Bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;

	@RequestMapping("/booklist")
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
	@RequestMapping("/add")
		public String addBook(Model model) {
			model.addAttribute("book", new Book());
			return "addbook";
		}
	
	// Save the new book
	@PostMapping("/save")
		public String savebook(Book book) {
			repository.save(book);
			return "redirect:booklist";
	}
	 
}
