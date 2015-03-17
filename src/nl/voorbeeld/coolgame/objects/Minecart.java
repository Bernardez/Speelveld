package nl.voorbeeld.coolgame.objects;

import nl.saxion.act.playground.model.GameBoard;
import nl.saxion.act.playground.model.GameObject;

public class Minecart extends GameObject {
	public static final String MINECART_IMAGE = "minecart";

	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {

		return MINECART_IMAGE;
	}

	@Override
	public void onTouched(GameBoard gameBoard) {
		// TODO Auto-generated method stub
		
	}
}