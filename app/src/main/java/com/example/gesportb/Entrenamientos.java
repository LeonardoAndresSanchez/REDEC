package com.example.gesportb;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import Adapter.RecyclerViewAdapterr;
import Clases.Users;


/**
 * A simple {@link Fragment} subclass.
 */
public class Entrenamientos extends Fragment{


    Toolbar toolbar;

    RequestQueue queue;
    Gson gson = new Gson();
    //vars
    private ArrayList<Users> mNames = new ArrayList<>();


    public Entrenamientos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_entrenamientos, container, false);


        Window w = getActivity().getWindow();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        ((AppCompatActivity) getActivity()).setTitle("Entrenamientos");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(true);




        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        final RecyclerView recyclerView = root.findViewById(R.id.recycler_view2);
        recyclerView.setLayoutManager(layoutManager);
        final RecyclerViewAdapterr adapter = new RecyclerViewAdapterr(getContext(), mNames);

        recyclerView.setAdapter(adapter);
        queue = Volley.newRequestQueue(getContext());


        final String url = "http://192.168.1.34/prueba/consultar.php";
        StringRequest requestInicio = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                response = quitarSaltos(response);

                Type type = new TypeToken<List<Users>>() {
                }.getType();
                mNames = gson.fromJson(response, type);

                RecyclerViewAdapterr adapter = new RecyclerViewAdapterr(getContext(), mNames);
                recyclerView.setAdapter(adapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("NO LLEGA", error.toString());

            }
        });

        queue.add(requestInicio);


        return root;

    }


    private String quitarSaltos(String response) {
        return response.replace("\n" +
                "  ", "");
    }


}
