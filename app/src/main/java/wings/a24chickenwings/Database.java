package wings.a24chickenwings;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
    public static final String DB_NAME="24Wings.db";
    public static final String TABLE_NAME = "accounts";
    private static final String TABLE2_NAME = "Orders";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "Password";
    public static final String COL_4 ="Email_Address";
    public static final String COL_5 = "Phone";
    public static final String COL_6 = "Address";
    private static final String T2_COL1 = "ID";
    private static final String T2_COL2 = "Orders";

    private static final String TAG = "DatabaseHelper";

    public Database(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Password TEXT,Email_Address TEXT,Phone TEXT,Address TEXT)");
        db.execSQL("CREATE TABLE " + TABLE2_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Orders TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String Query = "DROP TABLE IF EXISTS " +TABLE_NAME;
        db.execSQL(Query);
        onCreate(db);
        Query = "DROP TABLE IF EXISTS " +TABLE2_NAME;
        db.execSQL(Query);
        onCreate(db);
    }

    public void addData(String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(T2_COL2, item);
        long result = db.insert(TABLE2_NAME, T2_COL2, contentValues);
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE2_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getItemID(String items){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + T2_COL1 + " FROM " + TABLE2_NAME +
                " WHERE " + T2_COL2 + " = '" + items + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void delete(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE2_NAME);
    }
}