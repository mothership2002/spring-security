package hello.security.member.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import hello.security.member.controller.HelloController;

@ControllerAdvice(basePackageClasses = HelloController.class)
public class HelloControllerAdvice {

	@ExceptionHandler(RuntimeException.class) 
	public String exceptionResponse() {
		return "redirect:/error/500";
	}
}
