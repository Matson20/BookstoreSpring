package hh.sof3as3.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof3as3.Bookstore.domain.Category;
import hh.sof3as3.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository crepository;
    
    //Show categories
    @GetMapping(value="/categorylist")
	public String getBooks(Model model) {
		model.addAttribute("category", crepository.findAll());
		return "categorylist";
	}

    // Add new category
	@RequestMapping(value = "/addcategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    // Save the new category
    @PostMapping("/savecategory")
        public String savecategory(Category category) {
            crepository.save(category);
            return "redirect:categorylist";
    }

    // Delete category
	 @GetMapping(value = "/deletecategory/{id}")
     public String deleteCatecory(@PathVariable("id") Long categoryId, Model model) {
         crepository.deleteById(categoryId);
         return "redirect:../categorylist";
     }
	
}
