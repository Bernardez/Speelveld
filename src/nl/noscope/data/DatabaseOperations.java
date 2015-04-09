package nl.noscope.data;

/**
 * @author Bas
 * Deze code zorgt ervoor dat alles word opgeslagen in de Database.
 */

import nl.noscope.data.TableDataProgress.TableInfoProgress;
import nl.noscope.data.TableDataScore.TableInfoScore;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseOperations extends SQLiteOpenHelper {
	public static final int database_version = 1;
	public String CREATE_QUERY_SCORE = "CREATE TABLE "+TableInfoScore.TABLE_NAME+"("+TableInfoScore.PLAYER_NAME+" TEXT,"+TableInfoScore.PLAYER_SCORE+" INTEGER );";
	public String CREATE_QUERY_PROGRESS = "CREATE TABLE "+TableInfoProgress.TABLE_NAME+"("+TableInfoProgress.LEVEL_NUMBER+" INTEGER PRIMARY KEY,"+TableInfoProgress.LEVEL_COMPLETED+" INTEGER );";
	
	public DatabaseOperations(Context context) {
		super(context, TableInfoScore.DATABASE_NAME, null, database_version);
		Log.d("Database operations", "Database created");
	}

	
	@Override
	public void onCreate(SQLiteDatabase sdb) {
		sdb.execSQL(CREATE_QUERY_SCORE);
		sdb.execSQL(CREATE_QUERY_PROGRESS);
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
	
	public void levelComplete(DatabaseOperations dop, int levelNumber) {
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(TableInfoProgress.LEVEL_NUMBER, levelNumber);
		cv.put(TableInfoProgress.LEVEL_COMPLETED, 1);

		long k = SQ.update(TableInfoProgress.TABLE_NAME, cv, TableInfoProgress.LEVEL_NUMBER+" = " + levelNumber, null);
		//long k = SQ.insert(TableInfoProgress.TABLE_NAME, null, cv);
		Log.d("Database Operations", "Level " + levelNumber + " is now saved as 1 in the database");
	}
	
	public int[] completedLevels(DatabaseOperations dop) {
		SQLiteDatabase SQ = dop.getReadableDatabase();
		
		String[] projection = {
				TableInfoProgress.LEVEL_NUMBER,
				TableInfoProgress.LEVEL_COMPLETED
		};
		
		Cursor c = SQ.query(
				TableInfoProgress.TABLE_NAME,
				projection,
				TableInfoProgress.LEVEL_COMPLETED+" = 1", null, null, null, null
				);
		
		int[] levels = new int[c.getCount()];
		int i = 0;
		
		c.moveToFirst();
		Log.d("Database Operations", "Before loop");
		while (c.isAfterLast() == false) {
			levels[i] = c.getInt(0);
			i++;
			c.moveToNext();
		}
		Log.d("Database Operations", "after loop");
		return levels;
	}
	
	public void appendNonExistingLevels(DatabaseOperations dop) {
		SQLiteDatabase SQ = dop.getReadableDatabase();
		String[] projection = {
				TableInfoProgress.LEVEL_NUMBER,
		};
		
		for (int i = 1; i <=10; i++){
			Cursor c = SQ.query(
					TableInfoProgress.TABLE_NAME,
					projection,
					TableInfoProgress.LEVEL_NUMBER+" = "+ i, null, null, null, null
					);
			
			if (!(c.moveToFirst()) || c.getCount() ==0){
				ContentValues cv = new ContentValues();
				cv.put(TableInfoProgress.LEVEL_NUMBER, i);
				cv.put(TableInfoProgress.LEVEL_COMPLETED, 0);
				
				long k = SQ.insert(TableInfoProgress.TABLE_NAME, null, cv);
				Log.d("Database Operations", "Level " + i + " added as non completed");
			}
		}
	}
	
	

}
