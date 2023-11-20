package github.com.matheusrebola.ecommerceAPI.view;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Value;

public interface ClienteView2 {
    Long getId();
=======
public interface ClienteView2 {
	Long getId();
>>>>>>> 0fcdbe09f96d99ed2996683265b856409e4da340

    String getNome();

    @Value("#{target.municipio + ' - ' + target.uf + ' - ' + target.cep + ' - ' + target.logradouro + ' - ' + target.numero}")
    String getEnderecoCompleto();
<<<<<<< HEAD


}
=======
}
>>>>>>> 0fcdbe09f96d99ed2996683265b856409e4da340
