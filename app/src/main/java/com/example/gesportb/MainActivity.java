package com.example.gesportb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

import java.util.ArrayList;

import Adapter.RecyclerAdapterFotos;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    BottomNavigationView bottomNavigationView;
    DrawerLayout drawer;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    LinearLayout linearLista, linearLista2, linearLista3;
    Dialog myDialog;
    RequestQueue queue;
    final Gson gson = new Gson();
    CardView card1,card2,card3,card4;
    //vars
   // private ArrayList<Users> mNames = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<Integer>();



    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);



        myDialog = new Dialog(this);
        ShowPopup();


        bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        card1 = findViewById(R.id.card_1);
        card2 = findViewById(R.id.card_2);
        card3 = findViewById(R.id.card_3);
        card4 = findViewById(R.id.card_4);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Progreso.class);
                startActivity(intent);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Calendario.class);
                startActivity(intent);
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Perfil.class);
                startActivity(intent);
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Perfil.class);
                startActivity(intent);
            }
        });




        final Drawable bell = getResources().getDrawable(R.drawable.bell);
        bell.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        final Drawable logout = getResources().getDrawable(R.drawable.logout);
        logout.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);



    }

    private void ShowPopup() {
        TextView txtclose;
        myDialog.setContentView(R.layout.custompopup);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //myDialog.getWindow().getAttributes().verticalMargin = -0.18F;
        //myDialog.getWindow().getAttributes().horizontalMargin = 0.2F;
        myDialog.show();

    }
    private void ShowPopupr() {
        TextView txtclose;
        myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.custompopu_notificationp);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.getWindow().getAttributes().verticalMargin = -0.010F;
        myDialog.getWindow().getAttributes().horizontalMargin = 0.2F;

        final RecyclerView recyclerView = myDialog.findViewById(R.id.recycler_view_pop);
        queue = Volley.newRequestQueue(MainActivity.this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(myDialog.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerAdapterFotos adapter = new RecyclerAdapterFotos(getApplicationContext(), mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        getImages();





        myDialog.show();
    }

    private void getImages() {


        mImageUrls.add(R.drawable.des_nike);
        mNames.add("CC Unico");

        mImageUrls.add(R.drawable.des_croquet);
        mNames.add("Plaza colonial");

        mImageUrls.add(R.drawable.des_ropa);
        mNames.add("TerraPlaza");

        mImageUrls.add(R.drawable.des_sport);
        mNames.add("Cc Campanario");


    }



    private String quitarSaltos(String response) {
        return response.replace("\n" +
                "  ", "");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_notifications:
                ShowPopupr();
                break;

            case R.id.logout:
                Intent intent = new Intent(MainActivity.this, Ingreso.class);
                startActivity(intent);
                finish();
                break;
            case android.R.id.home:
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    Cupones cuponesFragment = new Cupones();
    Rendimiento rendimientoFragment = new Rendimiento();
    Entrenamientos entrenamientosFragment = new Entrenamientos();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.navigation_favourite:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out).replace(R.id.container, entrenamientosFragment).addToBackStack(null).commit();
                return true;

            case R.id.navigation_cart:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out).replace(R.id.container, cuponesFragment).commit();
                return true;

            case R.id.navigation_camera:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out).replace(R.id.container, rendimientoFragment).commit();
                return true;

            case R.id.inicio:
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
                break;


        }

        return false;
    }


}
