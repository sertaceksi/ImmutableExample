package com.rovio.plushmarket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@Value.Style(init = "set*")
public class Actions {
    @JsonProperty("actions")
    private List<IAction> actionList;

    public Actions(){

    }

    public Actions(List<IAction> actionList){
        this.actionList = List.copyOf(actionList);
    }

}
