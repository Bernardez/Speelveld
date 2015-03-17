package nl.noscope.emeraldextraction;

import nl.saxion.act.playground.model.Game;
import nl.saxion.act.playground.model.GameBoard;
import nl.voorbeeld.coolgame.CoolGameBoardView;
import nl.voorbeeld.coolgame.objects.Leaf;
import nl.voorbeeld.coolgame.objects.Rock;
import nl.voorbeeld.coolgame.objects.Wombat;
import nl.noscope.emeraldextraction.MainActivity;
import nl.noscope.emeraldextraction.objects.Hanz;

public class EmeraldExtraction extends Game {
	
	MainActivity activity;

	public EmeraldExtraction(MainActivity mainActivity) {
		// Maakt een nieuw spelbord aan
		super(new EmeraldExtractionBoard());
		// werkt dit
		// Zet de activity in het spel
		this.activity = mainActivity;
		
		// Reset the game
		initNewGame();

		// Tell the game board view which game board to show
		EmeraldExtractionBoardView gameView = activity.getGameBoardView();
		GameBoard gameBoard = getGameBoard();
		gameView.setGameBoard(gameBoard);
				
		// Set size of the view to that of the game board
		gameView.setFixedGridSize(gameBoard.getWidth(), gameBoard.getHeight());
		
		
	}

	private void initNewGame() {

			
		GameBoard board = getGameBoard();
		board.removeAllObjects();

		// Add a player object
		board.addGameObject(new Hanz(), 0, 5);

		// Redraw the game view
		board.updateView();
		
	}
	
	

}
