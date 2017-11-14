package android.alberto.app.lipangomovil;

/**
 * Created by AlBeRtO on 20/04/2017.
 */

public class Usuarios {
    private int _id;
    private String nombre;
    private String apellido;
    private String contrasena;
    private String puesto;
    private String perfilpuesto;
    private String nombre_corto;
    private String tipo_usuario;
    private int nivel_acceso;
    private String status;
    private String rfc;
    private String curp;
    private String nss;
    private String domicilio;
    private String telefono1;
    private String telefono2;

    public Usuarios(int _id, String nombre, String apellido, String contrasena, String puesto, String perfilpuesto, String nombre_corto, String tipo_usuario, int nivel_acceso, String status, String rfc, String curp, String nss, String domicilio, String telefono1, String telefono2) {
        this._id = _id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.puesto = puesto;
        this.perfilpuesto = perfilpuesto;
        this.nombre_corto = nombre_corto;
        this.tipo_usuario = tipo_usuario;
        this.nivel_acceso = nivel_acceso;
        this.status = status;
        this.rfc = rfc;
        this.curp = curp;
        this.nss = nss;
        this.domicilio = domicilio;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getPerfilpuesto() {
        return perfilpuesto;
    }

    public void setPerfilpuesto(String perfilpuesto) {
        this.perfilpuesto = perfilpuesto;
    }

    public String getNombre_corto() {
        return nombre_corto;
    }

    public void setNombre_corto(String nombre_corto) {
        this.nombre_corto = nombre_corto;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public int getNivel_acceso() {
        return nivel_acceso;
    }

    public void setNivel_acceso(int nivel_acceso) {
        this.nivel_acceso = nivel_acceso;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }
}
