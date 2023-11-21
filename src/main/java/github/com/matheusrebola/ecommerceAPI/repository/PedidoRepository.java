package github.com.matheusrebola.ecommerceAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import github.com.matheusrebola.ecommerceAPI.model.Pedido;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query("select o from Pedido o where o.cliente.id = :id")
    List<Pedido> findByCliente(@Param("id") Long id);
}
