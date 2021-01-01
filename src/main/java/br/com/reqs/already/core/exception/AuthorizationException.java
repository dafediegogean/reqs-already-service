package br.com.reqs.already.core.exception;

public class AuthorizationException extends RuntimeException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 2448934827853482181L;
	
	private String code;
	
	private String message;

	public AuthorizationException(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
