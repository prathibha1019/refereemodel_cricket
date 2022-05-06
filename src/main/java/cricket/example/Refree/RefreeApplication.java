package cricket.example.Refree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "controller" })
@EntityScan({"entity"})
@EnableJpaRepositories({"repository"})
public class RefreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RefreeApplication.class, args);
	}

}
