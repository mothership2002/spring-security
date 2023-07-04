package hello.security.member.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorControl implements ErrorController {

	@RequestMapping("/500")
	public String error500() {
		return "error500";
	}
}
