package nl.noscope.data;

/**
 * @author Bas
 * Deze code zorgt ervoor dat alles word opgeslagen in de Database.
 */

import nl.noscope.data.TableData.TableInfo;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseOperations extends SQLiteOpenHelper {
	public static final int database_version = 1;
	public String CREATE_QUERY = "CREATE TABLE "+TableInfo.TABLE_NAME+"("+TableInfo.PLAYER_NAME+" TEXT,"+TableInfo.PLAYER_SCORE+"INTEGER );";
	
	public DatabaseOperations(Context context) {
		super(context, TableInfo.DATABASE_NAME, null, database_version);
		Log.d("Database operations", "Database created");
	}

	
	@Override
	public void onCreate(SQLiteDatabase sdb) {
		sdb.execSQL(CREATE_QUERY);
		Log.d("Database Operations", "Table created");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
	
	public void addScore(DatabaseOperations dop, String player, int score) {
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(TableInfo.PLAYER_NAME, player);
		cv.put(TableInfo.PLAYER_SCORE, score);
		long k = SQ.insert(TableInfo.TABLE_NAME, null, cv);
		Log.d("Database operations", "One row inserted");
	}

}
