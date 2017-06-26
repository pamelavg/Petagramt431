package com.krivic.petagramt43.presenter;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.krivic.petagramt43.fragment.IRecicleyViewFragmentView;
import com.krivic.petagramt43.pojo.Mascota;
import com.krivic.petagramt43.pojo.Session;
import com.krivic.petagramt43.restApi.ConstRestApi;
import com.krivic.petagramt43.restApi.EndPointsApi;
import com.krivic.petagramt43.restApi.adapter.RestApiAdapter;
import com.krivic.petagramt43.restApi.model.MascotaResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class ReciclerViewFragmentPresenter implements IReciclerViewFragmentPresenter {

    String theIdOtherUser;

    Session session;

    private IRecicleyViewFragmentView iRecicleyViewFragmentView;
    private Context context;
    ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

    public ReciclerViewFragmentPresenter(IRecicleyViewFragmentView iRecicleyViewFragmentView, Context context) {
        this.iRecicleyViewFragmentView = iRecicleyViewFragmentView;
        this.context = context;


        String[] myFriends = new String[2];

        session = new Session(context);
        String idUser = session.getUserSeleted();

        switch (idUser){

            case "5451658654":
                myFriends[0] = "5560454415";
                myFriends[1] = "5431565715";
            break;

            case "5560454415":
                myFriends[0] = "5451658654";
                myFriends[1] = "5431565715";
            break;

            case "5431565715":
                myFriends[0] = "5560454415";
                myFriends[1] = "5451658654";
            break;
        }




        for(int cont = 0; cont<myFriends.length; cont++){
            theIdOtherUser = myFriends[cont];
            obtenerMediosRecientes();
        }

    }
    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();

        Gson gsonMediaRecent = restApiAdapter.contruyeGsonDeserializadorMediaRecentOtherUser();
        EndPointsApi endPointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

        String theUrl = ConstRestApi.getUrlOtherUserRecentMedia(theIdOtherUser);

        Call<MascotaResponse> mascotaResponseCall = endPointsApi.getRecentMediaOtherUser(theUrl);
        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                ArrayList<Mascota> theMascotas = mascotaResponse.getMascotas();
                for (int i=0;i<theMascotas.size();i++){
                    Mascota masc = theMascotas.get(i);
                    mascotas.add(masc);
                }

                mostrarMascotasRecicleyView();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Log.e("RecliclerViewFragment","obtenerMediosRecientes-> Fallas de conexión: "+t.toString());
            }
        });
    }

    @Override
    public void mostrarMascotasRecicleyView() {
        iRecicleyViewFragmentView.inicializarAdaptadorRecicleyView(iRecicleyViewFragmentView.crearAdaptador(mascotas));
        iRecicleyViewFragmentView.generarLinearLayoutVertica();
    }
}
