package nl.voorbeeld.coolgame;

import nl.saxion.act.playground.model.Game;
import nl.saxion.act.playground.model.GameBoard;
import nl.voorbeeld.coolgame.objects.Leaf;
import nl.voorbeeld.coolgame.objects.Rock;
import nl.voorbeeld.coolgame.objects.Wombat;

/**
 * Awesome game for the Speelveld-project.
 * 
 * @author Paul de Groot
 */
public class CoolGame extends Game {
	/** Tag used for log messages */
	public static final String TAG = "CoolGame";

	/** Reference to the main activity, so some labels can be updated. */
	private MainActivity activity;
	
	/** The number of leafs eaten. */
	private int score;
	
	//TEST COMMIT
	//TEST 2

	/**
	 * Constructor.
	 * 
	 * @param activity  The main activity
	 */
	public CoolGame(MainActivity activity) {
		// Create a new game board and couple it to this game
		super(new CoolGameBoard());
		
		// Store reference to the main activity
		this.activity = activity;

		// Reset the game
		initNewGame();

		// Tell the game board view which game board to show
		CoolGameBoardView gameView = activity.getGameBoardView();
		GameBoard gameBoard = getGameBoard();
		gameView.setGameBoard(gameBoard);
		
		// Set size of the view to that of the game board
		gameView.setFixedGridSize(gameBoard.getWidth(), gameBoard.getHeight());
	}

	/**
	 * Starts a new game.
	 * Resets the score and places all objects in the right place.
	 */
	public void initNewGame() {
		// Set the score and update the label
		score = 0;
		activity.updateScoreLabel(score);

		GameBoard board = getGameBoard();
		board.removeAllObjects();

		// Add a player object
		board.addGameObject(new Wombat(), 0, 5);

		// Add some rocks
		board.addGameObject(new Rock(false), 3, 3);
		board.addGameObject(new Rock(false), 2, 7);
		board.addGameObject(new Rock(true),  8, 5);
		board.addGameObject(new Rock(true),  1, 4);
		board.addGameObject(new Rock(false), 6, 10);

		// Add some leafs
		board.addGameObject(new Leaf(), 7, 7);
		board.addGameObject(new Leaf(), 9, 5);
		board.addGameObject(new Leaf(), 3, 6);
		board.addGameObject(new Leaf(), 4, 7);
		board.addGameObject(new Leaf(), 1, 9);

		// Redraw the game view
		board.updateView();
	}

	/**
	 * Called by Wombat if it ate a leaf. Increases the score.
	 */
	public void increaseScore() {
		score++;
		activity.updateScoreLabel(score);
	}
}
