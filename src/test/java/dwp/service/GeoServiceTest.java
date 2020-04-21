package dwp.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class GeoServiceTest {

    GeoService service;

    @Test
    public void milesToKm() {
        assertEquals(1.609, service.milesToKm(1.0), 0.01);
    }

    @Test
    public void kmToMiles() {
        assertEquals(49.71, service.kmToMiles(80.0), 0.01);
    }
}