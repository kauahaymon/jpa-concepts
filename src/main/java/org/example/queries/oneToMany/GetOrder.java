package org.example.queries.oneToMany;

import org.example.entities.oneToMany.Order;
import org.example.entities.oneToMany.OrderItem;
import org.example.infra.DAO;

public class GetOrder {
    public static void main(String[] args) {
        DAO<Order> dao = new DAO<>(Order.class);

        Order order = dao.getById(3L);

        for(OrderItem item: order.getItems()) {
            System.out.println(item.getQuantity());
            System.out.println(item.getProduct().getName());
        }
        dao.close();
    }
}
