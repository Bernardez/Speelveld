package nl.voorbeeld.coolgame;

import nl.saxion.act.playground.model.GameBoard;

/**
 * The game board for CoolGame.
 * 
 * @author Paul de Groot
 */
public class CoolGameBoard extends GameBoard {
	private static final int GAMEBOARD_WIDTH = 35;
	private static final int GAMEBOARD_HEIGHT = 20;

	/**
	 * Create a new game board.
	 */
	public CoolGameBoard() {
		super(GAMEBOARD_WIDTH, GAMEBOARD_HEIGHT);
	}

	@Override
	public void onEmptyTileClicked(int x, int y) {
		// Nothing to do in this game.
	}
	
	@Override
	public String getBackgroundImg(int mx, int my) {
		return null;
	}
	
}
