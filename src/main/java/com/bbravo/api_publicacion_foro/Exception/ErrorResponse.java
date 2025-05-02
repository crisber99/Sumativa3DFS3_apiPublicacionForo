package com.bbravo.api_publicacion_foro.Exception;

public class ErrorResponse {
    private final String msg;

    public ErrorResponse(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}
