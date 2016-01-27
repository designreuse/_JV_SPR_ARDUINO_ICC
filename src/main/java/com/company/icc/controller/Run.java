package com.company.icc.controller;

import com.company.icc.init.SerialClass;
import com.company.icc.model.Dht;
import com.company.icc.model.Motion;

import java.io.IOException;

/**
 * Created by leventyildiz on 27/01/16.
 */
public class Run {


    static SerialClass main = new SerialClass();


    public static void main(String[] args) {

        main.initialize();
        try {

            String data;
            Motion motion = new Motion();

            try {

                while (true) {
                    data = main.input.readLine();

                    if (data.toUpperCase().contains("MOTION")) {
                        String[] parts = data.split("=");

                        if(parts[1]=="0"){
                            motion.setMotionData(0);
                        }else {
                            motion.setMotionData(1);
                        }

                        //break;
                    }

                    System.out.println("---------- "+data.toString()+" -------- ");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
