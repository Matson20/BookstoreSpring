package hh.sof3as3.Bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.sof3as3.Bookstore.domain.Book;



@Controller
public class BookController {

	List<Book> books = new ArrayList<Book>(); // Tyhjän listan luonti
	
	@GetMapping("/index")
	public String getBooks(Model model) {
		
		books.add(new Book("This", "is", 1, "test", 2));
		model.addAttribute("books", books);
		return "booklist";
	}
	
}
