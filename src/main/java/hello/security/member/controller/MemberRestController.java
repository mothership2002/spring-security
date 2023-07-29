package hello.security.member.controller;

import hello.security.member.domain.dto.MemberInfoDto;
import hello.security.member.domain.dto.MemberJoinDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hello.security.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class MemberRestController {

    private final MemberService memberService;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    @GetMapping("/hello2")
    public ResponseEntity<String> hello2() {
        return new ResponseEntity<>("hello2", HttpStatus.OK);
    }

    @PostMapping("/member")
    public ResponseEntity<Long> join(@RequestBody MemberJoinDto memberDto) {
        return new ResponseEntity<>(memberService.join(memberDto), HttpStatus.OK);
    }

//	@PatchMapping("/member")
//	public ResponseEntity<MemberInfoDto> currentUserInfo() {
//
//		return new ResponseEntity<>();
//	}


    @PostMapping("/member/email")
    public ResponseEntity<String> duplicateEmail(@RequestBody String email) {
        return new ResponseEntity<>(String.valueOf(memberService.validateAccount(email)), HttpStatus.OK);
    }
}
