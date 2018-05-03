/*
* File: Project3X.java
* Author: Mohamed Nheri
* Date: 04/20/2018
* Purpose: This class will constrcut the Gui of the application 
* and perform the sorting of the nummbers entered
*/
package app;

import java.awt.event.ActionEvent;
import javax.swing.*;
class Project3X {
    
    private JTextField txtInputList;
    private JTextField txtResultList;
    JRadioButton optAscending;
    JRadioButton optDescending;
    JRadioButton optInteger;
    JRadioButton optFraction;    
    
    /**
     * Create UI
     */
    public void createUI(){
        // Create MainFrame
        JFrame mainFrame = new JFrame("Binary Search Tree Sort");

        // Create MainPanel
        JPanel mainPanel = (JPanel) mainFrame.getContentPane();
        mainFrame.setLayout(null);

        // Create Input Original List
        JLabel lblOriginalList = new JLabel("Original List");
        lblOriginalList.setBounds(15, 25, 100, 30);
        mainPanel.add(lblOriginalList);

        txtInputList = new JTextField("", 30);
        txtInputList.setBounds(125, 25, 350, 30);
        mainPanel.add(txtInputList);

        // Create Output of Result
        JLabel lblSortedList = new JLabel("Sorted List");
        lblSortedList.setBounds(25, 80, 100, 30);
        mainPanel.add(lblSortedList);

        txtResultList = new JTextField("", 30);
        txtResultList.setBounds(125, 80, 350, 30);
        mainPanel.add(txtResultList);

        // Create the Push Button for Running a Event
        JButton btnPerformSort = new JButton("Perform Sort");
        btnPerformSort.setBounds(175, 125, 125, 30);
        btnPerformSort.addActionListener((ActionEvent e) -> 
        { 
            processSort();
        });
        mainPanel.add(btnPerformSort);
        
        // Create Options of Sort Order Settings
        JLabel lblSortOrder = new JLabel("Sort Order");
        lblSortOrder.setBounds(15, 150, 100, 30);
        mainPanel.add(lblSortOrder);
        ButtonGroup btnGrpSortOrder = new ButtonGroup();
        
        optAscending = new JRadioButton("Ascending");
        optAscending.setBounds(30, 175, 100, 30);
        optAscending.setSelected(true);
        mainPanel.add(optAscending);
        btnGrpSortOrder.add(optAscending);
        
        optDescending = new JRadioButton("Descending");
        optDescending.setBounds(30, 200, 100, 30);
        mainPanel.add(optDescending);
        btnGrpSortOrder.add(optDescending);
        
        // Create Options of Numeric Type Settings
        JLabel lblNumericType = new JLabel("Numeric Type");
        lblNumericType.setBounds(365, 150, 100, 30);
        mainPanel.add(lblNumericType);
        ButtonGroup btnGrpNumericType = new ButtonGroup();
        
        optInteger = new JRadioButton("Integer");
        optInteger.setBounds(360, 175, 100, 30);
        optInteger.setSelected(true);
        mainPanel.add(optInteger);
        btnGrpNumericType.add(optInteger);
        
        optFraction = new JRadioButton("Fraction");
        optFraction.setBounds(360, 200, 100, 30);
        mainPanel.add(optFraction);
        btnGrpNumericType.add(optFraction); 

        // Setup the properties of mainFrame
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 275);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }        
    
    /**
     * process Sort using BST
     */
    private void processSort() {       
       //Check out the INPUT validation , if the user five nothing as input 
    	// we get error popup msg
       if(txtInputList.getText().equals("")){
          JOptionPane.showMessageDialog(null, "Please enter values by split spacing.", "Project3", JOptionPane.WARNING_MESSAGE);
          return;
       }
       //for loop to go through each value in the expression
       for(int i = 0; i < txtInputList.getText().length(); i++){
           char ch = txtInputList.getText().charAt(i);
           //condition to check if the character is a degit or space or fraction sign
           if(!Character.isDigit(ch) && ch != '/' && !Character.isWhitespace(ch)){
               JOptionPane.showMessageDialog(null, "You must input the values of Numeric Type(Integer, Fraction)", "Project3", JOptionPane.WARNING_MESSAGE);
               return ;
           }
           if(ch == '/' && optInteger.isSelected()) {
               JOptionPane.showMessageDialog(null, "You must input only ingegers", "Project3", JOptionPane.WARNING_MESSAGE);
               return ;
           }
       }       
       //splitting the iput expreression into array
       String values[] = txtInputList.getText().split(" ");      
       if(optFraction.isSelected()){
           // Checkout the fraction validation
            for(int i = 0; i < values.length; i++){
                if(values[i].split("/").length > 2){
                    JOptionPane.showMessageDialog(null, "Number Format is wrong", "Project3", JOptionPane.WARNING_MESSAGE);
                    return ;
                }
            }
       }

        // Construct the BST
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i < values.length; i++) 
            bst.add(values[i]);
        //condition to check if ascending radio button is selected or descending
        if (optAscending.isSelected()) {  // Print out by Ascending
            txtResultList.setText(bst.getAscendingString());
        }else   {                          // Print out by Descending
            txtResultList.setText(bst.getDescendingString()); 
        }
    } 


    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args)
    {
        Project3X project3x = new Project3X();
        project3x.createUI();
    }   
    
}
