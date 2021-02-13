package br.com.reqs.already.core.exception;

import javax.xml.ws.WebFault;

/**
 * Classe de exceção em execução, extende {@link RuntimeException},
 * de java.lang. Recebe como parâmetro no construtor o código e mensagem
 * a ser lançanda na exceção.
 *  
 * @author <a href="mailto:dafediegogean@gmail.com">Diego Gean da Fé</a>
 * @version
 * @since 01 de jan de 2021, 17:35:10
 */
@WebFault(name = "AuthorizationFault")
public class AuthorizationException extends Exception {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 2448934827853482181L;
	
	public AuthorizationException(String message) {
		super(message);
	}
	
	public String getFaultInfo() {
		return "Token inválido!";
	}
	
}
