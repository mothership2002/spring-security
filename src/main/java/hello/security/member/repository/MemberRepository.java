package hello.security.member.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import hello.security.member.domain.entity.Member;
import hello.security.member.exception.EmailDuplicateException;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

	private final MemberJpaRepository memberRepository;
	
	public Member save(Member member) {
		return memberRepository.save(member);
	}
	
	public Optional<Member> findById(Long id) {
		return memberRepository.findById(id);
	}

	public Optional<Member> findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	public boolean validateAccount(String email) {
		Optional<Member> findByEmail = memberRepository.findByEmail(email);
		if (findByEmail.isPresent()) {
			throw new EmailDuplicateException("이메일 중복");
		}
		return !findByEmail.isPresent();
	}
}
