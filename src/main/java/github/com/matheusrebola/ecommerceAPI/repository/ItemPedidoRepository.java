package com.github.matheusrebola.ecommerceAPI.repository;

import com.github.matheusrebola.ecommerceAPI.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}