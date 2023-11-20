package github.com.matheusrebola.ecommerceAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import github.com.matheusrebola.ecommerceAPI.model.Cliente;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
<<<<<<< HEAD
    <T> List<T> findByUf(String uf, Class<T> type);
=======
	<T> List<T> findByUf(String uf, Class<T> type);
>>>>>>> 0fcdbe09f96d99ed2996683265b856409e4da340
}
