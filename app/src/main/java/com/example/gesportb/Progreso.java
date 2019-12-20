package com.example.gesportb;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class Progreso extends AppCompatActivity {

    RadarChart radarChart;
    Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progreso);

        Window w = getWindow();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
       // w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Progreso");


        radarChart   = findViewById(R.id.radarChar);

        RadarDataSet dataSet1 = new RadarDataSet(dataValues1(),"Tests 1");
        RadarDataSet dataSet2 = new RadarDataSet(dataValues2(),"Tests 2");

        dataSet1.setColor(getColor(R.color.item1));
        dataSet2.setColor(getColor(R.color.item2));

        RadarData data = new RadarData();
            data.addDataSet(dataSet1);
            data.addDataSet(dataSet2);

        String[] labels = {"Fuerza","Resistencia","Pericia","Habilidad","Fuerza"};
        XAxis xAxis = radarChart.getXAxis();
            xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));

            radarChart.setData(data);


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
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}
