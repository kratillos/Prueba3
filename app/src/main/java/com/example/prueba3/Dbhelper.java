package com.example.prueba3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper {
    public static String Nombre_Bd="Votaciones.db";
    public static int Version_DB=1;
    public static String Tabla_Voto = "create table Voto (id_voto integer primary key autoincrement, voto_blanco integer not null, voto_nulo integer not null,voto_boric integer not null, voto_kast integer not null)";

    public Dbhelper(Context context) {
        super(context, Nombre_Bd, null, Version_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Tabla_Voto);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Voto");
        sqLiteDatabase.execSQL(Tabla_Voto);

    }
}
