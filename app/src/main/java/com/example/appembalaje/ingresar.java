package com.example.appembalaje;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class ingresar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);
        VideoView mivideo = findViewById(R.id.video1);

        String videop = "android.resource://" + getPackageName() + "/" + R.raw.video1;
        Uri uri=Uri.parse(videop);
        mivideo.setVideoURI(uri);

        MediaController mediaController=new MediaController(this);
        mivideo.setMediaController(mediaController);
        mediaController.setAnchorView(mivideo);

        // Aplica una animación de escala al VideoView para que aparezca gradualmente
        Animation animation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
              Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(1000); // Duración de la animación en milisegundos
        mivideo.startAnimation(animation);

        // Establece un listener para el evento de preparación del MediaPlayer
        mivideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
         public void onPrepared(MediaPlayer mediaPlayer) {
            mivideo.start(); // Inicia la reproducción del video cuando está preparado
          }
        });

    }

    public void menuAccesorios(View view){
        Intent mAccesorios = new Intent(this, activity_accesorios.class);
        startActivity(mAccesorios);
    }

    public void menuCajas(View view){
        Intent mCajas = new Intent(this, activity_cajas.class);
        startActivity(mCajas);
    }

    public void menuCrud(View view){
        Intent mCrud = new Intent(this, Crud.class);
        startActivity(mCrud);
    }
}