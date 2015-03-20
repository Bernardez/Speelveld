package nl.noscope.emeraldextraction.objects;

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

	public void walkLeft(GameBoard gameBoard){

		int newPosX = getPositionX() - 1;
		int newPosY = getPositionY();

		// Als de nieuwe positie naast het bord is doet hij niks
		if (newPosX >= gameBoard.getWidth() - 1) {
			return;
		}

		// Kijk of er een object is op het nieuwe punt
		GameObject objectAtNewPos = gameBoard.getObject(newPosX, newPosY);
		if (objectAtNewPos != null) {

			// Miner kan niet door steen heen;
			if (objectAtNewPos instanceof Stone) {
				return;
			}

			if (objectAtNewPos instanceof Emerald) {
				gameBoard.removeObject(objectAtNewPos);

			}
			if (objectAtNewPos instanceof Sand) {
				gameBoard.removeObject(objectAtNewPos);

			}
		}

		// Verplaats de miner naar zijn nieuwe positie
		gameBoard.moveObject(this, newPosX, newPosY);
		gameBoard.updateView();
	}
	
	
	public void walkRight(GameBoard gameBoard){

		int newPosX = getPositionX() + 1;
		int newPosY = getPositionY();

		// Als de nieuwe positie naast het bord is doet hij niks
		if (newPosX >= gameBoard.getWidth() - 1) {
			return;
		}

		// Kijk of er een object is op het nieuwe punt
		GameObject objectAtNewPos = gameBoard.getObject(newPosX, newPosY);
		if (objectAtNewPos != null) {

			// Miner kan niet door steen heen;
			if (objectAtNewPos instanceof Stone) {
				return;
			}

			if (objectAtNewPos instanceof Emerald) {
				gameBoard.removeObject(objectAtNewPos);

			}
			if (objectAtNewPos instanceof Sand) {
				gameBoard.removeObject(objectAtNewPos);

			}
		}

		// Verplaats de miner naar zijn nieuwe positie
		gameBoard.moveObject(this, newPosX, newPosY);
		gameBoard.updateView();
	}
	
	public void walkUp(GameBoard gameBoard){

		int newPosX = getPositionX();
		int newPosY = getPositionY() - 1;

		// Als de nieuwe positie naast het bord is doet hij niks
		if (newPosX >= gameBoard.getWidth() - 1) {
			return;
		}

		// Kijk of er een object is op het nieuwe punt
		GameObject objectAtNewPos = gameBoard.getObject(newPosX, newPosY);
		if (objectAtNewPos != null) {

			// Miner kan niet door steen heen;
			if (objectAtNewPos instanceof Stone) {
				return;
			}

			if (objectAtNewPos instanceof Emerald) {
				gameBoard.removeObject(objectAtNewPos);

			}
			if (objectAtNewPos instanceof Sand) {
				gameBoard.removeObject(objectAtNewPos);

			}
		}

		// Verplaats de miner naar zijn nieuwe positie
		gameBoard.moveObject(this, newPosX, newPosY);
		gameBoard.updateView();
	}

	public void walkDown(GameBoard gameBoard) {

		int newPosX = getPositionX();
		int newPosY = getPositionY() + 1;

		// Als de nieuwe positie naast het bord is doet hij niks
		if (newPosX >= gameBoard.getWidth() - 1) {
			return;
		}

		// Kijk of er een object is op het nieuwe punt
		GameObject objectAtNewPos = gameBoard.getObject(newPosX, newPosY);
		if (objectAtNewPos != null) {

			// Miner kan niet door steen heen;
			if (objectAtNewPos instanceof Stone) {
				return;
			}

			if (objectAtNewPos instanceof Emerald) {
				gameBoard.removeObject(objectAtNewPos);

			}
			if (objectAtNewPos instanceof Sand) {
				gameBoard.removeObject(objectAtNewPos);

			}
		}

		// Verplaats de miner naar zijn nieuwe positie
		gameBoard.moveObject(this, newPosX, newPosY);
		gameBoard.updateView();
		
	}

	@Override
	public void onTouched(GameBoard gameBoard) {
		// TODO Auto-generated method stub
		
	}
}

	

