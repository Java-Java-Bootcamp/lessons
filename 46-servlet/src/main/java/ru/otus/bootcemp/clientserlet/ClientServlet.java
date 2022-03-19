package ru.otus.bootcemp.clientserlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.otus.bootcemp.clientserlet.client.Client;
import ru.otus.bootcemp.clientserlet.client.ClientRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class ClientServlet extends HttpServlet {

    private final ClientRepository clientRepository = new ClientRepository();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> currentList = clientRepository.findAllClients();

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(objectMapper.writeValueAsString(currentList));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String content;
        StringBuffer stringBuffer = new StringBuffer();

        BufferedReader bufferedReader = request.getReader();

        while((content = bufferedReader.readLine()) != null){
            stringBuffer.append(content);
        }

        Client newClient = objectMapper.readValue(stringBuffer.toString(), Client.class);

        clientRepository.addClient(newClient);

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);

    }
}
