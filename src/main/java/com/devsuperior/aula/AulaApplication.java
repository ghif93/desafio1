package com.devsuperior.aula;

import com.devsuperior.entities.Order;
import com.devsuperior.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.devsuperior")
public class AulaApplication implements CommandLineRunner {

	//declarando a dependencia de AulaApplication para o OrderService
	private OrderService orderService;

	//injeta a dependência SalaryService na classe AulaApplication.
	//O framework cuida da injeção automaticamente,
	// instanciando SalaryService e passando-o
	// para o construtor da classe.
	public AulaApplication(OrderService orderService) {
		this.orderService = orderService;
	}
	public static void main(String[] args)  {

		SpringApplication.run(AulaApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception {
		Order order = new Order(1,95.90,0);
		System.out.println("Pedido código "+order.getCode()+"\nValor Total: "+orderService.total(order));
	}
}
