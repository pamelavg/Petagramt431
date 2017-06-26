package com.krivic.petagramt43.fragment;

import com.krivic.petagramt43.adapter.InfoMascotaAdapter;
import com.krivic.petagramt43.adapter.MascotaAdapter;
import com.krivic.petagramt43.pojo.Mascota;

import java.util.ArrayList;



public interface IRecicleyViewFragmentView {

    public void generarLinearLayoutVertica();
    public void generarGridLayout();
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas);
    public InfoMascotaAdapter crearAdaptadorInfo(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRecicleyViewInfo(InfoMascotaAdapter adapter);
    public void inicializarAdaptadorRecicleyView(MascotaAdapter adapter);
}
