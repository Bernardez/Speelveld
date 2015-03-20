package nl.noscope.emeraldextraction.objects;

import nl.saxion.act.playground.model.GameBoard;
import nl.saxion.act.playground.model.GameObject;

/**
 * A leaf object. This is the object that wombats should try to eat. Leafs move
 * up a square when touched, unless a rock is in their path.
 * 
 * @author Paul de Groot
 * @author Jan Stroet
 */
public class BovenRand extends GameObject {
	public static final String TOP_IMAGE = "top";

	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {
		return TOP_IMAGE;
	}

	@Override
	public void onTouched(GameBoard gameBoard) {
		// TODO Auto-generated method stub
		
	}

}
