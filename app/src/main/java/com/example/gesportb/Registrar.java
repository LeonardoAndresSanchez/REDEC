package com.example.gesportb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class Registrar extends AppCompatActivity {

    TextInputEditText txt_password,txt_email,txt_user,txt_nombre ;
    Button btn_registar;

    ProgressDialog progreso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        Window w = getWindow();
        getSupportActionBar().hide();
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        txt_email = findViewById(R.id.txt_correo);
        txt_nombre =findViewById(R.id.txt_nombre);
        txt_password = findViewById(R.id.txt_password);
        btn_registar = findViewById(R.id.btn_registrar);


        btn_registar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user =txt_nombre.getText().toString();
                String email = txt_email.getText().toString();
                String password = txt_password.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) ){
                    Toast.makeText(Registrar.this, "all fields are required", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6){
                    Toast.makeText(Registrar.this, "password most be at least 6 characters", Toast.LENGTH_SHORT).show();
                }else{
                    Registro();
                }

            }
        });

    }
    private void Registro() {
        progreso = new ProgressDialog(this);
        progreso.setMessage("CARGANDO...");
        progreso.show();

        String url="http://192.168.1.34/prueba/registro.php";

        //url = url.replace(" ", "%20");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "OPERACION EXITOSA"+response, Toast.LENGTH_SHORT).show();
                progreso.hide();
                txt_nombre.setText("");
                txt_password.setText("");
                txt_email.setText("");
                Intent bienvenido = new Intent(Registrar.this,Login.class);

                Registrar.this.startActivity(bienvenido);
                Registrar.this.finish();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_SHORT).show();
                progreso.hide();
            }

        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String,String>();
                parametros.put("contraseña",txt_password.getText().toString());
                parametros.put("nombre_usuario",txt_nombre.getText().toString());
                parametros.put( "correo",txt_email.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
