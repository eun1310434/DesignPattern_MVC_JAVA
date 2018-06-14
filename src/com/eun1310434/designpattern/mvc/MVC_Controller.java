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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MVC_Controller {
	
	private MVC_View view;
	private MVC_Model model;
	
	public MVC_Controller(MVC_View _view, MVC_Model _model) {
		this.view = _view;
		this.model = _model;
		
		// Integrate
		this.view.addCalculateListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int firstNumber, secondNumber = 0;
				
				// Surround interactions with the view with a try block in case numbers weren't properly entered
				
				try{
					//getView
					firstNumber = view.getFirstNum();
					secondNumber = view.getSecondNum();
					
					//calcModel
					model.addTwoNumbers(firstNumber, secondNumber);
					int result = model.getValue();

					//setView
					view.setCalcSolution(result);
					
				}catch(NumberFormatException ex){
					System.out.println(ex);
					view.displayErrorMessage("You Need to Enter 2 Integers");
				}
				
			}
		});
	}	
}
