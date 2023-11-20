package github.com.matheusrebola.ecommerceAPI.mapper;

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
}
