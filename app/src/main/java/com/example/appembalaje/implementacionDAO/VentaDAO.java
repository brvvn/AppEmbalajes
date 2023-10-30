package com.example.appembalaje.implementacionDAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.appembalaje.interfaces.DAO;

import java.util.List;

public class VentaDAO extends SQLiteOpenHelper {
    public VentaDAO(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DAO.CREATE_TABLE_VENTA_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DAO.DELETE_TABLE_VENTA_QUERY);
        sqLiteDatabase.execSQL(DAO.CREATE_TABLE_VENTA_QUERY);
    }

    public boolean Create(){
        return true;
    }
    public boolean Read(){
        return true;
    }

    public boolean Update(){
        return true;
    }

    public boolean Delete(){
        return true;
    }

    public void ReadByOne(String IDVenta){

    }
}
