/*
* File: BinarySearchTree.java
* Author: Mohamed Nheri
* Date: 04/20/2018
* Purpose: This Class will perform the sorting
*/
package app;

class BinarySearchTree<T extends Comparable<T>> {
    private Node        root = null;
    private String      sortedString = "";
    /**
     * Constructor 
     */
    public BinarySearchTree() {
    }
    
    /** 
     * Add value 
     */
    public void add(String value) {
        if(root == null){    // Create new Root
            root = new Node(value);
            return ;
        }
        
        insert(root, value);
    }    
    
    /** 
     * Insert value into Tree
     */
    private Node insert(Node node, String value) {
        Node newNode = new Node(value);
        
        if(node == null)  return newNode;  // Create new Root
            
        //condition to check node value to insert it to the left or right node       
        if(newNode.getNodeValue() < node.getNodeValue()) {    // Create LeftNode
            node.setLeftNode(insert(node.getLeftNode(), value));
        }else {                                         // Create RightNode
            node.setRightNode(insert(node.getRightNode(), value));
        }
        return node;
    }    
    
    /** 
     * getAscendingString
     */
    public String getAscendingString()
    {
        return sortByAscending(root);
    }
        
    /** 
     * sortByAscending
     */
    private String sortByAscending(Node node){        
        if(node != null){
            sortByAscending(node.getLeftNode());
            sortedString += node.getNodeString().toString() + " ";
            sortByAscending(node.getRightNode());
        }
        return sortedString;
    }
    
    /** 
     * getDescendingString
     */
    public String getDescendingString(){
        return sortByDescending(root);
    }  
    
    /**
     * sortByDescending
     */
    private String sortByDescending(Node node){        
        if(node != null){
            sortByDescending(node.getRightNode());
            sortedString += node.getNodeString().toString() + " ";
            sortByDescending(node.getLeftNode());
        }
        return sortedString;
    }
}//end of class