package android.alberto.app.lipangomovil;

/**
 * Created by AlBeRtO on 24/04/2017.
 */

public class Materiales {
    private int _id_material;
    private int _id_material_proveedor;
    //private int _id_proveedor;
    // private int nombre_proveedor;
    //private String telefono;
    //private String direccion;
    private String nombre_material;
    private String descripcion;
    private String unidad_medida;
    private int stock_base;
    private int stock_actual;
    private int precio;

    public Materiales(int _id_material, int _id_material_proveedor, String nombre_material, String descripcion, String unidad_medida, int stock_base, int stock_actual, int precio) {
        this._id_material = _id_material;
        this._id_material_proveedor = _id_material_proveedor;
        this.precio = precio;
        this.nombre_material = nombre_material;
        this.descripcion = descripcion;
        this.unidad_medida = unidad_medida;
        this.stock_base = stock_base;
        this.stock_actual = stock_actual;
    }

    public int get_id_material() {
        return _id_material;
    }

    public void set_id_material(int _id_material) {
        this._id_material = _id_material;
    }

    public int get_id_material_proveedor() {
        return _id_material_proveedor;
    }

    public void set_id_material_proveedor(int _id_material_proveedor) {
        this._id_material_proveedor = _id_material_proveedor;
    }

    public String getNombre_material() {
        return nombre_material;
    }

    public void setNombre_material(String nombre_material) {
        this.nombre_material = nombre_material;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public int getStock_base() {
        return stock_base;
    }

    public void setStock_base(int stock_base) {
        this.stock_base = stock_base;
    }

    public int getStock_actual() {
        return stock_actual;
    }

    public void setStock_actual(int stock_actual) {
        this.stock_actual = stock_actual;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}

