package com.example.appembalaje.implementacion;

import android.widget.Toast;

import com.example.appembalaje.adaptadores.ServerHandler;

public class ProtocolsImpl {

    protected void ProtocolAlternatives(Object objeto){
        ServerHandler server = new ServerHandler();
        String option = objeto.toString();//codigo placeholder
        switch (option){
            case "link":
                server.Link();
                break;
            case "back_up":
                server.Backup();
                break;
            case "move":
                server.Move();
                break;
            case "restore":
                server.Restore();
                break;
        }
    }
}
