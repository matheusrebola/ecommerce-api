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
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {
	private final ProdutoService clienteService;
	private final ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> getAll() {

		// mapear/converter cada produtoDTO -> ProdutoDTO
		List<ProdutoDTO> result = 
				produtoService.getAll()
				.stream()
				.map(this::map)
				.collect(Collectors.toList());

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable long id) {
		if (!produtoService.exists(id)) {
			return ResponseEntity.notFound().build();
		}

		ProdutoDTO dto = this.map(produtoService.findById(id));

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	private ProdutoDTO map(Produto produto) {
		ProdutoDTO dto = modelMapper.map(produto, ProdutoDTO.class);
		return dto;
	}
}
