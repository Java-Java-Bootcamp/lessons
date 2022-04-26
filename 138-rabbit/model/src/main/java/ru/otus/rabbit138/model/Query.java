package ru.otus.rabbit138.model;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Query {
	double a;
	double b;
	Operation operation;
}
