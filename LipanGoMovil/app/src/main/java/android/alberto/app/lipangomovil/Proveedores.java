package android.alberto.app.lipangomovil;

/**
 * Created by AlBeRtO on 25/04/2017.
 */

public class Proveedores {
    private int _id_proveedor;
    private int _id_material_proveedor;
    private String nombre_proveedor;
    private String telefono;
    private String  direccion;

    public Proveedores(int _id_proveedor, int _id_material_proveedor, String nombre_proveedor, String telefono, String direccion) {
        this._id_proveedor = _id_proveedor;
        this._id_material_proveedor = _id_material_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int get_id_proveedor() {
        return _id_proveedor;
    }

    public void set_id_proveedor(int _id_proveedor) {
        this._id_proveedor = _id_proveedor;
    }

    public int get_id_material_proveedor() {
        return _id_material_proveedor;
    }

    public void set_id_material_proveedor(int _id_material_proveedor) {
        this._id_material_proveedor = _id_material_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
