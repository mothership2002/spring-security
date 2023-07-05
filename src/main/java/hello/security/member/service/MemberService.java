package hello.security.member.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.security.member.domain.dto.MemberJoinDto;
import hello.security.member.domain.entity.Member;
import hello.security.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder encoder;
	
	// 계정 벨리데이트가 끝났다 가정
	@Transactional
	public Member join(MemberJoinDto memberDto) {
		Member member = new Member(memberDto.getEmail(), encoder.encode(memberDto.getPassword()), memberDto.getAddress());
		return memberRepository.save(member);
	}
	
	public boolean validateAccount(String email) {
		return memberRepository.validateAccount(email);
	}
	
}
