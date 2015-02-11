package nl.voorbeeld.coolgame.objects;

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
public class Leaf extends GameObject {
	public static final String LEAF_IMAGE = "Leaf";

	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {
		return LEAF_IMAGE;
	}

	/** Called when the user touched this leaf. */
	@Override
	public void onTouched(GameBoard gameBoard) {
		Log.d(CoolGame.TAG, "Touched leaf");

		// Leafs always move a square up
		int newPosX = getPositionX();
		int newPosY = getPositionY() - 1;

		// If new position is over the edge of the board, do nothing
		if (newPosY < 0) {
			return;
		}

		// Check if there is a object on the new position
		GameObject objectAtNewPos = gameBoard.getObject(newPosX, newPosY);
		if (objectAtNewPos != null) {

			// Leafs can't move through rocks or wombats
			if ((objectAtNewPos instanceof Rock) || 
			    (objectAtNewPos instanceof Wombat)){
				return;
			}
		}

		// Move leaf to the new position and redraw the app
		gameBoard.moveObject(this, newPosX, newPosY);
		gameBoard.updateView();
	}
}
