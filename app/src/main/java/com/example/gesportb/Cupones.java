package com.example.gesportb;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import Adapter.MovieAdapter;
import Clases.Movie;
import Clases.Users;


/**
 * A simple {@link Fragment} subclass.
 */
public class Cupones extends Fragment {

    Toolbar toolbar;

    RequestQueue queue;
    Gson gson = new Gson();
    //vars
    private ArrayList<Users> mNames = new ArrayList<>();
    //private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<Integer>();
    RecyclerView recyclerView;
    List<Movie> movieList;

    public Cupones() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_cupones, container, false);



        Window w = getActivity().getWindow();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
       // w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        ((AppCompatActivity) getActivity()).setTitle("Cupones");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(true);

        recyclerView = root.findViewById(R.id.recycler_view3);


        initData();
        
        initRecyclerView();
        return root;

    }

    private void initRecyclerView() {
        MovieAdapter movieAdapter = new MovieAdapter(getContext(),movieList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(movieAdapter);
    }

    private void initData() {
        movieList = new ArrayList<>();
        movieList.add(new Movie("NIKE","55% OFF","12/05/19","55% Descuento en tenis seleccionados C.C. Campanario local 105",R.drawable.des_nike));
        movieList.add(new Movie("Croquet","30% OFF","13/05/19","30% Descuento en toda la tienda  C.C. Terraplaza segundo piso loca 210",R.drawable.des_croquet));
        movieList.add(new Movie("Sport outlet","2x1","25/12/19","lleve 2x1 en Camisas de UNDERARMOR CC. Campanario local 114",R.drawable.des_sport));
        movieList.add(new Movie("Adidas","20% OFF","12/05/19","20% en Adidas boost C.C Titab Plaza local 35",R.drawable.des_adidas));
        movieList.add(new Movie("TOTTO","20%-55% OFF","12/05/19","20% - 50% Descuento en todas las tiendas C.C. Campanario local 110",R.drawable.des_totto));

    }

    /*private void getImages() {


        mImageUrls.add(R.drawable.des_nike);
        mNames.add("CC Unico");

        mImageUrls.add(R.drawable.des_croquet);
        mNames.add("Plaza colonial");

        mImageUrls.add(R.drawable.des_ropa);
        mNames.add("TerraPlaza");

        mImageUrls.add(R.drawable.des_sport);
        mNames.add("Cc Campanario");


    }*/

    private String quitarSaltos(String response) {
        return response.replace("\n" +
                "  ", "");
    }

}
