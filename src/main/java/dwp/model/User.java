package dwp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private static final Logger logger = LoggerFactory.getLogger(User.class);

    public static final double LONDON_LATITUDE = 51.5074;
    public static final double LONDON_LONGITUDE = 0.1278;

    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String email;

    @JsonProperty("ip_address")
    private String ipAddress;

    @JsonIgnore
    private InetAddress inetAddress;

    private Double latitude;
    private Double longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        try {
            this.inetAddress = InetAddress.getByName(ipAddress);
        } catch (UnknownHostException e) {
            logger.warn("Failed to set inet address from IP address {}.", ipAddress);
        }
    }

    public InetAddress getInetAddress() {
        return inetAddress;
    }

    public void setInetAddress(InetAddress inetAddress) {
        this.inetAddress = inetAddress;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {

        return "User{" +
            "id=" + id +
            ", firstName=" + firstName +
            ", lastName=" + lastName +
            ", email=" + email +
            ", ipAddress=" + ipAddress +
            ", inetAddress=" + inetAddress +
            ", lat/lon=(" + latitude + "," + longitude + ")" +
            '}';
    }

    //TODO: Call actual distance calculator instead of using random numbers
    protected Double milesTo(Double toLLatitude, Double toLongitude) {
        // for now, produce up to 5x the target distance.
        // so that we should have a number within 50 about 20% of the time
        Double distance = Math.random() * 50.0 * 5;
        return distance;

        // return calcDistance(latitude, longitude, toLLatitude, toLongitude);
    }
}
