package com.krivic.petagramt43.pojo;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;



public class Session {
    private SharedPreferences prefsSession;
    private SharedPreferences.Editor editorSession;

    private Context theContext;


    String userSeleted;

    public Session(Context theContext) {

        prefsSession = PreferenceManager.getDefaultSharedPreferences(theContext);

        editorSession =  prefsSession.edit();

        this.theContext = theContext;
    }

    public String getUserSeleted() {
        this.userSeleted = prefsSession.getString("userSeleted",null);
        return this.userSeleted;
    }

    public void setUserSeleted(String userSeleted) {
        editorSession.putString("userSeleted",userSeleted);
        editorSession.commit();
        this.userSeleted = userSeleted;
    }
}
