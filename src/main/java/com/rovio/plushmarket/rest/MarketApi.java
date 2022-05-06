package com.rovio.plushmarket.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rovio.plushmarket.dto.Actions;
import com.rovio.plushmarket.intf.IMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketApi {

    @Autowired
    IMarketService marketService;

    @GetMapping
    public Actions calculateStrategy(String offerJson, String marketJson) throws JsonProcessingException {
       return marketService.calculateStrategy(offerJson,marketJson);
    }
}
