package br.com.reqs.already.api.v1.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import br.com.reqs.already.domain.dto.PedidoDTO;

/**
 * Classe de exposição de WebService, e das demais operations para
 * buscar, criar, atualizar e remover de Pedidos.
 * 
 * @author <a href="mailto:dafediegogean@gmail.com">Diego Gean da Fé</a>
 * @version
 * @since 30 de out de 2020, 21:42:10
 */
@WebService
public class PedidoWS {
	  
	@WebMethod(operationName = "getPedido")
	@WebResult(name = "pedido")
	public PedidoDTO getPedido(@WebParam(name = "id") @XmlElement(required = true ) Long id) {
	
		return null;
	}
	
}
