package nl.noscope.level;

import nl.noscope.emeraldextraction.objects.*;
import nl.saxion.act.playground.model.GameObject;

public class ObjectHelper {
	
	/**
	 * @param char  Welke letter bepaald welk GameObject je terug krijgt.
	 * @return GameObject
	 * 
	 * @author Bas Siegerink
	 */
	public static GameObject getObject(char type) {
		switch(type) {
		case 's': return new Stone();
		case 'i': return new Iron();
		case 'e': return new Emerald();
		case 'm': return new Minecart();
		case 'z': return new Sand();
		case 'l': return new LinkerOnderHoek();
		case 'o': return new OnderRand();
		case 'r': return new RechterOnderHoek();
		case 'k': return new LinkerBovenHoek();
		case 'b': return new BovenRand();
		case 't': return new RechterBovenHoek();
		case 'a': return new LinkerRand();
		case 'c': return new RechterRand();
		case 'n': return new Miner();
		case 'f': return new StoneMove();
		default: return null;
		}
	}
}
