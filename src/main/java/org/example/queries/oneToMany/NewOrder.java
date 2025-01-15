package org.example.queries.oneToMany;

import org.example.entities.basic.Product;
import org.example.entities.oneToMany.Order;
import org.example.entities.oneToMany.OrderItem;
import org.example.infra.DAO;

import java.util.Date;

public class NewOrder {
    public static void main(String[] args) {
        Order order = new Order(new Date());
        Product item = new Product("Iphone", 989.00);
        OrderItem orderItem = new OrderItem(item, order, 2);

        DAO<Object> dao = new DAO<>();

        dao.openTransaction()
                .createEntity(item)
                .createEntity(order)
                .createEntity(orderItem)
                .closeTransaction()
                .close();
    }
}
