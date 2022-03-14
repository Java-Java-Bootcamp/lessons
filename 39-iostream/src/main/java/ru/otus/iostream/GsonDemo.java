package ru.otus.iostream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonDemo {
	public static void main(String ... args) throws JsonProcessingException {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();

		var str = gson.toJson(new Entry2(1, 2, "Hello"));
		System.out.println(str);

		var obj = gson.fromJson(str, Entry2.class);
		System.out.println(obj);
	}
}
