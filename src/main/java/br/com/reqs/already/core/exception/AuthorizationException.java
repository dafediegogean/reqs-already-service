package br.com.reqs.already.core.exception;

/**
 * Classe de exceção em execução, extende {@link RuntimeException},
 * de java.lang. Recebe como parâmetro no construtor o código e mensagem
 * a ser lançanda na exceção.
 *  
 * @author <a href="mailto:dafediegogean@gmail.com">Diego Gean da Fé</a>
 * @version
 * @since 01 de jan de 2021, 17:35:10
 */
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
