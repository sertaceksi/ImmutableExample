package com.rovio.plushmarket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;

@Value.Immutable
public class PlushDTO {

    @JsonProperty("plush")
    private String plush;


    @JsonProperty("price")
    private Integer price;

    public PlushDTO(String plush, Integer price) {
        this.plush = plush;
        this.price = price;
    }

    public PlushDTO() {
    }

    public String getPlush() {
        return plush;
    }

    public Integer getPrice() {
        return price;
    }

    public boolean findPlush(String plush) {
        return this.plush.equals(plush);
    }
}
