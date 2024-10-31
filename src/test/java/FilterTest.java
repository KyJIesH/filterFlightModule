import com.gridnine.testing.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilterTest {
    List<Flight> flights = null;

    @BeforeEach
    public void setUp() {
        flights = FlightBuilder.createFlights();
    }

    @Test
    public void testFilterArrivalDateBeforeDepartureDate() {
        List<Flight> list = new FilterArrivalDateBeforeDepartureDate().filter(flights);
        assertEquals(5, list.size());
    }

    @Test
    public void testFilterDepartureBeforeCurrentTime() {
        List<Flight> list = new FilterDepartureBeforeCurrentTime().filter(flights);
        assertEquals(5, list.size());
    }

    @Test
    public void testFilterTotalTimeOnEarth() {
        List<Flight> list = new FilterTotalTimeOnEarth().filter(flights);
        assertEquals(4, list.size());
    }
}