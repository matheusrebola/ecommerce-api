package github.com.matheusrebola.ecommerceAPI.service;

import java.util.List;

import github.com.matheusrebola.ecommerceAPI.model.Produto;
import github.com.matheusrebola.ecommerceAPI.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {

	private final ProdutoRepository produtoRepository;

	public List<Produto> getAll() {
		return produtoRepository.findAll();
	}

	public boolean exists(long id) {
		return produtoRepository.existsById(id);
	}

	public Produto findById(long id) {

		return produtoRepository.findById(id).orElse(null);
	}

	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}
}
