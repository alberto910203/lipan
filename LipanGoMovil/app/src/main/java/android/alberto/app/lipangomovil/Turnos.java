package android.alberto.app.lipangomovil;

/**
 * Created by AlBeRtO on 26/04/2017.
 */

public class Turnos {
    private int id_turno;
    private String  nombre_usuario;
    private String apellido_usuario;
    private String fecha_inicio;
    private String fecha_fin;
    private String hora_inicio;
    private String hora_fin;
    private String trabajadores;


    public Turnos(int id_turno, String nombre_usuario, String apellido_usuario, String fecha_inicio, String fecha_fin, String hora_inicio, String hora_fin, String trabajadores) {
        this.id_turno = id_turno;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.trabajadores = trabajadores;

    }

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(String trabajadores) {
        this.trabajadores = trabajadores;
    }


}

