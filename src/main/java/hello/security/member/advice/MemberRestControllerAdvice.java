package hello.security.member.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import hello.security.member.controller.MemberRestController;
import hello.security.member.exception.EmailDuplicateException;

@RestControllerAdvice(basePackageClasses = MemberRestController.class)
public class MemberRestControllerAdvice {

	@ExceptionHandler(EmailDuplicateException.class)
	public ResponseEntity<String> emailDuplicateMessage() {
		return new ResponseEntity<String>("hello",HttpStatus.FOUND);
	}
}
