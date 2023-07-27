package hello.security.member.domain.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import hello.security.common.baseEntity.BaseEntity;
import hello.security.common.vo.Address;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

	@Id @GeneratedValue
	@Column(name = "member_id")
	private Long id;
	
	private String email;
	private String password;
	
	@Embedded
	private Address address;

	public Member(String email, String password, Address address) {
		this.email = email;
		this.password = password;
		this.address = address;
	}
}
