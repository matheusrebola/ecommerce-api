package com.matheusrebola.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public List<Cliente> getAll() {
		return clienteRepository.findAll();
	}

	public boolean exists(long id) {
		return clienteRepository.existsById(id);
	}

	public Cliente findById(long id) {
		return clienteRepository.findById(id).orElse(null);
	}

}
