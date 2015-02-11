package nl.voorbeeld.coolgame.objects;

import android.util.Log;
import nl.saxion.act.playground.model.GameBoard;
import nl.saxion.act.playground.model.GameObject;
import nl.voorbeeld.coolgame.CoolGame;

/**
 * The Wombat is our 'player object'. It should try to eat leafs.
 * 
 * @author Paul de Groot
 */
public class Wombat extends GameObject {
	public static final String WOMBAT_IMAGE = "Wombat";

	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {
		return WOMBAT_IMAGE;
	}

	/** Called when the user touched this wombat. */
	@Override
	public void onTouched(GameBoard gameBoard) {
		Log.d(CoolGame.TAG, "Touched wombat");

		// Wombats always move a square to the right
		int newPosX = getPositionX() + 1;
		int newPosY = getPositionY();

		// If new position is over the edge of the board, do nothing
		if (newPosX >= gameBoard.getWidth()) {
			return;
		}

		// Check if there is a object on the new position
		GameObject objectAtNewPos = gameBoard.getObject(newPosX, newPosY);
		if (objectAtNewPos != null) {

			// Wombats can't move through rocks
			if (objectAtNewPos instanceof Rock) {
				return;
			}

			// Caught a leaf? Score!
			if (objectAtNewPos instanceof Leaf) {
				gameBoard.removeObject(objectAtNewPos);
				((CoolGame) gameBoard.getGame()).increaseScore();
			}
		}

		// Move wombat to the new position and redraw the app
		gameBoard.moveObject(this, newPosX, newPosY);
		gameBoard.updateView();
	}
}
