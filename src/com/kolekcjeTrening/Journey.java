package com.kolekcjeTrening;

class Journey{
    private Flight first;
    private Flight second;
    private double finalPrice;

    Journey(Flight first, Flight second, double finalPrice){
        this.first = first;
        this.second = second;
        this.finalPrice = finalPrice;

    }

    public double getFinalPrice() {
        return finalPrice;
    }

    @Override
    public String toString() {
        return "Journey{" +
                "first=" + first +
                ", second=" + second +
                ", finalPrice=" + finalPrice +
                '}';
    }
}
