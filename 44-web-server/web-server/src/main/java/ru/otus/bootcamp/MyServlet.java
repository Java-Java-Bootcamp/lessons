package ru.otus.bootcamp;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {

  private final ObjectMapper mapper = new ObjectMapper();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setStatus(201);
    resp.setContentType("application/json");
    Status status = new Status();
    status.setCode("Hello status");
    resp.getWriter().println(mapper.writeValueAsString(status));
  }

}
