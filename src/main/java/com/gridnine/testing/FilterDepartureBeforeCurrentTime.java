package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Фильтр: исключить рейсы с вылетом до текущего момента времени
 */
public class FilterDepartureBeforeCurrentTime implements Filter {
    LocalDateTime time = LocalDateTime.now();

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isAfter(time)))
                .collect(Collectors.toList());
    }
}
