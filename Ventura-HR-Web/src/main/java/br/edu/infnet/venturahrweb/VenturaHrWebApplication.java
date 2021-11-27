package br.edu.infnet.venturahrweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VenturaHrWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(VenturaHrWebApplication.class, args);
	}

}
