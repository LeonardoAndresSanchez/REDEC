package Clases;

import android.content.Context;

public class Users {

    String nombre_usuario;
    String correo;
    Context context;
    int asis;

    public int getAsis() {
        return asis;
    }

    public void setAsis(int asis) {
        this.asis = asis;
    }

    public Users(int asis) {
        this.asis = asis;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Users(Context context) {
        this.context = context;
    }

    public Users() {
    }


    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
