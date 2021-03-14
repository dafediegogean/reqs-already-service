package br.com.reqs.already.infrastructure.service;

import java.util.List;

import br.com.reqs.already.domain.dto.ProdutoDTO;

public interface ProdutoService {

	/**
	 * Método getAll(),busca e retorna todos os produtos cadastrados 
	 * na base de dados.
	 * 
	 * @return List<ProdutoDTO>
	 */
	List<ProdutoDTO> getAll();

	/**
	 * Método getProdutoById(Long id), recebe como parâmetro o id do tipo
	 * java.lang.Long, e busca o produto em base de dados pelo id. Faz se
	 * o set do objeto DTO do tipo produto.
	 * 
	 * @param id
	 * @return produtoDto
	 */
	ProdutoDTO getProdutoById(Long id);

	/**
	 * Método salvar(ProdutoDTO produtoDTO), recebe como parâmetro objeto
	 * do tipo produto, e persiste no banco de dados. 
	 * 
	 * @param produtoDTO
	 */
	void salvar(ProdutoDTO produtoDTO);
	
	/**
	 * Método atualizar(ProdutoDTO produtoDTO, Long id), recebe como parâmetro o
	 * objeto do tipo ProdutoDTO, e faz o merge do objeto caso já exista
	 * em banco de dados.
	 * 
	 * @param produtoDTO
	 * @return produtoDTO
	 */
	ProdutoDTO atualizar(ProdutoDTO produtoDTO);
	
	/**
	 * Método excluir(Long id), recebe como parâmetro o id do produto
	 * para remover do banco de dados.
	 * 
	 * @param id
	 */
	void excluir(Long id);

}