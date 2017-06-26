package com.krivic.petagramt43.restApi;

import com.krivic.petagramt43.restApi.model.MascotaResponse;
import com.krivic.petagramt43.restApi.model.UserHerokuResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;



public interface EndPointsApi {

    //INSTAGRAM
    @GET(ConstRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();

    @GET()
    //get
    Call<MascotaResponse> getRecentMediaOtherUser(@Url String url);

    //SERVIDOR
    @POST(ConstRestApi.KEY_POST_USER_HER)
    Call<UserHerokuResponse> postRegisterTokenIdUser(@Body Object dataTokenID);
}
