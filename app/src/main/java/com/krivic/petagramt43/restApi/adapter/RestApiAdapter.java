package com.krivic.petagramt43.restApi.adapter;

import com.krivic.petagramt43.restApi.ConstRestApi;
import com.krivic.petagramt43.restApi.EndPointsApi;
import com.krivic.petagramt43.restApi.deserializador.MascotaDeserializador;
import com.krivic.petagramt43.restApi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class RestApiAdapter {

    public EndPointsApi establecerConexionRestApiInstagram(Gson gson){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        return retrofit.create(EndPointsApi.class);
    }

    public Gson contruyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class,new MascotaDeserializador());
        return gsonBuilder.create();
    }

    public Gson contruyeGsonDeserializadorMediaRecentOtherUser(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class,new MascotaDeserializador());
        return gsonBuilder.create();
    }

    public EndPointsApi establecerConexionRestApiHeroku(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstRestApi.ROOT_URL_HER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit.create(EndPointsApi.class);
    }
}
