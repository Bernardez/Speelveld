package nl.noscope.emeraldextraction.objects;

import android.util.Log;
import nl.saxion.act.playground.model.GameBoard;
import nl.saxion.act.playground.model.GameObject;

/**
 * A StoneMove object is capable of getting pushed in a direction when there are no obstructions.
 * 
 * @author Bas Siegerink
 */
public class StoneMove extends GameObject {
	public static final String STONE_IMAGE = "stone";

	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {

		return STONE_IMAGE;
	}
	
public void gravityCheck(GameBoard gameBoard){
		boolean check = true;
		
		while (check){
			int newPosX = getPositionX();
			int newPosY = getPositionY() + 1;
			GameObject objectAtNewPos = gameBoard.getObject(newPosX, newPosY);
			if (objectAtNewPos == null) {
				gameBoard.moveObject(this, newPosX, newPosY);
			} else if (objectAtNewPos instanceof Minecart) {
				// GAME OVER
				// Remove Minecart & Place Broken minecart on the new position
				gameBoard.removeObject(objectAtNewPos);
				gameBoard.addGameObject(new MinecartDestroyed(), newPosX, newPosY);
				
				// Remove the stone
				gameBoard.removeObject(this);
				return;
			} else {
				return;
			}
			gameBoard.updateView();
			
		}
	}

	@Override
	public void onTouched(GameBoard gameBoard) {
		// TODO Auto-generated method stub
		
	}
}