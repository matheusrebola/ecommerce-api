package github.com.matheusrebola.ecommerceAPI.service;


import github.com.matheusrebola.ecommerceAPI.model.Cliente;
import github.com.matheusrebola.ecommerceAPI.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
<<<<<<< HEAD
=======

>>>>>>> 0fcdbe09f96d99ed2996683265b856409e4da340
}
