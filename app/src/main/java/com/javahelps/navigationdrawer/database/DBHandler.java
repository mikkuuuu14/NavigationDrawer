package com.javahelps.navigationdrawer.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.javahelps.navigationdrawer.models.Disease;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "diseases";
    // Contacts table name
    private static final String TABLE_DISEASE = "disease";

    // Disease Table Columns names
    private static final String KEY_ID = "id";

    private static final String KEY_NAME = "name";

    private static final String KEY_DESCRIPTION = "description";

    private static final String KEY_SYMPTOMS = "symptoms";

    private static final String KEY_PREVENTION = "prevention";

    private static final String KEY_MEDICINE = "medicine";

    private static final String KEY_ICON = "icon";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_DISEASE_TABLE = "CREATE TABLE " + TABLE_DISEASE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_DESCRIPTION + " TEXT," + KEY_SYMPTOMS + " TEXT," + KEY_PREVENTION + " TEXT,"
                + KEY_MEDICINE + " TEXT," + KEY_ICON + " INTEGER" + ")";

        db.execSQL(CREATE_DISEASE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_DISEASE);
        // Creating tables again
        onCreate(db);
    }

    // Adding new disease
    public void addDisease(Disease disease) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, disease.getName());
        values.put(KEY_DESCRIPTION, disease.getDescription());
        values.put(KEY_SYMPTOMS, disease.getSymptoms());
        values.put(KEY_PREVENTION, disease.getPrevention());
        values.put(KEY_MEDICINE, disease.getMedicine());
        values.put(KEY_ICON, disease.getIcon());


        db.insert(TABLE_DISEASE, null, values);
        db.close(); // Closing database connection
    }

    // Getting one disease
    public Disease getDisease(String key) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_DISEASE, new String[]{KEY_ID,
                        KEY_NAME, KEY_DESCRIPTION, KEY_SYMPTOMS, KEY_PREVENTION, KEY_MEDICINE, KEY_ICON}, KEY_SYMPTOMS + " LIKE?",
                new String[]{String.valueOf(key)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Disease disease = new Disease(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6));
        return disease;
    }

    // Getting one disease
    public List<Disease> getDiseaseList(String key) {
        List<Disease> diseaseList = new ArrayList<Disease>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_DISEASE, new String[]{KEY_ID,
                        KEY_NAME, KEY_DESCRIPTION, KEY_SYMPTOMS, KEY_PREVENTION, KEY_MEDICINE, KEY_ICON}, KEY_SYMPTOMS + " LIKE?",
                new String[]{"%" + key + "%"}, null, null, null, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Disease shop = new Disease();
                shop.setId(Integer.parseInt(cursor.getString(0)));
                shop.setName(cursor.getString(1));
                shop.setDescription(cursor.getString(2));
                shop.setSymptoms(cursor.getString(3));
                shop.setPrevention(cursor.getString(4));
                shop.setMedicine(cursor.getString(5));
                shop.setIcon(cursor.getInt(6));
                diseaseList.add(shop);
            } while (cursor.moveToNext());
        }
        return diseaseList;

    }


    // Getting All Disease
    public List<Disease> getAllDisease() {
        List<Disease> diseaseList = new ArrayList<Disease>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_DISEASE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Disease shop = new Disease();
                shop.setId(Integer.parseInt(cursor.getString(0)));
                shop.setName(cursor.getString(1));
                shop.setDescription(cursor.getString(2));
                shop.setSymptoms(cursor.getString(3));
                shop.setPrevention(cursor.getString(4));
                shop.setMedicine(cursor.getString(5));
                shop.setIcon(cursor.getInt(5));
                diseaseList.add(shop);
            } while (cursor.moveToNext());
        }
        return diseaseList;
    }
}



