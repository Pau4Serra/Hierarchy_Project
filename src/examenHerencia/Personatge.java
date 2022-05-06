package examenHerencia;

import java.util.ArrayList;

public abstract class Personatge {

	private String faccio;
	private String nom;
	private int attackPower;
	private int numWeapons;
	private ArrayList<Weapon> Weapons;
	
	public Personatge (String faccio, String nom, int attackPower, int numWeapons, ArrayList<Weapon> Weapons) {
		this.faccio = faccio;
		this.nom = nom;
		this.attackPower = attackPower;
		this.numWeapons = numWeapons;
		this.Weapons = Weapons;
	}

	public int getAttackPower() {
		return attackPower;
	}

	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}

	public int getNumWeapons() {
		return numWeapons;
	}

	public void setNumWeapons(int numWeapons) {
		this.numWeapons = numWeapons;
	}

	public ArrayList<Weapon> getWeapons() {
		return Weapons;
	}

	public void setWeapons(ArrayList<Weapon> weapons) {
		Weapons = weapons;
	}

	public String getFaccio() {
		return faccio;
	}

	public void setFaccio(String faccio) {
		this.faccio = faccio;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	abstract double average();
	
}
