
public class PokemonDB {

	public int checkExperience(String foePokemon) {
		int value = 0;

		switch(foePokemon) {
			case "Bulbasaur": value = 64; break;
			case "Ivysaur": value = 142; break;
			case "Venusaur": value = 236; break;
			case "Mega-Venusaur": value = 281; break;
			case "Charmander": value = 62; break;
			case "Charmeleon": value = 142; break;
			case "Charizard": value = 240; break;
			case "Mega-Charizard X": value = 285; break;
			case "Mega-Charizard Y": value = 285; break;
			case "Squirtle": value = 63; break;
			case "Wartortle": value = 142; break;
			case "Blastoise": value = 239; break;
			case "Mega-Blastoise": value = 284; break;
			case "Caterpie": value = 39; break;
			case "Metapod": value = 72; break;
			case "Butterfree": value = 178; break;
			case "Weedle": value = 39; break;
			case "Kakuna": value = 72; break;
			case "Beedrill": value = 178; break;
			case "Mega-Beedrill": value = 223; break;
			case "Pidgey": value = 50; break;
			case "Pidgeotto": value = 122; break;
			case "Pidgeot": value = 216; break;
			case "Mega-Pidgeot": value = 261; break;
			case "Rattata": value = 51; break;
			case "Raticate": value = 145; break;
			case "Spearow": value = 52; break;
			case "Fearow": value = 155; break;
			case "Ekans": value = 58; break;
			case "Arbok": value = 157; break;
			case "Pikachu": value = 112; break;
			case "Raichu": value = 218; break;
			default : value = 60; break;
		}

		return value;
	}

	public byte baseStats(String pkName, int statToGet) {

		byte statsFinal[];
		byte stats[];

		switch(statToGet) {
			case 0:
				switch(pkName) {
					case "Pikachu" : stats[] = { 35, 55, 40, 50, 50, 90 }; statsFinal = stats; break;
					case "Squirtle" : stats[] = { 44, 48, 65, 50, 64, 43 }; statsFinal = stats; break;
					default : break;
				} break;
			default : break;
		}

		return statsFinal[statToGet];
	}

}