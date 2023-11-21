package github.com.matheusrebola.ecommerceAPI.dtos;

import github.com.matheusrebola.ecommerceAPI.model.SituacaoPedido;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class PedidoDTO {
	private Long id;
	private Long cliente_id;
	private LocalDateTime dataDoPedido;
	private LocalDateTime dataEntrega;
	private BigDecimal valorTotalDoPedido;
	private SituacaoPedido situacao;
	private boolean ativo;
}
