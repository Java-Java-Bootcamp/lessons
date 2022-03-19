package com.example.demo.client;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ClientRepositoryTest {

	private final ClientRepository repository = new ClientRepository();
	private final Client
			client1 = new Client("Ivan", null),
			client2 = new Client("Petr", null);

	@Test
	void addClient() {
		repository.addClient(client1);
		repository.addClient(client2);
		assertThat(repository.findAllClients()).containsExactly(client1, client2);
	}

	@Test
	void removeClient() {
		repository.addClient(client1);
		repository.addClient(client2);
		repository.removeClient("Petr");
		assertThat(repository.findAllClients()).containsExactly(client1);
	}
}