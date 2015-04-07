package nl.saxion.act.playground.activities;

import nl.noscope.data.DatabaseOperations;
import nl.noscope.emeraldextraction.MainActivity;
import nl.saxion.act.playground.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class LevelSelect extends Activity {
	private static LevelSelect instance;
	
	private ImageButton level2, level3, level4, level5, level6, level7, level8, level9, level10;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		instance = this;
		Log.d("LevelSelect onCreate", "LevelSelect Activity Oncreate start");
		super.onCreate(savedInstanceState);
		Log.d("LevelSelect onCreate", "Before setContentView");
		setContentView(R.layout.activity_level__select);
		Log.d("LevelSelect onCreate", "After setContentView");
		
		
		
		// Instantiate all buttons (except 1)
		level2 = (ImageButton) findViewById(R.id.level2);
		level3 = (ImageButton) findViewById(R.id.level3);
		level4 = (ImageButton) findViewById(R.id.level4);
		level5 = (ImageButton) findViewById(R.id.level5);
		level6 = (ImageButton) findViewById(R.id.level6);
		level7 = (ImageButton) findViewById(R.id.level7);
		level8 = (ImageButton) findViewById(R.id.level8);
		level9 = (ImageButton) findViewById(R.id.level9);
		level10 = (ImageButton) findViewById(R.id.level10);
		
		
		loadLevelSelectImages();
		
//		setupBackButton();
		setupLevelButtons(R.id.level1, 1);
		setupLevelButtons(R.id.level2, 2);
		setupLevelButtons(R.id.level3, 3);
		setupLevelButtons(R.id.level4, 4);
		setupLevelButtons(R.id.level5, 5);
		setupLevelButtons(R.id.level6, 6);
		setupLevelButtons(R.id.level7, 7);
		setupLevelButtons(R.id.level8, 8);
		setupLevelButtons(R.id.level9, 9);
		setupLevelButtons(R.id.level10, 10);
		
		hideSystemUI();
		Log.d("LevelSelect onCreate", "LevelSelect Activity Oncreate end");
	}

	@Override
	protected void onResume() {
		super.onResume();
		loadLevelSelectImages();
		Log.d("LevelSelect onResume", "LevelSelect Activity onResume");
	}
	
	private void setupLevelButtons(int id, final int levelId) {
		ImageButton newGameButton = (ImageButton) findViewById(id);
		newGameButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				hideSystemUI();
				Log.d("setuplevel1button", "Set full screen");

				
				Intent intent = new Intent(LevelSelect.this, MainActivity.class);
				intent.putExtra("LEVEL_ID", levelId);
				Log.d("setuplevel1button", "start activity with intent level id: "  + levelId);
				startActivity(intent);
			}
		});
	}


<<<<<<< Updated upstream
	private void loadLevelSelectImages() {
		// Load level progress
		Context context = LevelSelect.getContext();
		DatabaseOperations DB = new DatabaseOperations(context);
		int levels[] = DB.completedLevels(DB);
=======
	private void setuplevel1Button() {
		ImageButton newGameButton = (ImageButton) findViewById(R.id.level1);
		newGameButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				hideSystemUI();
				Log.d("setuplevel1button", "Set full screen");

				startActivity(new Intent(LevelSelect.this, MainActivity.class));
				Log.d("setuplevel1button", "start activity");
			}
		});
	}

	private void setuplevel2Button() {
		ImageButton levelButton = (ImageButton) findViewById(R.id.level2);
		levelButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				hideSystemUI();

				
				// startActivity(new Intent(LevelSelect.this,
				// MainActivity.class));

			}
		});
	}

	private void setuplevel3Button() {
		ImageButton levelButton = (ImageButton) findViewById(R.id.level3);
		levelButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				hideSystemUI();

				// startActivity(new Intent(LevelSelect.this,
				// MainActivity.class));

			}
		});
	}

	private void setuplevel4Button() {
		ImageButton levelButton = (ImageButton) findViewById(R.id.level4);
		levelButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				hideSystemUI();

				// startActivity(new Intent(LevelSelect.this,
				// MainActivity.class));

			}
		});
	}

	private void setuplevel5Button() {
		ImageButton levelButton = (ImageButton) findViewById(R.id.level5);
		levelButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				hideSystemUI();

				// startActivity(new Intent(LevelSelect.this,
				// MainActivity.class));

			}
		});
	}

	private void setuplevel6Button() {
		ImageButton levelButton = (ImageButton) findViewById(R.id.level6);
		levelButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				hideSystemUI();

				// startActivity(new Intent(LevelSelect.this,
				// MainActivity.class));

			}
		});
	}

	private void setuplevel7Button() {
		ImageButton levelButton = (ImageButton) findViewById(R.id.level7);
		levelButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				hideSystemUI();

				// startActivity(new Intent(LevelSelect.this,
				// MainActivity.class));

			}
		});
	}

	private void setuplevel8Button() {
		ImageButton levelButton = (ImageButton) findViewById(R.id.level8);
		levelButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				hideSystemUI();

				// startActivity(new Intent(LevelSelect.this,
				// MainActivity.class));

			}
		});
	}

	private void setuplevel9Button() {
		ImageButton levelButton = (ImageButton) findViewById(R.id.level9);
		levelButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				hideSystemUI();

				// startActivity(new Intent(LevelSelect.this,
				// MainActivity.class));
>>>>>>> Stashed changes

		// Set 'unlocked' image as ImageButton when level was unlocked
		for (int i : levels) {
			switch (i) {
			case 1: level2.setImageResource(R.drawable.level2);
				break;
			case 2:	level3.setImageResource(R.drawable.level3);
				break;
			case 3:	level4.setImageResource(R.drawable.level4);
				break;
			case 4:	level5.setImageResource(R.drawable.level5);
				break;
			case 5:	level6.setImageResource(R.drawable.level6);
				break;
			case 6:	level7.setImageResource(R.drawable.level7);
				break;
			case 7:	level8.setImageResource(R.drawable.level8);
				break;
			case 8:	level9.setImageResource(R.drawable.level9);
				break;
			case 9:	level10.setImageResource(R.drawable.level10);
				break;
			}
		}
	}

<<<<<<< Updated upstream
	
=======
	private void setuplevel10Button() {
		ImageButton levelButton = (ImageButton) findViewById(R.id.level10);
		levelButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				hideSystemUI();

				// startActivity(new Intent(LevelSelect.this,
				// MainActivity.class));

			}
		});
	}
>>>>>>> Stashed changes
//	private void setupBackButton() {
//		ImageButton levelButton = (ImageButton) findViewById(R.id.backButton);
//		levelButton.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				hideSystemUI();
//
//				startActivity(new Intent(LevelSelect.this, MainMenuActivity.class));
//
//			}
//		});
//	}

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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main__menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.levelcleared_resetbutton) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/** Get singleton instance of activity **/
	public static LevelSelect getInstance() {
	    return instance;
	}

	/** Returns context of this activity **/
	public static Context getContext(){
	    return instance.getApplicationContext();
	}

}
