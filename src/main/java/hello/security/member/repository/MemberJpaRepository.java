package hello.security.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.security.member.domain.entity.Member;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

	Optional<Member> findByEmail(String email);
}
