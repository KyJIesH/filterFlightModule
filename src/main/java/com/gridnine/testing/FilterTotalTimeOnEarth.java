package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Фильтр: исключить рейсы с общим временем, проведённым на земле превышающем два часа
 */
public class FilterTotalTimeOnEarth implements Filter {

    private final int MAX_TIME_TRANSFER = 2;

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    if (segments.size() <= 1) {
                        return true;
                    }
                    int totalTimeOnEarth = 0;
                    for (int i = 0; i < segments.size() - 1; i++) {
                        LocalDateTime arrivalDate = segments.get(i).getArrivalDate();
                        LocalDateTime departureDate = segments.get(i + 1).getDepartureDate();
                        long hoursBetween = ChronoUnit.HOURS.between(arrivalDate, departureDate);
                        totalTimeOnEarth += (int) hoursBetween;
                    }
                    return totalTimeOnEarth < MAX_TIME_TRANSFER;
                })
                .collect(Collectors.toList());
    }
}
