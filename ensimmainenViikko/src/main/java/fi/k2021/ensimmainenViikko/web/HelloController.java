package fi.k2021.ensimmainenViikko.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@RequestMapping("index")
	@ResponseBody
	public String mainGreeting() {
		return "This is the main page";

	}

	@Controller
	public class ContactController {
		@RequestMapping("contact")
		@ResponseBody
		public String contactGreeting() {
			return "This is the contacts page";
		}
	}

	@Controller
	public class RequestController {
		@RequestMapping("hello")
		@ResponseBody
		public String paramReturn(@RequestParam(name = "location")String location,
				@RequestParam(name = "name") String name) {
			return "Welcome to the " + location + " " + name;
		}
	}

}
