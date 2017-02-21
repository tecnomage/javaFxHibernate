package br.jus.trt9.PjeMonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

@Lazy
@SpringBootApplication
public class LaunchClass {
	
	public static void main(String[] args) {
		
		SpringApplication.run(MainApp.class, args);
		
	}

}
