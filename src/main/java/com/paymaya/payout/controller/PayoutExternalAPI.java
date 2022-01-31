package com.paymaya.payout.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paymaya.payout.model.User;

@RestController
@RequestMapping("/payout")
public class PayoutExternalAPI {

    private static final Logger LOG = LoggerFactory.getLogger(PayoutExternalAPI.class);

    private final ObjectMapper objectMapper = new ObjectMapper();


    @GetMapping(value = "/getUser", produces = "application/json")
    public @ResponseBody String infoAboutUser() throws JsonProcessingException {
        LOG.info("Request for /getUser with GET");

       
        User user = null;
       
        String userJson = objectMapper.writeValueAsString(user);

        return   userJson;
    }
    
}
