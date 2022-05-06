package com.rovio.plushmarket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;

@Value.Immutable
@Value.Style(init = "set*")
public class OfferDTO {

    @JsonProperty("plush")
    private String plush;


    public String getPlush() {
        return plush;
    }

}
