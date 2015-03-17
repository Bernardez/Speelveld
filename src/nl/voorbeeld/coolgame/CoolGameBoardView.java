package nl.voorbeeld.coolgame;

import nl.saxion.act.playground.R;
import nl.saxion.act.playground.view.GameBoardView;
import nl.saxion.act.playground.view.SpriteCache;
import nl.voorbeeld.coolgame.objects.BovenRand;
import nl.voorbeeld.coolgame.objects.Iron;
import nl.voorbeeld.coolgame.objects.Emerald;
import nl.voorbeeld.coolgame.objects.LinkerBovenHoek;
import nl.voorbeeld.coolgame.objects.LinkerOnderHoek;
import nl.voorbeeld.coolgame.objects.LinkerRand;
import nl.voorbeeld.coolgame.objects.Minecart;
import nl.voorbeeld.coolgame.objects.OnderRand;
import nl.voorbeeld.coolgame.objects.RechterBovenHoek;
import nl.voorbeeld.coolgame.objects.RechterOnderHoek;
import nl.voorbeeld.coolgame.objects.RechterRand;
import nl.voorbeeld.coolgame.objects.Sand;
import nl.voorbeeld.coolgame.objects.Stone;
import nl.voorbeeld.coolgame.objects.Miner;
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
		spriteCache.loadTile(Sand.SAND_IMAGE, R.drawable.sand);
		setEmptyTile("empty");

		// Load the images for the GameObjects
		spriteCache.loadTile(Emerald.EMERALD_IMAGE, R.drawable.emerald);
		spriteCache.loadTile(Stone.STONE_IMAGE, R.drawable.stone);
		spriteCache.loadTile(Iron.IRON_IMAGE, R.drawable.iron);
		spriteCache.loadTile(Miner.MINER_IMAGE, R.drawable.miner);
		spriteCache.loadTile(LinkerRand.LEFT_IMAGE, R.drawable.left);
		spriteCache.loadTile(RechterRand.RIGHT_IMAGE, R.drawable.right);
		spriteCache.loadTile(RechterOnderHoek.RIGHTBOTTOM_IMAGE, R.drawable.rightbottom);
		spriteCache.loadTile(LinkerOnderHoek.LEFTBOTTOM_IMAGE, R.drawable.leftbottom);
		spriteCache.loadTile(LinkerBovenHoek.LEFTTOP_IMAGE, R.drawable.lefttop);
		spriteCache.loadTile(RechterBovenHoek.RIGHTTOP_IMAGE, R.drawable.righttop);
		spriteCache.loadTile(BovenRand.TOP_IMAGE, R.drawable.top);
		spriteCache.loadTile(OnderRand.BOTTOM_IMAGE, R.drawable.bottom);
		spriteCache.loadTile(Minecart.MINECART_IMAGE, R.drawable.minecart);

		
		
		
		
	}
}
