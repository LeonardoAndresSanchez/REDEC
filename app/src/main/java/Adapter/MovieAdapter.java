package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gesportb.R;

import java.util.List;

import Clases.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieVH> {

    private static final String TAG = "MovieAdapter";
    List<Movie> movieList;
    private Context mContext;

    public MovieAdapter(Context context,List<Movie> movieList) {
        this.movieList = movieList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public MovieVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new MovieVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieVH holder, int position) {

        Movie movie = movieList.get(position);
        holder.tiendaTextView.setText(movie.getTitle());
        holder.fechaTextView.setText(movie.getYear());
        holder.descuentosTextView.setText(movie.getRating());
        holder.productosTextView.setText(movie.getPlot());
        Glide.with(mContext)
                .asBitmap()
                .load(movie.getFoto())
                .into(holder.promoImageView);

        boolean isExpanded = movieList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieVH extends RecyclerView.ViewHolder {

        private static final String TAG = "MovieVH";

        ConstraintLayout expandableLayout;
        TextView tiendaTextView, fechaTextView, descuentosTextView, productosTextView;
        ImageView promoImageView;

        public MovieVH(@NonNull final View itemView) {
            super(itemView);

            tiendaTextView = itemView.findViewById(R.id.tiendaTextView);
            fechaTextView = itemView.findViewById(R.id.fechaTextView);
            descuentosTextView = itemView.findViewById(R.id.descuentoTextView);
            productosTextView = itemView.findViewById(R.id.productosTextView);
            promoImageView = itemView.findViewById(R.id.promoImageView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);


            tiendaTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Movie movie = movieList.get(getAdapterPosition());
                    movie.setExpanded(!movie.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });
        }
    }
}
