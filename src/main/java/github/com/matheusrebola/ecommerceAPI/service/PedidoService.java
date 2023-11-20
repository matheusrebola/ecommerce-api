package github.com.matheusrebola.ecommerceAPI.service;

import java.util.List;

import github.com.matheusrebola.ecommerceAPI.model.Cliente;
import github.com.matheusrebola.ecommerceAPI.model.Pedido;
import github.com.matheusrebola.ecommerceAPI.repository.ClienteRepository;
import github.com.matheusrebola.ecommerceAPI.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {

	private final PedidoRepository pedidoRepository;
	private final ClienteRepository clienteRepository;

	public List<Pedido> getAll() {
		return pedidoRepository.findAll();
	}

	public boolean exists(long id) {
		return pedidoRepository.existsById(id);
	}

	public Pedido findById(long id) {

		return pedidoRepository.findById(id).orElse(null);
	}

	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public Cliente findByCliente(long id) {
		return clienteRepository.findById(id).orElse(null);
	}
}
