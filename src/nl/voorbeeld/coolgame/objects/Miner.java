package nl.voorbeeld.coolgame.objects;

import nl.saxion.act.playground.model.GameBoard;
import nl.saxion.act.playground.model.GameObject;

/**
 * The Wombat is our 'player object'. It should try to eat leafs.
 * 
 * @author Paul de Groot
 */
public class Miner extends GameObject {
	public static final String MINER_IMAGE = "miner";

	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {
		return MINER_IMAGE;
	}

	/** Called when the user touched this wombat. */
	@Override
	public void onTouched(GameBoard gameBoard) {
		
		int newPosX = getPositionX() - 1;
		int newPosY = getPositionY();

		// If new position is over the edge of the board, do nothing
		if (newPosX >= gameBoard.getWidth() - 1) {
			return;
		}

		// Check if there is a object on the new position
		GameObject objectAtNewPos = gameBoard.getObject(newPosX, newPosY);
		if (objectAtNewPos != null) {

			// Miner can't move through rocks
			if (objectAtNewPos instanceof Stone) {
				return;
			}
			
			if (objectAtNewPos instanceof Emerald) {
				gameBoard.removeObject(objectAtNewPos);
				
			}
			if (objectAtNewPos instanceof Sand) {
				gameBoard.removeObject(objectAtNewPos);
				
			}
		}

		// Move wombat to the new position and redraw the app
		gameBoard.moveObject(this, newPosX, newPosY);
		gameBoard.updateView();
	}
}
