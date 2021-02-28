package br.com.reqs.already.infrastructure.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.reqs.already.domain.dto.ProdutoDTO;
import br.com.reqs.already.domain.entity.Produto;
import br.com.reqs.already.infrastructure.dao.ProdutoDAO;
import br.com.reqs.already.infrastructure.service.ProdutoService;

/**
 * Classe que representa a camada de negócios, onde possui toda a representação
 * de negócio do escopo de produto do sistema.
 * 
 * @author <a href="mailto:dafediegogean@gmail.com">Diego Gean da Fé</a>
 * @version
 * @since 21 de nov de 2020, 22:03:10
 */
@Stateless
public class ProdutoServiceImpl implements ProdutoService {
	
	@Inject
	ProdutoDAO produtoDAO;
	
	/**
	 * Método getAll(),busca e retorna todos os produtos cadastrados 
	 * na base de dados.
	 * 
	 * @return List<ProdutoDTO>
	 */
	@Override
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
	@Override
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
	@Override
	public void salvar(ProdutoDTO produtoDTO) {
		Produto produto = new Produto();
		produto.setNome(produtoDTO.getNome());
		produto.setValor(produtoDTO.getValor());
		produtoDAO.salvar(produto);
	}

	/**
	 * Método atualizar(ProdutoDTO produtoDTO), recebe como parâmetro o
	 * objeto do tipo ProdutoDTO, e faz o merge do objeto caso já exista
	 * em banco de dados.
	 * 
	 * @param produtoDTO
	 * @return produtoDTO
	 */
	@Override
	public ProdutoDTO atualizar(ProdutoDTO produtoDTO) {
		Produto produto = new Produto();
		produto.setId(produtoDTO.getId());
		produto.setNome(produto.getNome());
		produto.setValor(produto.getValor());
		
		Produto produtoSalvo = produtoDAO.atualizar(produto);
		produtoDTO.setNome(produtoSalvo.getNome());
		produtoDTO.setValor(produtoSalvo.getValor());
		
		return produtoDTO;
	}
	
}
