package com.example.latlong_googlemapas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText campoLat, campoLong;
    EditText campoLongitudOrigen, campoLongitudDestino;
    Button botonBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonBuscar = findViewById(R.id.btnBuscar);
        campoLat = findViewById(R.id.txtLatitud);
        campoLong = findViewById(R.id.txtLongitud);

        campoLongitudOrigen = findViewById(R.id.txtLongitudOrigen);
        campoLongitudDestino = findViewById(R.id.txtLongitudDestino);

        // FUNCIONALIDAD AL BOTÓN, CON MÉTODO SETONCLICK
        botonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verMapa(v);
            }
        });

    }

    public void verMapa(View v){
        double latitud = Double.parseDouble(campoLat.getText().toString());
        double longitud = Double.parseDouble(campoLong.getText().toString());

        double longitudOrigen = Double.parseDouble(campoLongitudOrigen.getText().toString());
        double longitudDestino = Double.parseDouble(campoLongitudDestino.getText().toString());

        googleMapas.latitud = latitud;
        googleMapas.longitud = longitud;

        googleMapas.longitudOrigen = longitudOrigen;
        googleMapas.longitudDestino= longitudDestino;

        Intent enviar = new Intent(MainActivity.this, googleMapas.class);
        startActivity(enviar);
    }
}
