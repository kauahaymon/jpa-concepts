package org.example.queries.oneToOne;

import org.example.entities.oneToOne.Client;
import org.example.entities.oneToOne.Seat;
import org.example.infra.DAO;

public class CreateSeatClient {
    public static void main(String[] args) {

        Seat seat = new Seat("A5");
        Client client = new Client("Roger", seat);

        DAO<Object> dao = new DAO<>();
        dao.openTransaction()
                .createEntity(seat)
                .createEntity(client)
                .closeTransaction()
                .close();
    }
}
