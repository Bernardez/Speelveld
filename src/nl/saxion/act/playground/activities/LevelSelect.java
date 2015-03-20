package nl.saxion.act.playground.activities;

import nl.noscope.emeraldextraction.MainActivity;
import nl.saxion.act.playground.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class LevelSelect extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d("LevelSelect onCreate", "LevelSelect Activity Oncreate start");
		super.onCreate(savedInstanceState);
		Log.d("LevelSelect onCreate", "Before setContentView");
		setContentView(R.layout.activity_level__select_copy);
		Log.d("LevelSelect onCreate", "After setContentView");
//		setupBackButton();
		setupLevelButtons(R.id.level1);
		
//		setuplevel1Button();
//		setuplevel2Button();
//		setuplevel3Button();
//		setuplevel4Button();
//		setuplevel5Button();
//		setuplevel6Button();
//		setuplevel7Button();
//		setuplevel8Button();
//		setuplevel9Button();
//		setuplevel10Button();
		setFullScreen();
		
		Log.d("LevelSelect onCreate", "LevelSelect Activity Oncreate end");
	}
	
	private void setupLevelButtons(int id) {
		ImageButton newGameButton = (ImageButton) findViewById(id);
		newGameButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setFullScreen();
				Log.d("setuplevel1button", "Set full screen");

				startActivity(new Intent(LevelSelect.this, MainActivity.class));
				Log.d("setuplevel1button", "start activity");
			}
		});
	}

	private void setuplevel1Button() {
		ImageButton newGameButton = (ImageButton) findViewById(R.id.level1);
		newGameButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setFullScreen();
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
				setFullScreen();

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
				setFullScreen();

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
				setFullScreen();

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
				setFullScreen();

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
				setFullScreen();

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
				setFullScreen();

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
				setFullScreen();

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
				setFullScreen();

				// startActivity(new Intent(LevelSelect.this,
				// MainActivity.class));

			}
		});
	}

	private void setuplevel10Button() {
		ImageButton levelButton = (ImageButton) findViewById(R.id.level10);
		levelButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setFullScreen();

				// startActivity(new Intent(LevelSelect.this,
				// MainActivity.class));

			}
		});
	}
//	private void setupBackButton() {
//		ImageButton levelButton = (ImageButton) findViewById(R.id.backButton);
//		levelButton.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				setFullScreen();
//
//				startActivity(new Intent(LevelSelect.this, MainMenuActivity.class));
//
//			}
//		});
//	}

	private void setFullScreen() {
		View decorView = getWindow().getDecorView();
		// Hide both the navigation bar and the status bar.
		// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and
		// higher, but as
		// a general rule, you should design your app to hide the status bar
		// whenever you
		// hide the navigation bar.
		int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE
				| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
		decorView.setSystemUiVisibility(uiOptions);
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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
