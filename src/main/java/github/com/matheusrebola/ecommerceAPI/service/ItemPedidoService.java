package com.matheusrebola.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemPedidoService {

	private final ItemPedidoRepository itemPedidoRepository;

	public List<ItemPedido> getAll() {
		return itemPedidoRepository.findAll();
	}

	public boolean exists(long id) {
		return itemPedidoRepository.existsById(id);
	}

	public ItemPedido findById(long id) {
		return itemPedidoRepository.findById(id).orElse(null);
	}

}
