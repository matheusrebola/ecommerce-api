package github.com.matheusrebola.ecommerceAPI.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import github.com.matheusrebola.ecommerceAPI.service.PedidoService;
import github.com.matheusrebola.ecommerceAPI.dtos.PedidoDTO;
import github.com.matheusrebola.ecommerceAPI.model.Pedido;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {
	private final PedidoService pedidoService;
	private final PedidoMapper pedidoMapper;

	@GetMapping
	public ResponseEntity<List<PedidoDTO>> getAll() {

		List<PedidoDTO> result =
				pedidoService.getAll()
				.stream()
				.map(pedidoMapper::map)
				.collect(Collectors.toList());

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
