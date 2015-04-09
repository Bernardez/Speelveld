package nl.noscope.emeraldextraction.objects;

import nl.saxion.act.playground.model.GameBoard;
import nl.saxion.act.playground.model.GameObject;
import android.util.Log;
/**
 * A leaf object. This is the object that wombats should try to eat. Leafs move
 * up a square when touched, unless a rock is in their path.
 * 
 * @author Paul de Groot
 * @author Jan Stroet
 */
public class Emerald extends GameObject {
	public static final String EMERALD_IMAGE = "emerald";

	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {
		return EMERALD_IMAGE;
	}


	public boolean gravityCheck(GameBoard gameBoard){
		boolean check = true;
		boolean isAboveMinecart = false;
		
		while (check){
			
			
			int newPosX = getPositionX();
			int newPosY = getPositionY() + 1;
			GameObject objectAtNewPos = gameBoard.getObject(newPosX, newPosY);
			
			
			if (objectAtNewPos == null) {
				
				Log.d("Emerald", "Object onder emerald is null");
			    gameBoard.moveObject(this, newPosX, newPosY);
			} else if (objectAtNewPos instanceof Minecart) {
				Log.d("Emerald", "Object onder emerald is minecart");
				gameBoard.removeObject(this);
				isAboveMinecart = true;
				check = false;
			} else { 
				return false; 
				}
			
			gameBoard.updateView();
		
			
		}
		return isAboveMinecart;
	}
	
	@Override
	public void onTouched(GameBoard gameBoard) {
		// TODO Auto-generated method stub
		
	}


	
}
