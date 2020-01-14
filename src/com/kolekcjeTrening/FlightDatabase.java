package com.kolekcjeTrening;

import java.util.ArrayList;

class FlightDatabase{
    private ArrayList<Flight> flights = new ArrayList<Flight>();

    FlightDatabase(){
        this.flights.add(new Flight("Berlin", "Tokyo", 234));
        this.flights.add(new Flight("Paris", "Tokyo", 2234.55));
        this.flights.add(new Flight("Warsaw", "Tokyo", 1234.34));
        this.flights.add(new Flight("Berlin", "Paris", 236));
        this.flights.add(new Flight("Berlin", "Warsaw", 123));
        this.flights.add(new Flight("Tokyo", "Paris", 3142));
        this.flights.add(new Flight("Warsaw", "Paris", 200));
        this.flights.add(new Flight("Paris", "Warsaw",212));
        this.flights.add(new Flight("Paris", "Berlin", 211));
        this.flights.add(new Flight("New York", "Paris", 2113));
        this.flights.add(new Flight("New York", "Warsaw", 2233));
        this.flights.add((new Flight("Warsaw", "Berlin", 198)));


    }

    public void checkIfFlightExists(String start, String end){
        boolean notExists = true;
        for (int i=0; i<this.flights.size(); i++){
            Flight flight = this.flights.get(i);
            if(start.equals(flight.departure) && end.equals(flight.arrival)){
                System.out.println("Flight exists!!!");
                return;
            }
        }
        System.out.println("Flight with given params not exists ;(");
    }

//    public void getFlightsFromCity(String city){
//        boolean isNotFound = true;
//        for(int i=0; i < this.flights.size(); i++){
//            Flight flight = this.flights.get(i);
//            if(city.equals(flight.departure)){
//                System.out.println(flight.getDetails());
//                isNotFound = false;
//            }
//        }
//        if (isNotFound){
//            System.out.println("Flight not found ;(");
//        }
//    }

    private ArrayList<Flight> getFlightsFromCity(String city){
        ArrayList<Flight> results = new ArrayList<Flight>();
        for(int i=0; i < this.flights.size(); i++){
            Flight flight = this.flights.get(i);
            if(city.equals(flight.departure)){
                results.add(flight);
            }
        }
        return results;
    }

//    public void getFlightsToCity(String city){
//        boolean isNotFound = true;
//        for(int i=0; i < this.flights.size(); i++){
//            Flight flight = this.flights.get(i);
//            if(city.equals(flight.arrival)){
//                System.out.println(flight.getDetails());
//                isNotFound = false;
//            }
//        }
//        if (isNotFound){
//            System.out.println("Flight not found ;(");
//        }
//    }

    private ArrayList<Flight> getFlightsToCity(String city){
        ArrayList<Flight> results = new ArrayList<Flight>();
        for(int i=0; i < this.flights.size(); i++){
            Flight flight = this.flights.get(i);
            if(city.equals(flight.arrival)){
                results.add(flight);
            }
        }
        return results;
    }

    private void displayFlights(ArrayList<Flight> results){
        if(results.isEmpty()){
            System.out.println("Flight not found");
        }
        for (int i=0; i<results.size(); i++){
            Flight flight = results.get(i);
            System.out.println(flight.getDetails());
        }
    }

    void displayFlightsFromCity(String city){
        ArrayList<Flight> results = getFlightsFromCity(city);
        displayFlights(results);
    }

    public void displayFlightsToCity (String city){
        ArrayList<Flight> results = getFlightsToCity(city);
        displayFlights(results);
    }

    ArrayList<String> getCities(){
        ArrayList<String> citiesList = new ArrayList<>();
        for (Flight flight: this.flights) {
            if(!citiesList.contains(flight.departure)){
                citiesList.add(flight.departure);
            }
            if(!citiesList.contains(flight.arrival)){
                citiesList.add(flight.arrival);
            }
        }
        return citiesList;
    }

    Flight getCheapestFlight(){
        Flight cheapestFlight = null;
        for (Flight flight: this.flights) {
            if (cheapestFlight == null || cheapestFlight.price > flight.price ){
                cheapestFlight = flight;
            }
        }
        return cheapestFlight;
    }

    Flight getCheapestFlightFromCity (String city){
        ArrayList<Flight> fromCity = getFlightsFromCity(city);
        Flight cheapestFlight = null;
        for (Flight flight: fromCity) {
            if (cheapestFlight == null || cheapestFlight.price > flight.price ){
                cheapestFlight = flight;
            }
        }
        return cheapestFlight;
    }

    ArrayList<Journey> getFlights (String start, String end) {
        ArrayList<Flight> starting = getFlightsFromCity(start);
        ArrayList<Flight> ending = getFlightsToCity(end);
        ArrayList<Journey> results = new ArrayList<>();
        double finalPrice;
        for (Flight first : starting) {
            for (Flight second : ending) {
                if (first.arrival.equals(second.departure)) {
                    finalPrice = first.price + second.price;
                    results.add(new Journey(first, second, finalPrice));
                }
            }
        }
        return results;
    }

    ArrayList<Journey> getFlightWithLowerPrice (String start, String end) {
        ArrayList<Flight> starting = getFlightsFromCity(start);
        ArrayList<Flight> ending = getFlightsToCity(end);
        ArrayList<Journey> results = new ArrayList<>();
        double finalPrice = 0;
        for (Flight first : starting) {
            for (Flight second : ending) {
                if (first.arrival.equals(second.departure)) {
                    if (finalPrice == 0 || first.price + second.price < finalPrice) {
                        finalPrice = first.price + second.price;
                        results.add(new Journey(first, second, finalPrice));
                    }
                }
            }
        }
        return results;
    }


}
