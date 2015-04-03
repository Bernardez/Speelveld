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

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
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
import nl.saxion.act.playground.activities.LevelSelect;
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
	
	/** Maakt een emerald lijst aan	 */
	private ArrayList<Emerald> emeralds = new ArrayList<Emerald>();
	
	/** Index die gebruikt wordt bij het
	 * toevoegen van emeralds aan het game board
	 */
	private int emeraldIndex;
	
	/** Maakt een emerald lijst aan	 */
	private ArrayList<StoneMove> stoneMoves = new ArrayList<StoneMove>();
	
	/** Index die gebruikt wordt bij het
	 * toevoegen van emeralds aan het game board
	 */
	private int stoneMoveIndex;

	/** Maakt een board aan */
	GameBoard board;
	
	/** Houd het level bij */
	int levelSelection;
	
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
		levelSelection = intent.getIntExtra("LEVEL_ID", 1);
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
		
		// Pre-define the objects that has influence on movement and gravity
     	miner = new Miner();
		
		//open a level with the level number
		
        Log.d("EmeraldExtrection", "bevore create inputfile" + levelSelection);
        InputStream is = null;
        
        switch (levelSelection) {
        case 1: is = activity.getApplicationContext().getResources().openRawResource(R.raw.level1);
        	break;
        case 2: is = activity.getApplicationContext().getResources().openRawResource(R.raw.level2);
        	break;
        case 3: is = activity.getApplicationContext().getResources().openRawResource(R.raw.level3);
    		break;
        case 4: is = activity.getApplicationContext().getResources().openRawResource(R.raw.level4);
    		break;
        case 5: is = activity.getApplicationContext().getResources().openRawResource(R.raw.level5);
    		break;
        case 6: is = activity.getApplicationContext().getResources().openRawResource(R.raw.level6);
    		break;
        case 7: is = activity.getApplicationContext().getResources().openRawResource(R.raw.level7);
    		break;
        case 8: is = activity.getApplicationContext().getResources().openRawResource(R.raw.level8);
    		break;
        case 9: is = activity.getApplicationContext().getResources().openRawResource(R.raw.level9);
    		break;
        case 10: is = activity.getApplicationContext().getResources().openRawResource(R.raw.level10);
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
        				emeralds.add(new Emerald());
        				board.addGameObject(emeralds.get(emeraldIndex), i, levelRow);
        				emeraldIndex++;
        			}
        			else if (levelColumns[i] == 'd') {
        				
        			}
        			else if (levelColumns[i] == 'f') {
        				stoneMoves.add(new StoneMove());
        				board.addGameObject(stoneMoves.get(stoneMoveIndex), i, levelRow);
        				emeraldIndex++;
        			}
        			else {
        				board.addGameObject(ObjectHelper.getObject(levelColumns[i]), i, levelRow);
        			}
        		}
        		levelRow++;
        	}
        }
        
        
     	//for (int i = 0; i < 5; i++) { emeralds.add(new Emerald()); }
     	//for (int i = 0; i < 10; i++) { stoneMoves.add(new StoneMove()); }
		
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
		gravityCheck();
		
		board.updateView();
	}
	
	public void moveMinerDown(){
		miner.walkDown(board);
		gravityCheck();
		
		board.updateView();
	}
	
	public void moveMinerLeft(){
		miner.walkLeft(board);
		gravityCheck();
		
		board.updateView();
	}
	
	public void moveMinerRight(){
		miner.walkRight(board);
		gravityCheck();
		
		board.updateView();
	}
	
	public void gravityCheck() {
		for (Emerald emerald : emeralds) {
			if (emerald.gravityCheck(board)) {
				emeralds.remove(emerald);
				Log.d("EmeraldExtraction", "Emerald removed");
				Log.d("EmeraldExtraction", "emeralds groote: " + emeralds.size());
			}
		}
		for (StoneMove stoneMove : stoneMoves) {
			stoneMove.gravityCheck(board);
		}
		
		if (emeralds.size() < 1) {
			Log.d("EmeraldExtraction", "Level gewonnen");
			

			final Dialog levelSucces = new Dialog(activity);
			
			levelSucces.requestWindowFeature(Window.FEATURE_NO_TITLE);
			levelSucces.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));
			levelSucces.setContentView(R.layout.levelclearedmenu);
			WindowManager.LayoutParams lp = levelSucces.getWindow().getAttributes();
			lp.dimAmount = 0.7f;
			levelSucces.getWindow().setAttributes(lp);
			
			levelSucces.show();
			
			ImageButton succesRetry = (ImageButton) levelSucces.findViewById(R.id.levelcleared_resetbutton);
			
			succesRetry.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					activity.finish();
					
					Intent intent = new Intent(activity, MainActivity.class);
					intent.putExtra("LEVEL_ID", levelSelection);
					Log.d("setuplevel1button", "start activity with intent level id: "  + levelSelection);
					activity.startActivity(intent);
				}
				
			});
			
			//activity.finish();
		}
	}

}
