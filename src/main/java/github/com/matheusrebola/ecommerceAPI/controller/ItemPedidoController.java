package github.com.matheusrebola.ecommerceAPI.controller;

import java.util.List;
import java.util.stream.Collectors;

import github.com.matheusrebola.ecommerceAPI.dtos.ItemPedidoDTO;
import github.com.matheusrebola.ecommerceAPI.model.ItemPedido;
import github.com.matheusrebola.ecommerceAPI.service.ItemPedidoService;
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
<<<<<<< HEAD
	private ItemPedidoService itemPedidoService;
	private ModelMapper modelMapper;
=======
	private final ItemPedidoService itemPedidoService;
	private final ModelMapper itemPedidoMapper;
>>>>>>> 0fcdbe09f96d99ed2996683265b856409e4da340

    @GetMapping
    public ResponseEntity<List<ItemPedidoDTO>> getAll() {

        // mapear/converter cada Cliente -> ClienteDTO
        List<ClienteDTO> result = 
        		itemPedidoService
        		.getAll()
        		.stream()
        		.map(clienteMapper::map)
        		.collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ItemPedidoDTO> findById(@PathVariable long id) {
        if (!itemPedidoService.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        ItemPedidoDTO dto = itemPedidoMapper.map(itemPedidoService.findById(id));

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("{id}/pedidos")
    public ResponseEntity<List<ItemPedidoDTO>> findPedidosByClienteId(@PathVariable long id) {
        if (!itemPedidoService.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        List<ItemPedidoDTO> dto = 
        		itemPedidoService
        		.findByCliente(id)
        		.stream()
        		.map(pedidoMapper::map)
        		.collect(Collectors.toList());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ItemPedidoDTO> create(@Valid @RequestBody ItemPedidoCreateDTO requestDto) {

        ItemPedido itemPedido = itemPedidoMapper.map(requestDto);

        ItemPedido itemPedidoSaved = itemPedidoService.save(itemPedido);

        ItemPedidoDTO responseDto = itemPedidoMapper.map(itemPedidoSaved);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}
