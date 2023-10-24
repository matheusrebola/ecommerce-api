package com.matheusrebola.service;

import java.util.List;
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
		return rodutoRepository.findById(id).orElse(null);
	}

}
