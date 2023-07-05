package hello.security.member.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import hello.security.member.controller.MemberController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice(basePackageClasses = MemberController.class)
public class MemberControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public String exceptionResponse(Model model, HttpServletRequest req) {
		model.addAttribute("error", getStatus(req));
		return "/error/500";
	}

	private HttpStatus getStatus(HttpServletRequest request) {
		Throwable exceptionClass = (Throwable) request.getAttribute("org.springframework.boot.web.servlet.error.DefaultErrorAttributes.ERROR");

		log.error("exception message : {}", exceptionClass.getMessage());
		log.error("exception cause : {}", exceptionClass.getCause());
		log.error("exception class : {}", exceptionClass.getClass());

		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.valueOf(statusCode);
	}
}
