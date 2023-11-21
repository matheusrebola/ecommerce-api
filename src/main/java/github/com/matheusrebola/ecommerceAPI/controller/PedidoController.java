package github.com.matheusrebola.ecommerceAPI.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import github.com.matheusrebola.ecommerceAPI.dtos.PedidoCreateDTO;
import github.com.matheusrebola.ecommerceAPI.dtos.PedidoDTO;
import github.com.matheusrebola.ecommerceAPI.mapper.PedidoMapper;
import github.com.matheusrebola.ecommerceAPI.model.Pedido;
import github.com.matheusrebola.ecommerceAPI.repository.PedidoRepository;
import github.com.matheusrebola.ecommerceAPI.service.PedidoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {
	private final PedidoService pedidoService;
    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getAll() {
        List<PedidoDTO> result = pedidoService.getAll().stream().map(pedidoMapper::map).collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<PedidoDTO> findByIdCliente(@PathVariable long id) {
        if (!pedidoService.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        PedidoDTO dto = pedidoMapper.map(pedidoService.findById(id));

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<PedidoDTO> create(@Valid @RequestBody PedidoCreateDTO requestDto) {

    	Pedido produto = pedidoMapper.map(requestDto);

    	Pedido produtoSaved = pedidoService.save(produto);

    	PedidoDTO responseDto = pedidoMapper.map(produtoSaved);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}