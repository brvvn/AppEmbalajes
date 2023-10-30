package com.example.appembalaje.implementacion;

public class SesionImpl {

    public Object SsInit(String data){
        String rut = data.substring(1,12); //
        String nDoc = data.substring(13,20); //
        String[] userData = {rut,nDoc};
        return userData;
    }
}
