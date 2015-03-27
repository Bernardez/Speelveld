package nl.noscope.emeraldextraction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import nl.noscope.emeraldextraction.objects.StoneMove;
import nl.noscope.level.LevelLoader;
import nl.noscope.level.ObjectHelper;
import nl.saxion.act.playground.R;
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
	
	/** Maakt een emerald aan	 */
	private Emerald emerald;
	
	/** Maakt een emerald aan	 */
	private StoneMove stoneMove;

	/** Maakt een board aan */
	GameBoard board;
	
	private Resources resources;
	
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
		
		//get the application's resources  
        resources = activity.getApplicationContext().getResources();  
		
		Intent intent = this.activity.getIntent();
		int levelSelection = intent.getIntExtra("LEVEL_ID", 1);
		Log.d("EmeraldExtracion", "Level id intent = " + intent.getIntExtra("LEVEL_ID", 1));
		Log.d("EmeraldExtracion", "Level id levelSelection int = " + levelSelection);

		// Reset the game
		initNewGame(activity, levelSelection);
		
		// Tell the game board view which game board to show
		EmeraldExtractionBoardView gameView = activity.getGameBoardView();
		GameBoard gameBoard = getGameBoard();
		gameView.setGameBoard(gameBoard);

		// Set size of the view to that of the game board
		gameView.setFixedGridSize(gameBoard.getWidth(), gameBoard.getHeight());
		

		
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
		
		miner = new Miner();
		emerald = new Emerald();
		stoneMove = new StoneMove();
		
		//open a level with the level number
		
        Log.d("EmeraldExtrection", "bevore create inputfile" + levelSelection);
        InputStream is = null;
        
        switch (levelSelection) {
        case 1: is = activity.getApplicationContext().getResources().openRawResource(R.raw.level1);
        	break;
        case 2: is = activity.getApplicationContext().getResources().openRawResource(R.raw.level2);
        	break;
        }
        Log.d("EmeraldExtrection", "after create inputfile");

        String fileLevel = "";
        try {
			fileLevel = convertStreamToString(is);
		} catch (Exception e) {
			e.printStackTrace();
			Log.d("EmeraldExtraction", "convertStreamToString Exception");
		}
        
        Scanner in = new Scanner(fileLevel);
        
        int levelRow = 0;
        while (in.hasNext()) {
        	String line = in.nextLine();
        	Log.d("EmeraldExtraction", "Level regel ingelezen: " + line);
        	if (line.startsWith("*")){
        	}
        	else {
        		char[] levelColumns = line.toCharArray();
        		for (int i = 0; i < levelColumns.length; i++) {
        			if (levelColumns[i] == 'n') {
        				board.addGameObject(miner, i, levelRow);
        			}
        			else if (levelColumns[i] == 'e') {
        				board.addGameObject(emerald, i, levelRow);
        			}
        			else if (levelColumns[i] == 'd') {
        				
        			}
        			else {
        				board.addGameObject(ObjectHelper.getObject(levelColumns[i]), i, levelRow);
        			}
        		}
        		levelRow++;
        	}
        }
		
		for (int i = 0; i <= 28; i++) {
			//read the message into a string variable and print it.
			
		}
		
		System.out.println(is);
		
//		for (int[] data : dataLevel1) {
//			if (data[0] != 14) {
//				board.addGameObject(ObjectHelper.getObject(data[0]), data[1], data[2]);
//			}
//			else {
//				board.addGameObject(miner, data[1], data[2]);
//			}
//			
//		}
		
		// Redraw the game view
		board.updateView();
		
		 
	}
	
	public static String convertStreamToString(InputStream is) throws Exception {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    StringBuilder sb = new StringBuilder();
	    String line = null;
	    while ((line = reader.readLine()) != null) {
	      sb.append(line + "\n");
	    }
	    is.close();
	    return sb.toString();
	  }
	
	public void moveMinerUp(){
		miner.walkUp(board);
		emerald.gravityCheck(board);
		stoneMove.gravityCheck(board);
		
		board.updateView();
	}
	
	public void moveMinerDown(){
		miner.walkDown(board);
		emerald.gravityCheck(board);
		board.updateView();
	}
	
	public void moveMinerLeft(){
		miner.walkLeft(board);
		emerald.gravityCheck(board);
		board.updateView();
	}
	
	public void moveMinerRight(){
		miner.walkRight(board);
		emerald.gravityCheck(board);
		board.updateView();
	}

}
