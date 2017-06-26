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



public class infoMascotaViewFragmentPresenter implements com.krivic.petagramt43.presenter.IReciclerViewFragmentPresenter {

    Session session;
    String idUser;

    private IRecicleyViewFragmentView iRecicleyViewFragmentView;
    private Context context;
    private ArrayList<Mascota> mascotas;

    public infoMascotaViewFragmentPresenter(IRecicleyViewFragmentView iRecicleyViewFragmentView, Context context) {
        this.iRecicleyViewFragmentView = iRecicleyViewFragmentView;
        this.context = context;

        obtenerMediosRecientes();

    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();

        session = new Session(context);
        idUser  = session.getUserSeleted();

        Gson gsonMediaRecent = restApiAdapter.contruyeGsonDeserializadorMediaRecentOtherUser();
        EndPointsApi endPointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

        String theUrl = ConstRestApi.getUrlOtherUserRecentMedia(idUser);

        Call<MascotaResponse> mascotaResponseCall = endPointsApi.getRecentMediaOtherUser(theUrl);
        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                mostrarMascotasRecicleyView();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Log.i("RecliclerViewFragment","obtenerMediosRecientes-> Fallas de conexión: "+t.toString());
            }
        });
    }

    @Override
    public void mostrarMascotasRecicleyView() {
        iRecicleyViewFragmentView.inicializarAdaptadorRecicleyViewInfo(iRecicleyViewFragmentView.crearAdaptadorInfo(mascotas));
        iRecicleyViewFragmentView.generarGridLayout();
    }
}
