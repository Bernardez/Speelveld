package nl.noscope.data;

import android.provider.BaseColumns;

public class TableDataLevel {
	
	public TableDataLevel()
	{
		
	}
	
	public static abstract class TableInfoLevel implements BaseColumns
	{
		
		public static final String LEVEL_NUMBER = "level_number";
		public static final String LEVEL_BLOCK_TYPE = "level_block_type";
		public static final String LEVEL_X = "level_x";
		public static final String LEVEL_Y = "level_y";
		public static final String DATABASE_NAME = "game_info";
		public static final String TABLE_NAME = "game_level";
	}
}
