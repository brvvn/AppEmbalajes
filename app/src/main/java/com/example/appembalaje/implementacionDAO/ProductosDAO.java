package com.example.appembalaje.implementacionDAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.appembalaje.interfaces.DAO;

public class ProductosDAO extends SQLiteOpenHelper {
    public ProductosDAO(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DAO.CREATE_TABLE_PRODUCTOS_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DAO.DELETE_TABLE_PRODUCTOS_QUERY);
        sqLiteDatabase.execSQL(DAO.CREATE_TABLE_PRODUCTOS_QUERY);
    }
}
