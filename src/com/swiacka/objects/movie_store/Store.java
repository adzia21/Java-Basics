package com.company.objects.movie_store;

import java.util.ArrayList;

public class Store {
    ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<>();
    }

    public Movie getMovie(int index) {
        return new Movie(movies.get(index));
    }

    public void setMovie(int index, Movie movie) {
        movies.add(index, new Movie(movie));
    }

    public void addMovie(Movie movie) {
        movies.add(new Movie(movie));
    }

    public boolean contains(Movie movie) {
        return movies.contains(movie);
    }

    public void sellMovie(String name) {
        if (movies.stream().anyMatch(movie -> movie.getName().equals(name) && !movie.isAvailable())) {
            throw new IllegalStateException("Movie can not be sold - not available.");
        }
        movies.removeIf(movie -> name.equals(movie.getName()));
    }

    public void rentMovie(String name) {
        if (movies.stream().anyMatch(movie -> movie.getName().equals(name) && !movie.isAvailable())) {
            throw new IllegalStateException("Movie can not be rent - not available.");
        }
        movies.stream().filter(movie -> movie.getName().equals(name) && movie.isAvailable()).forEach(movie -> movie.setAvailable(false));
    }

    public void returnMovie(String name) {
        if (movies.stream().anyMatch(movie -> movie.getName().equals(name) && movie.isAvailable())) {
            throw new IllegalStateException("Movie can not be returned - it is already available.");
        }
        movies.stream().filter(movie -> movie.getName().equals(name) && !movie.isAvailable()).forEach(movie -> movie.setAvailable(true));
    }

    public void checkException(String movieName, String action) {
        if (movies.isEmpty()) {
            throw new IllegalStateException("There is no movies. Add movie to perform action.");
        }

        if (!(action.equals("a") || action.equals("b") || action.equals("c"))) {
            throw new IllegalArgumentException("Action is not valid. Action must be sell, rent or return.");
        }

        if (movieName.isBlank() || movieName.isEmpty() || movieName == null) {
            throw new IllegalArgumentException("Name is blank, empty or null");
        }

    }


    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < movies.size(); i++) {
            temp.append(movies.get(i).toString()).append("\n");
        }

        return temp.toString();
    }
}
