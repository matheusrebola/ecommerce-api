package github.com.matheusrebola.ecommerceAPI.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import github.com.matheusrebola.ecommerceAPI.dtos.ItemPedidoCreateDTO;
import github.com.matheusrebola.ecommerceAPI.dtos.ItemPedidoDTO;
import github.com.matheusrebola.ecommerceAPI.mapper.ItemPedidoMapper;
import github.com.matheusrebola.ecommerceAPI.model.ItemPedido;
import github.com.matheusrebola.ecommerceAPI.repository.ItemPedidoRepository;
import github.com.matheusrebola.ecommerceAPI.service.ItemPedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/itens")
@RequiredArgsConstructor
public class ItemPedidoController {
	private final ItemPedidoService itemPedidoService;
    private final ItemPedidoRepository itemPedidoRepository;
    private final ItemPedidoMapper itemPedidoMapper;

    @GetMapping
    public ResponseEntity<List<ItemPedidoDTO>> getAll() {
        List<ItemPedidoDTO> result = itemPedidoService.getAll().stream().map(itemPedidoMapper::map).collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ItemPedidoDTO> findByIdCliente(@PathVariable long id) {
        if (!itemPedidoService.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        ItemPedidoDTO dto = itemPedidoMapper.map(itemPedidoService.findById(id));

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<ItemPedidoDTO> create(@Valid @RequestBody ItemPedidoCreateDTO requestDto) {

    	ItemPedido produto = itemPedidoMapper.map(requestDto);

    	ItemPedido produtoSaved = itemPedidoService.save(produto);

    	ItemPedidoDTO responseDto = itemPedidoMapper.map(produtoSaved);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}