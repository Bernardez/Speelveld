package nl.voorbeeld.coolgame;

import nl.saxion.act.playground.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * The main activity.
 * 
 * @author Paul de Groot
 * @author Jan Stroet
 */
public class MainActivity extends Activity {
	@SuppressWarnings("unused")
	private CoolGame game;
	private CoolGameBoardView gameView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// Load main.xml
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setFullScreen();
		setArrowKeys();
		// DELETE DEZE REGEL

		// Find some of the user interface elements
		gameView = (CoolGameBoardView) findViewById(R.id.game);

		// Create the game object. This contains all data and functionality
		// belonging to the game
		game = new CoolGame(this);

		// Tell user to start the game
		Toast.makeText(getApplicationContext(), "Lets start",
				Toast.LENGTH_SHORT).show();
		
		ImageButton pauseButton = (ImageButton) findViewById(R.id.pauseButton);
		pauseButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Dialog pause = new Dialog(MainActivity.this);
				pause.setContentView(R.layout.pausemenu);
				pause.show();
				
			}
		});
	}
	
	public void setArrowKeys() {
		ImageButton upArrow = (ImageButton) findViewById(R.id.uparrow);
		upArrow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Move Up",
						Toast.LENGTH_SHORT).show();
				
			}
		});
		ImageButton downArrow = (ImageButton) findViewById(R.id.downarrow);
		downArrow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Move Down",
						Toast.LENGTH_SHORT).show();

			}
		});
		ImageButton leftArrow = (ImageButton) findViewById(R.id.leftarrow);
		leftArrow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Move Left",
						Toast.LENGTH_SHORT).show();

			}
		});
		ImageButton rightArrow = (ImageButton) findViewById(R.id.rightarrow);
		rightArrow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Move Right",
						Toast.LENGTH_SHORT).show();

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
	public CoolGameBoardView getGameBoardView() {
		return gameView;
	}

}
