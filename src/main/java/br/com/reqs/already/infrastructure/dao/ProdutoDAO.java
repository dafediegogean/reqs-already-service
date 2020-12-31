package br.com.reqs.already.infrastructure.dao;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	 * Método findById(Long id), recebe como parâmetro o id do tipo
	 * java.lang.Long, e busca o produto em base de dados pelo id.
	 * 
	 * @param id
	 * @return produto
	 */
	public Produto findById(Long id) {
		return em.find(Produto.class, id);
	}
	
}
