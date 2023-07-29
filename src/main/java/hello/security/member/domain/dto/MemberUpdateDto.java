package hello.security.member.domain.dto;

import hello.security.common.vo.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberUpdateDto {

    private String password;
    private Boolean passwordValid;
    private Address address;
}
