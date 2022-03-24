package com.example.jpalesson.controller;


import com.example.jpalesson.dao.ClientRepository;
import com.example.jpalesson.model.Client;
import com.example.jpalesson.model.ClientDTO;
import com.example.jpalesson.util.ClientUtil;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/client")
@Transactional
public class ClientController {

    private final ClientRepository repository;

    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return repository.findAll();
    }

    @PostMapping
    public Client addClient(ClientDTO clientDTO) {
        return repository.save(ClientUtil.mapDTOToEntity(clientDTO));
    }
}