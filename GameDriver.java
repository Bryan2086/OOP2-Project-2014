import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class GameDriver extends JFrame{
	public int xp = 0;//xp you start off with
	public int hp = 0, totalHp = 0;//variables for health
	public int choice =0;//variable to select a character
	
	public String combatChoiceAsString;
	public char combatChoice;//used to choose between melee or magic
	
	JMenuBar menuBar;
	
    FileHandler handler;
    CharacterHandler handler1;
    buttonHandler handler2;
    combatHandler handler3;
    
    //String name, profession, race;
    LinkedList<Character> myCharacters = new LinkedList<Character>();
    Character player, mainPlayer;
    
    public JLabel xpLabel, hpLabel, strLabel, intLabel, stamLabel;//Labels
    public JButton combatButton, strButton, intButton, stamButton, cheatButton;//Buttons
    
    FlowLayout myFlowLayout = new FlowLayout();
    
    JTextField textField = new JTextField(15);
    
   
    
    
    
	public static void main(String args[]){
			GameDriver gui = new GameDriver();
		    gui.setVisible(true);
	}
	
	public GameDriver(){
	  setTitle("Game Menu");
	  setSize(200,300);
	  setLocation(200,100);	  
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  setLayout(myFlowLayout);
	  
	  //JMenuBar
	  menuBar = new JMenuBar();
	  setJMenuBar(menuBar);
	  createFileMenu();
	  createCharacterMenu();
	  createCombatMenu();
	  
	 
	  //creates labels
	  hp = 5;
	  xpLabel = new JLabel("XP: " + xp);
	  hpLabel = new JLabel("HP: " + hp * 10);
	  strLabel = new JLabel("Strength: " + "5");
	  intLabel = new JLabel("Intellect: " + "5");
	  stamLabel = new JLabel("Stamina: " + "5");
	  add(xpLabel);
	  add(hpLabel);
	  add(strLabel);
	  add(intLabel);
	  add(stamLabel);
	  add(textField);
	  
	   //creates buttons
	  
	  handler2 = new buttonHandler();
	  strButton = new JButton("Add Strength");
	  strButton.addActionListener(handler2);
	  add(strButton); 
	  	
	  intButton = new JButton("Add Intellect");
	  intButton.addActionListener(handler2);
	  add(intButton);
	  
	  stamButton = new JButton("Add Stamina");
	  stamButton.addActionListener(handler2);
	  add(stamButton);
	  
	  cheatButton = new JButton("Cheater!");
	  cheatButton.addActionListener(handler2);
	  add(cheatButton);
	  
	}
	//ALL MENUES
	
	//file menu
	public void createFileMenu()
    { 
      JMenu fileMenu = new JMenu("File"); 
	  menuBar.add(fileMenu);
	  
	  JMenuItem quitItem = new JMenuItem("Quit");
	  JMenuItem saveItem = new JMenuItem("Save");
	  JMenuItem loadItem = new JMenuItem("Load"); 
	  
	  handler = new FileHandler();
	   
	  fileMenu.add(saveItem);
	  fileMenu.add(loadItem);
	  fileMenu.add(quitItem);
	  saveItem.addActionListener(handler);
	  loadItem.addActionListener(handler);
	  quitItem.addActionListener(handler);
	  		
    }
    
    
    //character menu
    public void createCharacterMenu()
    { 
      JMenu characterMenu = new JMenu("Character");
	  menuBar.add(characterMenu);
	  
	  JMenuItem displayItem = new JMenuItem("Display");
	  JMenuItem addItem = new JMenuItem("Add");
	  JMenuItem chooseItem = new JMenuItem("Select Character");
	  
	  handler1 = new CharacterHandler();
	   
	  characterMenu.add(displayItem);
	  characterMenu.add(addItem);
	  characterMenu.add(chooseItem);
	  displayItem.addActionListener(handler1);
	  addItem.addActionListener(handler1);
	  chooseItem.addActionListener(handler1);
	  		
    }
    
    //Combat menu
    public void createCombatMenu()
    { 
      JMenu combatMenu = new JMenu("Combat");
	  menuBar.add(combatMenu);
	  
	  JMenuItem dragonItem = new JMenuItem("Dragon");
	  JMenuItem orcItem = new JMenuItem("Orc");
	  JMenuItem goblinItem = new JMenuItem("Goblin");
	  
	  handler3 = new combatHandler();
	   
	  combatMenu.add(dragonItem);
	  combatMenu.add(orcItem);
	  combatMenu.add(goblinItem);
	  dragonItem.addActionListener(handler3);
	  orcItem.addActionListener(handler3);
	  goblinItem.addActionListener(handler3);
	  		
    }
  
    
    //END OF MENUES
    
    
    //ALL HANDLERS
    
    //Handler for file menu
    public class FileHandler implements ActionListener{
  	public void actionPerformed(ActionEvent e) 
   {
   	if(e.getActionCommand().equals("Quit"))
   	{
   		JOptionPane.showMessageDialog(null, "Quitting");
  	    System.exit(0);
   	}
   	
   	else if(e.getActionCommand().equals("Save"))
   	{
   		JOptionPane.showMessageDialog(null, "Saving");
   		saveCharacter();
   	}
   	
   	else if(e.getActionCommand().equals("Load"))
   	{
   		JOptionPane.showMessageDialog(null, "Loading");
   		loadCharacter();
   	}
  		
   }
  }
  
  
  //Handler for character menu
  public class CharacterHandler implements ActionListener{
  	public void actionPerformed(ActionEvent e)
   {
  	  if(e.getActionCommand().equals("Display"))
  	{
  	   displayCharacter();
  	}
  	
  	 else if(e.getActionCommand().equals("Select Character"))
  	{
	   selectCharacter();
  	
  	}
  	 else if(e.getActionCommand().equals("Add"))
  	 {
  	   addCharacter();
  	 }
  		
   }
  }
  
  //Handler for Buttons
   public class buttonHandler implements ActionListener{
  	public void actionPerformed(ActionEvent e) 
   {
   	if(e.getActionCommand().equals("Add Strength"))
   	{
   		JOptionPane.showMessageDialog(null, "Strength increased by 1");
   		addStrength();
   	}
   	else if(e.getActionCommand().equals("Add Intellect"))
   	{
   		JOptionPane.showMessageDialog(null, "Intellect increased by 1");
   		addIntellect();
   	}
   	else if(e.getActionCommand().equals("Add Stamina"))
   	{
   		JOptionPane.showMessageDialog(null, "Stamina increased by 1");
   		addStamina();
   	}
   	else if(e.getActionCommand().equals("Cheater!"))
   	{
   		JOptionPane.showMessageDialog(null, "Well aren't you amazing....");
   		cheat();
   	}
  		
   }
  }
  
  //Handler for combat menu
   public class combatHandler implements ActionListener{
  	public void actionPerformed(ActionEvent e) 
   {
   	if(e.getActionCommand().equals("Dragon"))
   	{
   		dragonCombat();
   		if((totalHp + (hp * 10) <= 0))//if ur health reaches zero
   		characterDeath();
   	}
   	else if(e.getActionCommand().equals("Goblin"))
   	{
   		goblinCombat();
   		if((totalHp + (hp * 10) <= 0))
   		characterDeath();
   	}
   	else if(e.getActionCommand().equals("Orc"))
   	{
   		orcCombat();
   		if((totalHp + (hp * 10) <= 0))
   		characterDeath();
   	}
  		
   }
  }
  
  //END OF HANDLERS
  
  //METHODS FOR SAVING AND LOADING
  //THESE METHODS ARE HEAVILY INFLUENCED BY THE SAMPLES DONE IN CLASS
  
  //SAVE CHARACTER
  public void saveCharacter()//throws FileNotFoundException,IOException
   {
     try{
  
  	    File characterFile = new File("Character.dat");
		FileOutputStream fos = new FileOutputStream(characterFile);
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(myCharacters);
		oos.close();
       }
       
       catch(Exception e)
	       {
	         System.out.println(e.getMessage());
		
	       }
 
   }
   
   //LOAD CHARACTER
   public void loadCharacter()
   {
  	    try{	
      	  ObjectInputStream is;
      	  is = new ObjectInputStream(new FileInputStream ("Character.dat"));
          myCharacters =(LinkedList<Character>)is.readObject();
      	  is.close(); 
      	   }
	
	       
	    catch(Exception e)
	       {
	         System.out.println(e.getMessage());
		
	       }
   }
   
   
   
   //END OF SAVING/LOADING
   //BEGIN OR EXTRA METHODS
   
   //select character
   public void selectCharacter(){
   	   choice = Integer.parseInt(JOptionPane.showInputDialog("Please choose your character"));
  	   mainPlayer = myCharacters.get(choice);
  	   hpLabel.setText("HP: " + mainPlayer.showStam() * 10);
	   strLabel.setText("Strength: " + mainPlayer.showStr());
	   intLabel.setText("Intellect: " + mainPlayer.showInt());
	   stamLabel.setText("Stamina: " + mainPlayer.showStam());
   }
   
   
   //add new character
   public void addCharacter(){
   	  player = new Character();
  	  player.setName(JOptionPane.showInputDialog(null,"Please enter your character's name"));
	  player.setProf(JOptionPane.showInputDialog(null,"Please enter your character's profession (Warrior or Mage)"));
	  player.setRace(JOptionPane.showInputDialog(null,"Please enter your character's race"));
	  
	       if(!player.getProf().equalsIgnoreCase("mage") || !player.getProf().equalsIgnoreCase("warrior"))
	       {
	       	  JOptionPane.showMessageDialog(null,"Invalid profession you must be either a Warrior or a Mage");
	      	  player.setProf(JOptionPane.showInputDialog(null,"Please enter your character's profession (Warrior or Mage)"));
	      	  
	      	  if(player.getProf().equalsIgnoreCase("warrior"))
	      	  {
	       	    player.setStr(2);
	       	    hpLabel.setText("HP: " + player.showStam() * 10);
	       	    strLabel.setText("Strength: " + player.showStr());
	       	    intLabel.setText("Intellect: " + player.showInt());
	       	    stamLabel.setText("Stamina: " + player.showStam());
	      	  }
	      	  
	      	  else if(player.getProf().equalsIgnoreCase("mage"))
	          {
	       	    player.setInt(2);
	       	    hpLabel.setText("HP: " + player.showStam() * 10);
	       	    strLabel.setText("Strength: " + player.showStr());
	       	    intLabel.setText("Intellect: " + player.showInt());
	       	    stamLabel.setText("Stamina: " + player.showStam());

	          }

	       } 
	        
	  myCharacters.add(player);
   }
   
   //display a list of your characters
   public void displayCharacter(){
   	   JOptionPane.showMessageDialog(null, "Displaying");
       JOptionPane.showMessageDialog(null,"The current list of Characters on file are: " + "\n" + myCharacters.toString());
   }
   
   
   
   //ALL OF THE COMBAT METHODS
   public void dragonCombat(){
   	   combatChoiceAsString = JOptionPane.showInputDialog(null,"do you want to attack with a melee attack(m) or with a spell(s)");
   	   combatChoice = combatChoiceAsString.charAt(0);
   	   
   	   switch(combatChoice){
   	   	case 'm': if(mainPlayer.showStr() <10)
   	   	           {
   	   		          JOptionPane.showMessageDialog(null,"Your attack missed and the dragon injured you");
   	   		          totalHp -= 30;
   	   		          hpLabel.setText("HP: " + (totalHp + (hp * 10)));//Lost health
   	   	           }
   	   		    else
   	   		       {
   	   		    	  JOptionPane.showMessageDialog(null,"You killed the dragon!, you have earned experience");
   	   		    	  xp += 100;
   	   		          xpLabel.setText("XP: " + xp);//gain xp
   	   		       }
   	   		         break;
   	   		      
   	    case 's': if(mainPlayer.showInt() <10)
   	               {
   	    	          JOptionPane.showMessageDialog(null,"Your spell missed and the dragon injured you");
   	    	          totalHp -= 30;
   	    	          hpLabel.setText("HP: " + (totalHp + (hp * 10)));
   	               }
   	   		     
   	   		    else
   	   		       {
   	   		     	  JOptionPane.showMessageDialog(null,"You killed the dragon!, you have earned experience");
   	   		     	  xp += 100;
   	   		          xpLabel.setText("XP: " + xp);
   	   		       }
   	   		         break;
   	   
   	   }
   }
   
    public void goblinCombat(){
   	   combatChoiceAsString = JOptionPane.showInputDialog(null,"do you want to attack with a melee attack(m) or with a spell(s)");
   	   combatChoice = combatChoiceAsString.charAt(0);
   	   
   	   switch(combatChoice){
   	   	case 'm': if(mainPlayer.showStr() <5)
   	   	           {
   	   		          JOptionPane.showMessageDialog(null,"Your attack missed and the goblin injured you");
   	   		          totalHp -= 10;
   	    	          hpLabel.setText("HP: " + (totalHp + (hp * 10)));
   	   	           }
   	   		    else
   	   		       {
   	   		    	  JOptionPane.showMessageDialog(null,"You killed the goblin!, you have earned experience");
   	   		          xp += 20;
   	   		          xpLabel.setText("XP: " + xp);
   	   		       }
   	   		         break;
   	   		      
   	    case 's': if(mainPlayer.showInt() <5)
   	               {
   	    	          JOptionPane.showMessageDialog(null,"Your spell missed and the goblin injured you");
   	    	          totalHp -= 10;
   	    	          hpLabel.setText("HP: " + (totalHp + (hp * 10)));
   	               }
   	   		     
   	   		    else
   	   		       {
   	   		     	  JOptionPane.showMessageDialog(null,"You killed the goblin!, you have earned experience");
   	   		     	  xp += 20;
   	   		          xpLabel.setText("XP: " + xp);
   	   		       }
   	   		         break;
   	   
   	   }
   }
   
    public void orcCombat(){
   	   combatChoiceAsString = JOptionPane.showInputDialog(null,"do you want to attack with a melee attack(m) or with a spell(s)");
   	   combatChoice = combatChoiceAsString.charAt(0);
   	   
   	   switch(combatChoice){
   	   	case 'm': if(mainPlayer.showStr() <8)
   	   	           {
   	   		          JOptionPane.showMessageDialog(null,"Your attack missed and the orc injured you");
   	   		          totalHp -= 20;
   	    	          hpLabel.setText("HP: " + (totalHp + (hp * 10)));
   	   	           }
   	   		    else
   	   		       {
   	   		    	  JOptionPane.showMessageDialog(null,"You killed the orc!, you have earned experience");
   	   		    	  xp += 50;
   	   		          xpLabel.setText("XP: " + xp);
   	   		       }
   	   		         break;
   	   		      
   	    case 's': if(mainPlayer.showInt() <8)
   	               {
   	    	          JOptionPane.showMessageDialog(null,"Your spell missed and the orc injured you");
   	    	          totalHp -= 20;
   	    	          hpLabel.setText("HP: " + (totalHp + (hp * 10)));
   	               }
   	   		     
   	   		    else
   	   		       {
   	   		     	  JOptionPane.showMessageDialog(null,"You killed the orc!, you have earned experience");
   	   		     	  xp += 50;
   	   		          xpLabel.setText("XP: " + xp);
   	   		       }
   	   		         break;
   	   
   	   }
   }
   
   //ALL THE METHODS TO ADD STATS
   public void addStrength(){
   	           if(xp >= 100)
   	           {
   	           	     xp -= 100;//decrease xp by 100
   	   		         xpLabel.setText("XP: " + xp);//update xp label
   	   		         mainPlayer.setStr(1);//increase strength by 1
   	   		         strLabel.setText("Strength: " + mainPlayer.showStr());//update strength label
   	           }
   }
   
   public void addIntellect(){
   	           if(xp >= 100)
   	           {
   	           	     xp -= 100;//decrease xp by 100
   	   		         xpLabel.setText("XP: " + xp);//update xp label
   	   		         mainPlayer.setInt(1);//increase intellect by 1
   	   		         intLabel.setText("Intellect: " + mainPlayer.showInt());//update intellect label
   	           }
   }
   
   public void addStamina(){
   	           if(xp >= 100)
   	           {
   	           	     xp -= 100;//spend 100 xp
   	   		         xpLabel.setText("XP: " + xp);//update xp label
   	   		         mainPlayer.setStam(1);//increase stamina by 1
   	   		         stamLabel.setText("Stamina: " + mainPlayer.showStam());//update stamina label
   	   		         hp = mainPlayer.showStam();//hp is affected by player stamina
   	   		         hpLabel.setText("HP: " + (totalHp + (hp * 10)));//update hp label
   	           }
   }
   
   public void characterDeath(){
   	      
   	      	JOptionPane.showMessageDialog(null,"You died! all your xp has been reset but you are free to continue");
   	      	xp = 0;
   	      	xpLabel.setText("XP: " + xp);//reset xp to zero but continue playing
   	      
   }
   
   public void cheat(){
   	 xp += Integer.parseInt(textField.getText());
   	 xpLabel.setText("XP: " + xp);
   }
  
  
}