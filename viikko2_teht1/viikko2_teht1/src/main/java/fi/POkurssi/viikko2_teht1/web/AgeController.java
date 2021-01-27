package fi.POkurssi.viikko2_teht1.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class AgeController {
	
	
		@GetMapping(value="/hello")	
		public String welcomePerson(@RequestParam(name="age") int age,
				@RequestParam(name="name") String personName, Model model) {
			model.addAttribute("name", personName);
			model.addAttribute("age", age);
			return "hello";
		}
		
}
