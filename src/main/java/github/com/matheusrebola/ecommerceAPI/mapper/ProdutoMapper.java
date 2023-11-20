package github.com.matheusrebola.ecommerceAPI.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import github.com.matheusrebola.ecommerceAPI.dtos.ProdutoCreateDTO;
import github.com.matheusrebola.ecommerceAPI.dtos.ProdutoDTO;
import github.com.matheusrebola.ecommerceAPI.model.Produto;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProdutoMapper {
	private final ModelMapper modelMapper;

    public Produto map(ProdutoCreateDTO dto) {
    	Produto produto = modelMapper.map(dto, Produto.class);
        return produto;
    }

    public ProdutoDTO map(Produto produto) {
    	ProdutoDTO dto = modelMapper.map(produto, ProdutoDTO.class);
        return dto;
    }
}
