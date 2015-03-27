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
	

	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {
		return MINER_IMAGE;
	}

	public void walkLeft(GameBoard gameBoard) {

		int newPosX = getPositionX() - 1;
		int newPosY = getPositionY();

		StateCheck(newPosX, newPosY, gameBoard, 1);
		
	}

	public void walkRight(GameBoard gameBoard) {

		int newPosX = getPositionX() + 1;
		int newPosY = getPositionY();
		StateCheck(newPosX, newPosY, gameBoard, 2);
	}

	public void walkUp(GameBoard gameBoard) {

		int newPosX = getPositionX();
		int newPosY = getPositionY() - 1;

		StateCheck(newPosX, newPosY, gameBoard, 3);
	}

	public void walkDown(GameBoard gameBoard) {

		int newPosX = getPositionX();
		int newPosY = getPositionY() + 1;
		
		StateCheck(newPosX, newPosY, gameBoard, 4);
	
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
