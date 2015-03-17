package nl.voorbeeld.coolgame.objects;

import nl.saxion.act.playground.model.GameBoard;
import nl.saxion.act.playground.model.GameObject;

/**
 * A Rock object blocks the movement of the Wombat and Leaf. If the user touches
 * a rock, it toggles between being red or grey, but this is only a visual
 * effect.
 * 
 * @author Paul de Groot
 */
public class Stone extends GameObject {
	public static final String STONE_IMAGE = "stone";

	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {

		return STONE_IMAGE;
	}

	@Override
	public void onTouched(GameBoard gameBoard) {

		int newPosX = getPositionX();
		int newPosY = getPositionY() + 1;

		// If new position is over the edge of the board, do nothing
		if (newPosX >= gameBoard.getWidth() - 1) {
			return;
		}

		// Check if there is a object on the new position
		GameObject objectAtNewPos = gameBoard.getObject(newPosX, newPosY);
		if (objectAtNewPos == null) {
			gameBoard.moveObject(this, newPosX, newPosY);
			gameBoard.updateView();

		}

	}
}