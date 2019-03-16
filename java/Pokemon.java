import javax.swing.*;

public class Pokemon {

	//Statistics, Pokemon Name, Type, pokemon nature, etc...
	private String pkName, type, nature;
	private int hp, atk, spatk, def, spdef, speed, level;
	private int exp, expMax, currentHp;
	//ivs are the genes of the pokemon, it affects its stats when leveling up.
	protected int ivs[] = new int [6];
	public boolean isDead;

	//Fill the vars at the moment of creating the object.
	public Pokemon(String pkName, String type, String nature, int hp, int atk, int spatk, int def, int spdef, int speed, int level) {
		this.pkName = pkName;
		this.type = type;
		this.nature = nature;
		this.hp = hp;
		this.currentHp = hp;
		this.atk = atk;
		this.spatk = spatk;
		this.def = def;
		this.spdef = spdef;
		this.speed = speed;
		this.level = level;
		//checks if this pokemon is dead.
		if(hp <= 0) {
			this.isDead = true;
		} else {
			this.isDead = false;
		}
	}

	//Calculates the damage depending of the stats and returns the value.
	public int damageCalculator (String atkType, String foeType, int atkDmg, int foeDefense, int foeSDefense, boolean isSpecial) {
		//Conditional tho know if the attack is direct or special.
		if(!isSpecial) {
			//Inits variables.
			//cons is a constant value.
			double cons = 0.01;
			//dmg is the damage calculated.
			int dmg = 0;
			//bonus the extra damage that can get if the pokemon type is equal to the movement type.
			double bonus = 1;
			//variation is a random number from 85 to 100.
			int variation = (int) (Math.random() * 15) + 85;
			//efectivity calculates if the attack is effective, super effective, not much efecctive, no effective.
			double efectivity = calcEfectivity(atkType, foeType);

			//If the type of the pokemon is equals to the type of the movement, gets bonus damage.
			if(atkType.equals(type)) {
				bonus = 1.5;
			} else {
				bonus = 1;
			}
			//Calculates the damage with the data above.
			dmg = (int) Math.round((cons * bonus * efectivity * variation * ((((0.2 * level + 1) * (atk * atkDmg)) / (25 * foeDefense) + 2))));
			return dmg;

		} else {
			//the same as above but this time uses the special attack and special defense stats instead.
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
	//Function to deal damage to this object.
	public void receiveDamage(int dmg) {
		currentHp = currentHp - dmg;
		if(currentHp <= 0) {
			isDead = true;
		} else {
			isDead = false;
		}
	}
	//Function to calculate the effectivity of an attack depending on the attack type vs enemy pokemon type and returns the value.
	//foeType is the enemy Pokemon type.
	public double calcEfectivity(String atkType, String foeType) {
		//efc is the damage stat depending of the types.
		//It doesn't have all the pokemon types available, just a few ones for temporal test purposes.
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

	//Function to increase the experience of this Pokemon.
	public void gainExp(String foePokemon, int foeLevel, int combatType) {
		//Checks if the Pokemon can earn experience, setting a max level of 100.
		if(level < 100 && level >= 1) {
			//CombatType defines if this pokemon is battling against a wild pokemon, or against a trainer.
			//If it is a wild pokemon, combatType = 0;
			//If it is another value than 0, then it is a combat against a trainer.
			double combatTypeValue = 1;
			PokemonDB expDB = new PokemonDB();
			int foeExp = expDB.checkExperience(foePokemon);
			//CombatTypeValue checks the combat type and depending of the type of combat, its value can be 1 or 1.5.
			//Increasing the experience gained if it was a battle against a trainer.
			if(combatType == 0) {
				combatTypeValue = 1;
			} else {
				combatTypeValue = 1.5;
			}
			//calculates the experience gained.
			exp += (foeExp * foeLevel * combatTypeValue) / 7;
			//checks if the pokemon is ready to level up.
			if(exp >= expMax) {
				levelUp();
			}
		}
	}
	//Function to level up this Pokemon.
	public void levelUp() {
		exp = 0;
		level++;

		PokemonDB statsDB = new PokemonDB();

		int hpbase = (int) (statsDB.baseStats(pkName, 0));
		//int atkbase = s
		hp += 10 + (level / 100 * ((hpbase * 2) * ivs[0]));
		currentHp += 10 + (level / 100 * ((hpbase * 2) * ivs[0]));
	}

} 