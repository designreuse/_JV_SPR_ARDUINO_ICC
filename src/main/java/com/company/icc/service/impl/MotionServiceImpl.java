package com.company.icc.service.impl;

import com.company.icc.init.SerialClass;
import com.company.icc.model.Dht;
import com.company.icc.model.Motion;
import com.company.icc.service.DhtService;
import com.company.icc.service.MotionService;

import java.io.IOException;

/**
 * Created by leventyildiz on 27/01/16.
 */
public class MotionServiceImpl implements MotionService {
    static SerialClass main = new SerialClass();

    public MotionServiceImpl() {
        main.initialize();

    }

    @Override
    public Motion getData() {

        String data;
        Motion motion = new Motion();
        int counter = 0;
        int tmpVal = 0;


        try {

            while (true) {
                main.writeData("5");
                data = main.input.readLine();

                String[] parts = data.split("=");
                String s = parts[1];
                s = s.trim();


                if (s.equals("1")) {
                    tmpVal = (tmpVal + 1);
                }

                if (counter > 3) {

                    if (tmpVal > 1) {
                        motion.setMotionData(1);

                    } else {
                        motion.setMotionData(0);

                    }

                    break;
                }
                counter++;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return motion;

    }

}