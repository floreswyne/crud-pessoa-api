package api.crudpessoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CrudPessoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudPessoaApplication.class, args);
	}

}
