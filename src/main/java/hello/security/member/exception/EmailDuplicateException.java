package hello.security.member.exception;

public class EmailDuplicateException extends IllegalArgumentException {
	
	public EmailDuplicateException(String s) {
		super(s);
	}

	public EmailDuplicateException(String message, Throwable cause) {
		super(message, cause);
	}
}
