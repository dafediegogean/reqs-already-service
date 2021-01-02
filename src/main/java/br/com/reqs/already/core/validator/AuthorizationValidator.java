package br.com.reqs.already.core.validator;

import br.com.reqs.already.domain.model.Token;

/**
 * Classe de camada de validação, onde recebe um valor de tokenização e 
 * compara com o token de set default.
 *  
 * @author <a href="mailto:dafediegogean@gmail.com">Diego Gean da Fé</a>
 * @version
 * @since 01 de jan de 2021, 17:36:10
 */
public class AuthorizationValidator {
	
	/**
	 * Método tokenValidator(Token token), recebe como parâmetro o token 
	 * do tipo br.com.reqs.already.domain.model.Token, e valida com o 
	 * token da aplicação.
	 * 
	 * @param token
	 * @return boolean
	 */
	public static boolean tokenValidator(Token token) {
		if (token.getToken().equals("AXY10MYV")) {
			return true;
		}
		return false;
	}
}
