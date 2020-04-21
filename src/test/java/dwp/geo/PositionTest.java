package dwp.geo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    Position position1;

    @Before
    public void setUp() throws Exception {
        position1 = new Position(1.0, 2.0);
    }

    @Test
    public void getLatitude() {
        assertEquals(1.0, position1.getLatitude(), 0.0001);
    }

    @Test
    public void setLatitude() {
        position1.setLatitude(99.9);
        assertEquals(99.9, position1.getLatitude(), 0.0001);

    }

    @Test
    public void getLongitude() {
        assertEquals(2.0, position1.getLongitude(), 0.0001);
    }

    @Test
    public void setLongitude() {
        position1.setLongitude(99.9);
        assertEquals(99.9, position1.getLongitude(), 0.0001);
    }

    @Test
    public void setPosition() {
        position1.setPosition(20.0, 30.0);
        assertEquals(20.0, position1.getLatitude(), 0.0001);
        assertEquals(30.0, position1.getLongitude(), 0.0001);

    }

    @Test
    public void testToString() {
        assertEquals("Position(1.0000,2.0000)", position1.toString());
    }

    @Test
    public void testToStringNegative() {
        Position negative = new Position(-1.2345, -9.8765);
        assertEquals("Position(-1.2345,-9.8765)", negative.toString());
    }
}