package nl.noscope.emeraldextraction;

import nl.noscope.emeraldextraction.objects.Miner;
import nl.saxion.act.playground.R;
import nl.saxion.act.playground.model.GameBoard;
import nl.saxion.act.playground.model.GameObject;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The main activity.
 * 
 * @author Paul de Groot
 * @author Jan Stroet
 */
public class MainActivity extends Activity {
	@SuppressWarnings("unused")
	private EmeraldExtraction game;
	private EmeraldExtractionBoardView gameView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// Load main.xml
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setFullScreen();
		setArrowKeys();
<<<<<<< Updated upstream
=======
		// DELETE DEZE REGEL
>>>>>>> Stashed changes

		// Find some of the user interface elements
		gameView = (EmeraldExtractionBoardView) findViewById(R.id.game);

		// Create the game object. This contains all data and functionality
		// belonging to the game
		game = new EmeraldExtraction(this);

<<<<<<< Updated upstream
	
		
=======
		// Tell user to start the game
		// Toast.makeText(getApplicationContext(), "Lets start",
		// Toast.LENGTH_SHORT).show();

>>>>>>> Stashed changes
		// Create On screen Pause Button
		ImageButton pauseButton = (ImageButton) findViewById(R.id.pauseButton);
		pauseButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				;

				Dialog pause = new Dialog(MainActivity.this);
				pause.requestWindowFeature(Window.FEATURE_NO_TITLE);
				pause.getWindow().setBackgroundDrawable(
						new ColorDrawable(android.graphics.Color.TRANSPARENT));
				pause.setContentView(R.layout.pausemenu);
				WindowManager.LayoutParams lp = pause.getWindow()
						.getAttributes();
				lp.dimAmount = 0.7f;
				pause.getWindow().setAttributes(lp);
				onPause();
				pause.show();

			}
		});
	}

	// Create a set of On screen Navigation buttons
	public void setArrowKeys() {
		ImageButton upArrow = (ImageButton) findViewById(R.id.uparrow);
		upArrow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				game.moveMinerUp();
			}
		});
		ImageButton downArrow = (ImageButton) findViewById(R.id.downarrow);
		downArrow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				game.moveMinerDown();
			}
		});
		ImageButton leftArrow = (ImageButton) findViewById(R.id.leftarrow);
		leftArrow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				game.moveMinerLeft();
			}
		});
		ImageButton rightArrow = (ImageButton) findViewById(R.id.rightarrow);
		rightArrow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				game.moveMinerRight();

			}
		});

	}

	private void setFullScreen() {
		View decorView = getWindow().getDecorView();
		// Hide both the navigation bar and the status bar.
		// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and
		// higher, but as
		// a general rule, you should design your app to hide the status bar
		// whenever you
		// hide the navigation bar.
		int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
				| View.SYSTEM_UI_FLAG_FULLSCREEN;
		decorView.setSystemUiVisibility(uiOptions);
	}

	/**
	 * Returns the view on the game board.
	 */
	public EmeraldExtractionBoardView getGameBoardView() {
		return gameView;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		unbindDrawables(findViewById(R.id.game));
		System.gc();
	}

	private void unbindDrawables(View view) {
		if (view.getBackground() != null) {
			view.getBackground().setCallback(null);
		}
		if (view instanceof ViewGroup) {
			for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
				unbindDrawables(((ViewGroup) view).getChildAt(i));
			}
			((ViewGroup) view).removeAllViews();
		}
	}

}
