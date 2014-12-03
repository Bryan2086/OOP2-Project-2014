import java.io.*;
public class Character extends Stats implements Serializable{
	String name;
	String profession;
	String race;
	int strength;
	int agility;
	int stamina;
	int intellect;
	
	public Character(){
		name = "not given";
		profession = "no prof";
		race = "not given";
		strength = getStr();
		agility = getAgi();
		stamina = getStam();
		intellect = getInt();
		
	}
	//accessors
	public String getName(){
		return name;
	}
	public String getProf(){
		return profession;
	}
	public String getRace(){
		return race;
	}
	public int showStr(){
		return strength;
	}
	public int showAgi(){
		return agility;
	}
	public int showStam(){
		return stamina;
	}
	public int showInt(){
		return intellect;
	}
	
	public void setStr(int str){
		strength += str;
	}
	
	public void setStam(int stam){
		stamina += stam;
	}
	
	//mutators
	public void setName(String name){
		this.name = name;
	}
	public void setProf(String prof){
		profession = prof;
	}
	public void setRace(String race){
		this.race = race;
	}
	
	
	
	public String toString(){
		String answer;
	//	answer = ("Name: " +getName() + "\nProfession: " + getProf() + "\nRace: " + getRace() + "\nStrength: " + showStr() + 
	//		      "\nAgility: " + showAgi() + "\nStamina: " + showStam() + "\nIntellect: " + showInt());
	    
	    answer = String.format("%5s\n%5s\n%5s\n%02d\n%02d\n%02d\n%02d\n\n", "Name: "+getName(), "Class: "+getProf(), "Race: "+getRace(), showStr(), showAgi(), showStam(), showInt());
		return answer;
	}
 
}