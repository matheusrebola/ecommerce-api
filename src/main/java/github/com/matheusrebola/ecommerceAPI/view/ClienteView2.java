package github.com.matheusrebola.ecommerceAPI.view;

public interface ClienteView2 {
	Long getId();

    String getNome();

    @Value("#{target.municipio + ' - ' + target.uf + ' - ' + target.cep + ' - ' + target.logradouro + ' - ' + target.numero}")
    String getEnderecoCompleto();
}
