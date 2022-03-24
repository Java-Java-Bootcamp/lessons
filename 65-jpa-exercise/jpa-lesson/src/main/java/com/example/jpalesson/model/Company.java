package com.example.jpalesson.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * todo:
 * <p>
 * - сконфигурировать JPA entity
 * - Название таблицы: "companies"
 * - сконфигурировать автогенерируемый идентификатор
 * - сделать поле "name" обязательным
 * <p>
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "companies")
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
//    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        throw new UnsupportedOperationException("I'm still not implemented!");
    }

    public void removeProduct(Product product) {
        throw new UnsupportedOperationException("I'm still not implemented!");
    }
}
