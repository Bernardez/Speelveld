package nl.noscope.emeraldextraction;

import nl.noscope.emeraldextraction.objects.BovenRand;
import nl.noscope.emeraldextraction.objects.Emerald;
import nl.noscope.emeraldextraction.objects.Iron;
import nl.noscope.emeraldextraction.objects.LinkerBovenHoek;
import nl.noscope.emeraldextraction.objects.LinkerOnderHoek;
import nl.noscope.emeraldextraction.objects.LinkerRand;
import nl.noscope.emeraldextraction.objects.Minecart;
import nl.noscope.emeraldextraction.objects.Miner;
import nl.noscope.emeraldextraction.objects.OnderRand;
import nl.noscope.emeraldextraction.objects.RechterBovenHoek;
import nl.noscope.emeraldextraction.objects.RechterOnderHoek;
import nl.noscope.emeraldextraction.objects.RechterRand;
import nl.noscope.emeraldextraction.objects.Sand;
import nl.noscope.emeraldextraction.objects.Stone;
import nl.noscope.emeraldextraction.objects.StoneMove;
import nl.saxion.act.playground.R;
import nl.saxion.act.playground.view.GameBoardView;
import nl.saxion.act.playground.view.SpriteCache;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

/**
 * A view on the CoolGame game board.
 * 
 * @author Jan Stroet
 * @author Paul de Groot
 */
public class EmeraldExtractionBoardView extends GameBoardView {
	private static final String TAG = "GameView";

	/**
	 * Constructor.
	 */
	public EmeraldExtractionBoardView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initGameView();
	}

	/**
	 * Constructor.
	 */
	public EmeraldExtractionBoardView(Context context, AttributeSet attrs, int defStyle) {
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
		spriteCache.loadTile(Stone.STONE_IMAGE, R.drawable.sandstone);
		spriteCache.loadTile(StoneMove.STONE_IMAGE, R.drawable.stone);
		spriteCache.loadTile(Iron.IRON_IMAGE, R.drawable.iron);
		spriteCache.loadTile(Miner.MINER_IMAGE, R.drawable.miner);
		spriteCache.loadTile(Miner.MINER_DOWN, R.drawable.hanz_looptomlaag);
		spriteCache.loadTile(Miner.MINER_UP, R.drawable.hanz_looptomhoog);
		spriteCache.loadTile(Miner.MINER_LEFT, R.drawable.hanz_kijktnaarlinks);
		spriteCache.loadTile(Miner.MINER_RIGHT, R.drawable.hanz_kijktnaarrechts );
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
