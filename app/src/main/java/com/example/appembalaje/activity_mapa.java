package com.example.appembalaje;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.Polyline;

public class activity_mapa extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));

        MapView mapView = findViewById(R.id.mapView);
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);

        //Coordenadas de Ciudad Empresarial
        double ciudadEmpresarialLatitude = -33.392949;
        double ciudadEmpresarialLongitude = -70.619980;

        //Coordenadas de Mall Tobalaba
        double mallTobalabaLatitude = -33.568704;
        double mallTobalabaLongitude = -70.554746;

        //Crear objetos GeoPoint para los marcadores
        GeoPoint ciudadEmpresarialPoint = new GeoPoint(ciudadEmpresarialLatitude, ciudadEmpresarialLongitude);
        GeoPoint mallTobalabaPoint = new GeoPoint(mallTobalabaLatitude, mallTobalabaLongitude);

        //Crear marcadores con títulos y descripciones
        Marker santiagoMarker = new Marker(mapView);
        santiagoMarker.setPosition(ciudadEmpresarialPoint);
        santiagoMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        santiagoMarker.setTitle("Ciudad Empresarial, Chile");
        santiagoMarker.setSnippet("Santiago de Chile");

        Marker valparaisoMarker = new Marker(mapView);
        valparaisoMarker.setPosition(mallTobalabaPoint);
        valparaisoMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        valparaisoMarker.setTitle("Mall Tobalaba, Chile");
        valparaisoMarker.setSnippet("Santiago de Chile");

        //Agregar marcadores al mapa
        mapView.getOverlays().add(santiagoMarker);
        mapView.getOverlays().add(valparaisoMarker);

        //Crear y agregar la línea entre los locales
        Polyline polyline = new Polyline();
        polyline.addPoint(mallTobalabaPoint);
        polyline.addPoint(ciudadEmpresarialPoint);
        polyline.setColor(0xFF0000FF);  // Color de la línea (azul en formato ARGB)
        polyline.setWidth(5);  // Ancho de la línea en píxeles
        //Agrega la Linea al Mapa
        mapView.getOverlayManager().add(polyline);

        //Calcular la distancia entre los locales
        double distance = CalcularDistancia.CalcularDistancia(mallTobalabaPoint, ciudadEmpresarialPoint);
        TextView distanceTextView = findViewById(R.id.distanceTextView);
        distanceTextView.setText("Distancia entre los locales de Ciudad Empresarial y Mall Tobalaba: " + String.format("%.2f", distance) + " km");

        // Centrar el mapa en Santiago, Chile
        IMapController mapController = mapView.getController();
        mapController.setCenter(mallTobalabaPoint);
        mapController.setZoom(14);  // Puedes ajustar el nivel de zoom según sea necesario
    }
}
