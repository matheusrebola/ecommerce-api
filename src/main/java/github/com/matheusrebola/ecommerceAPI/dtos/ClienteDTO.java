package github.com.matheusrebola.ecommerceAPI.dtos;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
	private Long id;
	private String nome;
	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String municipio;
	private String uf;
	private Instant dataCadastro;
	private boolean ativo;
}
