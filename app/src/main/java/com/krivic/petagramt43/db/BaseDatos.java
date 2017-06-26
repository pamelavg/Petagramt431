package com.krivic.petagramt43.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.krivic.petagramt43.pojo.Mascota;

import java.util.ArrayList;



public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(Context context) {
        super(context, com.krivic.petagramt43.db.ConstantesBaseDatos.DATABASE_NAME, null, com.krivic.petagramt43.db.ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE "+ com.krivic.petagramt43.db.ConstantesBaseDatos.TABLE_MASCOTA+"("

                + com.krivic.petagramt43.db.ConstantesBaseDatos.TABLE_MASCOTA_ID           + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + com.krivic.petagramt43.db.ConstantesBaseDatos.TABLE_MASCOTA_NAME         + " TEXT, "
                + com.krivic.petagramt43.db.ConstantesBaseDatos.TABLE_MASCOTA_IMAGE        + " INTEGER, "
                + com.krivic.petagramt43.db.ConstantesBaseDatos.TABLE_MASCOTA_TOTALLIKES   + " INTEGER "
                +")";


        db.execSQL(queryCrearTablaMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+ com.krivic.petagramt43.db.ConstantesBaseDatos.TABLE_MASCOTA);
        onCreate(db);

    }

    public ArrayList<Mascota> obetenerTodasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        String query = "SELECT * FROM "+ com.krivic.petagramt43.db.ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resgitros = db.rawQuery(query,null);

        db.close();
        return mascotas;
    }

    public void insetarMascota(ContentValues contentValues)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(com.krivic.petagramt43.db.ConstantesBaseDatos.TABLE_MASCOTA,null,contentValues);
        db.close();
    }

    public void insertarLikeMascota (String nombreMascota, String totalLikes){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(com.krivic.petagramt43.db.ConstantesBaseDatos.TABLE_MASCOTA_TOTALLIKES,totalLikes);

        String stringSQL = com.krivic.petagramt43.db.ConstantesBaseDatos.TABLE_MASCOTA_NAME+"='"+nombreMascota+"'";

        db.update(com.krivic.petagramt43.db.ConstantesBaseDatos.TABLE_MASCOTA,values,stringSQL,null);
    }


}
