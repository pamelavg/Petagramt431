package com.krivic.petagramt43.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.krivic.petagramt43.R;
import com.krivic.petagramt43.pojo.Mascota;

import java.util.ArrayList;



public class ConstructorMascotas {
    private Context context;

    private SharedPreferences prefsSession;
    private SharedPreferences.Editor editorSession;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){


        BaseDatos db = new BaseDatos(context);


        prefsSession = PreferenceManager.getDefaultSharedPreferences(context);

        editorSession =  prefsSession.edit();


        boolean isData = prefsSession.getBoolean("isData",false);

        if(!isData){
            insertarCuatroContactos(db);
            editorSession.putBoolean("isData",true);
            editorSession.commit();
        }


    return  db.obetenerTodasMascotas();
    }


    public void insertarCuatroContactos (BaseDatos db){
        ContentValues contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NAME,"Beethoven");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGE ,R.drawable.img_mascota1_1);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_TOTALLIKES ,"5");

        db.insetarMascota(contentValues);

        ContentValues contentValues2 =  new ContentValues();
        contentValues2.put(ConstantesBaseDatos.TABLE_MASCOTA_NAME,"Lux");
        contentValues2.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGE ,R.drawable.img_mascota2_2);
        contentValues2.put(ConstantesBaseDatos.TABLE_MASCOTA_TOTALLIKES ,"3");

        db.insetarMascota(contentValues2);

        ContentValues contentValues3 =  new ContentValues();
        contentValues3.put(ConstantesBaseDatos.TABLE_MASCOTA_NAME,"Robbin");
        contentValues3.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGE ,R.drawable.img_mascota3_3);
        contentValues3.put(ConstantesBaseDatos.TABLE_MASCOTA_TOTALLIKES ,"2");

        db.insetarMascota(contentValues3);

        ContentValues contentValues4 =  new ContentValues();
        contentValues4.put(ConstantesBaseDatos.TABLE_MASCOTA_NAME,"Tobby");
        contentValues4.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGE ,R.drawable.img_mascota4_4);
        contentValues4.put(ConstantesBaseDatos.TABLE_MASCOTA_TOTALLIKES ,"1");

        db.insetarMascota(contentValues4);

        ContentValues contentValues5 =  new ContentValues();
        contentValues5.put(ConstantesBaseDatos.TABLE_MASCOTA_NAME,"Luna");
        contentValues5.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGE ,R.drawable.img_mascota5_5);
        contentValues5.put(ConstantesBaseDatos.TABLE_MASCOTA_TOTALLIKES ,"3");

        db.insetarMascota(contentValues5);

        ContentValues contentValues6 =  new ContentValues();
        contentValues6.put(ConstantesBaseDatos.TABLE_MASCOTA_NAME,"Mateo");
        contentValues6.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGE ,R.drawable.img_mascota6_6);
        contentValues6.put(ConstantesBaseDatos.TABLE_MASCOTA_TOTALLIKES ,"2");

        db.insetarMascota(contentValues6);

        ContentValues contentValues7 =  new ContentValues();
        contentValues7.put(ConstantesBaseDatos.TABLE_MASCOTA_NAME,"Lucas");
        contentValues7.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGE ,R.drawable.img_mascota7_7);
        contentValues7.put(ConstantesBaseDatos.TABLE_MASCOTA_TOTALLIKES ,"10");

        db.insetarMascota(contentValues7);

        ContentValues contentValues8 =  new ContentValues();
        contentValues8.put(ConstantesBaseDatos.TABLE_MASCOTA_NAME,"Fiona");
        contentValues8.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGE ,R.drawable.img_mascota8_8);
        contentValues8.put(ConstantesBaseDatos.TABLE_MASCOTA_TOTALLIKES ,"1");

        db.insetarMascota(contentValues8);

    }

    public void darLikeMascota (Mascota masoMascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues =  new ContentValues();
    }
}
