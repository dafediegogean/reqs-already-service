package br.com.reqs.already.domain.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
