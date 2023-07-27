package hello.security.member.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class NotFoundMemberException extends UsernameNotFoundException {

    public NotFoundMemberException(String msg) {
        super(msg);
    }
}
