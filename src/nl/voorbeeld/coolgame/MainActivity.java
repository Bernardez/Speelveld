package nl.voorbeeld.coolgame;

import nl.saxion.act.playground.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The main activity.
 * 
 * @author Paul de Groot
 * @author Jan Stroet
 */
public class MainActivity extends Activity {
	private CoolGame game;
	private CoolGameBoardView gameView;
	private TextView scoreLabel;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// Load main.xml
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//DELETE DEZE REGEL

		// Find some of the user interface elements
		gameView = (CoolGameBoardView) findViewById(R.id.game);
		scoreLabel = (TextView) findViewById(R.id.scoreTextView);

		// Create the game object. This contains all data and functionality
		// belonging to the game
		game = new CoolGame(this);

		// Do something when user clicks new game
		registerNewGameButton();

		// Tell user to start the game
		Toast.makeText(getApplicationContext(), "Lets start",
				Toast.LENGTH_SHORT).show();
	}

	/**
	 * Set a new score on the score label
	 * 
	 * @param newScore  The new score.
	 */
	public void updateScoreLabel(int newScore) {
		scoreLabel.setText("Score: " + newScore);
	}

	/**
	 * Returns the view on the game board.
	 */
	public CoolGameBoardView getGameBoardView() {
		return gameView;
	}

	/**
	 * Install a listener to the 'New game'-button so that it starts a new
	 * game when clicked.
	 */
	private void registerNewGameButton() {
		// Find the 'New Game'-button in the activity
		final Button button1 = (Button) findViewById(R.id.newGameButton);
		
		// Add a click listener to the button that calls initNewGame()
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				game.initNewGame();
			}
		});
	}

}
