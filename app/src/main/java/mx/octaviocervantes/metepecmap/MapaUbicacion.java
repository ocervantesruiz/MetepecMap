package mx.octaviocervantes.metepecmap;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaUbicacion extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private int iOpcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ubicacion_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Bundle params = getIntent().getExtras();
        iOpcion = params.getInt(getResources().getString(R.string.oUbicacion), 1);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Galerias Metepec:     19.258814, -99.621015
        //Iglesia Calvario:     19.250385, -99.605246
        //Mercado Metepec:      19.254187, -99.605403
        //Parque bicentenario:  19.245904, -99.586263

        LatLng mall = new LatLng(19.258814, -99.621015);
        LatLng park = new LatLng(19.245904, -99.586263);
        LatLng market = new LatLng(19.254187, -99.605403);
        LatLng church = new LatLng(19.250385, -99.605246);


        switch (iOpcion){
            case 1:
                mMap.addMarker(new MarkerOptions()
                        .position(church)
                        .title(getResources().getString(R.string.sChurch))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.church_marker))
                        .anchor(0.0f, 1.0f)
                );
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(church, 16));
                break;

            case 2:
                mMap.addMarker(new MarkerOptions()
                        .position(mall)
                        .title(getResources().getString(R.string.sMall))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.mall_marker))
                        .anchor(0.0f, 1.0f)
                );
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mall, 16));
                break;

            case 3:
                mMap.addMarker(new MarkerOptions()
                        .position(market)
                        .title(getResources().getString(R.string.sMarket))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.market_marker))
                        .anchor(0.0f, 1.0f)
                );
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(market, 16));
                break;

            case 4:
                mMap.addMarker(new MarkerOptions()
                        .position(park)
                        .title(getResources().getString(R.string.sPark))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.park_marker))
                        .anchor(0.0f, 1.0f)
                );
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(park, 16));
                break;

            default:
                break;
        }
    }
}
