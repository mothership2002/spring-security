package hello.security.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hello.security.member.domain.dto.MemberJoinDto;
import hello.security.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("/home")
	public String main(Model model) {
		model.addAttribute("hello", "hello thymeleaf");
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login() {
		return "redirect:/home";
	}
	
	@GetMapping("/member")
	public String joinPage() {
		return "member/join";
	}
	
	@PostMapping("/member")
	public void join(MemberJoinDto memberDto) {
		memberService.join(memberDto);
	}
	
}
