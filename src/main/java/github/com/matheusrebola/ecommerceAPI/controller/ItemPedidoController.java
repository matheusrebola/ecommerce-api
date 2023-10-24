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

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/itenspedidos")
@RequiredArgsConstructor
public class ItemPedidoController {
	private final ItemPedidoService itemPedidoService;
	private final ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<List<ItemPedidoDTO>> getAll() {

		// mapear/converter cada ItemPedido -> ItemPedidoDTO
		List<ItemPedidoDTO> result = 
				itemPedidoService.getAll()
				.stream()
				.map(this::map)
				.collect(Collectors.toList());

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<ItemPedidoDTO> findById(@PathVariable long id) {
		if (!itemPedidoService.exists(id)) {
			return ResponseEntity.notFound().build();
		}

		ItemPedidoDTO dto = this.map(itemPedidoService.findById(id));

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	private ItemPedidoDTO map(ItemPedido itemPedido) {
		ItemPedidoDTO dto = modelMapper.map(itemPedido, ItemPedidoDTO.class);
		return dto;
	}
}
