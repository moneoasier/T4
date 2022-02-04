package Data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class GameDBhelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "doodleDB.db";

    public GameDBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + GameDataStructure.GameDataColums.TABLE_NAME + " ("
                + GameDataStructure.GameDataColums._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + GameDataStructure.GameDataColums.PUNTUAZIOA + " INT,"
                + GameDataStructure.GameDataColums.DATA + " TEXT,"
                + GameDataStructure.GameDataColums.EMPLOYEEID + " TEXT,"
                + GameDataStructure.GameDataColums.ADINA + " INT,"
                + GameDataStructure.GameDataColums.DEPARTAMENDUA + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public long saveHighscore(Highscore highscore){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                GameDataStructure.GameDataColums.TABLE_NAME,null,new Highscore(highscore.getPoints(),highscore.getPlayerID(),highscore.getAge(),highscore.getDepartment()).toContentValues());

    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    public Cursor getData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from puntuazioa_offline", null);
        return cursor;
    }

    public void deleteLine(String IDtoDelete){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from puntuazioa_offline where _id=?",new String[] {IDtoDelete});
        if(cursor.getCount() > 0){
            long result = sqLiteDatabase.delete("puntuazioa_offline", "where _id=?",new String[] {IDtoDelete});
        }
    }
}
