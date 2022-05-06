package examenHerencia;

import java.util.ArrayList;

public class Human extends Personatge{
	
	private boolean intelligence;

	public Human(String faccio, String nom, int attackPower, int numWeapons, ArrayList<Weapon> Weapons, boolean intelligence) {
		super(faccio, nom, attackPower, numWeapons, Weapons);
		
		this.intelligence = intelligence;
	}

	public boolean isIntelligence() {
		return intelligence;
	}

	public void setIntelligence(boolean intelligence) {
		this.intelligence = intelligence;
	}
	
	double average() {
		double result;
		int totalAd = 0;
		for(int i = 0; i < this.getNumWeapons(); i++) {
			totalAd = totalAd + getWeapons().get(i).getDamage();
		}
		if(isIntelligence()) {
			result = ((getAttackPower()*1.33) + ((totalAd)/this.getNumWeapons()));
		} else {
			result = (getAttackPower() + ((totalAd)/this.getNumWeapons()));
		}
		
		return result;
	}	
}
