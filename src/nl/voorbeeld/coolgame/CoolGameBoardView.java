package nl.voorbeeld.coolgame;

import nl.saxion.act.playground.R;
import nl.saxion.act.playground.view.GameBoardView;
import nl.saxion.act.playground.view.SpriteCache;
import nl.voorbeeld.coolgame.objects.Leaf;
import nl.voorbeeld.coolgame.objects.Rock;
import nl.voorbeeld.coolgame.objects.Wombat;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

/**
 * A view on the CoolGame game board.
 * 
 * @author Jan Stroet
 * @author Paul de Groot
 */
public class CoolGameBoardView extends GameBoardView {
	private static final String TAG = "GameView";

	/**
	 * Constructor.
	 */
	public CoolGameBoardView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initGameView();
	}

	/**
	 * Constructor.
	 */
	public CoolGameBoardView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initGameView();
	}

	/**
	 * Loads all images that will be used for the game.
	 */
	private void initGameView() {
		Log.d(TAG, "Loading all images");

		SpriteCache spriteCache = SpriteCache.getInstance(); 
		spriteCache.setContext(this.getContext());		

		// Load the 'empty' cell bitmap and tell the tile view that this is the
		// image to use for cells without GameObject
		//spriteCache.loadTile("empty", R.drawable.cell);
		//setEmptyTile("empty");

		// Load the images for the GameObjects
		//spriteCache.loadTile(Leaf.LEAF_IMAGE, R.drawable.ic_launcher);
		//spriteCache.loadTile(Rock.ROCK_IMAGE, R.drawable.rock);
		//spriteCache.loadTile(Rock.RED_ROCK_IMAGE, R.drawable.rock2);
		//spriteCache.loadTile(Wombat.WOMBAT_IMAGE, R.drawable.wombat);
			}
}
