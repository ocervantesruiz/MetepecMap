package mx.octaviocervantes.metepecmap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tavo on 22/10/2016.
 */
public class AdapterMapa extends BaseAdapter {

    private Context context;
    private int[] imagenes;
    private String[] nombres;
    private static LayoutInflater layoutInflater = null;

    public AdapterMapa(ListaUbicaciones context, int[] imagenes, String[] nombres) {
        this.context = context;
        this.imagenes = imagenes;
        this.nombres = nombres;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imagenes.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;

        rowView = layoutInflater.inflate(R.layout.itemlist, null);
        holder.textView = (TextView) rowView.findViewById(R.id.tvIcono);
        holder.imageView = (ImageView) rowView.findViewById(R.id.imgIcono);

        holder.textView.setText(nombres[position]);
        holder.imageView.setImageResource(imagenes[position]);

        return rowView;
    }

    public class Holder{
        ImageView imageView;
        TextView textView;
    }
}
