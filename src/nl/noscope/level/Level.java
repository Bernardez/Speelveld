package nl.noscope.level;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import nl.noscope.data.DatabaseOperations;
import nl.saxion.act.playground.model.GameObject;

public class Level {
	private List<int[]> data = new ArrayList<int[]>();
	private int levelNumber;
	private int time;
	private int score;
	
	public Level(List<int[]> data, int levelNumber) {
		this.data = data;
		this.levelNumber = levelNumber;
	}
	
	public Level(List<int[]> data, int levelNumber, int time) {
		this.data = data;
		this.levelNumber = levelNumber;
		this.time = time;
	}
	
	public Level(List<int[]> data, int levelNumber, int time, int score) {
		this.data = data;
		this.levelNumber = levelNumber;
		this.time = time;
		this.score = score;
	}
	
	public List<int[]> getList() {
		return data;
	}
	
	public Level loadLevel(int levelNumber, Context ctx) {
		DatabaseOperations dop = new DatabaseOperations(ctx);
		return dop.getLevel(levelNumber);
	}
}
