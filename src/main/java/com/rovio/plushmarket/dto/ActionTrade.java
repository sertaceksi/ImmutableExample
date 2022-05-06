package com.rovio.plushmarket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;

@Value.Immutable
public class ActionTrade implements IAction {
    @JsonProperty("action")
    private String action;

    @JsonProperty("give")
    private String give;

    @JsonProperty("take")
    private String take;

    @Override
    public String getGive() {
        return give;
    }

    @Override
    public String getTake() {
        return take;
    }

    public ActionTrade(String give, String take) {
        this.action = "trade";
        this.give = give;
        this.take = take;
    }

    public ActionTrade() {
    }
}
