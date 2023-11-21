package github.com.matheusrebola.ecommerceAPI.view;

import org.springframework.beans.factory.annotation.Value;

public interface ClienteView2 {
	Long getId();

    String getNome();

    @Value("#{target.municipio + ' - ' + target.uf + ' - ' + target.cep + ' - ' + target.logradouro + ' - ' + target.numero}")
    String getEnderecoCompleto();
}