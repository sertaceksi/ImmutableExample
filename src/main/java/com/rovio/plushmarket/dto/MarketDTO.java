package com.rovio.plushmarket.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;

import java.util.*;
import java.util.stream.Collectors;

@Value.Immutable
@Value.Style(init = "set*")
public class MarketDTO {
    @JsonProperty("plushes")
    List<PlushDTO> plushDTOList;

    @JsonProperty("trades")
    List<TradeDTO> tradeDTOList;

    @JsonIgnore
    String mostValuableItem;

    @JsonIgnore
    TreeNode currentBestTradeNode;

    @JsonIgnore
    Set<String> tradedPlushSet;

    public Actions execute(OfferDTO offerDTO) {
        String plush = offerDTO.getPlush();
        tradedPlushSet = new HashSet<>();
        TreeNode rootNode = new TreeNode(plush);
        currentBestTradeNode = rootNode;
        doPossibleTrades(rootNode);
        return getActions();
    }

    public Actions getActions() {
        TreeNode node = currentBestTradeNode;
        List<IAction> actionList = new ArrayList<>();
        Optional<PlushDTO> plushToSell = getPlush(currentBestTradeNode.getPlushName());
        if (plushToSell.isPresent()) {
            ActionSell actionSell = new ActionSell(plushToSell.get().getPlush(), plushToSell.get().getPrice());
            actionList.add(actionSell);
        }
        while (node.isNotRootNode()) {
            ActionTrade actionTrade = new ActionTrade(node.getHeadNode().getPlushName(), node.getPlushName());
            actionList.add(actionTrade);
            node = node.getHeadNode();
        }
        Collections.reverse(actionList);
        return new Actions(actionList);
    }

    private void doPossibleTrades(TreeNode node) {
        if (checkIfThePlushTradedBefore(node.getPlushName())) {
            return;
        }
        List<TradeDTO> possibleTrades = tradeDTOList.stream().filter(a -> a.getTake().equals(node.getPlushName())).collect(Collectors.toList());
        possibleTrades.forEach(a -> doSingleTrade(a, node));
    }

    private boolean checkIfThePlushTradedBefore(String plush) {
        Optional<String> toBeDecidedStringName = tradedPlushSet.stream().filter(a -> a.equals(plush)).findAny();
        return toBeDecidedStringName.isPresent();
    }

    private void doSingleTrade(TradeDTO tradeDTO, TreeNode headNode) {
        tradedPlushSet.add(tradeDTO.getTake());
        TreeNode newNode = new TreeNode(tradeDTO.getGive(), headNode);
        updateCurrentBestNode(tradeDTO.getGive(), newNode);
        if (tradeDTO.getGive().equals(mostValuableItem)) {
            return;
        }
        doPossibleTrades(newNode);
    }

    private void updateCurrentBestNode(String plush, TreeNode node) {
        Optional<PlushDTO> currentBestValuePlush = getPlush(currentBestTradeNode.getPlushName());
        Optional<PlushDTO> candidateBestValuePlush = getPlush(plush);
        if (currentBestValuePlush.isPresent() && candidateBestValuePlush.isPresent()
                && candidateBestValuePlush.get().getPrice().compareTo(currentBestValuePlush.get().getPrice()) > 0) {
            currentBestTradeNode = node;
        }
        if (currentBestValuePlush.isPresent() && candidateBestValuePlush.isPresent()
                && checkIfDistanceShorterWithSamePrice(currentBestValuePlush.get(), candidateBestValuePlush.get(), node)) {
            currentBestTradeNode = node;
        }
    }

    private boolean checkIfDistanceShorterWithSamePrice(PlushDTO currentBestPlush, PlushDTO candidatePlush, TreeNode node) {
        return candidatePlush.getPrice().compareTo(currentBestPlush.getPrice()) == 0
                && node.getDistanceToRoot() < currentBestTradeNode.getDistanceToRoot();
    }

    private Optional<PlushDTO> getPlush(String plush) {
        return plushDTOList.stream().filter(a -> a.findPlush(plush)).findFirst();

    }

}
