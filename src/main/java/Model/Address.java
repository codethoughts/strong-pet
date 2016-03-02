package Model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Eiger on 2/26/16.
 */

@Embeddable
public class Address implements Serializable {
    private String first_line;
    private String second_line;
    private String city;
    private String country;
    private String post_code;

    public Address() { }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public void setFirstLine(String first_line) {
        this.first_line = first_line;
    }

    public String getSecondLine() {
        return second_line;
    }

    public void setSecondLine(String second_line) {
        this.second_line = second_line;
    }

    public String getPostCode() {
        return post_code;
    }

    public void setPostCode(String post_code) {
        this.post_code = post_code;
    }

    public String getFirstLine() {
        return first_line;
    }

    @Override
    public String toString() {
        return first_line + ", " + second_line + ", " + city + ", " + country + ", " + post_code;
    }
}
