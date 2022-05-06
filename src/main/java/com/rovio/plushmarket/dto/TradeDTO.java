package com.rovio.plushmarket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
public class TradeDTO {
    @JsonProperty("take")
    private String take;
    @JsonProperty("give")
    private String give;


    public TradeDTO(String take, String give) {
        this.take = take;
        this.give = give;
    }

    public String getGive() {
        return give;
    }

    public String getTake() {
        return take;
    }

    public TradeDTO() {
    }

    public Optional<ActionTrade> getAction() {
        return Optional.of(new ActionTrade(take, give));
    }

}
