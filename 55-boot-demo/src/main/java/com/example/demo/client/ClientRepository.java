package com.example.demo.client;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ClientRepository {

    private final List<Client> allClients = new ArrayList<>();

    public ClientRepository() {
        System.out.println("ClientRepository created");
    }

    public List<Client> findAllClients(){
        return allClients;
    }

    public void addClient(Client client){
        allClients.add(client);
    }

    public void removeClient(String name){
        allClients.removeIf(it -> Objects.equals(it.getFullname(), name));
    }
}
