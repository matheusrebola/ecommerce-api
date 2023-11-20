package github.com.matheusrebola.ecommerceAPI.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import github.com.matheusrebola.ecommerceAPI.model.Cliente;
import github.com.matheusrebola.ecommerceAPI.model.SituacaoPedido;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoCreateDTO {
	private Long cliente_id;
	private LocalDateTime dataDoPedido;
	private LocalDateTime dataEntrega;
	private BigDecimal valorTotalDoPedido;
	private SituacaoPedido situacao;
	private boolean ativo;
}
