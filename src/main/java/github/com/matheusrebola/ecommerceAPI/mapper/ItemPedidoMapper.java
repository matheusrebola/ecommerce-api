package github.com.matheusrebola.ecommerceAPI.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import github.com.matheusrebola.ecommerceAPI.dtos.ItemPedidoCreateDTO;
import github.com.matheusrebola.ecommerceAPI.dtos.ItemPedidoDTO;
import github.com.matheusrebola.ecommerceAPI.model.ItemPedido;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ItemPedidoMapper {
	private final ModelMapper modelMapper;

    public ItemPedido map(ItemPedidoCreateDTO dto) {
    	ItemPedido itemPedido = modelMapper.map(dto, ItemPedido.class);
        return itemPedido;
    }

    public ItemPedidoDTO map(ItemPedido itemPedido) {
    	ItemPedidoDTO dto = modelMapper.map(itemPedido, ItemPedidoDTO.class);
        return dto;
    }
}
