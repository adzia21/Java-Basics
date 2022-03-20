package com.company.objects.movie_store;

import java.util.Objects;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    private static final String FORMAT_DVD = "DVD";
    private static final String FORMAT_BLUERAY = "Blue-Ray";

    public Movie(String name, String format, double rating) {
        if (name.isBlank() || name.isEmpty() || name == null) {
            throw new IllegalArgumentException("name is not valid value");
        }
        if (!format.equals("Blue-Ray") && !format.equals("DVD")) {
            throw new IllegalArgumentException("format is not Blue-Ray or DVD");
        }
        if (rating > 10 || rating < 0) {
            throw new IllegalArgumentException("rating is not in range 0-10");
        }
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.isAvailable = true;
        this.rentalPrice = format.equals("Blue-Ray") ? 1.99 : 0.99;
        this.sellingPrice = format.equals("Blue-Ray") ? 4.25 : 2.25;

    }

    public Movie(Movie movie) {
        this.name = movie.name;
        this.format = movie.format;
        this.rating = movie.rating;
        this.sellingPrice = movie.sellingPrice;
        this.rentalPrice = movie.rentalPrice;
        this.isAvailable = movie.isAvailable;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank() || name.isEmpty() || name == null) {
            throw new IllegalArgumentException("name is not valid value");
        }
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        if (!(format.equals(FORMAT_BLUERAY) || format.equals(FORMAT_DVD))) {
            throw new IllegalArgumentException("format is not Blue-Ray or DVD");
        }
        this.format = format;
        setSellingPrice(format.equals(FORMAT_BLUERAY) ? 4.25 : 2.25);
        setRentalPrice(format.equals(FORMAT_DVD) ? 1.99 : 0.99);
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating > 10 || rating < 0) {
            throw new IllegalArgumentException("rating is not in range 0-10");
        }
        this.rating = rating;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    private void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    private void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.rating, rating) == 0 && Double.compare(movie.sellingPrice, sellingPrice) == 0 && Double.compare(movie.rentalPrice, rentalPrice) == 0 && isAvailable == movie.isAvailable && name.equals(movie.name) && format.equals(movie.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, format, rating, sellingPrice, rentalPrice, isAvailable);
    }

    @Override
    public String toString() {
        return "\t Name: " + name + "\n" +
                "\t Format: " + format + "\n" +
                "\t Rating: " + rating + "\n" +
                "\t Selling Price: " + sellingPrice + "\n" +
                "\t Rental Price: " + rentalPrice + "\n" +
                "\t Availability: " + isAvailable + "\n";
    }
}
