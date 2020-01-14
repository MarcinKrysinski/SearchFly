package com.kolekcjeTrening;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        boolean n = true;
        do {

            System.out.println("What you want to do?");
            System.out.println("[1] Search flight from ... city ");
            System.out.println("[2] Search cheapest flight ");
            System.out.println("[3] Search cheapest flight from ... city ");
            System.out.println("[4] Search flight with transfers from ... city ");
            System.out.println("[5] Search cheapest flight with transfers from ... city ");
            System.out.println("[x] Exit ");
            String choice = getUserInput();

            switch (choice){

                case "1":
                    FlightDatabase database = new FlightDatabase();
                    System.out.println("Please enter city:");
                    String city = getUserInput();
                    database.displayFlightsFromCity(city);
                    ArrayList<String> cities = database.getCities();
                    System.out.println("Available cities: " + cities);
                    break;
                case "2":
                    database = new FlightDatabase();
                    Flight cheapestFlight = database.getCheapestFlight();
                    System.out.println("Cheapest price : " + cheapestFlight.getDetails());
                    break;
                case "3":
                    database = new FlightDatabase();
                    System.out.println("Please enter city:");
                    city = getUserInput();
                    Flight cheapestFlightFromCity = database.getCheapestFlightFromCity(city);
                    System.out.println("Cheapest price from city: " + cheapestFlightFromCity);
                    break;
                case "4":
                    database = new FlightDatabase();
                    System.out.println("Enter departure city:");
                    String cityDeparture = getUserInput();
                    System.out.println("Enter arrival city:");
                    String cityArrival =getUserInput();
                    ArrayList<Journey> getFlights = database.getFlights(cityDeparture, cityArrival);
                    System.out.println("Flights with transfers: " + getFlights);
                    break;
                case "5":
                    database = new FlightDatabase();
                    System.out.println("Enter departure city:");
                    cityDeparture = getUserInput();
                    System.out.println("Enter arrival city:");
                    cityArrival =getUserInput();
                    ArrayList<Journey> getFlightWithLowerPrice = database.getFlightWithLowerPrice(cityDeparture, cityArrival);
                    System.out.println("Cheapest flight with transfers: " + getFlightWithLowerPrice);
                    break;
                case "x":
                    n = false;
                    break;
            }

        }while (n == true);

//	    database.checkIfFlightExists("Paris", "Madrid");
//	    database.getFlightsFromCity("Berlin");


    }

    private static String getUserInput() {
        return sc.nextLine().trim();
    }
}








