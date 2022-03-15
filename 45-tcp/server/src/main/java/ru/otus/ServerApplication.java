package ru.otus;

public class ServerApplication {
	public static void main(String[] args) throws Exception {
		try (var server = new Server(8081)) {
			server.start();
		}
	}
}
