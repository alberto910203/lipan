package android.alberto.app.lipangomovil;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AlBeRtO on 25/04/2017.
 */

public class Adaptador_Proveedores  extends BaseAdapter{
    Activity actividad;
    ArrayList<Proveedores> listaProvedores = null;
    SQLiteDatabase baseDatos = null;
    Cursor cursor = null;
    @Override
    public int getCount() {
        return listaProvedores.size();
    }

    @Override
    public Object getItem(int position) {
        return listaProvedores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.renglon_proveedores, null, true);
        TextView id_proveedor = (TextView) view.findViewById(R.id.id_proveedor_r);
        TextView id_material_proveedor = (TextView) view.findViewById(R.id.id_material_proveedor_r);
        TextView nombre_proveedor = (TextView) view.findViewById(R.id.nombre_proveedor_r);
        TextView direccion = (TextView) view.findViewById(R.id.direccion_r);
        TextView telefono = (TextView) view.findViewById(R.id.telefono_r);



        Proveedores proveedor = listaProvedores.get(position);
        id_proveedor.setText("Id_proveedor:------------------------------"+ proveedor.get_id_proveedor());
        id_material_proveedor.setText("Id_Material_Proveedor:--------------"+ proveedor.get_id_material_proveedor());
        nombre_proveedor.setText("Nombre del Proveedor:-----------------"+ proveedor.getNombre_proveedor());
        direccion.setText("Direccion:-----------------------------"+ proveedor.getDireccion());
        telefono.setText("Telefono:---------------------"+ proveedor.getTelefono());
        return view;

    }

    public Adaptador_Proveedores(Activity actividad) {
        this.actividad = actividad;
        baseDatos = actividad.openOrCreateDatabase("LipanDb", actividad.MODE_PRIVATE, null);
        String crearTabla_Proveedores ="CREATE TABLE IF NOT EXISTS Proveedores(id_proveedor integer primary key autoincrement, id_material_proveedor integer, nombre_proveedor text, telefono text, direccion text)";
        //baseDatos = this.actividad.openOrCreateDatabase("Usersdb_v1",actividad.MODE_PRIVATE, null);
        //String insert1 = "INSERT INTO Materiales (id_material, id_material_proveedor, nombre_material, descripcion, unidad_medida, stock_base, stock_actual, precio) VALUES (null, ' 1 ', 'Azucar Morena', 'Azucar Morena Refinada', 'Kilogramos', '100', '90','50 pesos el Kilogramo');";
        //baseDatos.execSQL(insert1);

        baseDatos.execSQL(crearTabla_Proveedores);

        String sql = "SELECT * FROM Proveedores;";
        cursor = baseDatos.rawQuery(sql, null);//Puede devolver 0, 1 o muchos registros
        //txtDatos.append("\nTamaño: "+ baseDatos.getPageSize());//Tamaño de la BD en bytes//Se le agrega al txtView
        //txtDatos.append("\nColumnas: "+ cursor.getColumnCount()); //Num columnas
        int renglones = cursor.getCount();//Num Renglones
        //int columnas = cursor.getColumnCount();
        //txtDatos.append("\nRenglones: "+ renglones);
        cursor.moveToFirst(); //Ir al primer registro
        //while (cursor.moveToNext()) {

        listaProvedores = new ArrayList<Proveedores>(); //Crea la colección vacía

        for (int i = 0; i < renglones; i++) {
            final int _id_proveedor = cursor.getInt(0);
            final int _id_material_proveedor = cursor.getInt(1);
            String nombre_proveedor = cursor.getString(2);
            String direccion = cursor.getString(3);
            String telefono = cursor.getString(4);
            //txtDatos.append("\n" + matricula + " " + nombre + " " + semestre);
            //Llenar la colección con datos de la base de datos
            listaProvedores.add(new Proveedores(_id_proveedor, _id_material_proveedor, nombre_proveedor, direccion, telefono));
            cursor.moveToNext();
            baseDatos.close();
        }
    }
}
