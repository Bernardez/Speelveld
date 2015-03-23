package nl.noscope.data;

/**
 * @author Bas
 * Deze code zorgt ervoor dat alles word opgeslagen in de Database.
 */

import java.util.ArrayList;
import java.util.List;

import nl.noscope.data.TableDataLevel.TableInfoLevel;
import nl.noscope.data.TableDataScore.TableInfoScore;
import nl.noscope.level.LevelLoader;
import nl.noscope.level.ObjectHelper;
import nl.saxion.act.playground.model.GameObject;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseOperations extends SQLiteOpenHelper {
	public static final int database_version = 1;
	public String CREATE_QUERY_SCORE = "CREATE TABLE "+TableInfoScore.TABLE_NAME+"("+TableInfoScore.PLAYER_NAME+" TEXT,"+TableInfoScore.PLAYER_SCORE+" INTEGER );";
	//public String CREATE_QUERY_LEVEL = "CREATE TABLE "+TableInfoLevel.TABLE_NAME+"("+TableInfoLevel.LEVEL_NUMBER+ " INTEGER,"+TableInfoLevel.LEVEL_BLOCK_TYPE+" INTEGER,"+ TableInfoLevel.LEVEL_X+" INTEGER,"+TableInfoLevel.LEVEL_Y+" INTEGER );";
	
	public DatabaseOperations(Context context) {
		super(context, TableInfoScore.DATABASE_NAME, null, database_version);
		Log.d("Database operations", "Database created");
	}

	
	@Override
	public void onCreate(SQLiteDatabase sdb) {
		sdb.execSQL(CREATE_QUERY_SCORE);
		//sdb.execSQL(CREATE_QUERY_LEVEL);
		Log.d("Database Operations", "Table created");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
	
	public void addScore(DatabaseOperations dop, String player, int score) {
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(TableInfoScore.PLAYER_NAME, player);
		cv.put(TableInfoScore.PLAYER_SCORE, score);
		long k = SQ.insert(TableInfoScore.TABLE_NAME, null, cv);
		Log.d("Database operations", "One score row inserted");
	}
	
//	public void addLevelPart(DatabaseOperations dop, int levelNumber, int typeId, int x, int y) {
//		if (hasObject(levelNumber, x, y)) {
//			Log.d("Database operations", "Deze bestaat al");
//			return;
//		}
//		
//		//Instanciante variables
//		SQLiteDatabase SQ = dop.getWritableDatabase();
//		ContentValues cv = new ContentValues();
//		cv.put(TableInfoLevel.LEVEL_NUMBER, levelNumber);
//		cv.put(TableInfoLevel.LEVEL_BLOCK_TYPE, typeId);
//		cv.put(TableInfoLevel.LEVEL_X, x);
//		cv.put(TableInfoLevel.LEVEL_Y, y);
//		
//		
//		//Input into database
//		long k = SQ.insert(TableInfoLevel.TABLE_NAME, null, cv);
//		Log.d("Database operations", "One level row inserted");
//	}
	
//	public boolean hasObject(int levelNumber, int x, int y){
//		SQLiteDatabase db = getWritableDatabase();
//		String selectString = "SELECT * FROM " + TableInfoLevel.TABLE_NAME + " WHERE " + TableInfoLevel.LEVEL_NUMBER + " = " + levelNumber + " AND " + TableInfoLevel.LEVEL_X + " = " + x + " AND " + TableInfoLevel.LEVEL_Y + " = " + y;
//		Cursor cursor = db.rawQuery(selectString, null);
//		
//		boolean hasObject = false;
//		if(cursor.moveToFirst()) {
//			hasObject = true;
//		}
//		cursor.close();
//		db.close();
//		return hasObject;
//	}
	
//	public Level getLevel(int levelNumber) {
//		// Getting all GameObjects from level number
//		List<int[]> data = new ArrayList<int[]>();
//		String selectQuery = "SELECT * FROM " + TableInfoLevel.TABLE_NAME + " WHERE " + TableInfoLevel.LEVEL_NUMBER + " = " + levelNumber;
//		
//		SQLiteDatabase db = this.getReadableDatabase();
//		Cursor cursor = db.rawQuery(selectQuery, null);
//		
//		Log.d("Database Operations", "after sql create");
//		
//		// Looping through all rows and adding to list
//		int counter = 0;
//		if (cursor.moveToFirst()) {
//			do {
//				int typeId = cursor.getInt(1);
//				int x = 0; //cursor.getInt(2);
//				int y =  0; //cursor.getInt(3);
//				data.add(new int[] {typeId, x, y});
//				//data.set(counter, new int[] {typeId, x, y});
//				counter++;
//			} while (cursor.moveToNext());
//		}
//		Level level = new Level(data, levelNumber);
//		
//		//SQLiteDatabase SQ = dop.getReadableDatabase();
//		//Cursor CR = SQ.query(TableInfoLevel.TABLE_NAME, columns, null, null, null, null, null);
//	
//		return level;
//	}

}
