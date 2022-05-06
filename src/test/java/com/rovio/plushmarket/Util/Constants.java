package com.rovio.plushmarket.Util;

public class Constants {
    public final static String EXAMPLE_1_OFFER = "{\"plush\": \"Stella\"}";
    public final static String EXAMPLE_2_OFFER = "{\"plush\": \"RedBird\"}";
    public final static String EXAMPLE_3_OFFER = "{\"plush\": \"BlueBird\"}";
    public final static String EXAMPLE_4_OFFER = "{\"plush\": \"Stella\"}";

    public final static String EXAMPLE_1_MARKET = "{\"plushes\": [\n" +
            "    {\"plush\": \"RedBird\", \"price\": 80},\n" +
            "    {\"plush\": \"Stella\", \"price\": 90},\n" +
            "    {\"plush\": \"Pig\", \"price\": 75}\n" +
            "],\n" +
            "\"trades\": [\n" +
            "    {\"take\": \"RedBird\", \"give\": \"Pig\"},\n" +
            "    {\"take\": \"Pig\", \"give\": \"Stella\"}\n" +
            "]}";
    public final static String EXAMPLE_2_MARKET = "{\"plushes\": [\n" +
            "    {\"plush\": \"RedBird\", \"price\": 80},\n" +
            "    {\"plush\": \"Stella\", \"price\": 90},\n" +
            "    {\"plush\": \"Pig\", \"price\": 75}\n" +
            "],\n" +
            "\"trades\": [\n" +
            "    {\"take\": \"RedBird\", \"give\": \"Pig\"},\n" +
            "    {\"take\": \"Pig\", \"give\": \"Stella\"}\n" +
            "]}";
    public final static String EXAMPLE_3_MARKET = "{\"plushes\": [\n" +
            "    {\"plush\": \"RedBird\", \"price\": 80},\n" +
            "    {\"plush\": \"Stella\", \"price\": 90},\n" +
            "    {\"plush\": \"Pig\", \"price\": 75}\n" +
            "],\n" +
            "\"trades\": [\n" +
            "    {\"take\": \"RedBird\", \"give\": \"Pig\"},\n" +
            "    {\"take\": \"Pig\", \"give\": \"Stella\"}\n" +
            "]}";
    public final static String EXAMPLE_4_MARKET = "{\n" +
            "    \"plushes\": [\n" +
            "        { \"plush\": \"Chuck\", \"price\": 100 },\n" +
            "        { \"plush\": \"RedBird\", \"price\": 80  },\n" +
            "        { \"plush\": \"Gaia\", \"price\": 80 },\n" +
            "        { \"plush\": \"Stella\", \"price\": 90 },\n" +
            "        { \"plush\": \"Bomb\", \"price\": 85 },\n" +
            "        { \"plush\": \"Pig\", \"price\": 75 }\n" +
            "    ],\n" +
            "        \"trades\": [\n" +
            "] }\n" +
            "{ \"take\": \"RedBird\", \"give\": \"Pig\" },\n" +
            "{ \"take\": \"Pig\", \"give\": \"Stella\" },\n" +
            "{ \"take\": \"Chuck\", \"give\": \"Stella\" },\n" +
            "{ \"take\": \"Stella\", \"give\": \"Bomb\" },\n" +
            "{ \"take\": \"Gaia\", \"give\": \"RedBird\" },\n" +
            "{ \"take\": \"Bomb\", \"give\": \"RedBird\" }";
    ;

    public final static String EXAMPLE_1_RESPONSE = "{\"actions\":[\n" +
            "    {\"action\":\"sell\",\"plush\":\"Stella\",\"price\":90}\n" +
            "]}";
    public final static String EXAMPLE_2_RESPONSE = "{\"actions\":[\n" +
            "    {\"action\":\"trade\",\"give\":\"RedBird\",\"take\":\"Pig\"},\n" +
            "    {\"action\":\"trade\",\"give\":\"Pig\",\"take\":\"Stella\"},\n" +
            "    {\"action\":\"sell\",\"plush\":\"Stella\",\"price\":90}\n" +
            "]}";
    public final static String EXAMPLE_3_RESPONSE = "{\"actions\":[]}";
    public final static String EXAMPLE_4_RESPONSE = "{\n" +
            "  \"actions\": [\n" +
            "    { \"action\": \"sell\", \"plush\": \"Stella\", \"price\": 90 }\n" +
            "  ]\n" +
            "}";

}
