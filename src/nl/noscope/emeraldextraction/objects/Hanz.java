package nl.noscope.emeraldextraction.objects;

import android.util.Log;
import nl.saxion.act.playground.model.GameBoard;
import nl.saxion.act.playground.model.GameObject;
import nl.voorbeeld.coolgame.CoolGame;

/**
 * A leaf object. This is the object that wombats should try to eat. Leafs move
 * up a square when touched, unless a rock is in their path.
 * 
 * @author Paul de Groot
 * @author Jan Stroet
 */
public class Hanz extends GameObject {
	public static final String HANZ_KIJKTNAARLINKS ="Hanz kijkt naar links";
	public static final String HANZ_LOOPTNAARLINKS ="Hanz loopt naar links";
	public static final String HANZ_KIJKTNAARRECHTS ="Hanz kijkt naar rechts";
	public static final String HANZ_LOOPTNAARRECHTS ="Hanz loopt naar rechts";
	public static final String HANZ_LOOPTOMHOOG ="Hanz loopt omhoog";
	public static final String HANZ_LOOPTOMHOOGLINKERVOET ="Hanz loopt omhoog en tilt hierbij zijn linkervoet op";
	public static final String HANZ_LOOPTOMHOOGRECHTERVOET ="Hanz loopt omhoog en tilt hierbij zijn rechtervoet op";
	public static final String HANZ_LOOPTOMLAAG ="Hanz loopt omlaag";
	public static final String HANZ_LOOPTOMLAAGLINKERVOET ="Hanz loopt omlaag en tilt hierbij zijn linkervoet op";
	public static final String HANZ_LOOPTOMHLAAGRECHTERVOET ="Hanz loopt omlaag en tilt hierbij zijn rechtervoet op";
	
	
	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {
		return HANZ_KIJKTNAARLINKS;
		
	}

	/** Called when the user touched this leaf. */
	@Override
	public void onTouched(GameBoard gameBoard) {
			// Doet niks
		}
	}

