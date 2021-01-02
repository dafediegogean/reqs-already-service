package br.com.reqs.already.domain.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * POJO que representa uma lista do tipo {@link List} de {@link ProdutoDTO},
 * de produtos.
 * 
 * @author <a href="mailto:dafediegogean@gmail.com">Diego Gean da Fé</a>
 * @version
 * @since 01 de jan de 2020, 17:40:14
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaProdutoDTO {

	@XmlElement(name = "produto")
	private List<ProdutoDTO> produtos;

	public ListaProdutoDTO(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}

	public ListaProdutoDTO() {
		
	}

	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}
	
}
