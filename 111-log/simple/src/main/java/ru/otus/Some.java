package ru.otus;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Some {
	public static void f(String a) {
		log.info("Hello from {}", a);
	}
}
