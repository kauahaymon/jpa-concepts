package org.example.queries.product;

import org.example.entities.basic.Product;
import org.example.infra.DAO;

import java.util.List;

public class GetProducts {
    public static void main(String[] args) {
        DAO<Product> dao = new DAO<>(Product.class);

        List<Product> products = dao.getAll(3, 0);
        products.forEach(p -> System.out.println("Id: " + p.getId() + ", name: " + p.getName()));

        Double totalPrice = products
                .stream()
                .map(p -> p.getPrice())
                .reduce(0.0, (t, p) -> t + p)
                .doubleValue();

        System.out.println("Total price: " + totalPrice);
    }
}
