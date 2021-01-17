package br.com.reqs.already.api.v1.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.bind.annotation.XmlElement;

import br.com.reqs.already.core.exception.AuthorizationException;
import br.com.reqs.already.core.validator.AuthorizationValidator;
import br.com.reqs.already.domain.dto.ListaProdutoDTO;
import br.com.reqs.already.domain.dto.ProdutoDTO;
import br.com.reqs.already.domain.model.Token;
import br.com.reqs.already.infrastructure.service.ProdutoService;

/**
 * WebService que atende a demais operations para buscar, criar, atualizar 
 * e remover ao produto.
 * 
 * @author <a href="mailto:dafediegogean@gmail.com">Diego Gean da Fé</a>
 * @version
 * @since 21 de nov de 2020, 20:48:10
 */
@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public class ProdutoWS {
	
	@Inject
	private ProdutoService produtoService;
	
	@WebMethod(operationName = "todosOsProdutos")
	@WebResult(name = "produtos")
	public ListaProdutoDTO getAll(@WebParam(name= "token", header = true) Token token, 
			@WebParam(name="paginacao") @XmlElement(required = false) boolean paginacao) {
		boolean isAuthenticated = AuthorizationValidator.tokenValidator(token);
		
		if (!isAuthenticated) {
			throw new AuthorizationException("00051", "You are not allowed to make the request");
		}
		
		List<ProdutoDTO> produtos = produtoService.getAll();
		
		return new ListaProdutoDTO(produtos);
	}
	
	@WebMethod(operationName = "getProdutoById")
	@WebResult(name = "produto")
	public ProdutoDTO getProdutoById(@WebParam(name = "token", header = true) Token token, 
			@WebParam(name = "id") @XmlElement(required = true) Long id) {
		boolean isAuthenticated = AuthorizationValidator.tokenValidator(token);
		
		if (!isAuthenticated) {
			throw new AuthorizationException("00051", "You are not allowed to make the request");
		}
		return produtoService.getProdutoById(id);
	}
	
}
