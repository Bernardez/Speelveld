package nl.noscope.emeraldextraction.objects;

import android.widget.Toast;
import nl.saxion.act.playground.model.GameBoard;
import nl.saxion.act.playground.model.GameObject;
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

	
	public void gravityCheck(GameBoard gameBoard){
		
		int newPosX = getPositionX();
		int newPosY = getPositionY() + 1;
		
		GameObject objectAtNewPos = gameBoard.getObject(newPosX, newPosY);
		if (objectAtNewPos == null) {
			gameBoard.moveObject(this, newPosX, newPosY + 1);
		} else if (objectAtNewPos instanceof Minecart) {
			gameBoard.removeObject(this);
		} else {
			return;
		}
		
		gameBoard.updateView();
	}
	
	
	@Override
	public void onTouched(GameBoard gameBoard) {
		// TODO Auto-generated method stub
		
	}

	
}
