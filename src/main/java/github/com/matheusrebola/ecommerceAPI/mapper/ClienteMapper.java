package github.com.matheusrebola.ecommerceAPI.mapper;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClienteMapper {
	private final ModelMapper modelMapper;

	public Cliente map(ClienteCreateDTO dto) {
		Cliente cliente = modelMapper.map(dto, Cliente.class);
		cliente.setDataCadastro(Instant.now());
		return cliente;
	}

	public ClienteDTO map(Cliente cliente) {
		ClienteDTO dto = modelMapper.map(cliente, ClienteDTO.class);
		return dto;
	}
}
