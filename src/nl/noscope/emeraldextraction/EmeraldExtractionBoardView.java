package nl.noscope.emeraldextraction;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import nl.noscope.emeraldextraction.objects.Hanz;
import nl.saxion.act.playground.R;
import nl.saxion.act.playground.view.GameBoardView;
import nl.saxion.act.playground.view.SpriteCache;

public class EmeraldExtractionBoardView extends GameBoardView {
	private static final String TAG = "GameView";

	public EmeraldExtractionBoardView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initGameView();
	}

	public EmeraldExtractionBoardView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		initGameView();
	}

	private void initGameView() {
		Log.d(TAG, "Loading all images");

		SpriteCache spriteCache = SpriteCache.getInstance();
		spriteCache.setContext(this.getContext());
		
		spriteCache.loadTile(Hanz.HANZ_KIJKTNAARLINKS, R.drawable.hanz_kijktnaarlinks);
		spriteCache.loadTile(Hanz.HANZ_LOOPTNAARLINKS, R.drawable.hanz_looptnaarlinks);
		spriteCache.loadTile(Hanz.HANZ_KIJKTNAARRECHTS, R.drawable.hanz_kijktnaarrechts);
		spriteCache.loadTile(Hanz.HANZ_LOOPTNAARRECHTS, R.drawable.hanz_looptnaarrechts);
		spriteCache.loadTile("dirt", R.drawable.dirt);
		setEmptyTile("dirt");
		
	}
}
