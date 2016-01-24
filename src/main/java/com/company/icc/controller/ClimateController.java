package com.company.icc.controller;

import com.company.icc.model.Climate;
import com.company.icc.model.HttpStatus;
import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by leventyildiz on 24/01/16.
 */
@Controller
@RequestMapping("climate")
public class ClimateController {

    @RequestMapping(value = "/start", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    HttpStatus startClimate(@RequestBody String json) {

        Gson gson = new Gson();
       Climate c =  gson.fromJson(json, Climate.class);

        HttpStatus status = new HttpStatus();
        status.setMsg("success");
        status.setStatus("200");

        return status;

    }

}