package com.github.matheusrebola.ecommerceAPI.dtos;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDTO {
	private Long id;
	private Cliente cliente;
	private LocalDateTime dataDoPedido;
	private LocalDateTime dataEntrega;
	private BigDecimal valorTotalDoPedido;
	private SituacaoPedido situacao;
	private boolean ativo;
}
