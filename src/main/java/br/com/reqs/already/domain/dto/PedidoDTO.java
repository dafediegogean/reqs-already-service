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
	private String descricao;
	
	@XmlElement(required = true)
	private ProdutoDTO produtoDTO;
	
	@XmlJavaTypeAdapter(DateAdapter.class)
	@XmlElement(required = true)
	private Date dataCompra;
	
	@XmlElement(required = true)
	private Integer quantidade;

	public PedidoDTO() {
		
	}

	public PedidoDTO(Long id, String descricao, ProdutoDTO produtoDTO, Date dataCompra, Integer quantidade) {
		this.id = id;
		this.descricao = descricao;
		this.produtoDTO = produtoDTO;
		this.dataCompra = dataCompra;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ProdutoDTO getProdutoDTO() {
		return produtoDTO;
	}

	public void setProdutoDTO(ProdutoDTO produtoDTO) {
		this.produtoDTO = produtoDTO;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
