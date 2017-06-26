package com.krivic.petagramt43.restApi;

public final class ConstRestApi {


    //INSTAGRAM
    public static final String VERSION                     = "/v1/";
    public static final String ROOT_URL                    = "https://api.instagram.com"+VERSION;
    public static final String ACCESS_TOKEN                = "5451658654.859f4fd.d971025d61834c59a56233fac5f18d98";
    public static final String KEY_ACCESS_TOKEN            = "?access_token=";


    //usuario
    public static final String KEY_GET_RECENT_MEDIA_USER    = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER    = KEY_GET_RECENT_MEDIA_USER+KEY_ACCESS_TOKEN+ACCESS_TOKEN;


    //Devuelve informacón del otro usuario
    public static String getUrlOtherUserRecentMedia(String idOtherUser){

        String KEY_GET_RECENT_MEDIA_OTHER_USER    = "users/"+idOtherUser+"/media/recent/";
        String URL_GET_RECENT_MEDIA_OTHER_USER    = KEY_GET_RECENT_MEDIA_OTHER_USER+KEY_ACCESS_TOKEN+ACCESS_TOKEN;


        return URL_GET_RECENT_MEDIA_OTHER_USER;
    }


    //SERVIDOR
    public static final String ROOT_URL_HER         = "https://secure-escarpment-67964.herokuapp.com/";
    public static final String KEY_POST_USER_HER    = "registrar-usuario/";


}
