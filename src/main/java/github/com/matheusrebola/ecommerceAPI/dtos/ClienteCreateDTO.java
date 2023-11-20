package github.com.matheusrebola.ecommerceAPI.dtos;

<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class ClienteCreateDTO {
    @Size(min = 3, message = "O nome deve ter no mínimo 5 caracteres")
    @Size(max = 100, message = "Tamanho máximo permito: 100")
    private String nome;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String uf;
    private boolean ativo;
=======
import java.time.Instant;

public class ClienteCreateDTO {
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
>>>>>>> 0fcdbe09f96d99ed2996683265b856409e4da340
}
