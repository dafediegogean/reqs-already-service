package br.com.reqs.already.infrastructure.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.reqs.already.domain.dto.ProdutoDTO;
import br.com.reqs.already.infrastructure.dao.ProdutoDAO;

@Stateless
public class ProdutoService {
	
	@Inject
	ProdutoDAO produtoDAO;
	
	public ProdutoDTO getProduto(Long id) {
		produtoDAO.getProdutoById(id);
		return null;
	}
}
