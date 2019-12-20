package com.example.gesportb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    Button btn_login;
    TextInputEditText txt_password,txt_email,txt_user ;
    TextView registrar, olvidoContraseña;
    ProgressDialog progreso;
    SessionManager sessionManager;
    //SaveSharedPreferences saveSharedPreferences;
    SharedPreferencesConfig preferencesConfig;
    public static String login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Window w = getWindow();
        getSupportActionBar().hide();
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //sessionManager= new SessionManager(this);
        preferencesConfig= new SharedPreferencesConfig(getApplicationContext());


        txt_user=findViewById(R.id.txt_user);
        txt_password = findViewById(R.id.txt_password);
        btn_login = findViewById(R.id.btn_login);
        registrar = findViewById(R.id.registrar);
        olvidoContraseña = findViewById(R.id.olvidoContraseña);

        //Boton para ingresar
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login = txt_user.getText().toString();
                Login();
            }
        });

    }

    private void Login() {
        progreso = new ProgressDialog(this);
        progreso.setMessage("CARGANDO...");
        progreso.show();


            String url="http://192.168.1.34/prueba/login.php";
        StringRequest stringRequest= new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try{
                    //response=response.replace("array(0){\n}\n ", "");
                    JSONObject jsonObject= new JSONObject(response);
                    boolean ok= jsonObject.getBoolean("success");

                    if(ok==true){

                        preferencesConfig.writeLohginStatus(true);

                        Intent bienvenido = new Intent(Login.this,MainActivity.class);
                        startActivity(bienvenido);
                        progreso.hide();
                        finish();


                    }else{
                        Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                        progreso.hide();
                    }

                }catch (JSONException e){
                    e.getMessage();
                }
                Log.e("response",response.toString());
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Conexion Fallida", Toast.LENGTH_SHORT).show();
                        progreso.hide();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String,String>();
                parametros.put("nombre_usuario",txt_user.getText().toString());
                parametros.put("contraseña",txt_password.getText().toString());
                return parametros;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
