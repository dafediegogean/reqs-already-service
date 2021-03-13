package br.com.reqs.already.infrastructure.dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.reqs.already.core.jpa.AbstractJPA;
import br.com.reqs.already.domain.entity.Produto;

/**
 * Classe que representa a camada de persistência (DAO), e que atende a demais
 * ao escopo de produto.
 * 
 * @author <a href="mailto:dafediegogean@gmail.com">Diego Gean da Fé</a>
 * @version
 * @since 21 de nov de 2020, 22:03:10
 */
@Named
public class ProdutoDAO extends AbstractJPA {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Método findAll(),busca e retorna todos os produtos cadastrados 
	 * na base de dados.
	 * 
	 * @return listaProdutoDTO
	 */
	public List<Object[]> findAll() {
		Query query = em.createNativeQuery("SELECT * FROM TB_PRODUTO");
		
		List<Object[]> listaGenerica = query.getResultList();
		
		return listaGenerica;
	}
	
	/**
	 * Método findById(Long id), recebe como parâmetro o id do tipo
	 * java.lang.Long, e busca o produto em base de dados pelo id.
	 * 
	 * @param id
	 * @return produto
	 */
	public Produto findById(Long id) {
		return em.find(Produto.class, id);
	}

	/**
	 * Método salvar(ProdutoDTO produtoDTO), recebe como parâmetro objeto
	 * do tipo produto, e persiste no banco de dados. 
	 * 
	 * @param produtoDTO
	 */
	public void salvar(Produto produto) {
		em.persist(produto);
	}
	
	public Produto atualizar(Produto produto) {
		return em.merge(produto);
	}

	/**
	 * Método excluir(Long id), recebe como parâmetro o id do produto
	 * para remover do banco de dados.
	 * 
	 * @param id
	 */
	@Transactional
	public void excluir(Long id) {
		Produto produto = em.find(Produto.class, id);
		em.remove(produto);	
	}
	
}
