package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        Filter filterArrivalDateBeforeDepartureDate = new FilterArrivalDateBeforeDepartureDate();
        Filter filterDepartureBeforeCurrentTime = new FilterDepartureBeforeCurrentTime();
        Filter filterTotalTimeOnEarth = new FilterTotalTimeOnEarth();

        System.out.println("Фильтр: исключить рейсы с датой прилёта раньше даты вылета");
        List<Flight> arrivalDateBeforeDepartDate = filterArrivalDateBeforeDepartureDate.filter(flights);
        FlightBuilder.print(arrivalDateBeforeDepartDate);

        System.out.println("Фильтр: исключить рейсы с вылетом до текущего момента времени");
        List<Flight> departureDateBeforeCurrentTime = filterDepartureBeforeCurrentTime.filter(flights);
        FlightBuilder.print(departureDateBeforeCurrentTime);

        System.out.println("Фильтр: исключить рейсы с общим временем, проведённым на земле превышающем два часа");
        List<Flight> totalTimeOnEarth = filterTotalTimeOnEarth.filter(flights);
        FlightBuilder.print(totalTimeOnEarth);
    }
}