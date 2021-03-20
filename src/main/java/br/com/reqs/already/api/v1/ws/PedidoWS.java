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
import br.com.reqs.already.domain.dto.ListaPedidoDTO;
import br.com.reqs.already.domain.dto.PedidoDTO;
import br.com.reqs.already.domain.model.Token;
import br.com.reqs.already.infrastructure.service.PedidoService;

/**
 * WebService que atende as demais operations para buscar, criar, atualizar 
 * e remover ao pedido.
 * 
 * @author <a href="mailto:dafediegogean@gmail.com">Diego Gean da Fé</a>
 * @version
 * @since 30 de out de 2020, 21:42:10
 */
@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public class PedidoWS {
	
	@Inject
	private PedidoService pedidoService;
	
	/**
	 * Endpoint getPedidos, recebe como parâmetro o token no header, e um booleano, a 
	 * paginacao. Lista todos os pedidos cadastrados.
	 * 
	 * @param token
	 * @param paginacao
	 * @return ListaPedidoDTO
	 * @throws AuthorizationException 
	 */
	@WebMethod(operationName = "getPedidos")
	@WebResult(name = "pedidos")
	public ListaPedidoDTO getAll(@WebParam(name = "token", header = true) Token token,
			@WebParam(name = "paginacao") @XmlElement(required = false) boolean paginacao) throws AuthorizationException {
		boolean isAuthenticated = AuthorizationValidator.tokenValidator(token);		
		if (!isAuthenticated) {
			throw new AuthorizationException("Token inválido!");
		}
		
		List<PedidoDTO> pedidos = pedidoService.getAll();
		return new ListaPedidoDTO(pedidos);
	}
	
	/**
	 * Endpoint getPedidoById, recebe como parâmetro o token no header, e o id. Busca
	 * o pedido através do id passado.
	 * 
	 * @param token
	 * @param id
	 * @return ProdutoDTO
	 * @throws AuthorizationException
	 */
	@WebMethod(operationName = "getPedidoById")
	@WebResult(name = "pedido")
	public PedidoDTO getProdutoById(@WebParam(name = "token", header = true) Token token, 
			@WebParam(name = "id") @XmlElement(required = true) Long id) 
					throws AuthorizationException {
		boolean isAuthenticated = AuthorizationValidator.tokenValidator(token);
		
		if (!isAuthenticated) {
			throw new AuthorizationException("Token inválido!");
		}
		return pedidoService.getPedidoById(id);
	}
	
	/**
	 * Endpoint criar, recebe como parâmetro o token no header, e PedidoDTO. Cria
	 * um novo dado de pedido no banco de dados.
	 * 
	 * @param token
	 * @param pedidoDTO
	 * @throws AuthorizationException
	 */
	@WebMethod(operationName = "criarPedido")
	@WebResult(name = "pedido")
	public void criar(@WebParam(name = "token", header = true) Token token,
			@WebParam(name = "pedido") @XmlElement(required = true) PedidoDTO pedidoDTO) 
					throws AuthorizationException {
		boolean isAuthenticated = AuthorizationValidator.tokenValidator(token);
		
		if (!isAuthenticated) {
			throw new AuthorizationException("Token inválido!");
		}
		pedidoService.salvar(pedidoDTO);
	}
	
	/**
	 * Endpoint atualizar, recebe como parâmetro o token no header, PedidoDTO. 
	 * Atualiza um registro já existente no banco de dados.
	 * 
	 * @param token
	 * @param pedidoDTO
	 * @throws AuthorizationException
	 */
	@WebMethod(operationName = "atualizarPedido")
	@WebResult(name = "pedido")
	public void atualizar(@WebParam(name = "token", header = true) Token token,
			@WebParam(name = "pedido") @XmlElement(required = true) PedidoDTO pedidoDTO)
					throws AuthorizationException {
		boolean isAuthenticated = AuthorizationValidator.tokenValidator(token);
		
		if (!isAuthenticated) {
			throw new AuthorizationException("Token inválido!");
		}
		pedidoService.atualizar(pedidoDTO);
	}
	
	/**
	 * Endpoint remover, recebe como parâmetro o token no header, e o id do pedido,
	 * para remover da base de dados.
	 * 
	 * @param token
	 * @param id
	 * @throws AuthorizationException
	 */
	@WebMethod(operationName = "removerPedido")
	public void remover(@WebParam(name = "token", header = true) Token token, @WebParam(name = "id") 
		@XmlElement(required = true) Long id) throws AuthorizationException {
		boolean isAuthenticated = AuthorizationValidator.tokenValidator(token);
		
		if (!isAuthenticated) {
			throw new AuthorizationException("Token inválido!");
		}
		pedidoService.excluir(id);
	}
	
}
