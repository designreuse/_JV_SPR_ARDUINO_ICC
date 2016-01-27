package com.company.icc.controller;

import com.company.icc.model.Climate;
import com.company.icc.model.Dht;
import com.company.icc.model.HttpStatus;
import com.company.icc.service.ClimateService;
import com.company.icc.service.DhtService;
import com.company.icc.service.impl.ClimateServiceImpl;
import com.company.icc.service.impl.DhtServiceImpl;
import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by leventyildiz on 24/01/16.
 */
@Controller
@RequestMapping("dht")
public class DhtController {

    DhtService dhtService = new DhtServiceImpl();


    @RequestMapping(value = "/read", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    HttpStatus readDht(@RequestBody String json) {

//        Gson gson = new Gson();
//        Dht d = gson.fromJson(json, Dht.class);

        Dht dht = dhtService.getData();
        dht.setMsg("success");
        dht.setStatus("200");
        return dht;

    }


}