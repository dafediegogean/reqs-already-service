package br.com.reqs.already.domain.dto;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.reqs.already.domain.entity.Produto;

/**
 * POJO que representa a entidade {@link Produto}. DTO para uso
 * no WS.
 * 
 * @author <a href="mailto:dafediegogean@gmail.com">Diego Gean da Fé</a>
 * @version
 * @since 24 de out de 2020, 22:16:10
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ProdutoDTO {
	
	@XmlElement(required = true)
	private Long id;
	
	@XmlElement(required = true)
	private String nome;
	
	@XmlElement(required = true)
	private BigDecimal valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
