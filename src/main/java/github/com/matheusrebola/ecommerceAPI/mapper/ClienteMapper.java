package github.com.matheusrebola.ecommerceAPI.mapper;

import github.com.matheusrebola.ecommerceAPI.dtos.ClienteCreateDTO;
import github.com.matheusrebola.ecommerceAPI.dtos.ClienteDTO;
import github.com.matheusrebola.ecommerceAPI.model.Cliente;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;

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
