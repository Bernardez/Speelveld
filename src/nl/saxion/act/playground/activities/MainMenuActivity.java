package nl.saxion.act.playground.activities;

import nl.noscope.data.DatabaseOperations;
import nl.noscope.level.Level;
import nl.saxion.act.playground.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainMenuActivity extends Activity {
	private static MainMenuActivity instance;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		instance = this;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);

		setupNewGameButton();
		setFullScreen();

		//Database operations
		Log.d("Database operations", "main menu activity oncreate //database operations");
				String player_name = "Henk";
				int player_score = 100;
				Context context = MainMenuActivity.getContext();
				DatabaseOperations DB = new DatabaseOperations(context);
				DB.addScore(DB, player_name, player_score);
				
	}

	private void setupNewGameButton() {
		ImageButton newGameButton = (ImageButton) findViewById(R.id.imageButtonNewGame);
		newGameButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setFullScreen();
				
				Log.d("setupNewGameButton onclick", "Start activity levelselect");
				startActivity(new Intent(MainMenuActivity.this,
						LevelSelect.class));

			}
		});
		Log.d("setupNewGameButton", "newGameButton setup");
	}

	private void setFullScreen() {
		View decorView = getWindow().getDecorView();
		// Hide both the navigation bar and the status bar.
		// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and
		// higher, but as
		// a general rule, you should design your app to hide the status bar
		// whenever you
		// hide the navigation bar.
		int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
		decorView.setSystemUiVisibility(uiOptions);
		
		Log.d("setFullScreen", "setFullScreen executed");
	}

	/** Get singleton instance of activity **/
	public static MainMenuActivity getInstance() {
	    return instance;
	}

	/** Returns context of this activity **/
	public static Context getContext(){
	    return instance.getApplicationContext();
	}
}
