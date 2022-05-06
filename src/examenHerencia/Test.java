package examenHerencia;

import java.util.ArrayList;

import java.util.Scanner;

public class Test {

	Scanner e = new Scanner(System.in);

	public static void main(String[] args) {

		Test t = new Test();
		t.principal();
	}
	
	public void principal() {
		
		ArrayList<Personatge> Personatges = new ArrayList<>();
		
		menu(Personatges);
		
	}
	
public void inicialitzarPersonatge(ArrayList<Personatge> Personatges) {
		
	 String faccio;
	 String nom;
	 int attackPower;
	 int numWeapons;
	 String type;
	 boolean intelligence;
	 int tenacity;
	 int magic;
		
		int t = -1;
		System.out.println("Choose race (Human, Orc, Elf): ");
		System.out.print(">> ");
		type = e.next().toLowerCase();
		System.out.println();
		
		if (type.equals("human")) {
			t = 1;
			
		} else if (type.equals("orc")) {
			t = 2;
			
		} else if (type.equals("elf")) {
			t = 3;
			
		} else {
			System.out.println("Not a valid race");
		}
		
		if(t == -1) {
			
		} else {
			System.out.println("Choose faction (Alliance or Horde): ");
			System.out.print(">> ");
			faccio = e.next();
			System.out.println();
			
			System.out.println("Name: ");
			System.out.print(">> ");
			nom = e.next();
			System.out.println();
			
			System.out.println("Attack Power: ");
			System.out.print(">> ");
			attackPower = e.nextInt();
			System.out.println();
			
			System.out.println("How many weapons: ");
			System.out.print(">> ");
			numWeapons = e.nextInt();
			System.out.println();
			
			ArrayList<Weapon> Armes = new ArrayList<>();
			
			for(int i = 0; i < numWeapons; i++) {
				System.out.println("Weapon " + (i+1) + " Name: ");
				System.out.print(">> ");
				String weaponName = e.next();
				System.out.println("Weapon " + (i+1) + " Attack: ");
				System.out.print(">> ");
				int weaponDamage = e.nextInt();
				Armes.add(new Weapon (weaponName, weaponDamage));
			}
			
			if(t == 1) {
				System.out.println("Intelligence (True - False): ");
				System.out.print(">> ");
				intelligence = e.nextBoolean();
				System.out.println();
				
				Personatges.add(new Human (faccio, nom, attackPower, numWeapons, Armes, intelligence));

			} else if(t == 2) {
				System.out.println("Tenacity (1-3): ");
				System.out.print(">> ");
				tenacity = e.nextInt();
				System.out.println();
				
				Personatges.add(new Orc (faccio, nom, attackPower, numWeapons, Armes, tenacity));
				
			} else if(t == 3) {
				System.out.println("Magic (0-0.99): ");
				System.out.print(">> ");
				magic = e.nextInt();
				System.out.println();
				
				Personatges.add(new Elf (faccio, nom, attackPower, numWeapons, Armes, magic));
			}
		}
	}

	public void menu(ArrayList<Personatge> Personatges) {
		int option = -1;
		
		do {
			
			System.out.println();
			System.out.println("1 - Exit");
			System.out.println("2 - Insert data");
			System.out.println("3 - Show data");
			System.out.println("4 - Fight between factions");
			System.out.println();
			System.out.println("Choose an option: ");
			System.out.print(">> ");
			
			option = e.nextInt();
			
			switch(option) {
			case 1:
				if (option == 1) {
					break;
				} break;
			case 2:
				if (option == 2) {
					inicialitzarPersonatge(Personatges);
					
				} break;
				
			case 3: 
				if (option == 3) {
					showData(Personatges);
					
				} break;
				
			case 4:
				if (option == 4) {
					Battle(Personatges);
					
				} break;
			}
		} while (option != 1);
	}
	
	public void showData(ArrayList<Personatge> Personatges) {	
		for(int i = 0; i<Personatges.size(); i++) {
			System.out.println("__________");
			System.out.println();
			System.out.println("Character " + (i+1) + ":");
			System.out.println("__________");
			System.out.println();
			String classe = null;
			String power = null;
			int ten = 0;
			boolean intel = false;
			double magica = 0;
			if(Personatges.get(i) instanceof Human) {
				classe = "Human";
				power = "Intelligence";
				intel = ((Human) Personatges.get(i)).isIntelligence();
				System.out.println(power + ": " + intel);
			} else if (Personatges.get(i) instanceof Orc) {
				classe = "Orc";
				power = "Tenacity";
				ten = ((Orc) Personatges.get(i)).getTenacity();
				System.out.println(power + ": " + ten);
			} else if (Personatges.get(i) instanceof Elf) {
				classe = "Elf";
				power = "Magic";
				magica = ((Elf) Personatges.get(i)).getMagic();
				System.out.println(power + ": " + magica);
			}
			System.out.println(Personatges.get(i).getNom() + " is an " + classe + " in " + Personatges.get(i).getFaccio() + " faction");
			System.out.println("Attack power without weapons: " + Personatges.get(i).getAttackPower());
			for(int j = 0; j < Personatges.get(i).getNumWeapons(); j++) {
				System.out.println("Weapon " + (j+1) + ": " + Personatges.get(i).getWeapons().get(j).getName() + " - " + Personatges.get(i).getWeapons().get(j).getDamage());
			}
			System.out.println("Average Weapon Attack: " + Personatges.get(i).average());
		}
	}
	
	public void Battle(ArrayList<Personatge> Personatges) {
		double totalHorde = 0;
		double totalAlliance = 0;
		for(int i = 0; i < Personatges.size(); i++) {
			if(Personatges.get(i).getFaccio().equals("Horde")) {
				totalHorde = totalHorde + Personatges.get(i).average();
			} else if (Personatges.get(i).getFaccio().equals("Alliance")) {
				totalAlliance = totalAlliance + Personatges.get(i).average();
			}
		} if(totalHorde > totalAlliance) {
			System.out.println("The faction Horde has " + totalHorde + " Attack Points");
			System.out.println("The faction Alliance has " + totalAlliance + " Attack Points");
			System.out.println("Horde wins!");
		} else if (totalHorde < totalAlliance) {
			System.out.println("The faction Horde has " + totalHorde + " Attack Points");
			System.out.println("The faction Alliance has " + totalAlliance + " Attack Points");
			System.out.println("Alliance wins!");
		} else {
			System.out.println("The faction Horde has " + totalHorde + " Attack Points");
			System.out.println("The faction Alliance has " + totalAlliance + " Attack Points");
			System.out.println("Since both factions have the same amount of points no one wins!");
		}
	}
}
