package fi.POkurssi.viikko2_teht3.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fi.POkurssi.viikko2_teht3.domain.Friend;

@Controller
public class FriendController {
	
	ArrayList<Friend> friends = new ArrayList<>();
	
	@GetMapping("/hello")
		public String initialPage(Model model) {
			
		model.addAttribute("friend", new Friend());
		return "hello";
		
	}
	
	@PostMapping("/hello")
		public String addList(@ModelAttribute Friend friend, String nimi, Model model) {
			
			if(nimi != null && nimi.length() >= 1) {
				Friend lisays = new Friend(nimi);
				friends.add(lisays);
			}
			
			model.addAttribute("friends", friends);
		
		return "hello";
	}
	
}
