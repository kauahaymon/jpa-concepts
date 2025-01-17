package org.example.queries.manyToMany;

import org.example.entities.manyToMany.Actor;
import org.example.entities.manyToMany.Movie;
import org.example.infra.DAO;

public class CreateMovieActor {
    public static void main(String[] args) {
        Movie movieA = new Movie("Back to the future 2", 7.8);
        Movie movieB = new Movie("Stuart Little", 6.3);

        Actor actorA = new Actor("Michael J. Fox");
        Actor actorB = new Actor("Mouse");

        movieA.addActor(actorA);
        movieA.addActor(actorB);

        DAO<Movie> dao = new DAO<>();

        dao.openTransaction()
                .createEntity(movieA)
                .closeTransaction()
                .close();
    }
}
