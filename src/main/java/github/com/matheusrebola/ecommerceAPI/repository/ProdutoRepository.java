package github.com.matheusrebola.ecommerceAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import github.com.matheusrebola.ecommerceAPI.model.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}