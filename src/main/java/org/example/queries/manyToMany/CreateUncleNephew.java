package org.example.queries.manyToMany;

import org.example.entities.manyToMany.Nephew;
import org.example.entities.manyToMany.Uncle;
import org.example.infra.DAO;

public class CreateUncleNephew {
    public static void main(String[] args) {
        Uncle uncle1 = new Uncle("Roger");
        Uncle uncle2 = new Uncle("Rosane");

        Nephew nephew1 = new Nephew("Bia");
        Nephew nephew2 = new Nephew("Davi");

        uncle1.getNephews().add(nephew1);
        nephew1.getUncles().add(uncle1);

        uncle1.getNephews().add(nephew2);
        nephew2.getUncles().add(uncle1);

        uncle2.getNephews().add(nephew1);
        nephew1.getUncles().add(uncle2);

        uncle2.getNephews().add(nephew2);
        nephew2.getUncles().add(uncle2);

        DAO<Object> dao = new DAO<>();

        dao.openTransaction()
                .createEntity(uncle1)
                .createEntity(uncle2)
                .createEntity(nephew1)
                .createEntity(nephew2)
                .closeTransaction()
                .close();
    }
}
