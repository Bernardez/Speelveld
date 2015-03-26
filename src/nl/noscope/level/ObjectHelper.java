package nl.noscope.level;

import nl.noscope.emeraldextraction.objects.*;
import nl.saxion.act.playground.model.GameObject;

public class ObjectHelper {
	public static GameObject getObject(char type) {
		if (type == 's') {
			return new Stone();
		}
		else if (type == 'i') {
			return new Iron();
		}
		else if (type == 'e') {
			return new Emerald();
		}
		else if (type == 'm') {
			return new Minecart();
		}
		else if (type == 'z') {
			return new Sand();
		}
		else if (type == 'l') {
			return new LinkerOnderHoek();
		}
		else if (type == 'o') {
			return new OnderRand();
		}
		else if (type == 'r') {
			return new RechterOnderHoek();
		}
		else if (type == 'k') {
			return new LinkerBovenHoek();
		}
		else if (type == 'b') {
			return new BovenRand();
		}
		else if (type == 't') {
			return new RechterBovenHoek();
		}
		else if (type == 'a') {
			return new LinkerRand();
		}
		else if (type == 'c') {
			return new RechterRand();
		}
		else if (type == 'n') {
			return new Miner();
		}
		return null;
	}
}
