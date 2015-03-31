package nl.noscope.data;

import android.provider.BaseColumns;

public class TableDataProgress {
	
	public TableDataProgress()
	{
		
	}
	
	public static abstract class TableInfoProgress implements BaseColumns
	{
		
		public static final String LEVEL_NUMBER = "level_number";
		public static final String LEVEL_COMPLETED = "level_completed";
		public static final String DATABASE_NAME = "game_info";
		public static final String TABLE_NAME = "game_progress";
	}
}
