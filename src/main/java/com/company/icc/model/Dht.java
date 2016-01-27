package com.company.icc.model;

/**
 * Created by leventyildiz on 27/01/16.
 */
public class Dht extends HttpStatus{

    public double temperature;
    public double humidity;

    @Override
    public String toString() {
        return "Dht{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}
