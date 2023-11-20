package github.com.matheusrebola.ecommerceAPI.mapper;

import github.com.matheusrebola.ecommerceAPI.dtos.PedidoDTO;
import github.com.matheusrebola.ecommerceAPI.model.Pedido;
import org.modelmapper.ModelMapper;

public class PedidoMapper {
    private ModelMapper modelMapper;

    public PedidoDTO map(Pedido pedido) {
        PedidoDTO dto = modelMapper.map(pedido, PedidoDTO.class);

        dto.setCliente_id(pedido.getCliente().getId());

        return dto;
    }
}
