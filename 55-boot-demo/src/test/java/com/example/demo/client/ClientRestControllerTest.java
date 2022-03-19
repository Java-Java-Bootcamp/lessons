package com.example.demo.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ClientRestControllerTest {
	@MockBean
	private ClientRepository repository;

	@Autowired
	private MockMvc mockMvc;

	private final Client
			client1 = new Client("Ivan", null),
			client2 = new Client("Petr", null);

	@Test
	public void getAllClients() throws Exception {
		when(repository.findAllClients()).thenReturn(List.of(client1, client2));

		mockMvc.perform(MockMvcRequestBuilders.get("/client"))
						.andExpect(status().isOk())
								.andExpect(content().json("""
										[{"fullname": "Ivan"}, {"fullname": "Petr"}]"""));
	}

}