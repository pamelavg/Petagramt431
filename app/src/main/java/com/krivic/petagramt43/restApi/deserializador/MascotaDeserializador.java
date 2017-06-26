package com.krivic.petagramt43.restApi.deserializador;

import com.krivic.petagramt43.pojo.Mascota;
import com.krivic.petagramt43.restApi.JsonKeys;
import com.krivic.petagramt43.restApi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;



public class MascotaDeserializador implements JsonDeserializer<MascotaResponse> {

    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();
        MascotaResponse mascotaResponse = gson.fromJson(json,MascotaResponse.class);

        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        mascotaResponse.setMascotas(deserialiarMascotaDeJson(mascotaResponseData));

        return mascotaResponse;
    }

    private ArrayList<Mascota> deserialiarMascotaDeJson(JsonArray mascotaResponseData){

        ArrayList<Mascota> mascotas = new ArrayList<>();

        for (int i = 0; i < mascotaResponseData.size(); i++) {
            JsonObject mascotaResponseDataObject = mascotaResponseData.get(i).getAsJsonObject();

            //Para info de usuario
            JsonObject userObject = mascotaResponseDataObject.getAsJsonObject(JsonKeys.USER);
            String id = userObject.get(JsonKeys.USER_ID).getAsString();
            String name = userObject.get(JsonKeys.USER_FULL_NAME).getAsString();
            String imagePerURL = userObject.get(JsonKeys.USER_IMAGE_URL).getAsString();

            //Para la imagen
            JsonObject imageObject = mascotaResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject imageResolutionObject = imageObject.getAsJsonObject(JsonKeys.MEDIA_STANDAR_RESOLUTION);
            String imageURL = imageResolutionObject.get(JsonKeys.MEDIA_URL).getAsString();

            //Para los likes
            JsonObject likesObject = mascotaResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int totalLikes = likesObject.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();


            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(id);
            mascotaActual.setName(name);
            mascotaActual.setImageURL(imageURL);
            mascotaActual.setTotalLikes(totalLikes);
            mascotaActual.setImagePerURL(imagePerURL);

            mascotas.add(mascotaActual);
        }
    return mascotas;
    }
}
