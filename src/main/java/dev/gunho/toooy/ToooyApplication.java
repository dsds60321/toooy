package dev.gunho.toooy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ToooyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToooyApplication.class, args);
	}

}
