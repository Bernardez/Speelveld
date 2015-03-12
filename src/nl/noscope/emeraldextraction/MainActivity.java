package nl.noscope.emeraldextraction;


import nl.saxion.act.playground.model.GameBoard;
import nl.voorbeeld.coolgame.CoolGameBoardView;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	
	EmeraldExtractionBoardView gameView;
	EmeraldExtraction game;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.gameView	=	(EmeraldExtractionBoardView) findViewById(R.id.boardview);	
		this.game	=  new EmeraldExtraction(this);	
			//Tell	the	game	board	view	which	game	board	to	show	
		GameBoard	board	=	game.getGameBoard();	
			gameView.setGameBoard(board);	
		gameView.setFixedGridSize(board.getWidth(),	board.getHeight());	
	}
	
	public EmeraldExtractionBoardView getGameBoardView() {
		return gameView;
	}



	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

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
