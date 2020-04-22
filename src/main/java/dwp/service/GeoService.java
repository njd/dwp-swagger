package dwp.service;

import dwp.geo.Position;
import net.sf.geographiclib.Geodesic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class GeoService {

    Geodesic geo;
    private static final Logger logger = LoggerFactory.getLogger(GeoService.class);

    public static final double MILES_TO_KM = 1.60934;
    protected static final double LONDON_LATITUDE = 51.5074;
    protected static double LONDON_LONGITUDE = 0.1278;
    public static final Position LONDON = new Position(LONDON_LATITUDE, LONDON_LONGITUDE);

    public GeoService() {
        geo = new Geodesic(Geodesic.WGS84.EquatorialRadius(), Geodesic.WGS84.Flattening());
    }

    /**
     * Calculate distance between two positions
     * @param from position
     * @param to position
     * @return distance in miles
     */
    public Double milesBetween(Position from, Position to) {

        double distanceInMetres = geo.Inverse(from.latitude, from.longitude, to.latitude, to.longitude).s12;
        double distanceInKm = distanceInMetres / 1000.0;

        double distanceInMiles = kmToMiles(distanceInKm);

        logger.debug("%s to %s is %f miles", from, to, distanceInMiles);
        return distanceInMiles;
    }

    protected static double milesToKm(double miles) {
        return miles * MILES_TO_KM;
    }

    protected static double kmToMiles(double km) {
        return km / MILES_TO_KM;
    }
}
