import javax.swing.*;

public class Pokemon {

	private String pkName, type;
	private int hp, atk, spatk, def, spdef, speed, level;
	private int exp, expMax;
	public boolean isDead;

	public Pokemon(String pkName, String type, int hp, int atk, int spatk, int def, int spdef, int speed, int level) {
		this.pkName = pkName;
		this.type = type;
		this.hp = hp;
		this.atk = atk;
		this.spatk = spatk;
		this.def = def;
		this.spdef = spdef;
		this.speed = speed;
		this.level = level;

		if(hp <= 0) {
			this.isDead = true;
		} else {
			this.isDead = false;
		}
	}

	public int damageCalculator (String atkType, String foeType, int atkDmg, int foeDefense, int foeSDefense, boolean isSpecial) {

		if(!isSpecial) {

			double cons = 0.01;

			int dmg = 0;
			double bonus = 1;
			int variation = (int) (Math.random() * 15) + 85;
			double efectivity = calcEfectivity(atkType, foeType);

			if(atkType.equals(type)) {
				bonus = 1.5;
			} else {
				bonus = 1;
			}

			dmg = (int) Math.round((cons * bonus * efectivity * variation * ((((0.2 * level + 1) * (atk * atkDmg)) / (25 * foeDefense) + 2))));
			JOptionPane.showMessageDialog(null, dmg);
			return dmg;

		} else {

			double cons = 0.01;

			int dmg = 0;
			double bonus = 1;
			int variation = (int) (Math.random() * 15) + 85;
			double efectivity = calcEfectivity(atkType, foeType);

			if(atkType.equals(type)) {
				bonus = 1.5;
			} else {
				bonus = 1;
			}

			dmg = (int) Math.round((cons * bonus * efectivity * variation * ((((0.2 * level + 1) * (spatk * atkDmg)) / (25 * foeSDefense) + 2))));
			JOptionPane.showMessageDialog(null, dmg);
			return dmg;

		}
	}

	public void receiveDamage(int dmg) {
		hp = hp - dmg;
		if(hp <= 0) {
			isDead = true;
		} else {
			isDead = false;
		}
	}

	public double calcEfectivity(String atkType, String foeType) {

		double efc = 1;

		switch (atkType) {
			case "Fire" :
				switch(foeType) {
					case "Fire" : efc = 0.5; break;
					case "Water" : efc = 0.5; break;
					case "Grass" : efc = 2; break;
					default : efc = 1;
				} break;

			case "Water" :
				switch(foeType) {
					case "Fire" : efc = 2; break;
					case "Water" : efc = 0.5; break;
					case "Grass" : efc = 0.5; break;
					default : efc = 1;
				} break;

			case "Grass" : 
				switch(foeType) {
					case "Fire" : efc = 0.5; break;
					case "Water" : efc = 2; break;
					case "Grass" : efc = 0.5; break;
					default : efc = 1;
				} break;

			case "Electric" :
				switch(foeType) {
					case "Ground" : efc = 0; break;
					case "Water" : efc = 2; break;
					case "Grass" : efc = 0.5; break;
					default : efc = 1;
				} break;
			default : break;
		}

		return efc;

	}

	public void gainExp(int foeExp, int foeLevel, int combatType) {

		double combatTypeValue = 1;

		if(combatType == 0) {
			combatTypeValue = 1;
		} else {
			combatTypeValue = 1.5;
		}

		exp += (foeExp * foeLevel * combatTypeValue) / 7;

		if(exp >= expMax) {
			levelUp();
		}

	}

	public void levelUp() {
		exp = 0;
		level++;
	}

} 