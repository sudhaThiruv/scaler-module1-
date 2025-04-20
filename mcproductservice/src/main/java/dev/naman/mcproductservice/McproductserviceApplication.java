package dev.naman.mcproductservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class McproductserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(McproductserviceApplication.class, args);
	}

}
