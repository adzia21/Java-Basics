package com.company.objects.movie_store;


import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MovieStoreUnitTests {
    Store store;

    @Before
    public void setup() {
        store = new Store();
        store.addMovie(new Movie("The Shawshank Redemption", "Blue-Ray", 9.2));
        store.addMovie(new Movie("The Godfather", "Blue-Ray", 9.1));
    }

    @Test
    public void movieAdded() {
        Assertions.assertTrue(store.contains(new Movie("The Godfather", "Blue-Ray", 9.1)));
    }

    @Test
    public void sellMovie() {
        store.sellMovie("The Godfather");
        Assertions.assertFalse(store.contains(new Movie("The Godfather", "Blue-Ray", 9.1)));
    }

    @Test
    public void rentMovie() {
        store.rentMovie("The Godfather");
        Assertions.assertFalse(store.getMovie(1).isAvailable());
    }

    @Test
    public void returnMovie() {
        store.rentMovie("The Godfather");
        Assertions.assertFalse(store.getMovie(1).isAvailable());
        store.returnMovie("The Godfather");
        Assertions.assertTrue(store.getMovie(1).isAvailable());
    }

}
