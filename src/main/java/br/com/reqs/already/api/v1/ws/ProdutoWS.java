package br.com.reqs.already.api.v1.ws;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import br.com.reqs.already.domain.dto.ProdutoDTO;
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
public class ProdutoWS {
	
	@Inject
	private ProdutoService produtoService;
	
	/**
	 * Método getProduto(Long id), recebe como parâmetro o id, para
	 * buscar um produto pelo id. 
	 * 
	 * @param id
	 * @return ProdutoDTO
	 */
	@WebMethod(operationName = "getProduto")
	@WebResult(name = "produto")
	public ProdutoDTO getProduto(@WebParam(name = "id") @XmlElement(required = true) Long id) {
		return produtoService.getProdutoById(id);
	}
}
