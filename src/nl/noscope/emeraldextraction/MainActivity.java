package nl.noscope.emeraldextraction;

import nl.saxion.act.playground.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

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
		hideSystemUI();
		setArrowKeys();

		// Find some of the user interface elements
		gameView = (EmeraldExtractionBoardView) findViewById(R.id.game);

		// Create the game object. This contains all data and functionality
		// belonging to the game
		game = new EmeraldExtraction(this);

		// Create On screen Pause Button
		ImageButton pauseButton = (ImageButton) findViewById(R.id.pauseButton);

		// Create in menu buttons

		pauseButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				final Dialog pause = new Dialog(MainActivity.this);

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
				ImageButton pausePlay = (ImageButton) pause
						.findViewById(R.id.playButton);
				ImageButton pauseReset = (ImageButton) pause
						.findViewById(R.id.resetButton);
				ImageButton pauseToMenu = (ImageButton) pause
						.findViewById(R.id.toMenuButton);

				pausePlay.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						onResume();
						pause.hide();

					}
				});
				pauseReset.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = getIntent();
						overridePendingTransition(0, 0);
						intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
						finish();
						startActivity(intent);

					}
				});
				pauseToMenu.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						onBackPressed();

					}
				});
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
		
		private void hideSystemUI() {
			View mDecorView  = getWindow().getDecorView();
		    // Set the IMMERSIVE flag.
		    // Set the content to appear under the system bars so that the content
		    // doesn't resize when the system bars hide and show.
		    mDecorView.setSystemUiVisibility(
		            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
		            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
		            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
		            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
		            | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
		            | View.SYSTEM_UI_FLAG_IMMERSIVE);
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
