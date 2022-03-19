package ru.otus.bootcemp.clientserlet;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class ServerApp {

    public static void main(String[] args) {
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(7070);
        server.setConnectors(new Connector[]{connector});
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);
        handler.addServletWithMapping(ClientServlet.class, "/clients");
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
