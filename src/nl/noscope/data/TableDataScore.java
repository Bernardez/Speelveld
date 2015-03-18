package nl.noscope.data;

import android.provider.BaseColumns;

public class TableDataScore {
	
	public TableDataScore()
	{
		
	}
	
	public static abstract class TableInfoScore implements BaseColumns
	{
		
		public static final String PLAYER_NAME = "player_name";
		public static final String PLAYER_SCORE = "player_score";
		public static final String DATABASE_NAME = "game_info";
		public static final String TABLE_NAME = "game_scores";
	}
}
