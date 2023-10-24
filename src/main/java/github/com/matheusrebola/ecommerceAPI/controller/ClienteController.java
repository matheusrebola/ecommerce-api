package github.com.matheusrebola.ecommerceAPI.controller;

import java.util.List;
import java.util.stream.Collectors;

import github.com.matheusrebola.ecommerceAPI.dtos.ClienteDTO;
import github.com.matheusrebola.ecommerceAPI.model.Cliente;
import github.com.matheusrebola.ecommerceAPI.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
	private final ClienteService clienteService;
	private final ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> getAll() {

		// mapear/converter cada Cliente -> ClienteDTO
		List<ClienteDTO> result = 
				clienteService.getAll()
				.stream()
				.map(this::map)
				.collect(Collectors.toList());

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable long id) {
		if (!clienteService.exists(id)) {
			return ResponseEntity.notFound().build();
		}

		ClienteDTO dto = this.map(clienteService.findById(id));

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	private ClienteDTO map(Cliente cliente) {
		ClienteDTO dto = modelMapper.map(cliente, ClienteDTO.class);
		return dto;
	}
}
