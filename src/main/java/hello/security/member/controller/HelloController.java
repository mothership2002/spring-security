package hello.security.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/home")
	public String main(Model model) {
		model.addAttribute("hello", "hello thymeleaf");
		return "index";
	}
}
