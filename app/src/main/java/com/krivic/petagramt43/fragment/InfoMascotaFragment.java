package com.krivic.petagramt43.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.krivic.petagramt43.R;
import com.krivic.petagramt43.adapter.InfoMascotaAdapter;
import com.krivic.petagramt43.adapter.MascotaAdapter;
import com.krivic.petagramt43.pojo.Mascota;
import com.krivic.petagramt43.presenter.infoMascotaViewFragmentPresenter;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class InfoMascotaFragment extends Fragment implements com.krivic.petagramt43.fragment.IRecicleyViewFragmentView {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    private CircularImageView circularImageView;
    private TextView name_pet_selected;


    View v;
    Context context;

    infoMascotaViewFragmentPresenter presenter;

    public InfoMascotaFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_info_mascota, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.recyclerView_pet);
        presenter = new infoMascotaViewFragmentPresenter(this,getContext());
        context = v.getContext();


        return v;
    }

    @Override
    public void generarLinearLayoutVertica() {

    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);
        listaMascotas.setLayoutManager(glm);


    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas) {

        return null;
    }

    @Override
    public InfoMascotaAdapter crearAdaptadorInfo(ArrayList<Mascota> mascotas) {

        circularImageView =  (CircularImageView) v.findViewById(R.id.img_pet_seledcted);

        Picasso.with(context)
                .load(mascotas.get(0).getImagePerURL())
                .into(circularImageView);

        name_pet_selected = (TextView) v.findViewById(R.id.name_pet_selected);
        name_pet_selected.setText(mascotas.get(0).getName());

        InfoMascotaAdapter adapter = new InfoMascotaAdapter(mascotas);
        return adapter;
    }

    @Override
    public void inicializarAdaptadorRecicleyViewInfo(InfoMascotaAdapter adapter) {
        listaMascotas.setAdapter(adapter);
    }

    @Override
    public void inicializarAdaptadorRecicleyView(MascotaAdapter adapter) {

    }
}
