package nl.noscope.emeraldextraction;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import nl.noscope.data.DatabaseOperations;
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
import nl.noscope.level.Level;
import nl.noscope.level.ObjectHelper;
import nl.saxion.act.playground.activities.MainMenuActivity;
import nl.saxion.act.playground.model.Game;
import nl.saxion.act.playground.model.GameBoard;

/**
 * Awesome game for the Speelveld-project.
 * 
 * @author Paul de Groot
 */
public class EmeraldExtraction extends Game {

	/** Reference to the main activity, so some labels can be updated. */
	@SuppressWarnings("unused")
	private MainActivity activity;

	/** The number of leafs eaten. */

	/**
	 * Constructor.
	 * 
	 * @param activity
	 *            The main activity
	 */
	public EmeraldExtraction(MainActivity activity) {
		// Create a new game board and couple it to this game
		super(new EmeraldExtractionBoard());

		// Store reference to the main activity
		this.activity = activity;

		// Reset the game
		initNewGame();
		
		// Tell the game board view which game board to show
		EmeraldExtractionBoardView gameView = activity.getGameBoardView();
		GameBoard gameBoard = getGameBoard();
		gameView.setGameBoard(gameBoard);

		// Set size of the view to that of the game board
		gameView.setFixedGridSize(gameBoard.getWidth(), gameBoard.getHeight());
		
//		Log.d("Load level", "Load level");
//		this.context = activity.getApplicationContext();
//		//Level level = null;
//		//level = level.loadLevel(999, context);
//		DatabaseOperations dob = new DatabaseOperations(context);
//		level = dob.getLevel(999);
//		Log.d("Load level", "Level Loaded");
		
	}

	/**
	 * Starts a new game. Resets the score and places all objects in the right
	 * place.
	 */
	public void initNewGame() {

		GameBoard board = getGameBoard();
		board.removeAllObjects();
		
		
		//Load level 1
		Level level = null;
		try {
			DatabaseOperations DB = new DatabaseOperations(MainMenuActivity.getContext());
			Log.d("CoolGame" , "Databaseoperations gemaakt!");
			level = DB.getLevel(999);
			Log.d("CoolGame" , "Level Geladen!");
		}
		catch (Exception ex) {
			Log.d("CoolGame" , "databaseoperations exception!");
		}
		
		if (level != null) {
			Log.d("CoolGame" , "Level is niet null!");
		}
		List<int[]> lijst = level.getList();
		
		for (int[] blok : lijst) {
			//board.addGameObject(ObjectHelper.getObject(blok[0]), blok[1], blok[2]);
		}

		// // Add a player object
		board.addGameObject(new Miner(), 10, 11);

		// // Add some Stones
		board.addGameObject(new Stone(), 8, 10);
		board.addGameObject(new Stone(), 4, 3);
		board.addGameObject(new Stone(), 9, 5);
		board.addGameObject(new Stone(), 1, 5);
		board.addGameObject(new Stone(), 6, 11);
		board.addGameObject(new Stone(), 20, 11);
		board.addGameObject(new Stone(), 19, 11);
		board.addGameObject(new Stone(), 20, 10);
		board.addGameObject(new Stone(), 20, 9);
		board.addGameObject(new Stone(), 20, 8);
		board.addGameObject(new Stone(), 27, 16);
		board.addGameObject(new Stone(), 23, 3);
		board.addGameObject(new Stone(), 24, 6);
		board.addGameObject(new Stone(), 31, 2);
		board.addGameObject(new Stone(), 30, 7);

		// Add some Iron
		board.addGameObject(new Iron(), 10, 12);
		board.addGameObject(new Iron(), 11, 12);
		board.addGameObject(new Iron(), 12, 12);
		board.addGameObject(new Iron(), 13, 12);
		board.addGameObject(new Iron(), 11, 7);
		board.addGameObject(new Iron(), 12, 7);
		board.addGameObject(new Iron(), 13, 2);
		board.addGameObject(new Iron(), 18, 4);
		board.addGameObject(new Iron(), 2, 9);
		board.addGameObject(new Iron(), 28, 11);
		board.addGameObject(new Iron(), 33, 13);
		board.addGameObject(new Iron(), 20, 15);
		board.addGameObject(new Iron(), 4, 16);
		board.addGameObject(new Iron(), 4, 17);
		board.addGameObject(new Iron(), 5, 16);

		// Add some Emeralds
		board.addGameObject(new Emerald(), 16, 9);

		// Add one Minecart
		board.addGameObject(new Minecart(), 17, 18);

		// Add some Sand
		board.addGameObject(new Sand(), 1, 17);
		board.addGameObject(new Sand(), 2, 17);
		board.addGameObject(new Sand(), 3, 17);
		board.addGameObject(new Sand(), 5, 17);
		board.addGameObject(new Sand(), 6, 17);
		board.addGameObject(new Sand(), 7, 17);
		board.addGameObject(new Sand(), 8, 17);
		board.addGameObject(new Sand(), 9, 17);
		board.addGameObject(new Sand(), 10, 17);
		board.addGameObject(new Sand(), 11, 17);
		board.addGameObject(new Sand(), 12, 17);
		board.addGameObject(new Sand(), 13, 17);
		board.addGameObject(new Sand(), 14, 17);
		board.addGameObject(new Sand(), 15, 17);
		board.addGameObject(new Sand(), 16, 17);
		// board.addGameObject(new Sand(), 17, 17);
		board.addGameObject(new Sand(), 18, 17);
		board.addGameObject(new Sand(), 19, 17);
		board.addGameObject(new Sand(), 20, 17);
		board.addGameObject(new Sand(), 21, 17);
		board.addGameObject(new Sand(), 22, 17);
		board.addGameObject(new Sand(), 23, 17);
		board.addGameObject(new Sand(), 24, 17);
		board.addGameObject(new Sand(), 25, 17);
		board.addGameObject(new Sand(), 26, 17);
		board.addGameObject(new Sand(), 27, 17);
		board.addGameObject(new Sand(), 28, 17);
		board.addGameObject(new Sand(), 29, 17);
		board.addGameObject(new Sand(), 30, 17);
		board.addGameObject(new Sand(), 31, 17);
		board.addGameObject(new Sand(), 32, 17);
		board.addGameObject(new Sand(), 33, 17);

		board.addGameObject(new Sand(), 1, 16);
		board.addGameObject(new Sand(), 2, 16);
		board.addGameObject(new Sand(), 3, 16);
		// board.addGameObject(new Sand(), 5, 16);
		board.addGameObject(new Sand(), 6, 16);
		board.addGameObject(new Sand(), 7, 16);
		board.addGameObject(new Sand(), 8, 16);
		board.addGameObject(new Sand(), 9, 16);
		board.addGameObject(new Sand(), 10, 16);
		board.addGameObject(new Sand(), 11, 16);
		board.addGameObject(new Sand(), 12, 16);
		board.addGameObject(new Sand(), 13, 16);
		board.addGameObject(new Sand(), 14, 16);
		board.addGameObject(new Sand(), 15, 16);
		board.addGameObject(new Sand(), 16, 16);
		// board.addGameObject(new Sand(), 17, 17);
		board.addGameObject(new Sand(), 18, 16);
		board.addGameObject(new Sand(), 19, 16);
		board.addGameObject(new Sand(), 20, 16);
		board.addGameObject(new Sand(), 21, 16);
		board.addGameObject(new Sand(), 22, 16);
		board.addGameObject(new Sand(), 23, 16);
		board.addGameObject(new Sand(), 24, 16);
		board.addGameObject(new Sand(), 25, 16);
		board.addGameObject(new Sand(), 26, 16);
		// board.addGameObject(new Sand(), 27, 16);
		board.addGameObject(new Sand(), 28, 16);
		board.addGameObject(new Sand(), 29, 16);
		board.addGameObject(new Sand(), 30, 16);
		board.addGameObject(new Sand(), 31, 16);
		board.addGameObject(new Sand(), 32, 16);
		board.addGameObject(new Sand(), 33, 16);

		board.addGameObject(new Sand(), 1, 15);
		board.addGameObject(new Sand(), 2, 15);
		board.addGameObject(new Sand(), 3, 15);
		board.addGameObject(new Sand(), 4, 15);
		board.addGameObject(new Sand(), 5, 15);
		board.addGameObject(new Sand(), 6, 15);
		board.addGameObject(new Sand(), 7, 15);
		board.addGameObject(new Sand(), 8, 15);
		board.addGameObject(new Sand(), 9, 15);
		board.addGameObject(new Sand(), 10, 15);
		board.addGameObject(new Sand(), 11, 15);
		board.addGameObject(new Sand(), 12, 15);
		board.addGameObject(new Sand(), 13, 15);
		board.addGameObject(new Sand(), 14, 15);
		board.addGameObject(new Sand(), 15, 15);
		board.addGameObject(new Sand(), 16, 15);
		// board.addGameObject(new Sand(), 17, 15);
		board.addGameObject(new Sand(), 18, 15);
		board.addGameObject(new Sand(), 19, 15);
		// board.addGameObject(new Sand(), 20, 15);
		board.addGameObject(new Sand(), 21, 15);
		board.addGameObject(new Sand(), 22, 15);
		board.addGameObject(new Sand(), 23, 15);
		board.addGameObject(new Sand(), 24, 15);
		board.addGameObject(new Sand(), 25, 15);
		board.addGameObject(new Sand(), 26, 15);
		board.addGameObject(new Sand(), 27, 15);
		board.addGameObject(new Sand(), 28, 15);
		board.addGameObject(new Sand(), 29, 15);
		board.addGameObject(new Sand(), 30, 15);
		board.addGameObject(new Sand(), 31, 15);
		board.addGameObject(new Sand(), 32, 15);
		board.addGameObject(new Sand(), 33, 15);

		board.addGameObject(new Sand(), 1, 14);
		board.addGameObject(new Sand(), 2, 14);
		board.addGameObject(new Sand(), 3, 14);
		board.addGameObject(new Sand(), 4, 14);
		board.addGameObject(new Sand(), 5, 14);
		board.addGameObject(new Sand(), 6, 14);
		board.addGameObject(new Sand(), 7, 14);
		board.addGameObject(new Sand(), 8, 14);
		board.addGameObject(new Sand(), 9, 14);
		board.addGameObject(new Sand(), 10, 14);
		board.addGameObject(new Sand(), 11, 14);
		board.addGameObject(new Sand(), 12, 14);
		board.addGameObject(new Sand(), 13, 14);
		board.addGameObject(new Sand(), 14, 14);
		board.addGameObject(new Sand(), 15, 14);
		board.addGameObject(new Sand(), 16, 14);
		// board.addGameObject(new Sand(), 17, 14);
		board.addGameObject(new Sand(), 18, 14);
		board.addGameObject(new Sand(), 19, 14);
		board.addGameObject(new Sand(), 20, 14);
		board.addGameObject(new Sand(), 21, 14);
		board.addGameObject(new Sand(), 22, 14);
		board.addGameObject(new Sand(), 23, 14);
		board.addGameObject(new Sand(), 24, 14);
		board.addGameObject(new Sand(), 25, 14);
		board.addGameObject(new Sand(), 26, 14);
		board.addGameObject(new Sand(), 27, 14);
		board.addGameObject(new Sand(), 28, 14);
		board.addGameObject(new Sand(), 29, 14);
		board.addGameObject(new Sand(), 30, 14);
		board.addGameObject(new Sand(), 31, 14);
		board.addGameObject(new Sand(), 32, 14);
		board.addGameObject(new Sand(), 33, 14);

		board.addGameObject(new Sand(), 1, 13);
		board.addGameObject(new Sand(), 2, 13);
		board.addGameObject(new Sand(), 3, 13);
		board.addGameObject(new Sand(), 4, 13);
		board.addGameObject(new Sand(), 5, 13);
		board.addGameObject(new Sand(), 6, 13);
		board.addGameObject(new Sand(), 7, 13);
		board.addGameObject(new Sand(), 8, 13);
		board.addGameObject(new Sand(), 9, 13);
		board.addGameObject(new Sand(), 10, 13);
		board.addGameObject(new Sand(), 11, 13);
		board.addGameObject(new Sand(), 12, 13);
		board.addGameObject(new Sand(), 13, 13);
		board.addGameObject(new Sand(), 14, 13);
		board.addGameObject(new Sand(), 15, 13);
		board.addGameObject(new Sand(), 16, 13);
		// board.addGameObject(new Sand(), 17, 13);
		board.addGameObject(new Sand(), 18, 13);
		board.addGameObject(new Sand(), 19, 13);
		board.addGameObject(new Sand(), 20, 13);
		board.addGameObject(new Sand(), 21, 13);
		board.addGameObject(new Sand(), 22, 13);
		board.addGameObject(new Sand(), 23, 13);
		board.addGameObject(new Sand(), 24, 13);
		board.addGameObject(new Sand(), 25, 13);
		board.addGameObject(new Sand(), 26, 13);
		board.addGameObject(new Sand(), 27, 13);
		board.addGameObject(new Sand(), 28, 13);
		board.addGameObject(new Sand(), 29, 13);
		board.addGameObject(new Sand(), 30, 13);
		board.addGameObject(new Sand(), 31, 13);
		board.addGameObject(new Sand(), 32, 13);
		// board.addGameObject(new Sand(), 33, 13);

		board.addGameObject(new Sand(), 1, 12);
		board.addGameObject(new Sand(), 2, 12);
		board.addGameObject(new Sand(), 3, 12);
		board.addGameObject(new Sand(), 4, 12);
		board.addGameObject(new Sand(), 5, 12);
		board.addGameObject(new Sand(), 6, 12);
		board.addGameObject(new Sand(), 7, 12);
		board.addGameObject(new Sand(), 8, 12);
		board.addGameObject(new Sand(), 9, 12);
		// board.addGameObject(new Sand(), 10, 12);
		// board.addGameObject(new Sand(), 11, 12);
		// board.addGameObject(new Sand(), 12, 12);
		// board.addGameObject(new Sand(), 13, 12);
		board.addGameObject(new Sand(), 14, 12);
		board.addGameObject(new Sand(), 15, 12);
		board.addGameObject(new Sand(), 16, 12);
		// board.addGameObject(new Sand(), 17, 12);
		board.addGameObject(new Sand(), 18, 12);
		board.addGameObject(new Sand(), 19, 12);
		board.addGameObject(new Sand(), 20, 12);
		board.addGameObject(new Sand(), 21, 12);
		board.addGameObject(new Sand(), 22, 12);
		board.addGameObject(new Sand(), 23, 12);
		board.addGameObject(new Sand(), 24, 12);
		board.addGameObject(new Sand(), 25, 12);
		board.addGameObject(new Sand(), 26, 12);
		board.addGameObject(new Sand(), 27, 12);
		board.addGameObject(new Sand(), 28, 12);
		board.addGameObject(new Sand(), 29, 12);
		board.addGameObject(new Sand(), 30, 12);
		board.addGameObject(new Sand(), 31, 12);
		board.addGameObject(new Sand(), 32, 12);
		board.addGameObject(new Sand(), 33, 12);

		board.addGameObject(new Sand(), 1, 11);
		board.addGameObject(new Sand(), 2, 11);
		board.addGameObject(new Sand(), 3, 11);
		board.addGameObject(new Sand(), 4, 11);
		board.addGameObject(new Sand(), 5, 11);
		// board.addGameObject(new Sand(), 6, 11);
		board.addGameObject(new Sand(), 7, 11);
		board.addGameObject(new Sand(), 8, 11);
		board.addGameObject(new Sand(), 9, 11);
		// board.addGameObject(new Sand(), 10, 11);
		// board.addGameObject(new Sand(), 11, 11);
		// board.addGameObject(new Sand(), 12, 11);
		// board.addGameObject(new Sand(), 13, 11);
		// board.addGameObject(new Sand(), 14, 11);
		// board.addGameObject(new Sand(), 15, 11);
		// board.addGameObject(new Sand(), 16, 11);
		// //board.addGameObject(new Sand(), 17, 11);
		board.addGameObject(new Sand(), 18, 11);
		// board.addGameObject(new Sand(), 19, 11);
		// board.addGameObject(new Sand(), 20, 11);
		board.addGameObject(new Sand(), 21, 11);
		board.addGameObject(new Sand(), 22, 11);
		board.addGameObject(new Sand(), 23, 11);
		board.addGameObject(new Sand(), 24, 11);
		board.addGameObject(new Sand(), 25, 11);
		board.addGameObject(new Sand(), 26, 11);
		board.addGameObject(new Sand(), 27, 11);
		// board.addGameObject(new Sand(), 28, 11);
		board.addGameObject(new Sand(), 29, 11);
		board.addGameObject(new Sand(), 30, 11);
		board.addGameObject(new Sand(), 31, 11);
		board.addGameObject(new Sand(), 32, 11);
		board.addGameObject(new Sand(), 33, 11);

		board.addGameObject(new Sand(), 1, 10);
		board.addGameObject(new Sand(), 2, 10);
		board.addGameObject(new Sand(), 3, 10);
		board.addGameObject(new Sand(), 4, 10);
		board.addGameObject(new Sand(), 5, 10);
		board.addGameObject(new Sand(), 6, 10);
		board.addGameObject(new Sand(), 7, 10);
		// board.addGameObject(new Sand(), 8, 10);
		board.addGameObject(new Sand(), 9, 10);
		board.addGameObject(new Sand(), 10, 10);
		board.addGameObject(new Sand(), 11, 10);
		board.addGameObject(new Sand(), 12, 10);
		board.addGameObject(new Sand(), 13, 10);
		board.addGameObject(new Sand(), 14, 10);
		board.addGameObject(new Sand(), 15, 10);
		board.addGameObject(new Sand(), 16, 10);
		// board.addGameObject(new Sand(), 17, 10);
		board.addGameObject(new Sand(), 18, 10);
		board.addGameObject(new Sand(), 19, 10);
		// board.addGameObject(new Sand(), 20, 10);
		board.addGameObject(new Sand(), 21, 10);
		board.addGameObject(new Sand(), 22, 10);
		board.addGameObject(new Sand(), 23, 10);
		board.addGameObject(new Sand(), 24, 10);
		board.addGameObject(new Sand(), 25, 10);
		board.addGameObject(new Sand(), 26, 10);
		board.addGameObject(new Sand(), 27, 10);
		board.addGameObject(new Sand(), 28, 10);
		board.addGameObject(new Sand(), 29, 10);
		board.addGameObject(new Sand(), 30, 10);
		board.addGameObject(new Sand(), 31, 10);
		board.addGameObject(new Sand(), 32, 10);
		board.addGameObject(new Sand(), 33, 10);

		board.addGameObject(new Sand(), 1, 9);
		// board.addGameObject(new Sand(), 2, 9);
		board.addGameObject(new Sand(), 3, 9);
		board.addGameObject(new Sand(), 4, 9);
		board.addGameObject(new Sand(), 5, 9);
		board.addGameObject(new Sand(), 6, 9);
		board.addGameObject(new Sand(), 7, 9);
		board.addGameObject(new Sand(), 8, 9);
		board.addGameObject(new Sand(), 9, 9);
		board.addGameObject(new Sand(), 10, 9);
		board.addGameObject(new Sand(), 11, 9);
		board.addGameObject(new Sand(), 12, 9);
		board.addGameObject(new Sand(), 13, 9);
		board.addGameObject(new Sand(), 14, 9);
		board.addGameObject(new Sand(), 15, 9);
		// board.addGameObject(new Sand(), 16, 9);
		// board.addGameObject(new Sand(), 17, 9);
		board.addGameObject(new Sand(), 18, 9);
		board.addGameObject(new Sand(), 19, 9);
		// board.addGameObject(new Sand(), 20, 9);
		board.addGameObject(new Sand(), 21, 9);
		board.addGameObject(new Sand(), 22, 9);
		board.addGameObject(new Sand(), 23, 9);
		board.addGameObject(new Sand(), 24, 9);
		board.addGameObject(new Sand(), 25, 9);
		board.addGameObject(new Sand(), 26, 9);
		board.addGameObject(new Sand(), 27, 9);
		board.addGameObject(new Sand(), 28, 9);
		board.addGameObject(new Sand(), 29, 9);
		board.addGameObject(new Sand(), 30, 9);
		board.addGameObject(new Sand(), 31, 9);
		board.addGameObject(new Sand(), 32, 9);
		board.addGameObject(new Sand(), 33, 9);

		board.addGameObject(new Sand(), 1, 8);
		board.addGameObject(new Sand(), 2, 8);
		board.addGameObject(new Sand(), 3, 8);
		board.addGameObject(new Sand(), 4, 8);
		board.addGameObject(new Sand(), 5, 8);
		board.addGameObject(new Sand(), 6, 8);
		board.addGameObject(new Sand(), 7, 8);
		board.addGameObject(new Sand(), 8, 8);
		board.addGameObject(new Sand(), 9, 8);
		board.addGameObject(new Sand(), 10, 8);
		board.addGameObject(new Sand(), 11, 8);
		board.addGameObject(new Sand(), 12, 8);
		board.addGameObject(new Sand(), 13, 8);
		board.addGameObject(new Sand(), 14, 8);
		board.addGameObject(new Sand(), 15, 8);
		board.addGameObject(new Sand(), 16, 8);
		// board.addGameObject(new Sand(), 17, 8);
		board.addGameObject(new Sand(), 18, 8);
		board.addGameObject(new Sand(), 19, 8);
		// board.addGameObject(new Sand(), 20, 8);
		board.addGameObject(new Sand(), 21, 8);
		board.addGameObject(new Sand(), 22, 8);
		board.addGameObject(new Sand(), 23, 8);
		board.addGameObject(new Sand(), 24, 8);
		board.addGameObject(new Sand(), 25, 8);
		board.addGameObject(new Sand(), 26, 8);
		board.addGameObject(new Sand(), 27, 8);
		board.addGameObject(new Sand(), 28, 8);
		board.addGameObject(new Sand(), 29, 8);
		board.addGameObject(new Sand(), 30, 8);
		board.addGameObject(new Sand(), 31, 8);
		board.addGameObject(new Sand(), 32, 8);
		board.addGameObject(new Sand(), 33, 8);

		board.addGameObject(new Sand(), 1, 7);
		board.addGameObject(new Sand(), 2, 7);
		board.addGameObject(new Sand(), 3, 7);
		board.addGameObject(new Sand(), 4, 7);
		board.addGameObject(new Sand(), 5, 7);
		board.addGameObject(new Sand(), 6, 7);
		board.addGameObject(new Sand(), 7, 7);
		board.addGameObject(new Sand(), 8, 7);
		board.addGameObject(new Sand(), 9, 7);
		board.addGameObject(new Sand(), 10, 7);
		// board.addGameObject(new Sand(), 11, 7);
		// board.addGameObject(new Sand(), 12, 7);
		board.addGameObject(new Sand(), 13, 7);
		board.addGameObject(new Sand(), 14, 7);
		board.addGameObject(new Sand(), 15, 7);
		board.addGameObject(new Sand(), 16, 7);
		// board.addGameObject(new Sand(), 17,7);
		board.addGameObject(new Sand(), 18, 7);
		board.addGameObject(new Sand(), 19, 7);
		board.addGameObject(new Sand(), 20, 7);
		board.addGameObject(new Sand(), 21, 7);
		board.addGameObject(new Sand(), 22, 7);
		board.addGameObject(new Sand(), 23, 7);
		board.addGameObject(new Sand(), 24, 7);
		board.addGameObject(new Sand(), 25, 7);
		board.addGameObject(new Sand(), 26, 7);
		board.addGameObject(new Sand(), 27, 7);
		board.addGameObject(new Sand(), 28, 7);
		board.addGameObject(new Sand(), 29, 7);
		// board.addGameObject(new Sand(), 30, 7);
		board.addGameObject(new Sand(), 31, 7);
		board.addGameObject(new Sand(), 32, 7);
		board.addGameObject(new Sand(), 33, 7);

		board.addGameObject(new Sand(), 1, 6);
		board.addGameObject(new Sand(), 2, 6);
		board.addGameObject(new Sand(), 3, 6);
		board.addGameObject(new Sand(), 4, 6);
		board.addGameObject(new Sand(), 5, 6);
		board.addGameObject(new Sand(), 6, 6);
		board.addGameObject(new Sand(), 7, 6);
		board.addGameObject(new Sand(), 8, 6);
		board.addGameObject(new Sand(), 9, 6);
		board.addGameObject(new Sand(), 10, 6);
		board.addGameObject(new Sand(), 11, 6);
		board.addGameObject(new Sand(), 12, 6);
		board.addGameObject(new Sand(), 13, 6);
		board.addGameObject(new Sand(), 14, 6);
		board.addGameObject(new Sand(), 15, 6);
		board.addGameObject(new Sand(), 16, 6);
		board.addGameObject(new Sand(), 17, 6);
		board.addGameObject(new Sand(), 18, 6);
		board.addGameObject(new Sand(), 19, 6);
		board.addGameObject(new Sand(), 20, 6);
		board.addGameObject(new Sand(), 21, 6);
		board.addGameObject(new Sand(), 22, 6);
		board.addGameObject(new Sand(), 23, 6);
		// board.addGameObject(new Sand(), 24, 6);
		board.addGameObject(new Sand(), 25, 6);
		board.addGameObject(new Sand(), 26, 6);
		board.addGameObject(new Sand(), 27, 6);
		board.addGameObject(new Sand(), 28, 6);
		board.addGameObject(new Sand(), 29, 6);
		board.addGameObject(new Sand(), 30, 6);
		board.addGameObject(new Sand(), 31, 6);
		board.addGameObject(new Sand(), 32, 6);
		board.addGameObject(new Sand(), 33, 6);

		// board.addGameObject(new Sand(), 1, 5);
		board.addGameObject(new Sand(), 2, 5);
		board.addGameObject(new Sand(), 3, 5);
		board.addGameObject(new Sand(), 4, 5);
		board.addGameObject(new Sand(), 5, 5);
		board.addGameObject(new Sand(), 6, 5);
		board.addGameObject(new Sand(), 7, 5);
		board.addGameObject(new Sand(), 8, 5);
		// board.addGameObject(new Sand(), 9, 5);
		board.addGameObject(new Sand(), 10, 5);
		board.addGameObject(new Sand(), 11, 5);
		board.addGameObject(new Sand(), 12, 5);
		board.addGameObject(new Sand(), 13, 5);
		board.addGameObject(new Sand(), 14, 5);
		board.addGameObject(new Sand(), 15, 5);
		board.addGameObject(new Sand(), 16, 5);
		board.addGameObject(new Sand(), 17, 5);
		board.addGameObject(new Sand(), 18, 5);
		board.addGameObject(new Sand(), 19, 5);
		board.addGameObject(new Sand(), 20, 5);
		board.addGameObject(new Sand(), 21, 5);
		board.addGameObject(new Sand(), 22, 5);
		board.addGameObject(new Sand(), 23, 5);
		board.addGameObject(new Sand(), 24, 5);
		board.addGameObject(new Sand(), 25, 5);
		board.addGameObject(new Sand(), 26, 5);
		board.addGameObject(new Sand(), 27, 5);
		board.addGameObject(new Sand(), 28, 5);
		board.addGameObject(new Sand(), 29, 5);
		board.addGameObject(new Sand(), 30, 5);
		board.addGameObject(new Sand(), 31, 5);
		board.addGameObject(new Sand(), 32, 5);
		board.addGameObject(new Sand(), 33, 5);

		board.addGameObject(new Sand(), 1, 4);
		board.addGameObject(new Sand(), 2, 4);
		board.addGameObject(new Sand(), 3, 4);
		board.addGameObject(new Sand(), 4, 4);
		board.addGameObject(new Sand(), 5, 4);
		board.addGameObject(new Sand(), 6, 4);
		board.addGameObject(new Sand(), 7, 4);
		board.addGameObject(new Sand(), 8, 4);
		board.addGameObject(new Sand(), 9, 4);
		board.addGameObject(new Sand(), 10, 4);
		board.addGameObject(new Sand(), 11, 4);
		board.addGameObject(new Sand(), 12, 4);
		board.addGameObject(new Sand(), 13, 4);
		board.addGameObject(new Sand(), 14, 4);
		board.addGameObject(new Sand(), 15, 4);
		board.addGameObject(new Sand(), 16, 4);
		board.addGameObject(new Sand(), 17, 4);
		// board.addGameObject(new Sand(), 18, 4);
		board.addGameObject(new Sand(), 19, 4);
		board.addGameObject(new Sand(), 20, 4);
		board.addGameObject(new Sand(), 21, 4);
		board.addGameObject(new Sand(), 22, 4);
		board.addGameObject(new Sand(), 23, 4);
		board.addGameObject(new Sand(), 24, 4);
		board.addGameObject(new Sand(), 25, 4);
		board.addGameObject(new Sand(), 26, 4);
		board.addGameObject(new Sand(), 27, 4);
		board.addGameObject(new Sand(), 28, 4);
		board.addGameObject(new Sand(), 29, 4);
		board.addGameObject(new Sand(), 30, 4);
		board.addGameObject(new Sand(), 31, 4);
		board.addGameObject(new Sand(), 32, 4);
		board.addGameObject(new Sand(), 33, 4);

		board.addGameObject(new Sand(), 1, 3);
		board.addGameObject(new Sand(), 2, 3);
		board.addGameObject(new Sand(), 3, 3);
		// board.addGameObject(new Sand(), 4, 3);
		board.addGameObject(new Sand(), 5, 3);
		board.addGameObject(new Sand(), 6, 3);
		board.addGameObject(new Sand(), 7, 3);
		board.addGameObject(new Sand(), 8, 3);
		board.addGameObject(new Sand(), 9, 3);
		board.addGameObject(new Sand(), 10, 3);
		board.addGameObject(new Sand(), 11, 3);
		board.addGameObject(new Sand(), 12, 3);
		board.addGameObject(new Sand(), 13, 3);
		board.addGameObject(new Sand(), 14, 3);
		board.addGameObject(new Sand(), 15, 3);
		board.addGameObject(new Sand(), 16, 3);
		board.addGameObject(new Sand(), 17, 3);
		board.addGameObject(new Sand(), 18, 3);
		board.addGameObject(new Sand(), 19, 3);
		board.addGameObject(new Sand(), 20, 3);
		board.addGameObject(new Sand(), 21, 3);
		board.addGameObject(new Sand(), 22, 3);
		// board.addGameObject(new Sand(), 23, 3);
		board.addGameObject(new Sand(), 24, 3);
		board.addGameObject(new Sand(), 25, 3);
		board.addGameObject(new Sand(), 26, 3);
		board.addGameObject(new Sand(), 27, 3);
		board.addGameObject(new Sand(), 28, 3);
		board.addGameObject(new Sand(), 29, 3);
		board.addGameObject(new Sand(), 30, 3);
		board.addGameObject(new Sand(), 31, 3);
		board.addGameObject(new Sand(), 32, 3);
		board.addGameObject(new Sand(), 33, 3);

		board.addGameObject(new Sand(), 1, 2);
		board.addGameObject(new Sand(), 2, 2);
		board.addGameObject(new Sand(), 3, 2);
		board.addGameObject(new Sand(), 4, 2);
		board.addGameObject(new Sand(), 5, 2);
		board.addGameObject(new Sand(), 6, 2);
		board.addGameObject(new Sand(), 7, 2);
		board.addGameObject(new Sand(), 8, 2);
		board.addGameObject(new Sand(), 9, 2);
		board.addGameObject(new Sand(), 10, 2);
		board.addGameObject(new Sand(), 11, 2);
		board.addGameObject(new Sand(), 12, 2);
		// board.addGameObject(new Sand(), 13, 2);
		board.addGameObject(new Sand(), 14, 2);
		board.addGameObject(new Sand(), 15, 2);
		board.addGameObject(new Sand(), 16, 2);
		board.addGameObject(new Sand(), 17, 2);
		board.addGameObject(new Sand(), 18, 2);
		board.addGameObject(new Sand(), 19, 2);
		board.addGameObject(new Sand(), 20, 2);
		board.addGameObject(new Sand(), 21, 2);
		board.addGameObject(new Sand(), 22, 2);
		board.addGameObject(new Sand(), 23, 2);
		board.addGameObject(new Sand(), 24, 2);
		board.addGameObject(new Sand(), 25, 2);
		board.addGameObject(new Sand(), 26, 2);
		board.addGameObject(new Sand(), 27, 2);
		board.addGameObject(new Sand(), 28, 2);
		board.addGameObject(new Sand(), 29, 2);
		board.addGameObject(new Sand(), 30, 2);
		// board.addGameObject(new Sand(), 31, 2);
		board.addGameObject(new Sand(), 32, 2);
		board.addGameObject(new Sand(), 33, 2);

		board.addGameObject(new Sand(), 1, 1);
		board.addGameObject(new Sand(), 2, 1);
		board.addGameObject(new Sand(), 3, 1);
		board.addGameObject(new Sand(), 4, 1);
		board.addGameObject(new Sand(), 5, 1);
		board.addGameObject(new Sand(), 6, 1);
		board.addGameObject(new Sand(), 7, 1);
		board.addGameObject(new Sand(), 8, 1);
		board.addGameObject(new Sand(), 9, 1);
		board.addGameObject(new Sand(), 10, 1);
		board.addGameObject(new Sand(), 11, 1);
		board.addGameObject(new Sand(), 12, 1);
		board.addGameObject(new Sand(), 13, 1);
		board.addGameObject(new Sand(), 14, 1);
		board.addGameObject(new Sand(), 15, 1);
		board.addGameObject(new Sand(), 16, 1);
		board.addGameObject(new Sand(), 17, 1);
		board.addGameObject(new Sand(), 18, 1);
		board.addGameObject(new Sand(), 19, 1);
		board.addGameObject(new Sand(), 20, 1);
		board.addGameObject(new Sand(), 21, 1);
		board.addGameObject(new Sand(), 22, 1);
		board.addGameObject(new Sand(), 23, 1);
		board.addGameObject(new Sand(), 24, 1);
		board.addGameObject(new Sand(), 25, 1);
		board.addGameObject(new Sand(), 26, 1);
		board.addGameObject(new Sand(), 27, 1);
		board.addGameObject(new Sand(), 28, 1);
		board.addGameObject(new Sand(), 29, 1);
		board.addGameObject(new Sand(), 30, 1);
		board.addGameObject(new Sand(), 31, 1);
		board.addGameObject(new Sand(), 32, 1);
		board.addGameObject(new Sand(), 33, 1);

		// Add some Borders
		board.addGameObject(new LinkerOnderHoek(), 0, 19);
		board.addGameObject(new OnderRand(), 1, 19);
		board.addGameObject(new OnderRand(), 2, 19);
		board.addGameObject(new OnderRand(), 3, 19);
		board.addGameObject(new OnderRand(), 4, 19);
		board.addGameObject(new OnderRand(), 5, 19);
		board.addGameObject(new OnderRand(), 6, 19);
		board.addGameObject(new OnderRand(), 7, 19);
		board.addGameObject(new OnderRand(), 8, 19);
		board.addGameObject(new OnderRand(), 9, 19);
		board.addGameObject(new OnderRand(), 10, 19);
		board.addGameObject(new OnderRand(), 11, 19);
		board.addGameObject(new OnderRand(), 12, 19);
		board.addGameObject(new OnderRand(), 13, 19);
		board.addGameObject(new OnderRand(), 14, 19);
		board.addGameObject(new OnderRand(), 15, 19);
		board.addGameObject(new OnderRand(), 16, 19);
		board.addGameObject(new OnderRand(), 17, 19);
		board.addGameObject(new OnderRand(), 18, 19);
		board.addGameObject(new OnderRand(), 19, 19);
		board.addGameObject(new OnderRand(), 20, 19);
		board.addGameObject(new OnderRand(), 21, 19);
		board.addGameObject(new OnderRand(), 22, 19);
		board.addGameObject(new OnderRand(), 23, 19);
		board.addGameObject(new OnderRand(), 24, 19);
		board.addGameObject(new OnderRand(), 25, 19);
		board.addGameObject(new OnderRand(), 26, 19);
		board.addGameObject(new OnderRand(), 27, 19);
		board.addGameObject(new OnderRand(), 28, 19);
		board.addGameObject(new OnderRand(), 29, 19);
		board.addGameObject(new OnderRand(), 30, 19);
		board.addGameObject(new OnderRand(), 31, 19);
		board.addGameObject(new OnderRand(), 32, 19);
		board.addGameObject(new OnderRand(), 33, 19);
		board.addGameObject(new RechterOnderHoek(), 34, 19);

		board.addGameObject(new LinkerBovenHoek(), 0, 0);
		board.addGameObject(new BovenRand(), 1, 0);
		board.addGameObject(new BovenRand(), 2, 0);
		board.addGameObject(new BovenRand(), 3, 0);
		board.addGameObject(new BovenRand(), 4, 0);
		board.addGameObject(new BovenRand(), 5, 0);
		board.addGameObject(new BovenRand(), 6, 0);
		board.addGameObject(new BovenRand(), 7, 0);
		board.addGameObject(new BovenRand(), 8, 0);
		board.addGameObject(new BovenRand(), 9, 0);
		board.addGameObject(new BovenRand(), 10, 0);
		board.addGameObject(new BovenRand(), 11, 0);
		board.addGameObject(new BovenRand(), 12, 0);
		board.addGameObject(new BovenRand(), 13, 0);
		board.addGameObject(new BovenRand(), 14, 0);
		board.addGameObject(new BovenRand(), 15, 0);
		board.addGameObject(new BovenRand(), 16, 0);
		board.addGameObject(new BovenRand(), 17, 0);
		board.addGameObject(new BovenRand(), 18, 0);
		board.addGameObject(new BovenRand(), 19, 0);
		board.addGameObject(new BovenRand(), 20, 0);
		board.addGameObject(new BovenRand(), 21, 0);
		board.addGameObject(new BovenRand(), 22, 0);
		board.addGameObject(new BovenRand(), 23, 0);
		board.addGameObject(new BovenRand(), 24, 0);
		board.addGameObject(new BovenRand(), 25, 0);
		board.addGameObject(new BovenRand(), 26, 0);
		board.addGameObject(new BovenRand(), 27, 0);
		board.addGameObject(new BovenRand(), 28, 0);
		board.addGameObject(new BovenRand(), 29, 0);
		board.addGameObject(new BovenRand(), 30, 0);
		board.addGameObject(new BovenRand(), 31, 0);
		board.addGameObject(new BovenRand(), 32, 0);
		board.addGameObject(new BovenRand(), 33, 0);
		board.addGameObject(new RechterBovenHoek(), 34, 0);

		board.addGameObject(new LinkerRand(), 0, 1);
		board.addGameObject(new LinkerRand(), 0, 2);
		board.addGameObject(new LinkerRand(), 0, 3);
		board.addGameObject(new LinkerRand(), 0, 4);
		board.addGameObject(new LinkerRand(), 0, 5);
		board.addGameObject(new LinkerRand(), 0, 6);
		board.addGameObject(new LinkerRand(), 0, 7);
		board.addGameObject(new LinkerRand(), 0, 8);
		board.addGameObject(new LinkerRand(), 0, 9);
		board.addGameObject(new LinkerRand(), 0, 10);
		board.addGameObject(new LinkerRand(), 0, 11);
		board.addGameObject(new LinkerRand(), 0, 12);
		board.addGameObject(new LinkerRand(), 0, 13);
		board.addGameObject(new LinkerRand(), 0, 14);
		board.addGameObject(new LinkerRand(), 0, 15);
		board.addGameObject(new LinkerRand(), 0, 16);
		board.addGameObject(new LinkerRand(), 0, 17);
		board.addGameObject(new LinkerRand(), 0, 18);

		board.addGameObject(new RechterRand(), 34, 1);
		board.addGameObject(new RechterRand(), 34, 2);
		board.addGameObject(new RechterRand(), 34, 3);
		board.addGameObject(new RechterRand(), 34, 4);
		board.addGameObject(new RechterRand(), 34, 5);
		board.addGameObject(new RechterRand(), 34, 6);
		board.addGameObject(new RechterRand(), 34, 7);
		board.addGameObject(new RechterRand(), 34, 8);
		board.addGameObject(new RechterRand(), 34, 9);
		board.addGameObject(new RechterRand(), 34, 10);
		board.addGameObject(new RechterRand(), 34, 11);
		board.addGameObject(new RechterRand(), 34, 12);
		board.addGameObject(new RechterRand(), 34, 13);
		board.addGameObject(new RechterRand(), 34, 14);
		board.addGameObject(new RechterRand(), 34, 15);
		board.addGameObject(new RechterRand(), 34, 16);
		board.addGameObject(new RechterRand(), 34, 17);
		board.addGameObject(new RechterRand(), 34, 18);

		// Redraw the game view
		board.updateView();
	}

}
