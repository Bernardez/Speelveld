package nl.noscope.level;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import nl.noscope.data.DatabaseOperations;
import nl.saxion.act.playground.model.GameObject;

public class LevelLoader {
	private List<int[]> data = new ArrayList<int[]>();
	private int levelNumber;
	private int time;
	private int score;
	
	public LevelLoader(int levelNumber) {
		this.levelNumber = levelNumber;
		loadLevel();
	}
	
	public LevelLoader(int levelNumber, int time) {
		this.levelNumber = levelNumber;
		this.time = time;
		loadLevel();
	}
	
	public LevelLoader(int levelNumber, int time, int score) {
		this.levelNumber = levelNumber;
		this.time = time;
		this.score = score;
		loadLevel();
	}
	
	public void loadLevel() {
		if (levelNumber == 1) {
			Level1 level1 = new Level1();
			this.data = level1.getData();
		}
	}
	
	public List<int[]> getData() {
		return this.data;
	}
	
	public int getLevelNumber() {
		return this.levelNumber;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public int getScore() {
		return this.score;
	}
	
	//public List<int[]> getList() {
	//	return data;
	//}
	
//	public Level loadLevel(int levelNumber, Context ctx) {
//		DatabaseOperations dop = new DatabaseOperations(ctx);
//		return dop.getLevel(levelNumber);
//	}
}
