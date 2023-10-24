package com.github.matheusrebola.ecommerceAPI.dtos;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {
	private Long id;
	private Sttring nome;
	private LocalDateTime dataDeCadastro;
	private boolean ativo;;
}
