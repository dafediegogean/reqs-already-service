package br.com.reqs.already.core.validator;

import br.com.reqs.already.domain.model.Token;

public class AuthorizationValidator {
	
	public static boolean tokenValidator(Token token) {
		if (token.getToken().equals("AXY10MYV")) {
			return true;
		}
		return false;
	}
}
