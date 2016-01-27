package com.company.icc.service.impl;

import com.company.icc.init.SerialClass;
import com.company.icc.service.ClimateService;

/**
 * Created by leventyildiz on 27/01/16.
 */
public class ClimateServiceImpl implements ClimateService {

    static SerialClass main = new SerialClass();

    public  ClimateServiceImpl(){
        main.initialize();

    }


    @Override
    public boolean startClimate() {

        main.writeData("1");
        return  true;

    }


    @Override
    public boolean stopClimate() {

        main.writeData("0");
        return  true;
    }


}