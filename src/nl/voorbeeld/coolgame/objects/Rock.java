package nl.voorbeeld.coolgame.objects;

import android.util.Log;
import nl.saxion.act.playground.model.GameBoard;
import nl.saxion.act.playground.model.GameObject;
import nl.voorbeeld.coolgame.CoolGame;

/**
 * A Rock object blocks the movement of the Wombat and Leaf.
 * If the user touches a rock, it toggles between being red or grey, but this
 * is only a visual effect.
 * 
 * @author Paul de Groot
 */
public class Rock extends GameObject {
	public static final String ROCK_IMAGE = "Rock";
	public static final String RED_ROCK_IMAGE = "RockTwo";

	/** True if the block should be shown red, false if it's grey. */
	private boolean redBlock;

	/**
	 * Constructs a rock.
	 */
	public Rock(boolean red) {
		super();
		this.redBlock = red;
	}

	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {
		if (redBlock) {
			return RED_ROCK_IMAGE;
		} else {
			return ROCK_IMAGE;
		}
	}

	/** Called when the user touched this rock. */
	@Override
	public void onTouched(GameBoard gameBoard) {
		// Toggle the red block boolean
		Log.d(CoolGame.TAG, "Touched rock");
		redBlock = !redBlock;
		gameBoard.updateView();
	}
}
