package hello.security.member.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import hello.security.common.vo.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberJoinDto {

	@Email(message = "올바른 이메일 형식으로 작성하세요.")
	@NotNull(message = "이메일을 적어주세요.")
	@NotBlank(message = "올바른 이메일 형식으로 작성하세요.")
	private String email;
	
	@Pattern(regexp = "", message = "올바른 비밀번호 형식으로 작성하세요.")
	@NotNull(message = "패스워드를 적어주세요.")
	@NotBlank(message = "올바른 비밀번호 형식으로 작성하세요.")
	private String password;
	
	private Boolean passwordFlag; //?
	
	private Address address;
	
}
