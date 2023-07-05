package hello.security.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.security.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class MemberRestController {

	private final MemberService memberService;
	
	@PostMapping("/member/email")
	public ResponseEntity<String> duplicateEmail(@RequestBody String email) {
		memberService.validateAccount(email);
		return new ResponseEntity<String>("사용 가능한 Email", HttpStatus.OK); 
	}
}
