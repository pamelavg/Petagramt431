package com.krivic.petagramt43.restApi.model;



public class UserHerokuResponse {

    private String IdDB;
    private String UserIdInst;
    private String TokenDevice;

    public UserHerokuResponse(String idDB, String userIdInst, String tokenDevice) {
        IdDB = idDB;
        UserIdInst = userIdInst;
        TokenDevice = tokenDevice;
    }

    public UserHerokuResponse() {
    }

    public String getIdDB() {
        return IdDB;
    }

    public void setIdDB(String idDB) {
        IdDB = idDB;
    }

    public String getUserIdInst() {
        return UserIdInst;
    }

    public void setUserIdInst(String userIdInst) {
        UserIdInst = userIdInst;
    }

    public String getTokenDevice() {
        return TokenDevice;
    }

    public void setTokenDevice(String tokenDevice) {
        TokenDevice = tokenDevice;
    }
}
