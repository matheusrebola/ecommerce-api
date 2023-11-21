package github.com.matheusrebola.ecommerceAPI.mapper;

import github.com.matheusrebola.ecommerceAPI.model.Pedido;
import github.com.matheusrebola.ecommerceAPI.repository.PedidoRepository;

import org.springframework.stereotype.Component;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PedidoMapper {
	private final PedidoRepository pedidoRepository;

	public List<Pedido> getAll() {
		return pedidoRepository.findAll();
	}

	public java.util.List<Pedido> findByCliente(long id) {

		return pedidoRepository.findByCliente(id);
	}
}
