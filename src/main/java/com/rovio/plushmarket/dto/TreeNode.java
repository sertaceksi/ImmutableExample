package com.rovio.plushmarket.dto;

public class TreeNode {
    private String plushName;

    private TreeNode headNode;

    private Integer distance;

    public TreeNode(String plushName) {
        this.plushName = plushName;
    }

    public TreeNode(String plushName, TreeNode headNode) {
        this.plushName = plushName;
        this.headNode = headNode;
    }

    public String getPlushName() {
        return plushName;
    }

    public boolean isNotRootNode(){
        return headNode != null;
    }

    public Integer getDistanceToRoot(){
        if(distance == null){
            return calculateDistance();
        }
        return distance;
    }

    private Integer calculateDistance(){
        distance = 0;
        TreeNode node = this;
        while (node.isNotRootNode()){
            node = node.getHeadNode();
            distance++;
        }
        return distance;
    }

    public TreeNode getHeadNode() {
        return headNode;
    }
}
