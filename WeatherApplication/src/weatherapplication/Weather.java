/*
 * This class is used to create convert the Json objects from the API to java
 * objects. It has getters and setters. 
 */
package weatherapplication;

import java.util.TreeMap;

/**
 *
 * @author Dave
 */
public class Weather {
    double humidity;
    double pressure;
    double maxTemprature;
    double minTemprature;

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getMaxTemprature() {
        return maxTemprature;
    }

    public void setMaxTemprature(double maxTemprature) {
        this.maxTemprature = maxTemprature;
    }

    public double getMinTemprature() {
        return minTemprature;
    }

    public void setMinTemprature(double minTemprature) {
        this.minTemprature = minTemprature;
    }
    
    
}
