package fi.POkurssi.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.el.stream.Optional;

import fi.POkurssi.Bookstore.domain.Book;
import fi.POkurssi.Bookstore.domain.BookRepository;
import fi.POkurssi.Bookstore.domain.Category;
import fi.POkurssi.Bookstore.domain.CategoryRepository;
import fi.POkurssi.Bookstore.domain.UserRepository;

@Controller
public class BookController {
	
	
	@GetMapping("/home")
		public String indexPage() {
		
		return "home";
	}
	@GetMapping("/")
	public String Page() {
	
	return "home";
}
	
	@Autowired
	private BookRepository brepository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	private UserRepository urepository;
	
	@RequestMapping("/booklist")
		public String kirjalista(Model model) {
		
			
		model.addAttribute("books", brepository.findAll());
		model.addAttribute("categories", crepository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value="/login")
	public String loginsivu() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "home";
	}
	
	
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
	return (List<Book>) brepository.findAll();
}
	
	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public @ResponseBody List<Category> categoryListRest() {
		return (List<Category>) crepository.findAll();
	}
	
	
	@RequestMapping("/add")
		public String add(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		
		return "add";
	}
	
	@PostMapping("/save")
		public String savebook(@ModelAttribute("book") Book book, Model model) {
		
		brepository.save(book);
		
		return "redirect:booklist";
	}
	
	@GetMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
		public String poista(@PathVariable("id") Long id, Model model) {
		
		brepository.deleteById(id);
		
		return "redirect:/booklist";
		
	}
	
	@GetMapping("/edit/{id}")
		public String muuta(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("book", brepository.findById(id));
		model.addAttribute("categories", crepository.findAll());
		
		return "edit";
	}
	
	@PostMapping("/update")
		public String update(Model model, @ModelAttribute("book") Book book) {
		
		brepository.save(book);
		return "redirect:/booklist";
	}
}
