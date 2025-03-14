package org.ieselcaminas.jpa;

import org.ieselcaminas.jpa.entity.Customer;
import org.ieselcaminas.jpa.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	private final CustomerRepository customerRepository;
	public JpaApplication(CustomerRepository customerRepository){
		this.customerRepository = customerRepository;
	}

	//En este método definimos nuestro propio código
	@Override
	public void run(String... args) {
		// Código del ejemplo:
		Customer c = new Customer("Pepe", "García");
		//El repositorio es donde están todos los métodos que tratan con la base de datos.
		//En este caso está haciendo un INSERT, ya que el objeto es nuevo
		this.customerRepository.save(c);

		//Pero también puedo modificar un registro
		c.setFirstName("Juan");
		this.customerRepository.save(c);

		//Vamos a seleccionar el Customer con ID 1
		//Se escribe 1L porque es un dato escrito a mano de tipo long
		Optional<Customer> clienteOp = this.customerRepository.findById(1L);
		clienteOp.ifPresent(System.out::println);

		//Si queremos acceder al objeto Customer, hacemos:
		if (clienteOp.isPresent()){
			c = clienteOp.get();
			System.out.println(c);
		}

		//El método findAll devuelve todos los registros de la entidad asociada
		this.customerRepository.findAll().forEach(System.out::println);

		//En este código estamos guardando los datos en un Iterable que es lo que devuelven los métodos findAll
		Iterable<Customer> l = this.customerRepository.findAll();
		for (Customer customer : l) {
			System.out.println(customer);
		}

		//Cuidado que si no existe el registro con ID 5, saltará una excepción
		c = this.customerRepository.findById(5L).get();
		this.customerRepository.delete(c);
	}
}
