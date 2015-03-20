package nl.noscope.level;

import nl.noscope.emeraldextraction.objects.*;
import nl.saxion.act.playground.model.GameObject;

public class ObjectHelper {
	public static GameObject getObject(int typeId) {
		if (typeId == 1) {
			return new Stone();
		}
		else if (typeId == 2) {
			return new Iron();
		}
		else if (typeId == 3) {
			return new Emerald();
		}
		else if (typeId == 4) {
			return new Minecart();
		}
		else if (typeId == 5) {
			return new Sand();
		}
		else if (typeId == 6) {
			return new LinkerOnderHoek();
		}
		else if (typeId == 7) {
			return new OnderRand();
		}
		else if (typeId == 8) {
			return new RechterOnderHoek();
		}
		else if (typeId == 9) {
			return new LinkerBovenHoek();
		}
		else if (typeId == 10) {
			return new BovenRand();
		}
		else if (typeId == 11) {
			return new RechterBovenHoek();
		}
		else if (typeId == 12) {
			return new LinkerRand();
		}
		else if (typeId == 13) {
			return new RechterRand();
		}
		else if (typeId == 14) {
			return new Miner();
		}
		return null;
	}
}
