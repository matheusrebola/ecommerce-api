package github.com.matheusrebola.ecommerceAPI.dtos;

import java.math.BigDecimal;

<<<<<<< HEAD
import github.com.matheusrebola.ecommerceAPI.model.Pedido;
import github.com.matheusrebola.ecommerceAPI.model.Produto;
=======
>>>>>>> 0fcdbe09f96d99ed2996683265b856409e4da340
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoCreateDTO {
<<<<<<< HEAD
=======

>>>>>>> 0fcdbe09f96d99ed2996683265b856409e4da340
	private Pedido pedido;
	private Produto produto;
	private BigDecimal quantidade;
	private BigDecimal valorUnitario;
	private BigDecimal valorTotal;
	private boolean ativo;
}
