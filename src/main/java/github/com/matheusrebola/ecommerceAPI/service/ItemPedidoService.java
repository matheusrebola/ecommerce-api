package github.com.matheusrebola.ecommerceAPI.service;


import github.com.matheusrebola.ecommerceAPI.model.ItemPedido;
import github.com.matheusrebola.ecommerceAPI.repository.ItemPedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

	public ItemPedido save(ItemPedido itemPedido) {
		return itemPedidoRepository.save(itemPedido);
	}
}
