package com.company.icc.controller;

import com.company.icc.model.Climate;
import com.company.icc.model.HttpStatus;
import com.company.icc.service.ClimateService;
import com.company.icc.service.impl.ClimateServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by leventyildiz on 24/01/16.
 */
@Controller
@RequestMapping("climate")
public class ClimateController {

    ClimateService climateService = new ClimateServiceImpl();


    @RequestMapping(value = "/start", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    HttpStatus startClimate(@RequestBody String json) {

        Gson gson = new Gson();
        Climate c = gson.fromJson(json, Climate.class);


        climateService.startClimate();

        HttpStatus status = new HttpStatus();
        status.setMsg("success");
        status.setStatus("200");

        return status;

    }



    @RequestMapping(value = "/stop", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    HttpStatus stopClimate(@RequestBody String json) {

        Gson gson = new Gson();
        Climate c = gson.fromJson(json, Climate.class);

        climateService.stopClimate();

        HttpStatus status = new HttpStatus();
        status.setMsg("success");
        status.setStatus("200");

        return status;

    }


}