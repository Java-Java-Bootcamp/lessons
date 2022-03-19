package ru.otus.bootcemp.clientserlet.client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    private final List<Client> allClients = new ArrayList<>();

    public List<Client> findAllClients(){
        return allClients;
    }

    public void addClient(Client client){
        allClients.add(client);
    }
}
