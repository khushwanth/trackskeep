package bt.edu.cst.www.trackskeep;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Khushwanth on 13-Feb-18.
 * This java file is the main file to handle the SQLite Database for the App
 */

class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="trackskeep";
    public static final String TABLE_NAME="track";

    public static final String KEY="slno";
    public static final String COL_1="HCI";
    public static final String COL_2="OAD";
    public static final String COL_3="CNS";
    public static final String COL_4="SYP";
    public static final String COL_5="ECO";

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreate="CREATE TABLE "+TABLE_NAME+"("+KEY+" INTEGER PRIMARY KEY,"+COL_1+" TEXT,"+COL_2+" TEXT,"+COL_3+" TEXT,"+COL_4+"            TEXT,"+COL_5+" TEXT"+")";
        db.execSQL(queryCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public boolean insertTrack(int key, String m1,String m2,String m3,String m4,String m5) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(KEY,key);//remove this line if there is an unexpeted error
        contentValues.put(COL_1,m1);
        contentValues.put(COL_2,m2);
        contentValues.put(COL_3,m3);
        contentValues.put(COL_4,m4);
        contentValues.put(COL_5,m5);
        long result=db.insert(TABLE_NAME,null,contentValues);
        db.close();
        if(result==-1)
            return  false;
        else
            return true;
    }

    public boolean updateTrack(int key, String m1,String m2,String m3,String m4,String m5) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(KEY,key);//remove this line if there is an unexpeted error
        contentValues.put(COL_1,m1);
        contentValues.put(COL_2,m2);
        contentValues.put(COL_3,m3);
        contentValues.put(COL_4,m4);
        contentValues.put(COL_5,m5);
        long result=db.update(TABLE_NAME, contentValues, KEY + " = 1", null);
        db.close();
        if(result==-1)
            return  false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("SELECT "+COL_1+","+COL_2+","+COL_3+","+COL_4+","+COL_5+" FROM "+TABLE_NAME+" WHERE "+KEY+"=1",null);
        return res;
    }
}