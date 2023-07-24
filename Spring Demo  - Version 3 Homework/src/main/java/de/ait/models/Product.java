package de.ait.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // toString, equals, hashCode, getters, setter
@NoArgsConstructor // конструктор без параметров
@AllArgsConstructor // конструктор с параметрами
public class Product {
    private Long id;
    private String name;
    private int quantity;
    private boolean valid;
}
