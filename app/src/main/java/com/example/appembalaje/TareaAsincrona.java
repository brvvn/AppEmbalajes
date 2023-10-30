package com.example.appembalaje;

import android.os.AsyncTask;

public class TareaAsincrona  extends AsyncTask<Object, Void, Boolean> {
    private Comunicacion comunicacion;

    public TareaAsincrona(Comunicacion comunicacion){
        this.comunicacion = comunicacion;
    }

    //Codigo que se ejecuta antes de comenzar el hilo
    @Override
    protected void onPreExecute(){comunicacion.toggleProgressBar(true);}

    //Codigo en segundo plano evalua las credenciales
    @Override
    protected Boolean doInBackground(Object... objects) {
        try {
            Thread.sleep((int)objects[2]);
            String user = (String) objects[0];
            String pass = (String)  objects[1];
            if (user.equals("admin") && pass.equals("admin")){
                return true;
            }else {
                return false;
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return false;
    }
    //Codigo ejecutado una vez termine el hilo
    @Override
    protected  void onPostExecute(Boolean bo) {
        if (bo){
            this.comunicacion.lanzarActividad(ingresar.class);
            this.comunicacion.showMessage("Datos Correctos");
            this.comunicacion.toggleProgressBar(false);
        }else{
            this.comunicacion.showMessage("Datos Incorrectos");
        }
    }
}