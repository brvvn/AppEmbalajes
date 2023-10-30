package com.example.appembalaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appembalaje.adaptadores.QrHanlder;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity implements Comunicacion {

    private ProgressBar pgbEjecutando;
    private Button button4;
    private TextView editTextText3, editTextTextPassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pgbEjecutando = findViewById(R.id.pgbEjecutando);
        button4 = findViewById(R.id.button4);
        editTextText3 = findViewById(R.id.editTextText3);
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TareaAsincrona(MainActivity.this).execute(editTextText3.getText().toString(),
                        editTextTextPassword2.getText().toString(),3000);
            }
        });
    }

    public void ingresar(View view){
        Intent login = new Intent(this, ingresar.class);
        startActivity(login);
    }

    public void ubicacionMapa(View view){
        Intent login = new Intent(this, activity_mapa.class);
        startActivity(login);
    }

    public void PruebasScanner(View view){
        QrHanlder scan = new QrHanlder();
        scan.ReadCode(MainActivity.this,1);
    }

    protected void onActivityResult(int RequestCode,int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(RequestCode,resultCode,data);
        if(result !=null){
            if(result.getContents()==null){
                Toast.makeText(this, "Lector Cerrado antes de tiempo", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show();
            }
        }else{
            super.onActivityResult(RequestCode, resultCode, data);
        }

    }
    @Override
    public void toggleProgressBar(boolean status) {
        if (status) {
            pgbEjecutando.setVisibility(View.VISIBLE);
        }else {
            pgbEjecutando.setVisibility(View.GONE);
        }
    }
    @Override
    public void lanzarActividad(Class<?> tipoActividad) {
        Intent intent = new Intent(this, tipoActividad);
        startActivity(intent);
    }
    @Override
    public void showMessage(String msg) { Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

    }

    public void onClickVideo(View view){
        Intent intent = new Intent(this, VistaVideo.class);
        startActivity(intent);
    }
}