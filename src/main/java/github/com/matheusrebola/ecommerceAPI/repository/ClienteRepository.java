package com.github.matheusrebola.ecommerceAPI.repository;

import com.github.matheusrebola.ecommerceAPI.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
