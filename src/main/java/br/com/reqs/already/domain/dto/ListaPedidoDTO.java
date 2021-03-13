package br.com.reqs.already.domain.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * POJO que representa uma lista do tipo {@link List} de {@link PedidoDTO},
 * de pedidos.
 * 
 * @author <a href="mailto:dafediegogean@gmail.com">Diego Gean da Fé</a>
 * @version
 * @since 13 de mar de 2021, 18:03:10
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaPedidoDTO {

	@XmlElement(name =  "pedido")
	private List<PedidoDTO> pedidos;

	public ListaPedidoDTO(List<PedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}

	public ListaPedidoDTO() {

	}

	public List<PedidoDTO> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}
	
}
