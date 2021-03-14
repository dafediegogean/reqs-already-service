package br.com.reqs.already.infrastructure.service;

import java.util.List;

import br.com.reqs.already.domain.dto.PedidoDTO;
import br.com.reqs.already.domain.dto.ProdutoDTO;

public interface PedidoService {

	/**
	 * Método getAll(),busca e retorna todos os pedidos cadastrados 
	 * na base de dados.
	 * 
	 * @return List<ProdutoDTO>
	 */
	List<PedidoDTO> getAll();

	/**
	 * Método getPedidoById(Long id), recebe como parâmetro o id do tipo
	 * java.lang.Long, e busca o pedido em base de dados pelo id. Faz se
	 * o set do objeto DTO do tipo pedido.
	 * 
	 * @param id
	 * @return pedidoDto
	 */
	PedidoDTO getPedidoById(Long id);

	/**
	 * Método salvar(PedidoDTO pedidoDTO), recebe como parâmetro objeto
	 * do tipo pedido, e persiste no banco de dados. 
	 * 
	 * @param pedidoDTO
	 */
	void salvar(PedidoDTO pedidoDTO);

	/**
	 * Método excluir(Long id), recebe como parâmetro o id do pedido
	 * para remover do banco de dados.
	 * 
	 * @param id
	 */
	void excluir(Long id);
	
	/**
	 * Método atualizar(PedidoDTO pedidoDTO), recebe como parâmetro o
	 * objeto do tipo, PedidoDTO, e faz o merge do objeto caso já exista
	 * em banco de dados.
	 * 
	 * @param pedidoDTO
	 * @return pedidoDTO
	 */
	void atualizar(PedidoDTO pedidoDTO);

}
