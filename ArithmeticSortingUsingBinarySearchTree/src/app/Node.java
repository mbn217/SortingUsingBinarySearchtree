/*
* File: Node.java
* Author: Mohamed Nheri
* Date: 04/20/2018
* Purpose: This is the node Class
*/
package app;

class Node{    
    private String   valueStr;
    private Node     leftNode;
    private Node     rightNode;

    /**
     * Construct New Node
     */
    public Node(String value){
        this.valueStr = value;
    }
    
    /**
     * GetNodeValue
     */
    public double getNodeValue(){
        if(!valueStr.contains("/")) {
            return Integer.parseInt(valueStr.split("/")[0]);
        }else {
            return Integer.parseInt(valueStr.split("/")[0]) / Integer.parseInt(valueStr.split("/")[1]);
        }
    }
    
    public String getNodeString(){
        return valueStr;
    }
    
    /**
     * Set/Get LeftNode
     */
    public Node getLeftNode(){
        return leftNode;
    }
    
    public void setLeftNode(Node lNode){
        this.leftNode = lNode;
    }
    
    /**
     * Set/Get RightNode
     */
    public Node getRightNode(){
        return rightNode;
    }
    
    public void setRightNode(Node rNode){
        this.rightNode = rNode;
    }
} 