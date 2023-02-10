package hh.sof3as3.Bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.BookRepository;



@Controller
public class BookController {

	@Autowired
	private BookRepository repository;
	
	@GetMapping("/booklist")
	public String getBooks(Model model) {
		model.addAttribute("books", repository.findAll());
		
		return "booklist";
	}
	
}
