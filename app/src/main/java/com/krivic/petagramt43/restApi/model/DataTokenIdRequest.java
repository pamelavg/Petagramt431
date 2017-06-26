package com.krivic.petagramt43.restApi.model;



public class DataTokenIdRequest {
    private String UserIdInst;
    private String TokenDevice;

    public DataTokenIdRequest(String userIdInst, String tokenDevice) {
        UserIdInst = userIdInst;
        TokenDevice = tokenDevice;
    }
}
