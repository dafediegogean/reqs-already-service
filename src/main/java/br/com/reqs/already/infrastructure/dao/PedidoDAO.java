package br.com.reqs.already.infrastructure.dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.reqs.already.core.jpa.AbstractJPA;
import br.com.reqs.already.domain.entity.Pedido;
import br.com.reqs.already.domain.entity.Produto;

/**
 * Classe que representa a camada de persistência (DAO), e que atende as demais
 * ao escopo de pedido.
 * 
 * @author <a href="mailto:dafediegogean@gmail.com">Diego Gean da Fé</a>
 * @version
 * @since13 de marc de 2021, 18:03:10
 */
@Named
public class PedidoDAO extends AbstractJPA {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Método findAll(),busca e retorna todos os produtos cadastrados 
	 * na base de dados.
	 * 
	 * @return listaProdutoDTO
	 */
	public List<Object[]> findAll() {
		Query query = em.createNativeQuery("SELECT * FROM TB_PEDIDO");
		
		List<Object[]> listaGenerica = query.getResultList();
		
		return listaGenerica;
	}
	
	/**
	 * Método findById(Long id), recebe como parâmetro o id do tipo
	 * java.lang.Long, e busca o pedido em base de dados pelo id.
	 * 
	 * @param id
	 * @return produto
	 */
	public Pedido findById(Long id) {
		return em.find(Pedido.class, id);
	}

	/**
	 * Método salvar(Pedido pedido), recebe como parâmetro objeto
	 * do tipo pedido, e persiste no banco de dados. 
	 * 
	 * @param pedidoDTO
	 */
	public void salvar(Pedido pedido) {
		em.persist(pedido);
	}

	public void excluir(Long id) {
		Pedido pedido = em.find(Pedido.class, id);
		em.remove(pedido);
	}
	
	/**
	 * Método atualizar(PedidoDTO pedidoDTO), recebe como parâmetro o
	 * objeto do tipo, PedidoDTO, e faz o merge do objeto caso já exista
	 * em banco de dados.
	 * 
	 * @param pedidoDTO
	 * @return pedidoDTO
	 */
	public void atualizar(Pedido pedido) {
		Pedido pedidoSalvo = em.find(Pedido.class, pedido.getId());
		Produto produto = new Produto();
		produto.setId(pedidoSalvo.getId());
		pedido.setProduto(new Produto());
		pedido.setProduto(produto);
		pedido.setDataCompra(pedidoSalvo.getDataCompra());
		em.merge(pedido);
	}
	
}
