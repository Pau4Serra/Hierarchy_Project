package examenHerencia;

import java.util.ArrayList;

public class Elf extends Personatge{

	private double magic;
	
	public Elf(String faccio, String nom, int attackPower, int numWeapons, ArrayList<Weapon> Weapons, double magic) {
		super(faccio, nom, attackPower, numWeapons, Weapons);
		
		this.magic = magic;
	}

	public double getMagic() {
		return magic;
	}

	public void setMagic(double magic) {
		this.magic = magic;
	}
	
	double average() {
		double result;
		int totalAd = 0;
		for(int i = 0; i < this.getNumWeapons(); i++) {
			totalAd = totalAd + getWeapons().get(i).getDamage();
		}
		result = (getAttackPower() + ((totalAd)*(1 + getMagic())/this.getNumWeapons()));
		return result;
	}
	
}
