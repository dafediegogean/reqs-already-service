package br.com.reqs.already.api.v1.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import br.com.reqs.already.domain.model.Pedido;

@WebService
public class PedidoWS {
	
	@WebMethod(operationName = "getPedido")
	@WebResult(name = "pedido")
	public Pedido getPedido(@WebParam(name = "id") @XmlElement(required = true ) Long id) {
		Pedido pedido = new Pedido();
		
		if (id == 1L) {
			pedido.setId(1L);
			pedido.setNome("Compra Kit Camiseta Promo");
		} else {
			pedido.setId(2L);
			pedido.setNome("Compra Celular Samsung Galaxy");
		}
		return pedido;
	}
	
}
