package app;

import app.adapters.inputs.LoginInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Getter;
import lombok.Setter;

@SpringBootApplication
public class VeterinaryApplication implements CommandLineRunner {

    @Autowired
    private ListableBeanFactory beanFactory;
    
    @Autowired
    private LoginInput loginInput;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Beans registrados en la aplicación:");
        String[] beanNames = beanFactory.getBeanDefinitionNames(); // Se corrige 'beanFactory'
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        loginInput.menu(); // Llamada al método menu de LoginInput
    }

    public static void main(String[] args) {
        SpringApplication.run(VeterinaryApplication.class, args);
    }
}
