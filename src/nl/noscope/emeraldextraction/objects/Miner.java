package nl.noscope.emeraldextraction.objects;

import android.util.Log;
import nl.saxion.act.playground.model.GameBoard;
import nl.saxion.act.playground.model.GameObject;

/**
 * De miner is ons speler object, deze verplaatst zich dan ook steeds
 * 
 * @author Boyd
 */
public class Miner extends GameObject {
	public static final String MINER_IMAGE = "miner";
	public static final String MINER_UP = "up";
	public static final String MINER_DOWN = "down";
	public static final String MINER_LEFT = "links";
	public static final String MINER_RIGHT = "rechts";
	
	int position = 0;
	

	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {
		if (position == 1) {
			return MINER_LEFT;	
		}  else if (position == 2) {
			return MINER_RIGHT;	
		}  else if (position == 3) {
			return MINER_UP;	
		} else if (position == 4) {
			return MINER_DOWN;	
		} else {
			return MINER_IMAGE;
		}
	}
	
	

	public void walkLeft(GameBoard gameBoard) {
		
		position = 1;

		int newPosX = getPositionX() - 1;
		int newPosY = getPositionY();

		StateCheck(newPosX, newPosY, gameBoard, position);
		
	}

	public void walkRight(GameBoard gameBoard) {

		position = 2;
		
		int newPosX = getPositionX() + 1;
		int newPosY = getPositionY();
		StateCheck(newPosX, newPosY, gameBoard, position);
	}

	public void walkUp(GameBoard gameBoard) {

		position = 3;
		
		int newPosX = getPositionX();
		int newPosY = getPositionY() - 1;

		StateCheck(newPosX, newPosY, gameBoard, position);
	}

	public void walkDown(GameBoard gameBoard) {

		position = 4;
		
		int newPosX = getPositionX();
		int newPosY = getPositionY() + 1;
		
		StateCheck(newPosX, newPosY, gameBoard, position);
	
	}

	private void StateCheck(int newPosX, int newPosY, GameBoard gameBoard, int direction) {
		// Als de nieuwe positie naast het bord is doet hij niks
		if (newPosX >= gameBoard.getWidth() - 1 || newPosX == 0) {
			return;
		} else if (newPosY >= gameBoard.getHeight() - 1 || newPosY == 0){
			return;
		}
		
		// Kijk of er een object is op het nieuwe punt
		GameObject objectAtNewPos = gameBoard.getObject(newPosX, newPosY);
		if (objectAtNewPos != null) {

			// Miner kan niet door een aantal objecten heen
			if (objectAtNewPos instanceof Stone) {
				return;
			}
			if (objectAtNewPos instanceof Iron) {
				return;
			}
			if (objectAtNewPos instanceof Minecart) {
				return;
			}

			if (objectAtNewPos instanceof Emerald) {
				// Je kan een emerald niet naar beneden drukken
				if (direction == 4) { return; }
				// Duw de emerald omhoog als er vrije ruimte boven is
				if (direction == 3) {
					if (gameBoard.getObject(newPosX, newPosY - 1) == null) {
						gameBoard.moveObject(objectAtNewPos, newPosX, newPosY - 1);
					}
					else { return; }
				}
				// Duw de emerald naar links als er vrije ruimte links van de emerald is
				if (direction == 1) {
					if (gameBoard.getObject(newPosX - 1, newPosY) == null) {
						gameBoard.moveObject(objectAtNewPos, newPosX -1, newPosY);
					}
					else { return; }
				}
				// Duw de emerald naar rechts als er vrije ruimte rechts van de emerald is
				if (direction == 2) {
					if (gameBoard.getObject(newPosX + 1, newPosY) == null) {
						gameBoard.moveObject(objectAtNewPos, newPosX + 1, newPosY);
					}
					else { return ; }
				}
			}
			if (objectAtNewPos instanceof StoneMove) {
				// Je kan een emerald niet naar beneden drukken
				if (direction == 4) { return; }
				// Duw de emerald omhoog als er vrije ruimte boven is
				if (direction == 3) {
					if (gameBoard.getObject(newPosX, newPosY - 1) == null) {
						gameBoard.moveObject(objectAtNewPos, newPosX, newPosY - 1);
					}
					else { return; }
				}
				// Duw de emerald naar links als er vrije ruimte links van de emerald is
				if (direction == 1) {
					if (gameBoard.getObject(newPosX - 1, newPosY) == null) {
						gameBoard.moveObject(objectAtNewPos, newPosX -1, newPosY);
					}
					else { return; }
				}
				// Duw de emerald naar rechts als er vrije ruimte rechts van de emerald is
				if (direction == 2) {
					if (gameBoard.getObject(newPosX + 1, newPosY) == null) {
						gameBoard.moveObject(objectAtNewPos, newPosX + 1, newPosY);
					}
					else { return ; }
				}
			}
			
			if (objectAtNewPos instanceof Sand) {
				gameBoard.removeObject(objectAtNewPos);

			}
		}

		// Verplaats de miner naar zijn nieuwe positie
		Log.d("Miner", "Ik verplaats nu de miner");
		gameBoard.moveObject(this, newPosX, newPosY);
		gameBoard.updateView();
		Log.d("Miner", "Miner verplaatst");
		
	}

	@Override
	public void onTouched(GameBoard gameBoard) {
		// TODO Auto-generated method stub

	}
}
