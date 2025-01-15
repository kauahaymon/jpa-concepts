package org.example.queries.product;

import org.example.entities.basic.Product;
import org.example.infra.DAO;

public class CreateProduct {
    public static void main(String[] args) {
        DAO<Product> dao = new DAO<>(Product.class);

        Product newProduct = new Product("Iphone", 999.0);
        dao.createWithTransaction(newProduct).close();

        System.out.println("New product: " + newProduct.getName());
    }
}
