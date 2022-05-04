package net.lyncas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class LyncasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LyncasApiApplication.class, args);
	}

}
