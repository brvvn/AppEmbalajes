package com.example.appembalaje;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {
    public DataHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE producto (cod INTEGER PRIMARY KEY, nom TEXT, cat TEXT, can TEXT,tam TEXT, nota INTEGER)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS producto");

        // Crea la nueva estructura de la tabla
        db.execSQL("CREATE TABLE producto (cod INTEGER PRIMARY KEY, nom TEXT, cat TEXT, can TEXT,tam TEXT, nota INTEGER)");
    }
}
