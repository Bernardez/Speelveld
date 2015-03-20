package nl.noscope.emeraldextraction.objects;

import nl.saxion.act.playground.model.GameBoard;
import nl.saxion.act.playground.model.GameObject;

/**
 * A Rock object blocks the movement of the Wombat and Leaf. If the user touches
 * a rock, it toggles between being red or grey, but this is only a visual
 * effect.
 * 
 * @author Paul de Groot
 */
public class Iron extends GameObject {
	public static final String IRON_IMAGE = "iron";

	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {

		return IRON_IMAGE;
	}

	@Override
	public void onTouched(GameBoard gameBoard) {

	}
}
