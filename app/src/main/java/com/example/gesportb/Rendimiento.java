package com.example.gesportb;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.gson.Gson;

import java.util.ArrayList;

import Clases.Users;


/**
 * A simple {@link Fragment} subclass.
 */
public class Rendimiento extends Fragment {
    Toolbar toolbar;
    RadarChart radarChart;
    RequestQueue queue;
    Gson gson = new Gson();
    //vars
    private ArrayList<Users> mNames = new ArrayList<>();


    public Rendimiento() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_rendimiento, container, false);





        Window w = getActivity().getWindow();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
       // w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        ((AppCompatActivity) getActivity()).setTitle("Rendimiento");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(true);
        radarChart   = root.findViewById(R.id.radarChar);

        RadarDataSet dataSet1 = new RadarDataSet(dataValues1(),"Tests 1");
        RadarDataSet dataSet2 = new RadarDataSet(dataValues2(),"Tests 2");



        RadarData data = new RadarData();
        data.addDataSet(dataSet1);
        data.addDataSet(dataSet2);

        String[] labels = {"Fuerza","Resistencia","Pericia","Habilidad","Fuerza"};
        XAxis xAxis = radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));

        radarChart.setData(data);

    return root;
    }
    private ArrayList<RadarEntry>dataValues1(){
        ArrayList<RadarEntry>dataVals = new ArrayList<RadarEntry>();
        dataVals.add(new RadarEntry(5));
        dataVals.add(new RadarEntry(8));
        dataVals.add(new RadarEntry(3));
        dataVals.add(new RadarEntry(7));
        dataVals.add(new RadarEntry(4));

        return dataVals;

    }


    private ArrayList<RadarEntry>dataValues2(){
        ArrayList<RadarEntry>dataVals = new ArrayList<RadarEntry>();
        dataVals.add(new RadarEntry(8));
        dataVals.add(new RadarEntry(4));
        dataVals.add(new RadarEntry(9));
        dataVals.add(new RadarEntry(1));
        dataVals.add(new RadarEntry(7));

        return dataVals;

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                startActivity(new Intent(getContext(),MainActivity.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}
