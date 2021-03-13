package br.com.reqs.already.domain.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.reqs.already.core.adapter.DateAdapter;

/**
 * POJO que representa a entidade {@link Pedido}. DTO para uso
 * no WS.
 * 
 * @author <a href="mailto:dafediegogean@gmail.com">Diego Gean da Fé</a>
 * @version
 * @since 24 de out de 2020, 15:25:10
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class PedidoDTO {
	
	@XmlElement(required = false)
	private Long id;

	@XmlElement(required = true)
	private ProdutoDTO produto;
	
	@XmlElement(required = true)
	private String descricao;
	
	@XmlElement(required = true)
	private Integer quantidade;
	
	@XmlJavaTypeAdapter(DateAdapter.class)
	@XmlElement(required = true)
	private Date dataCompra;

	public PedidoDTO() {
		
	}

	public PedidoDTO(Long id, ProdutoDTO produto, String descricao, Integer quantidade, Date dataCompra) {
		this.id = id;
		this.produto = produto;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.dataCompra = dataCompra;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

}
