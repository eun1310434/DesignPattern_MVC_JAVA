/*==================================================================================================
¡à INFORMATION
  ¡Û Data : Thursday - 14/06/18
  ¡Û Mail : eun1310434@naver.com
  ¡Û WebPage : https://eun1310434.github.io/
  ¡Û Reference
     - http://www.newthinktank.com/2013/02/mvc-java-tutorial/

¡à Function
   ¡Û Unit
      - public class MVC_Model
        01) public void addTwoNumbers(int firstNum, int secondNum)
        02) public int getValue()
        
      - public class MVC_View extends JFrame
        01) public MVC_View()
        02) public int getFirstNum()
        03) public int getSecondNum()
        04) public int getCalcSolution()
        05) public void setCalcSolution(int solution)
        06) public void addCalculateListener(ActionListener listenForCalcButton)
        07) public void displayErrorMessage(String errorMessage)

      - public class MVC_Controller
        01) public MVC_Controller(MVC_View _view, MVC_Model _model)

      - public class MVC_Main
        01) public static void main(String[] args)


¡à Study
   ¡Û MVC
     - Completely separates the Calculations and Interface from each other
     
   ¡Û Model
     - Data and Methods used to work with it.
     - The Model performs all the calculations needed and that is it. It doesn't know the View exists
     
   ¡Û View : 
     - The Interface
     - Its only job is to display what the user sees 
     - It performs no calculations, but instead passes information entered by the user to whomever needs it. 
     
   ¡Û Controller
     - Coordinates interactions berween the View and Model 
==================================================================================================*/
package com.eun1310434.designpattern.mvc;

import java.awt.event.ActionListener;

import javax.swing.*;

public class MVC_View extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JTextField textField_firstNum  = new JTextField(10);
	private JLabel label_addition = new JLabel("+");
	
	private JTextField textField_secondNum = new JTextField(10);
	
	private JButton btn_calculate = new JButton("Calculate");
	private JTextField textField_solution = new JTextField(10);
	
	public MVC_View(){
		// Sets up the view 
		// Adds the components
		
		JPanel calcPanel = new JPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 200);
		
		
		calcPanel.add(textField_firstNum);
		calcPanel.add(label_addition);
		calcPanel.add(textField_secondNum);
		calcPanel.add(btn_calculate);
		calcPanel.add(textField_solution);
		this.add(calcPanel);
	}
	
	public int getFirstNum(){
		return Integer.parseInt(textField_firstNum.getText());
	}
	
	public int getSecondNum(){
		return Integer.parseInt(textField_secondNum.getText());
	}
	
	public int getCalcSolution(){
		return Integer.parseInt(textField_solution.getText());
	}
	
	public void setCalcSolution(int solution){
		textField_solution.setText(Integer.toString(solution));
	}
	
	// If the calculateButton is clicked execute a method
	// in the Controller named actionPerformed
	public void addCalculateListener(ActionListener listenForCalcButton){
		btn_calculate.addActionListener(listenForCalcButton);
	}
	
	// Open a popup that contains the error message passed
	public void displayErrorMessage(String errorMessage){
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}