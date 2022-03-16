package ru.otus.bootcamp;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8094);
        server.setConnectors(new Connector[]{connector});

        var handler = new ServletHandler();
        server.setHandler(handler);
        handler.addServletWithMapping(MyServlet.class, "/status");
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
