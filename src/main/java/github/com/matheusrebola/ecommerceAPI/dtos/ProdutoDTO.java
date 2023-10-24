package github.com.matheusrebola.ecommerceAPI.dtos;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {
	private Long id;
	private String nome;
	private LocalDateTime dataDeCadastro;
	private boolean ativo;
}
