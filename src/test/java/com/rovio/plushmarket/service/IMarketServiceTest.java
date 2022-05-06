package com.rovio.plushmarket.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rovio.plushmarket.dto.Actions;
import com.rovio.plushmarket.intf.IMarketService;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import static com.rovio.plushmarket.Util.Constants.*;

class IMarketServiceTest {

    static IMarketService marketService;

    @BeforeAll
    static void init() {
        marketService = new MarketService();
    }

    @Test
    void calculateStrategy_EasyPath_NoTrade() throws JsonProcessingException, JSONException {
        Actions actions = marketService.calculateStrategy(EXAMPLE_1_OFFER, EXAMPLE_1_MARKET);
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        JSONAssert.assertEquals(EXAMPLE_1_RESPONSE, objectMapper.writeValueAsString(actions), true);
    }

    @Test
    void calculateStrategy_MediumPath_FindPath() throws JsonProcessingException, JSONException {
        Actions actions = marketService.calculateStrategy(EXAMPLE_2_OFFER, EXAMPLE_2_MARKET);
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        JSONAssert.assertEquals(EXAMPLE_2_RESPONSE, objectMapper.writeValueAsString(actions), true);
    }

    @Test
    void calculateStrategy_NoPath_ReturnEmpty() throws JsonProcessingException, JSONException {
        Actions actions = marketService.calculateStrategy(EXAMPLE_3_OFFER, EXAMPLE_3_MARKET);
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        JSONAssert.assertEquals(EXAMPLE_3_RESPONSE, objectMapper.writeValueAsString(actions), true);
    }

    @Test
    void calculateStrategy_MostExpensiveInput_JustSell() throws JsonProcessingException, JSONException {
        Actions actions = marketService.calculateStrategy(EXAMPLE_4_OFFER, EXAMPLE_4_MARKET);
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        JSONAssert.assertEquals(EXAMPLE_4_RESPONSE, objectMapper.writeValueAsString(actions), true);
    }

}
