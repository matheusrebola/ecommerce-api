package github.com.matheusrebola.ecommerceAPI.mapper;

<<<<<<< HEAD
import github.com.matheusrebola.ecommerceAPI.dtos.PedidoCreateDTO;
import github.com.matheusrebola.ecommerceAPI.dtos.PedidoDTO;
import github.com.matheusrebola.ecommerceAPI.model.Pedido;


import org.modelmapper.ModelMapper;

public class PedidoMapper {
    private final ModelMapper modelMapper;

    public Pedido map(PedidoCreateDTO dto) {
    	Pedido pedido = modelMapper.map(dto, Pedido.class);
        return pedido;
    }

    public PedidoDTO map(Pedido pedido) {
    	PedidoDTO dto = modelMapper.map(pedido, PedidoDTO.class);
        return dto;
    }
=======
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PedidoMapper {
	private final ModelMapper modelMapper;

	public PedidoDTO map(Pedido pedido) {
		PedidoDTO dto = modelMapper.map(pedido, PedidoDTO.class);

		dto.setCliente_id(pedido.getCliente().getId());

		return dto;
	}
>>>>>>> 0fcdbe09f96d99ed2996683265b856409e4da340
}
