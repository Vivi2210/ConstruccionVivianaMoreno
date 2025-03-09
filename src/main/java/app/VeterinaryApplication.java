package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Getter;
import lombok.Setter;

@SpringBootApplication
public class VeterinaryApplication implements CommandLineRunner{

	@Autowired
	ListableBeanFactory factory;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Beans registrados en la aplicacion:");
		String[] beanNames = factory.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(
			VeterinaryApplication.class, args);
	}

}
