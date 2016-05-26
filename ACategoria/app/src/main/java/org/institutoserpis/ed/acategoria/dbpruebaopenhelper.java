package org.institutoserpis.ed.acategoria;

import android.database.sqlite.*;
import  android.content.*;
import android.provider.BaseColumns;

/**
 * Created by mati on 25/05/16.
 */
public class dbpruebaopenhelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "dbprueba.db";
    private static final int DATABASE_VERSION = 1;

    public static abstract class TableCategoria implements BaseColumns{

        public static final String NAME = "Categoria";
        public static final String COLUMN_NAME = "Nombre";
    }


    private static final String CREATE_TABLE_CATEGORIA ="Create table " + TableCategoria.NAME + "("
            + TableCategoria._ID+ "integer primary key, "+ TableCategoria.COLUMN_NAME + "Text" + ");";


    public dbpruebaopenhelper(Context contex){
        super(contex,DATABASE_NAME,null,DATABASE_VERSION);

    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CATEGORIA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
