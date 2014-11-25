public class Character extends Stats{
	String name;
	String profession;
	String race;
	int strength;
	int agility;
	int stamina;
	int intellect;
	
	public Character(String name, String prof, String race){
		this.name = name;
		profession = prof;
		this.race = race;
		strength = getStr();
		agility = getAgi();
		stamina = getStam();
		intellect = getInt();
		
	}
	
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
	
	public String toString(){
		String answer;
		answer = (getName() + "\n" + getProf() + "\n" + getRace() + "\n" + showStr() + "\n" + showAgi() + "\n" + showStam() + "\n" + showInt());
		return answer;
	}
 
}