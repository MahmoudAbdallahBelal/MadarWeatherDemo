package mab.belal.madarweatherdemo.data.local.sqlLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;

import mab.belal.madarweatherdemo.data.models.local.city.CityAttributes;

import static mab.belal.madarweatherdemo.data.local.sqlLite.ItemContract.ItemEntry.TABLE_NAME;


public class ItemDbHelper  extends SQLiteOpenHelper {

    // The name of the database
    private static final String DATABASE_NAME = "Weather.db";

    // If you change the database schema, you must increment the database version
    private static final int VERSION = 1;


    // Constructor
    public ItemDbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }


    /**
     * Called when the items database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create items table (careful to follow SQL formatting rules)
        final String CREATE_TABLE = "CREATE TABLE "  + TABLE_NAME + " (" +
                ItemContract.ItemEntry._ID                + " INTEGER PRIMARY KEY, " +
                ItemContract.ItemEntry.COLUMN_CITY_NAME + " TEXT NOT NULL, " +
                ItemContract.ItemEntry.COLUMN_CITY_LAT + " TEXT NOT NULL, " +
                ItemContract.ItemEntry.COLUMN_CITY_LON    + " TEXT NOT NULL, " +
                ItemContract.ItemEntry.COLUMN_CITY_Temp + " TEXT NOT NULL);";

        db.execSQL(CREATE_TABLE);
    }

    public void saveCities(List<CityAttributes> items) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (CityAttributes item : items) {
                values.put(ItemContract.ItemEntry.COLUMN_CITY_NAME, item.getName());
                values.put(ItemContract.ItemEntry.COLUMN_CITY_LAT, item.getLat());
                values.put(ItemContract.ItemEntry.COLUMN_CITY_LON, item.getLon());
                values.put(ItemContract.ItemEntry.COLUMN_CITY_Temp, item.getTemp());
                db.insert(TABLE_NAME, null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    public ArrayList<CityAttributes>  getAllCities() {
        ArrayList<CityAttributes> items = new ArrayList<>();
        // Get access to underlying database (read-only for query)
        final SQLiteDatabase db = this.getReadableDatabase();

        Cursor retCursor;
        retCursor =  db.query(TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);


        if(retCursor!=null){
            while (retCursor.moveToNext()) {
                CityAttributes item = new CityAttributes();
                item.setId(retCursor.getInt(retCursor.getColumnIndex(ItemContract.ItemEntry._ID)));
                item.setName( retCursor.getString(retCursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_CITY_NAME)));
                item.setLat( retCursor.getString(retCursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_CITY_LAT)));
                item.setLon( retCursor.getString(retCursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_CITY_LON)));
                item.setTemp( retCursor.getString(retCursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_CITY_Temp)));
                items.add(item);
            }
        }

        db.close();


        return  items;

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void deleteSavedData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from  " + TABLE_NAME);
        db.close();
    }
}