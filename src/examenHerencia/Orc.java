package examenHerencia;

import java.util.ArrayList;

public class Orc extends Personatge{
	
	private int tenacity;

	public Orc(String faccio, String nom, int attackPower, int numWeapons, ArrayList<Weapon> Weapons, int tenacity) {
		super(faccio, nom, attackPower, numWeapons, Weapons);
		
		this.tenacity = tenacity;
	}

	public int getTenacity() {
		return tenacity;
	}

	public void setTenacity(int tenacity) {
		this.tenacity = tenacity;
	}

	double average() {
		double result;
		int totalAd = 0;
		for(int i = 0; i < this.getNumWeapons(); i++) {
			totalAd = totalAd + getWeapons().get(i).getDamage();
		}
		result = (getAttackPower() + ((totalAd)/this.getNumWeapons())*getTenacity()/2);
		return result;
	}
	
}
