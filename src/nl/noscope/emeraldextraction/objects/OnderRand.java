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
public class OnderRand extends GameObject {
	public static final String BOTTOM_IMAGE = "bottom";

	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {
		return BOTTOM_IMAGE;
	}

	@Override
	public void onTouched(GameBoard gameBoard) {

	}
}
