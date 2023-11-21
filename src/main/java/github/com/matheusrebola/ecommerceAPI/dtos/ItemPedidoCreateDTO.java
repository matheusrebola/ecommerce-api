package github.com.matheusrebola.ecommerceAPI.dtos;

import java.math.BigDecimal;

import github.com.matheusrebola.ecommerceAPI.model.Pedido;
import github.com.matheusrebola.ecommerceAPI.model.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoCreateDTO {
	private Pedido pedido;
	private Produto produto;
	private BigDecimal quantidade;
	private BigDecimal valorUnitario;
	private BigDecimal valorTotal;
	private boolean ativo;
}
