package com.rovio.plushmarket.intf;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.rovio.plushmarket.dto.Actions;

public interface IMarketService {
    Actions calculateStrategy(String offerJSON, String marketJSON) throws JsonProcessingException;
}
