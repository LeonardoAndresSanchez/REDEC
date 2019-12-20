package Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.gesportb.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import Clases.Entrenamientos;
import Clases.Users;
import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerViewAdapterr extends RecyclerView.Adapter<RecyclerViewAdapterr.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    //vars
    private ArrayList<Users> mNames;
    private Context mContext;
    int asis = 1;
    String algo;
    String algo1;


    public RecyclerViewAdapterr(Context context, ArrayList<Users> names) {
        this.mNames = names;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_entrenamientos,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        Entrenamientos entrenamientos = new Entrenamientos();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();

        String fecha = dateFormat.format(date);
        holder.fecha.setText(fecha);

        holder.name.setText("Lugar");
        holder.asistentes.setText("Entrenador");


    }



    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView name, asistentes,fecha,hora;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nombre);
            asistentes = itemView.findViewById(R.id.descripcion);
            fecha = itemView.findViewById(R.id.fecha);
            hora = itemView.findViewById(R.id.hora);
        }


    }
}
