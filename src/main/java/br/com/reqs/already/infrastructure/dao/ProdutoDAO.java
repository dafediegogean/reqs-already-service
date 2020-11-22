package br.com.reqs.already.infrastructure.dao;

import javax.inject.Named;

import br.com.reqs.already.core.jpa.AbstractJPA;
import br.com.reqs.already.domain.dto.ProdutoDTO;

@Named
public class ProdutoDAO extends AbstractJPA {
	
	public ProdutoDTO getProdutoById(Long id) {
		System.out.println("ProdutoDAO");
		return null;
	}
	
}
