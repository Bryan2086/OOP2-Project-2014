//ProblemSet0Question1.java
/*This program is based off of problem set 0 and is for revision purposes*/

import javax.swing.JOptionPane;

public class ProblemSet0Question1 {
	public static void main(String args[])
		{
			String name, className, numberOfSnacksAsString;
		//	float className;
			int price; 
				
		//	float classNameAsFloat = Float.parseFloat(className);
		//	int numberOfSnacks = Integer.parseInt(numberOfSnacksAsString);
			
			name = JOptionPane.showInputDialog("Please enter your name");
			className = JOptionPane.showInputDialog("Please enter your class name");
			numberOfSnacksAsString = JOptionPane.showInputDialog("Please enter the amount of snacks you would like");
			
			int numberOfSnacks = Integer.parseInt(numberOfSnacksAsString);
			
			
			price = (numberOfSnacks * 2);
			
			
			
		JOptionPane.showMessageDialog(null,"your name is: " + name + "\nyour class name is : " + className +
			                           "\nthe number of snacks you would like is: " + numberOfSnacks +
			                           	"\n the price you have to pay is: " + "€" + price,"results",JOptionPane.INFORMATION_MESSAGE);
		}} 
		