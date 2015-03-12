/** 
 * Het bord van het spel, hier word het bord nog niet getekend.
 * @author Boyd
 */
package nl.noscope.emeraldextraction;


import nl.saxion.act.playground.model.GameBoard;

public class EmeraldExtractionBoard extends GameBoard{



		private static final int GAMEBOARD_WIDTH = 32; 
		private static final int GAMEBOARD_HEIGHT = 20; 

		/**
		 * Create a new game board.
		 */
		public EmeraldExtractionBoard() {
			super(GAMEBOARD_WIDTH, GAMEBOARD_HEIGHT);
		}

		@Override
		public void onEmptyTileClicked(int x, int y) {
			// Doet niks in ons spel
		}
		
		@Override
		public String getBackgroundImg(int mx, int my) {
			return "dirt";
		}
		
	}

