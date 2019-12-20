package Clases;

public class Entrenamientos {
    String lugar;
    String fecha;
    String hora;
    String entrenador;

    public Entrenamientos(String lugar, String fecha, String hora, String entrenador) {
        this.lugar = lugar;
        this.fecha = fecha;
        this.hora = hora;
        this.entrenador = entrenador;
    }

    public Entrenamientos() {

    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }
}
