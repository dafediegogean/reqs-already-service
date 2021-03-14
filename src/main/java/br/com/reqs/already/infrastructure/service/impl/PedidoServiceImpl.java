package br.com.reqs.already.infrastructure.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.reqs.already.domain.dto.PedidoDTO;
import br.com.reqs.already.domain.dto.ProdutoDTO;
import br.com.reqs.already.domain.entity.Pedido;
import br.com.reqs.already.domain.entity.Produto;
import br.com.reqs.already.infrastructure.dao.PedidoDAO;
import br.com.reqs.already.infrastructure.dao.ProdutoDAO;
import br.com.reqs.already.infrastructure.service.PedidoService;

@Stateless
public class PedidoServiceImpl implements PedidoService {

	@Inject
	private PedidoDAO pedidoDAO;
	
	@Inject
	private ProdutoDAO produtoDAO;

	/**
	 * Método getAll(),busca e retorna todos os pedidos cadastrados 
	 * na base de dados.
	 * 
	 * @return List<PedidoDTO>
	 */
	@Override
	public List<PedidoDTO> getAll() {
		List<PedidoDTO> listaPedidoDTO = new ArrayList<PedidoDTO>();
		
		List<Object[]> listaGenerica = pedidoDAO.findAll();
	
		for (Object[] object : listaGenerica) {
			PedidoDTO pedidoDTO = new PedidoDTO();
			Produto produto = new Produto();
			ProdutoDTO produtoDTO = new ProdutoDTO();
			pedidoDTO.setId(Long.valueOf(object[0].toString()));
			produto = produtoDAO.findById(Long.valueOf(object[1].toString()));
			produtoDTO.setId(produto.getId());
			produtoDTO.setNome(produto.getNome());
			produtoDTO.setValor(produto.getValor());
			pedidoDTO.setProduto(produtoDTO);
			pedidoDTO.setDescricao((String) object[2]);
			pedidoDTO.setQuantidade((Integer) object[3]);
			pedidoDTO.setDataCompra((Date) object[4]);
			listaPedidoDTO.add(pedidoDTO);
		}
		return listaPedidoDTO;
	}

	/**
	 * Método getPedidoById(Long id), recebe como parâmetro o id do tipo
	 * java.lang.Long, e busca o pedido em base de dados pelo id. Faz se
	 * o set do objeto DTO do tipo pedido.
	 * 
	 * @param id
	 * @return peditoDto
	 */
	@Override
	public PedidoDTO getPedidoById(Long id) {
		Pedido pedido = pedidoDAO.findById(id);
		PedidoDTO pedidoDTO = new PedidoDTO();
		pedidoDTO.setId(pedido.getId());
		pedidoDTO.setDescricao(pedido.getDescricao());
		
		ProdutoDTO produtoDTO = new ProdutoDTO();
		produtoDTO.setId(pedido.getProduto().getId());
		produtoDTO.setNome(pedido.getProduto().getNome());
		produtoDTO.setValor(pedido.getProduto().getValor());
		pedidoDTO.setProduto(produtoDTO);
		
		pedidoDTO.setDataCompra(pedido.getDataCompra());
		return pedidoDTO;
	}

	/**
	 * Método salvar(PedidoDTO pedidoDTO), recebe como parâmetro objeto
	 * do tipo pedido, e persiste no banco de dados. 
	 * 
	 * @param pedidoDTO
	 */
	@Override
	public void salvar(PedidoDTO pedidoDTO) {
		Pedido pedido = new Pedido();
		
		Produto produto = new Produto();
		produto.setId(pedidoDTO.getProduto().getId());
		
		pedido.setProduto(produto);
		pedido.setDescricao(pedidoDTO.getDescricao());
		pedido.setQuantidade(pedidoDTO.getQuantidade());
		pedido.setDataCompra(pedidoDTO.getDataCompra());
		pedidoDAO.salvar(pedido);
	}

	/**
	 * Método excluir(Long id), recebe como parâmetro o id do pedido
	 * para remover do banco de dados.
	 * 
	 * @param id
	 */
	@Override
	public void excluir(Long id) {
		pedidoDAO.excluir(id);
	}

	/**
	 * Método atualizar(PedidoDTO pedidoDTO), recebe como parâmetro o
	 * objeto do tipo, PedidoDTO, e faz o merge do objeto caso já exista
	 * em banco de dados.
	 * 
	 * @param pedidoDTO
	 * @return pedidoDTO
	 */
	@Override
	public void atualizar(PedidoDTO pedidoDTO) {
		Pedido pedido = new Pedido();
		pedido.setId(pedidoDTO.getId());
		pedido.setDescricao(pedidoDTO.getDescricao());
		pedido.setQuantidade(pedidoDTO.getQuantidade());
		pedidoDAO.atualizar(pedido);
	}

}
