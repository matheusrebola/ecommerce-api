package github.com.matheusrebola.ecommerceAPI.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import github.com.matheusrebola.ecommerceAPI.dtos.ProdutoCreateDTO;
import github.com.matheusrebola.ecommerceAPI.dtos.ProdutoDTO;
import github.com.matheusrebola.ecommerceAPI.mapper.ProdutoMapper;
import github.com.matheusrebola.ecommerceAPI.model.Produto;
import github.com.matheusrebola.ecommerceAPI.repository.ProdutoRepository;
import github.com.matheusrebola.ecommerceAPI.service.ProdutoService;
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
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;
    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAll() {
        List<ProdutoDTO> result = produtoService.getAll().stream().map(produtoMapper::map).collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable long id) {
        if (!produtoService.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        ProdutoDTO dto = produtoMapper.map(produtoService.findById(id));

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<ProdutoDTO> create(@Valid @RequestBody ProdutoCreateDTO requestDto) {

        Produto produto = produtoMapper.map(requestDto);

        Produto produtoSaved = produtoService.save(produto);

        ProdutoDTO responseDto = produtoMapper.map(produtoSaved);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}