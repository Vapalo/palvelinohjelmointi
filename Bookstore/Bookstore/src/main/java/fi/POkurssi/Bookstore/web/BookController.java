package fi.POkurssi.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.POkurssi.Bookstore.domain.Book;
import fi.POkurssi.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	
	@GetMapping("/index")
		public String indexPage() {
		
		return "index";
	}
	
	@Autowired
	private BookRepository repository;
	
	@RequestMapping("/booklist")
		public String kirjalista(Model model) {
		
			
		model.addAttribute("books", repository.findAll());
		
		return "booklist";
	}
	
	@RequestMapping("/add")
		public String add(Model model) {
		model.addAttribute("book", new Book());
		
		return "add";
	}
	
	@PostMapping("/save")
		public String savebook(@ModelAttribute("book") Book book, Model model) {
		repository.save(book);
		
		return "redirect:booklist";
	}
	
	@GetMapping("/delete/{id}")
		public String poista(@PathVariable("id") Long id, Model model) {
		
		repository.deleteById(id);
		
		return "redirect:/booklist";
		
	}
}
