package com.github.matheusrebola.ecommerceAPI.dtos;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoDTO {
	private Long id;
	private Pedido pedido;
	private Produto produto;
	private BigDecimal quantidade;
	private BigDecimal valorUnitario;
	private BigDecimal valorTotal;
	private boolean ativo;
}
