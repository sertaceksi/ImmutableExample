package com.rovio.plushmarket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;

@Value.Immutable
public class ActionSell implements IAction {
    @JsonProperty("action")
    private String action;

    @JsonProperty("plush")
    private String give;

    @JsonProperty("price")
    private Integer take;

    @Override
    public String getGive() {
        return give;
    }

    @Override
    public Integer getTake() {
        return take;
    }

    public ActionSell(String give, Integer take) {
        this.action = "sell";
        this.give = give;
        this.take = take;
    }

    public ActionSell() {
    }
}
