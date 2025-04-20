package dev.naman.mcuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class McuserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(McuserserviceApplication.class, args);
	}

}
