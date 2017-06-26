package com.krivic.petagramt43.Notification;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;



public class NotificationIdTokenService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String Token = FirebaseInstanceId.getInstance().getToken();
        sendTheTokenForNotification(Token);

    }

    public void sendTheTokenForNotification(String Token){
        Log.d("NotificationTokenServic","El Token es: "+Token);

    }
}
