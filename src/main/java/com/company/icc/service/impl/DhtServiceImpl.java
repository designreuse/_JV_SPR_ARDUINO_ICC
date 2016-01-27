package com.company.icc.service.impl;

import com.company.icc.init.SerialClass;
import com.company.icc.model.Dht;
import com.company.icc.service.DhtService;

import java.io.IOException;

/**
 * Created by leventyildiz on 27/01/16.
 */
public class DhtServiceImpl implements DhtService {
    static SerialClass main = new SerialClass();

    public DhtServiceImpl() {
        main.initialize();

    }


    @Override
    public Dht getData() {

        String data;
        Dht dht = new Dht();
        boolean readTemperature = true;
        boolean readHumidity = true;
        int counter = 0;

        try {

            while (true) {
                main.writeData("6");
                data = main.input.readLine();

                if (readTemperature == true && data.toUpperCase().contains("TEMPERATURE")) {

                    String[] parts = data.split("=");
                    dht.setTemperature(Double.valueOf(parts[1]));
                    readTemperature = false;
                    counter++;
                }

                if (readHumidity == true && data.toUpperCase().contains("HUMIDITY")) {

                    String[] parts = data.split("=");
                    dht.setHumidity(Double.valueOf(parts[1]));
                    readHumidity = false;
                    counter++;
                }

                if (counter > 1) {
                    break;
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return dht;

    }

}