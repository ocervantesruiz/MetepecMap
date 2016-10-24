package mx.octaviocervantes.metepecmap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class ListaUbicaciones extends AppCompatActivity {

    private String sChurch;
    private String sMall;
    private String sMarket;
    private String sPark;

    private int[] imagenes = {R.drawable.church, R.drawable.mall, R.drawable.market, R.drawable.park};
    private String[] nombres = {"", "", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ubicaciones_lista);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);

        sChurch = getResources().getString(R.string.sChurch).toString();
        sMall = getResources().getString(R.string.sMall).toString();
        sMarket = getResources().getString(R.string.sMarket).toString();
        sPark = getResources().getString(R.string.sPark).toString();

        nombres[0] = sChurch;
        nombres[1] = sMall;
        nombres[2] = sMarket;
        nombres[3] = sPark;

        GridView grid = (GridView) findViewById(R.id.gridPuntos);
        grid.setAdapter(new AdapterMapa(this, imagenes, nombres));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(ListaUbicaciones.this, "" + position,  Toast.LENGTH_SHORT).show();
                mostrarMapa(view, position + 1);
            }
        });
    }

    public void mostrarMapa(View view, int valor){
        Intent intent = new Intent(this, MapaUbicacion.class);
        intent.putExtra("ubicacion", valor);
        startActivity(intent);
    }
}
