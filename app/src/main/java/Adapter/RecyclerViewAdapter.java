package Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.gesportb.R;

import java.util.ArrayList;

import Clases.UserAsistencia;
import Clases.Users;
import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    //vars
    private ArrayList<Users> mNames;
    private Context mContext;
    int asis = 1;
    String algo;
    String algo1;


    public RecyclerViewAdapter(Context context, ArrayList<Users> names) {
        this.mNames = names;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_ofertas,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        UserAsistencia userAsistencia= new UserAsistencia();


        //holder.name.setText(mNames.get(position).getNombre_usuario());
        //holder.name.setText(mNames.get(position).getCorreo());


    }



    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView name;
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nombre);
        }


    }
}
