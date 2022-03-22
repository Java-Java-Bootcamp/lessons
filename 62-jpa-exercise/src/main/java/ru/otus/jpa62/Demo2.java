package ru.otus.jpa62;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionOperations;
import ru.otus.jpa62.model.Client;
import ru.otus.jpa62.model.Order;

import javax.persistence.EntityManager;
import javax.transaction.TransactionManager;
import javax.transaction.Transactional;

//@Component
public class Demo2 implements CommandLineRunner {
	private final EntityManager entityManager;
	private final TransactionOperations transactionOperations;

	public Demo2(EntityManager entityManager, TransactionOperations transactionOperations) {
		this.entityManager = entityManager;
		this.transactionOperations = transactionOperations;
	}

	@Override
	public void run(String... args) {
		Order outer = transactionOperations.execute(status -> {
			//var client = entityManager.find(Client.class, 1l);

			var client = new Client("Sidorov", null);

			var order = new Order();
			order.setClient(client);
			entityManager.persist(order);
			entityManager.flush();
			entityManager.clear();

			System.out.println("==================================");
			var fromDB = entityManager.find(Order.class, order.getId());
			System.out.println(">> received");
			System.out.println(fromDB);

			return fromDB;
		});

		//System.out.println(">> outer");
		//System.out.println(outer);
	}
}
