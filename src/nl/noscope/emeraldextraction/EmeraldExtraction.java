package nl.noscope.emeraldextraction;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import nl.noscope.data.DatabaseOperations;
import nl.noscope.emeraldextraction.objects.Emerald;
import nl.noscope.emeraldextraction.objects.Miner;
import nl.noscope.emeraldextraction.objects.StoneMove;
import nl.noscope.level.ObjectHelper;
import nl.saxion.act.playground.R;
import nl.saxion.act.playground.model.Game;
import nl.saxion.act.playground.model.GameBoard;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Emerald Extraction
 * Informatie houder van het spelbord.
 * Bijzondere GameObjecten worden ook bijgehouden. (Emeralds, stonemove, miner)
 * 
 * @author Boyd
 */
public class EmeraldExtraction extends Game {

	/** Reference to the main activity, so some labels can be updated. */
	private MainActivity activity;

	/** Maakt een miner aan */
	private Miner miner;

	/** Maakt een emerald lijst aan */
	private ArrayList<Emerald> emeralds = new ArrayList<Emerald>();

	/**
	 * Index die gebruikt wordt bij het toevoegen van emeralds aan het game
	 * board
	 */
	private int emeraldIndex;

	/** Maakt een emerald lijst aan */
	private ArrayList<StoneMove> stoneMoves = new ArrayList<StoneMove>();

	/**
	 * Index die gebruikt wordt bij het toevoegen van emeralds aan het game
	 * board
	 */
	private int stoneMoveIndex;

	/** Maakt een board aan */
	GameBoard board;

	/** Houd het level bij */
	int levelSelection;
	
	/** Houd een score bij */
	Score score = new Score(0,0);
	
	/** Maakt een textview scorelabel aan */
	TextView scoreLabel;
	
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
		
		

		// Get level selection from intent
		Intent intent = this.activity.getIntent();
		levelSelection = intent.getIntExtra("LEVEL_ID", 1);
		Log.d("EmeraldExtracion", "Level id levelSelection int = " + levelSelection);
		
		score.setLevelNumber(levelSelection);

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
	 * Starts a new game. Reset the board. Create miner object.
	 * Load Level from resources.
	 * Scan level resources to fill in the GameBoard with objects.
	 * 
	 */

	public void initNewGame(MainActivity activity, int levelSelection) {
		// Reset the GameBoard. Remove all its objects
		board = getGameBoard();
		board.removeAllObjects();
		// Pre-define the objects that has influence on movement and gravity
		miner = new Miner();

		// open a level with the level number
		InputStream is = null;

		switch (levelSelection) {
		case 1:	is = activity.getApplicationContext().getResources().openRawResource(R.raw.level1);
			break;
		case 2:	is = activity.getApplicationContext().getResources().openRawResource(R.raw.level2);
			break;
		case 3:	is = activity.getApplicationContext().getResources().openRawResource(R.raw.level3);
			break;
		case 4:	is = activity.getApplicationContext().getResources().openRawResource(R.raw.level4);
			break;
		case 5:	is = activity.getApplicationContext().getResources().openRawResource(R.raw.level5);
			break;
		case 6:	is = activity.getApplicationContext().getResources().openRawResource(R.raw.level6);
			break;
		case 7:	is = activity.getApplicationContext().getResources().openRawResource(R.raw.level7);
			break;
		case 8:	is = activity.getApplicationContext().getResources().openRawResource(R.raw.level8);
			break;
		case 9:	is = activity.getApplicationContext().getResources().openRawResource(R.raw.level9);
			break;
		case 10: is = activity.getApplicationContext().getResources().openRawResource(R.raw.level10);
			break;
		}
		Log.d("EmeraldExtrection", "Inputfile created");

		// Convert level resouce to String
		String fileLevel = "";
		try {
			fileLevel = convertStreamToString(is);
		} catch (Exception e) {
			e.printStackTrace();
			Log.d("EmeraldExtraction", "convertStreamToString Exception");
		}

		Scanner in = new Scanner(fileLevel);
		int levelRow = 0;
		
		// Read the Level String until its done
		while (in.hasNext()) {
			String line = in.nextLine();
			
			// Regels die beginnen met een * worden niet ingelezen
			if (!line.startsWith("*")) {
				char[] levelColumns = line.toCharArray();
				for (int i = 0; i < levelColumns.length; i++) {
					
					if (levelColumns[i] == 'n') {
						
						// Gebruikt het eerder aangemaakte Miner object en
						// stopt het op de jusite positie in het Game Board
						board.addGameObject(miner, i, levelRow);
					} else if (levelColumns[i] == 'e') {
						
						// Stopt een nieuw Emerald object in de lijst van
						// Emeralds en plaats dezelfde emerald op het bord.
						emeralds.add(new Emerald());
						Log.d("EmeraldExtraction", "emeraldIndex : "
								+ emeraldIndex);
						board.addGameObject(emeralds.get(emeraldIndex), i,
								levelRow);
						emeraldIndex++;
					} else if (levelColumns[i] == 'd') {
						
						// Voeg niks toe als het een 'd' Doorgang is
					} else if (levelColumns[i] == 'f') {
						
						// Stopt een nieuw StoneMove object in de lijst van
						// StoneMoves en plaats dezelfde StoneMove op het bord.
						stoneMoves.add(new StoneMove());
						board.addGameObject(stoneMoves.get(stoneMoveIndex), i,
								levelRow);
						stoneMoveIndex++;
					} else {
						
						// Voor alle andere letters, gebruik de ObjectHelper
						// Class voor het toevoegen van een GameObject m.b.v. een letter.
						board.addGameObject(
								ObjectHelper.getObject(levelColumns[i]), i,
								levelRow);
					}
				}
				levelRow++;
			}
		}
		
		in.close();
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

	public void moveMinerUp() {
		miner.walkUp(board);
		gameProgressCheck();
		board.updateView();
	}

	public void moveMinerDown() {
		miner.walkDown(board);
		gameProgressCheck();
		board.updateView();
	}

	public void moveMinerLeft() {
		miner.walkLeft(board);
		gameProgressCheck();
		board.updateView();
	}

	public void moveMinerRight() {
		miner.walkRight(board);
		gameProgressCheck();
		board.updateView();
	}

	public void gameProgressCheck() {
		score.setScore(score.getScore() + 1);
		Log.d("Score", "De score is: " + score.getScore());
		
		// Sla de nieuwe score ook op in de lavel op het scherm
		TextView scoreLabel = (TextView) this.activity.findViewById(R.id.scoreLabel);
		scoreLabel.setText(String.valueOf(score.getScore()));
		
		int emeraldToRemove = -1;
		
		// Start de methode gravityCheck van Emerald.
		// Delete de emerald als gravityCheck true returnt.
		for (Emerald emerald : emeralds) {
			if (emerald != null) {
				if (emerald.gravityCheck(board)) {
					emeraldToRemove = emeralds.indexOf(emerald);
				}
			}
		}
		if (emeraldToRemove >= 0) {
			emeralds.remove(emeraldToRemove);
		}
		
		// Start de methode gravitiyCheck van StoneMove
		for (StoneMove stoneMove : stoneMoves) {
			if (stoneMove != null) {
				stoneMove.gravityCheck(board);
			}
		}

		// Het level is voltooid als er geen emeralds meer bestaan.
		if (emeralds.size() < 1) {
			levelCleared();
		}
	}

	public void levelCleared() {
		Log.d("EmeraldExtraction", "Level gewonnen");

		// Zet in de database dat dit level is voltooid
		DatabaseOperations DOP = new DatabaseOperations(
				activity.getApplicationContext());
		DOP.levelComplete(DOP, levelSelection);
		
		// Zet in de database de score wat gehaald is bij dit level
		DOP.addScore(DOP, levelSelection, score.getScore());
		Log.d("EmeraldExtraction", "Score: " + score.getScore() + " Toegevoegd");
		
		
		Log.d("EmeraldExtraction", "highscore is: " + DOP.getHighscore(DOP, levelSelection));

		
		// Open een dialoog voor het opnieuw starten, volgende
		// level of terug gaan naar Level Selection menu
		final Dialog levelSucces = new Dialog(activity,
				android.R.style.Theme_Light_NoTitleBar_Fullscreen);

		levelSucces.requestWindowFeature(Window.FEATURE_NO_TITLE);

		levelSucces.getWindow().setBackgroundDrawable(
				new ColorDrawable(android.graphics.Color.TRANSPARENT));
		levelSucces.setContentView(R.layout.levelclearedmenu);
		WindowManager.LayoutParams lp = levelSucces.getWindow().getAttributes();
		lp.dimAmount = 0.7f;
		levelSucces.getWindow().setAttributes(lp);

		levelSucces.show();

		ImageButton succesSelection = (ImageButton) levelSucces
				.findViewById(R.id.levelcleared_tomenubutton);
		ImageButton succesRetry = (ImageButton) levelSucces
				.findViewById(R.id.levelcleared_resetbutton);
		ImageButton succesAdvance = (ImageButton) levelSucces
				.findViewById(R.id.levelcleared_nextlevelbutton);
		
		TextView scoreText = (TextView) levelSucces.findViewById(R.id.score);
		TextView highScoreText = (TextView) levelSucces.findViewById(R.id.highScore);
		
		// Voeg de scores toe aan het dialoog
		scoreText.setText(String.valueOf(score.getScore()));
		try {
			highScoreText.setText(String.valueOf(DOP.getHighscore(DOP, levelSelection)));
		} catch (Exception ex) {
			highScoreText.setText("");
		}

		succesSelection.setOnClickListener(new OnClickListener() {
			// Ga terug naar Level Selection
			@Override
			public void onClick(View v) {
				activity.finish();
			}

		});

		succesRetry.setOnClickListener(new OnClickListener() {
			// Herstart dit level. Geef een intent mee met dit level nummer
			@Override
			public void onClick(View v) {
				activity.finish();

				Intent intent = new Intent(activity, MainActivity.class);
				intent.putExtra("LEVEL_ID", levelSelection);
				Log.d("setuplevel1button",
						"start activity with intent level id: "
								+ levelSelection);
				activity.startActivity(intent);
			}

		});

		succesAdvance.setOnClickListener(new OnClickListener() {
			// Start het volgende level. Geef een intent mee met het volgende level
			@Override
			public void onClick(View v) {
				activity.finish();

				Intent intent = new Intent(activity, MainActivity.class);
				intent.putExtra("LEVEL_ID", levelSelection + 1);
				Log.d("setuplevel1button",
						"start activity with intent level id: "
								+ levelSelection + 1);
				activity.startActivity(intent);
			}

		});
	}

}
