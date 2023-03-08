package net.javaguides.springboot;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, XADataSourceAutoConfiguration.class})
//@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class RegistrationLoginSpringBootSecurityThymeleafApplication {

	public static void main(String[] args) 
	
	{
		SpringApplication.run(RegistrationLoginSpringBootSecurityThymeleafApplication.class, args);
	}
	
}
