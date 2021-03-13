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
 * WebService que atende as demais operations para buscar, criar, atualizar 
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
	
	/**
	 * Endpoint getAll, recebe como parâmetro o token no header, e um booleano, a 
	 * paginacao. Lista todos os produtos cadastrados.
	 * 
	 * @param token
	 * @param paginacao
	 * @return ListaProdutoDTO
	 * @throws AuthorizationException 
	 */
	@WebMethod(operationName = "getProdutos")
	@WebResult(name = "produtos")
	public ListaProdutoDTO getAll(@WebParam(name= "token", header = true) Token token, 
			@WebParam(name="paginacao") @XmlElement(required = false) boolean paginacao) 
					throws AuthorizationException {
		boolean isAuthenticated = AuthorizationValidator.tokenValidator(token);
		
		if (!isAuthenticated) {
			throw new AuthorizationException("Token inválido!");
		}
		
		List<ProdutoDTO> produtos = produtoService.getAll();
		
		return new ListaProdutoDTO(produtos);
	}
	
	/**
	 * Endpoint getProdutoById, recebe como parâmetro o token no header, e o id. Busca
	 * o produto através do id passado.
	 * 
	 * @param token
	 * @param id
	 * @return ProdutoDTO
	 * @throws AuthorizationException
	 */
	@WebMethod(operationName = "getProdutoById")
	@WebResult(name = "produto")
	public ProdutoDTO getProdutoById(@WebParam(name = "token", header = true) Token token, 
			@WebParam(name = "id") @XmlElement(required = true) Long id) 
					throws AuthorizationException {
		boolean isAuthenticated = AuthorizationValidator.tokenValidator(token);
		
		if (!isAuthenticated) {
			throw new AuthorizationException("Token inválido!");
		}
		return produtoService.getProdutoById(id);
	}
	
	/**
	 * Endpoint criar, recebe como parâmetro o token no header, e ProdutoDTO. Cria
	 * um novo dado de produto no banco de dados.
	 * 
	 * @param token
	 * @param produtoDTO
	 * @throws AuthorizationException
	 */
	@WebMethod(operationName = "criarProduto")
	@WebResult(name = "produto")
	public void criar(@WebParam(name = "token", header = true) Token token,
			@WebParam(name = "produto") @XmlElement(required = true) ProdutoDTO produtoDTO) 
					throws AuthorizationException {
		boolean isAuthenticated = AuthorizationValidator.tokenValidator(token);
		
		if (!isAuthenticated) {
			throw new AuthorizationException("Token inválido!");
		}
		produtoService.salvar(produtoDTO);
	}
	
	/**
	 * Endpoint remover, recebe como parâmetro o token no header, e o id do produto,
	 * para remover da base de dados.
	 * 
	 * @param token
	 * @param id
	 * @throws AuthorizationException
	 */
	@WebMethod(operationName = "removerProduto")
	public void remover(@WebParam(name = "token", header = true) Token token, @WebParam(name = "id") 
		@XmlElement(required = true) Long id) throws AuthorizationException {
		boolean isAuthenticated = AuthorizationValidator.tokenValidator(token);
		
		if (!isAuthenticated) {
			throw new AuthorizationException("Token inválido!");
		}
		produtoService.excluir(id);
	}
	
}
