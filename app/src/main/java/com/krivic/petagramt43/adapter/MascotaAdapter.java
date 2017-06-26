package com.krivic.petagramt43.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.krivic.petagramt43.R;
import com.krivic.petagramt43.db.BaseDatos;
import com.krivic.petagramt43.pojo.Mascota;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{

    public MascotaAdapter(ArrayList<Mascota> mascotas)
    {
        this.mascotas = mascotas;
    }

    Context context;

    ArrayList<Mascota> mascotas;
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        context = parent.getContext();
        return new MascotaViewHolder(v);

    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota = mascotas.get(position);

        Picasso.with(context)
                .load(mascota.getImageURL())
                .into(mascotaViewHolder.img_mascota);

        mascotaViewHolder.txt_left_cardview_name.setText(mascota.getName());


        mascotaViewHolder.txt_rigth_likes.setText(Integer.toString(mascota.getTotalLikes()));
    }

    @Override
    public int getItemCount() { //cantidad de elementos que contiene la lista
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView img_mascota;
        private TextView txt_left_cardview_name;
        private TextView txt_rigth_likes;
        private ImageView img_bone_yellow;


        public MascotaViewHolder(final View itemView) {
            super(itemView);
            img_mascota                 = (ImageView)   itemView.findViewById(R.id.img_mascota);
            txt_left_cardview_name      = (TextView)    itemView.findViewById(R.id.txt_left_cardview_name);
            txt_rigth_likes             = (TextView)    itemView.findViewById(R.id.txt_rigth_likes);
            img_bone_yellow             = (ImageView)   itemView.findViewById(R.id.img_bone_yellow);

            img_bone_yellow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int newCountLikes = Integer.parseInt(txt_rigth_likes.getText().toString());
                    newCountLikes+=1;
                    String nuevosLike       = String.valueOf(newCountLikes);
                    String nombreMascota    = txt_left_cardview_name.getText().toString();

                    txt_rigth_likes.setText(nuevosLike);

                    BaseDatos baseDatos = new BaseDatos(itemView.getContext());
                    baseDatos.insertarLikeMascota(nombreMascota,nuevosLike);

                }
            });

        }


    }
}
