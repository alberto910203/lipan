package android.alberto.app.lipangomovil;

import android.widget.EditText;

/**
 * Created by AlBeRtO on 02/05/2017.
 */

public class Consulta_revision {
    private int id_produccion_pan_blanco;
    private int id_turnos_produccion_pan_blanco;
    private String nombre;
    private String apellido;
    private String fecha;
    private String hora;
    private int cant_bolillo;
    private int cant_bolillo_chico;
    private int cant_bolillo_mignon;
    private int cant_pan_acimo;
    private int cant_pambazo;
    private int cant_pambazo_grande;
    private String trabajadores;
    private String comentarios;


    public Consulta_revision(int id_produccion_pan_blanco, int id_turnos_produccion_pan_blanco, String nombre, String apellido, String fecha, String hora, int cant_bolillo, int cant_bolillo_chico, int cant_bolillo_mignon, int cant_pan_acimo, int cant_pambazo, int cant_pambazo_grande, String trabajadores, String comentarios) {
        this.id_produccion_pan_blanco = id_produccion_pan_blanco;
        this.id_turnos_produccion_pan_blanco = id_turnos_produccion_pan_blanco;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.hora = hora;
        this.cant_bolillo = cant_bolillo;
        this.cant_bolillo_chico = cant_bolillo_chico;
        this.cant_bolillo_mignon = cant_bolillo_mignon;
        this.cant_pan_acimo = cant_pan_acimo;
        this.cant_pambazo = cant_pambazo;
        this.cant_pambazo_grande = cant_pambazo_grande;
        this.trabajadores = trabajadores;
        this.comentarios = comentarios;
    }

    public int getId_produccion_pan_blanco() {
        return id_produccion_pan_blanco;
    }

    public void setId_produccion_pan_blanco(int id_produccion_pan_blanco) {
        this.id_produccion_pan_blanco = id_produccion_pan_blanco;
    }

    public int getId_turnos_produccion_pan_blanco() {
        return id_turnos_produccion_pan_blanco;
    }

    public void setId_turnos_produccion_pan_blanco(int id_turnos_produccion_pan_blanco) {
        this.id_turnos_produccion_pan_blanco = id_turnos_produccion_pan_blanco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public int getCant_bolillo() {
        return cant_bolillo;
    }

    public void setCant_bolillo(int cant_bolillo) {
        this.cant_bolillo = cant_bolillo;
    }

    public int getCant_bolillo_chico() {
        return cant_bolillo_chico;
    }

    public void setCant_bolillo_chico(int cant_bolillo_chico) {
        this.cant_bolillo_chico = cant_bolillo_chico;
    }

    public int getCant_bolillo_mignon() {
        return cant_bolillo_mignon;
    }

    public void setCant_bolillo_mignon(int cant_bolillo_mignon) {
        this.cant_bolillo_mignon = cant_bolillo_mignon;
    }

    public int getCant_pan_acimo() {
        return cant_pan_acimo;
    }

    public void setCant_pan_acimo(int cant_pan_acimo) {
        this.cant_pan_acimo = cant_pan_acimo;
    }

    public int getCant_pambazo() {
        return cant_pambazo;
    }

    public void setCant_pambazo(int cant_pambazo) {
        this.cant_pambazo = cant_pambazo;
    }

    public int getCant_pambazo_grande() {
        return cant_pambazo_grande;
    }

    public void setCant_pambazo_grande(int cant_pambazo_grande) {
        this.cant_pambazo_grande = cant_pambazo_grande;
    }

    public String getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(String trabajadores) {
        this.trabajadores = trabajadores;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
