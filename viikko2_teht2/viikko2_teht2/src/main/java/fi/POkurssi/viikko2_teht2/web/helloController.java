package fi.POkurssi.viikko2_teht2.web;



import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import fi.POkurssi.viikko2_teht2.domain.Friend;

@Controller
public class helloController {
	
	
	
	
	@GetMapping("/hello")
		public String helloList(Model model) {
		
		ArrayList<Friend> friends = new ArrayList<>();
		friends.add(new Friend("Tero"));
		friends.add(new Friend("Seppo"));
		friends.add(new Friend("Pertti"));
			
			model.addAttribute("friends", friends); 
		
		return "hello";
	}
	
}
