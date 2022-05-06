package com.rovio.plushmarket.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rovio.plushmarket.dto.*;
import com.rovio.plushmarket.intf.IMarketService;
import org.springframework.stereotype.Service;

@Service
public class MarketService implements IMarketService {

    @Override
    public Actions calculateStrategy(String offerJSON, String marketJSON) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        OfferDTO offerDTO = objectMapper.readValue(offerJSON, OfferDTO.class);
        MarketDTO marketDTO =  objectMapper.readValue(marketJSON, MarketDTO.class) ;
        return marketDTO.execute(offerDTO);
    }

}
