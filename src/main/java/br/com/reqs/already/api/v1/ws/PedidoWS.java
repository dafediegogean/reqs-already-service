package br.com.reqs.already.api.v1.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.bind.annotation.XmlElement;

import br.com.reqs.already.domain.dto.PedidoDTO;

/**
 * WebService que atende a demais operations para buscar, criar, atualizar 
 * e remover ao pedido.
 * 
 * @author <a href="mailto:dafediegogean@gmail.com">Diego Gean da Fé</a>
 * @version
 * @since 30 de out de 2020, 21:42:10
 */
@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public class PedidoWS {
	  
	@WebMethod(operationName = "getPedido")
	@WebResult(name = "pedido")
	public PedidoDTO getPedido(@WebParam(name = "id") 
		@XmlElement(required = true ) Long id) {
		return null;
	}
	
}
