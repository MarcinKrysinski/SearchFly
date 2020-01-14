package com.kolekcjeTrening;

class Flight{
    String departure;
    String arrival;
    double price;

    Flight(String departure, String arrival, double price){
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
    }

    String getDetails() {
        return "Flight from " + this.departure + " to " + this.arrival + " costs " + this.price;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", price=" + price +
                '}';
    }
}