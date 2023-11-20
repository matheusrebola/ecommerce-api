package github.com.matheusrebola.ecommerceAPI.mapper;

<<<<<<< HEAD
import github.com.matheusrebola.ecommerceAPI.dtos.ClienteCreateDTO;
import github.com.matheusrebola.ecommerceAPI.dtos.ClienteDTO;
import github.com.matheusrebola.ecommerceAPI.model.Cliente;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;
=======
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
>>>>>>> 0fcdbe09f96d99ed2996683265b856409e4da340

@Component
@RequiredArgsConstructor
public class ClienteMapper {
<<<<<<< HEAD
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
=======
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
>>>>>>> 0fcdbe09f96d99ed2996683265b856409e4da340
}
