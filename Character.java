import java.io.*;
/**
* <h1>Character class</h1>
* The Class is used to crate a Character which can then be used in combat simulations
* <p>
* 
* @author  Bryan McCarthy
* @version 1.0
* @since   2014-12-01
*/

public class Character extends Stats implements Serializable{
	String name;
	String profession;
	String race;
	int strength;
	int stamina;
	int intellect;
	
	public Character(){
		name = "not given";
		profession = "no prof";
		race = "not given";
		strength = getStr();
		//agility = getAgi();
		stamina = getStam();
		intellect = getInt();
		
	}
	//accessors
	/**
   * This method returns the name of the character. 
   * @return String this method returns the name of the character
   */
	public String getName(){
		return name;
	}
   /**
   * This method returns the class of the character. 
   * @return String this method returns the class of the character
   */
	public String getProf(){
		return profession;
	}
   /**
   * This method returns the race of the character. 
   * @return String this method returns the race of the character
   */
	public String getRace(){
		return race;
	}
   /**
   * This method returns the strength of the character. 
   * @return int this method returns the strength of the character
   */
	public int showStr(){
		return strength;
	}
	
   /**
   * This method returns the stamina of the character. 
   * @return int this method returns the stamina of the character
   */
	public int showStam(){
		return stamina;
	}
   /**
   * This method returns the intellect of the character. 
   * @return int this method returns the intellect of the character
   */
	public int showInt(){
		return intellect;
	}
	
   /**
   * This method adds a new value to the old strength value
   * @param str This is the only parameter to setStr method 
   * @return int this method returns the strength of the character
   */
	public void setStr(int str){
		strength += str;
	}
	
   /**
   * This method adds a new value to the old stamina value
   * @param stam This is the only parameter to setStam method 
   * @return int this method returns the strength of the character
   */
	public void setStam(int stam){
		stamina += stam;
	}
	
   /**
   * This method adds a new value to the old intellect value
   * @param Int This is the only parameter to setint method 
   * @return int this method returns the strength of the character
   */
	public void setInt(int Int){
		intellect += Int;
	}
	
	//mutators
	/**
   * This method replaces the old name with the new name value
   * @param name This is the only parameter to setName method 
   * @return nothing
   */
	public void setName(String name){
		this.name = name;
	}
	/**
   * This method replaces the old class with the new class value
   * @param name This is the only parameter to setProf method 
   * @return nothing
   */
	public void setProf(String prof){
		profession = prof;
	}
	/**
   * This method replaces the old race with the new race value
   * @param name This is the only parameter to setProf method 
   * @return nothing
   */
	public void setRace(String race){
		this.race = race;
	}
	
	
	
	/**
   * This method allows al of the character attributes to be displayed as a string
   * @param name This is the only parameter to setProf method 
   * @return nothing
   */
	public String toString(){
		String answer;
	//	answer = ("Name: " +getName() + "\nProfession: " + getProf() + "\nRace: " + getRace() + "\nStrength: " + showStr() + 
	//		      "\nAgility: " + showAgi() + "\nStamina: " + showStam() + "\nIntellect: " + showInt());
	    
	    answer = String.format("%5s\n%5s\n%5s\n%02d\n%02d\n%02d\n\n", "Name: "+getName(), "Class: "+getProf(), "Race: "+getRace(), showStr(), showStam(), showInt());
		return answer;
	}
 
}