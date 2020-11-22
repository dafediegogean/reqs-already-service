package br.com.reqs.already.core.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Classe abstrata responsável por fazer o gerenciamento e de criar de 
 * novas instâncias do EntityManager.
 *  
 * @author <a href="mailto:dafediegogean@gmail.com">Diego Gean da Fé</a>
 * @version
 * @since 30 de out de 2020, 21:42:10
 */
public class AbstractJPA {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
}
