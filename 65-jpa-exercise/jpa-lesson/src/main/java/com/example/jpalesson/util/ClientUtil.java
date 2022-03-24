package com.example.jpalesson.util;

import com.example.jpalesson.model.Client;
import com.example.jpalesson.model.ClientDTO;

public class ClientUtil {

    public static Client mapDTOToEntity(ClientDTO clientDTO) {
        Client client = new Client();
        client.setFullName(clientDTO.getFullName());
        client.setPhone(clientDTO.getPhone());
        return client;
    }
}
