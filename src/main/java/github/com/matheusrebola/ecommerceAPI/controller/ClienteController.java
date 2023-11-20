package github.com.matheusrebola.ecommerceAPI.controller;

import java.util.List;
import java.util.stream.Collectors;

import github.com.matheusrebola.ecommerceAPI.dtos.ClienteDTO;
import github.com.matheusrebola.ecommerceAPI.dtos.ClienteCreateDTO;
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
    private final ClienteRepository clienteRepository;
    private final PedidoService pedidoService;
    private final ClienteMapper clienteMapper;
    private final PedidoMapper pedidoMapper;
    
    @GetMapping("/param")
    public ResponseEntity<List<?>> findByUf(@RequestParam("uf") String uf, @RequestParam("tipo") String tipo) {

        List<?> result = null;
        if ("1".equals(tipo))
            result = clienteRepository.findByUf(
                    uf.toUpperCase(), ClienteView1.class);
        else if ("2".equals(tipo))
            result = clienteRepository.findByUf(
                    uf.toUpperCase(), ClienteView2.class);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll() {

        // mapear/converter cada Cliente -> ClienteDTO
        List<ClienteDTO> result = clienteService.getAll().stream().map(clienteMapper::map).collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable long id) {
        if (!clienteService.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        ClienteDTO dto = clienteMapper.map(clienteService.findById(id));

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("{id}/pedidos")
    public ResponseEntity<List<PedidoDTO>> findPedidosByClienteId(@PathVariable long id) {
        if (!clienteService.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        List<PedidoDTO> dto = pedidoService.findByCliente(id).stream().map(pedidoMapper::map).collect(Collectors.toList());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteCreateDTO requestDto) {

        Cliente cliente = clienteMapper.map(requestDto);

        Cliente clienteSaved = clienteService.save(cliente);

        ClienteDTO responseDto = clienteMapper.map(clienteSaved);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}
