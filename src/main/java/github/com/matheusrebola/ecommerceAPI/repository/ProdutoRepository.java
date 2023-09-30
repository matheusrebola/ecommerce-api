package com.github.matheusrebola.ecommerceAPI.repository;

import com.github.matheusrebola.ecommerceAPI.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}