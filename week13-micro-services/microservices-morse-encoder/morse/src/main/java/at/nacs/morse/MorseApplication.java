package at.nacs.morse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class MorseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MorseApplication.class, args);
	}

}
