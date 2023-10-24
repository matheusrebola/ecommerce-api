package com.matheusrebola.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.acnaweb.ecommerce.model.Cliente;
import com.github.acnaweb.ecommerce.service.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {
	private final PedidoService pedidoService;
	private final ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<List<PedidoDTO>> getAll() {

		// mapear/converter cada Pedido -> PedidoDTO
		List<PedidoDTO> result = 
				clienteService.getAll()
				.stream()
				.map(this::map)
				.collect(Collectors.toList());

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<PedidoDTO> findById(@PathVariable long id) {
		if (!pedidoService.exists(id)) {
			return ResponseEntity.notFound().build();
		}

		PedidoDTO dto = this.map(pedidoService.findById(id));

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	private PedidoDTO map(Pedido pedido) {
		PedidoDTO dto = modelMapper.map(cliente, PedidoDTO.class);
		return dto;
	}
}
