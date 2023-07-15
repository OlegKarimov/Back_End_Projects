package de.ait.homework_products_19_07.models;


//1. Нужно пересмотреть урок
//        2. Сделать аналогичный проект, но с товарами (Products, Goods)
//        - Название
//        - Количество
//        - Вышел срок годности или нет (boolean)
//        3. В личку скинуть ссылку на проект и скриншот браузера со списков товаров

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Product {
private Long id;
private String name;
private int quantity;
private boolean valid;


}
