package br.com.reqs.already.infrastructure.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.reqs.already.domain.dto.ProdutoDTO;
import br.com.reqs.already.domain.entity.Produto;
import br.com.reqs.already.infrastructure.dao.ProdutoDAO;

/**
 * Classe que representa a camada de negócios, onde possui toda a representação
 * de negócio do escopo de produto do sistema.
 * 
 * @author <a href="mailto:dafediegogean@gmail.com">Diego Gean da Fé</a>
 * @version
 * @since 21 de nov de 2020, 22:03:10
 */
@Stateless
public class ProdutoService {
	
	@Inject
	ProdutoDAO produtoDAO;
	
	/**
	 * Método getAll(),busca e retorna todos os produtos cadastrados 
	 * na base de dados.
	 * 
	 * @return List<ProdutoDTO>
	 */
	public List<ProdutoDTO> getAll() {
		return produtoDAO.findAll();
	}
	
	/**
	 * Método getProdutoById(Long id), recebe como parâmetro o id do tipo
	 * java.lang.Long, e busca o produto em base de dados pelo id. Faz se
	 * o set do objeto DTO do tipo produto.
	 * 
	 * @param id
	 * @return produtoDto
	 */
	public ProdutoDTO getProdutoById(Long id) {
		Produto produto = produtoDAO.findById(id);
		ProdutoDTO produtoDto = new ProdutoDTO();
		produtoDto.setId(produto.getId());
		produtoDto.setNome(produto.getNome());
		produtoDto.setValor(produto.getValor());
		return produtoDto;
	}
	
	/**
	 * Método salvar(ProdutoDTO produtoDTO), recebe como parâmetro objeto
	 * do tipo produto, e persiste no banco de dados. 
	 * 
	 * @param produtoDTO
	 */
	public void salvar(ProdutoDTO produtoDTO) {
		Produto produto = new Produto();
		produto.setNome(produtoDTO.getNome());
		produto.setValor(produtoDTO.getValor());
		produtoDAO.salvar(produto);
	}
	
}
