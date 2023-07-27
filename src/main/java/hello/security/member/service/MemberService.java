package hello.security.member.service;

import hello.security.config.PrincipalDetail;
import hello.security.member.domain.dto.MemberJoinDto;
import hello.security.member.domain.entity.Member;
import hello.security.member.exception.NotFoundMemberException;
import hello.security.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService implements UserDetailsService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Member> byEmail = memberRepository.findByEmail(email);
		return new PrincipalDetail(byEmail.orElseThrow(() -> new NotFoundMemberException("계정을 확인해주세요")));
	}

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
