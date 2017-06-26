package com.krivic.petagramt43.restApi.model;

import com.krivic.petagramt43.pojo.Mascota;

import java.util.ArrayList;



public class MascotaResponse {

    ArrayList<Mascota> Mascotas;

    public ArrayList<Mascota> getMascotas() {
        return Mascotas;
    }

    public Mascota getAMascota (){

        return this.Mascotas.get(0);

    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        Mascotas = mascotas;
    }
}
