package nl.noscope.data;

import android.provider.BaseColumns;

public class TableData {
	
	public TableData()
	{
		
	}
	
	public static abstract class TableInfo implements BaseColumns
	{
		
		public static final String PLAYER_NAME = "player_name";
		public static final String PLAYER_SCORE = "player_score";
		public static final String DATABASE_NAME = "game_info";
		public static final String TABLE_NAME = "game_scores";
	}
}
