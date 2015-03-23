package nl.noscope.emeraldextraction;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
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
import nl.noscope.level.LevelLoader;
import nl.noscope.level.ObjectHelper;
import nl.saxion.act.playground.activities.MainMenuActivity;
import nl.saxion.act.playground.model.Game;
import nl.saxion.act.playground.model.GameBoard;

/**
 * Emerald Extraction
 * 
 * @author Boyd
 */
public class EmeraldExtraction extends Game {

	/** Reference to the main activity, so some labels can be updated. */
	@SuppressWarnings("unused")
	private MainActivity activity;

	/** Maakt een miner aan*/
	private Miner miner;

	/** Maakt een board aan */
	GameBoard board;
	
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
		
		Intent intent = this.activity.getIntent();
		int levelSelection = intent.getFlags();

		// Reset the game
		initNewGame(activity, levelSelection);
		
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

	
	public void initNewGame(MainActivity activity, int levelSelection) {

		board = getGameBoard();
		board.removeAllObjects();
		
		//Load level based on level number
		Log.d("EmeraldExtrection", "Loading level" + levelSelection);
		LevelLoader levelLoader = new LevelLoader(levelSelection, 500, 1000);
		
		List<int[]> dataLevel1 = levelLoader.getData();
		
		miner = new Miner();
		for (int[] data : dataLevel1) {
			if (data[0] != 14) {
				board.addGameObject(ObjectHelper.getObject(data[0]), data[1], data[2]);
			}
			else {
				board.addGameObject(miner, data[1], data[2]);
			}
			
		}
		
		// Redraw the game view
		board.updateView();
		
		 
	}
	
	public void moveMinerUp(){
		miner.walkUp(board);
		board.updateView();
	}
	
	public void moveMinerDown(){
		miner.walkDown(board);
		board.updateView();
	}
	
	public void moveMinerLeft(){
		miner.walkLeft(board);
		board.updateView();
	}
	
	public void moveMinerRight(){
		miner.walkRight(board);
		board.updateView();
	}

}
