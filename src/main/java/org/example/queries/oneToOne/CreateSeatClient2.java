package org.example.queries.oneToOne;

import org.example.entities.oneToOne.Client;
import org.example.entities.oneToOne.Seat;
import org.example.infra.DAO;

public class CreateSeatClient2 {
    public static void main(String[] args) {
        Seat seat = new Seat("A5");
        Client client = new Client("Roger", seat);

        /*
        * Using Cascade to persist, can save client without saving seat first
        *     @OneToOne(cascade = CascadeType.PERSIST)
        * */
        DAO<Object> dao = new DAO<>();
        dao.createWithTransaction(client).close();
    }
}
