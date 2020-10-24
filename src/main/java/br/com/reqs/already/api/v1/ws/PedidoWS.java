package br.com.reqs.already.api.v1.ws;

import java.math.BigInteger;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.bind.annotation.XmlElement;

import br.com.reqs.already.domain.model.Pedido;

@WebService
public class PedidoWS {
	
	@Produces
	@PersistenceContext
    private EntityManager em;
    
	@WebMethod(operationName = "getPedido")
	@WebResult(name = "pedido")
	public Pedido getPedido(@WebParam(name = "id") @XmlElement(required = true ) Long id) {
		Pedido pedido = new Pedido();
		
		Query query = em.createNativeQuery("select * from pedido");
		List<Object[]> pedidos = query.getResultList();
		System.out.println(pedidos);
		for (Object[] object : pedidos) {
			System.out.println(object);
			br.com.reqs.already.domain.entity.Pedido p = new br.com.reqs.already.domain.entity.Pedido();
			p.setId(Long.valueOf(object[0].toString()));
			p.setDescricao(object[1].toString());
			System.out.println(p);
		}
		
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
