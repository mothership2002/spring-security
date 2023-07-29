package hello.security.member.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundMemberException extends UsernameNotFoundException {

    public NotFoundMemberException(String msg) {
        super(msg);
    }
}
