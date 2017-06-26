package com.krivic.petagramt43.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krivic.petagramt43.R;
import com.krivic.petagramt43.adapter.InfoMascotaAdapter;
import com.krivic.petagramt43.adapter.MascotaAdapter;
import com.krivic.petagramt43.pojo.Mascota;
import com.krivic.petagramt43.presenter.ReciclerViewFragmentPresenter;

import java.util.ArrayList;



public class ReciclerViewFragment extends Fragment implements IRecicleyViewFragmentView{

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    ReciclerViewFragmentPresenter presenter;

    public ReciclerViewFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recicler_view, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.recyclerView_mascotas);
        presenter = new ReciclerViewFragmentPresenter(this,getContext());

        return v;
    }



    @Override
    public void generarLinearLayoutVertica() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public void generarGridLayout() {

    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas) {

        MascotaAdapter adapter = new MascotaAdapter(mascotas);
        return adapter;
    }

    @Override
    public InfoMascotaAdapter crearAdaptadorInfo(ArrayList<Mascota> mascotas) {
        return null;
    }

    @Override
    public void inicializarAdaptadorRecicleyViewInfo(InfoMascotaAdapter adapter) {

    }

    @Override
    public void inicializarAdaptadorRecicleyView(MascotaAdapter adapter) {
        listaMascotas.setAdapter(adapter);
    }
}
