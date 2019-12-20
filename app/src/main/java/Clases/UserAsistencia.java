package Clases;

public class UserAsistencia {

    String nombreUsuario;
    String asistencia;
    String idBeneficiario;

    public UserAsistencia(String idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public String getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(String idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public UserAsistencia() {
    }
}
