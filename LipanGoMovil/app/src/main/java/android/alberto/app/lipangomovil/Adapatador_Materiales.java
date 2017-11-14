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
 * Created by AlBeRtO on 24/04/2017.
 */

public class Adapatador_Materiales extends BaseAdapter{
    ArrayList<Materiales> listaMateriales = null;
    SQLiteDatabase baseDatos = null;
    Cursor cursor = null;

    Activity actividad;

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getCount() {
        return listaMateriales.size();
    }

    @Override
    public Object getItem(int position) {
        return listaMateriales.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.renglon_materiales, null, true);

        TextView id_material = (TextView) view.findViewById(R.id.id_material);
        TextView id_material_proveedor = (TextView) view.findViewById(R.id.id_proveedor_material);
        TextView nombre_material = (TextView) view.findViewById(R.id.nombre_material);
        TextView decripcion = (TextView) view.findViewById(R.id.decripcion);
        TextView unidad_medida = (TextView) view.findViewById(R.id.unidad_medida);
        TextView stock_base = (TextView) view.findViewById(R.id.stock_base);
        TextView stock_actual= (TextView) view.findViewById(R.id.stock_actual);
        TextView precio = (TextView) view.findViewById(R.id.precio);


        Materiales material = listaMateriales.get(position);
        id_material.setText("Id_material:------------------------------"+ material.get_id_material());
        id_material_proveedor.setText("Id_Material_Proveedor:--------------"+ material.get_id_material_proveedor());
        nombre_material.setText("Nombre del Marerial:-----------------"+ material.getNombre_material());
        decripcion.setText("Descripcion:-----------------------------"+ material.getDescripcion());
        unidad_medida.setText("Unidad de Medida:---------------------"+ material.getUnidad_medida());
        stock_base.setText("Stock Base:------------------------------"+ material.getStock_base());
        stock_actual.setText("Stock Actual:----------------------------"+ material.getStock_actual());
        precio.setText("Precio:-------------------------------------"+ material.getPrecio());
        return view;

    }

    public Adapatador_Materiales(Activity actividad) {
        this.actividad = actividad;
        baseDatos = actividad.openOrCreateDatabase("LipanDb", actividad.MODE_PRIVATE, null);
        String crearTabla_Materiales = "CREATE TABLE IF NOT EXISTS Materiales (id_material integer primary key autoincrement, id_material_proveedor integer, nombre_material text, descripcion text, unidad_medida text, stock_base integer, stock_actual integer, precio text)";
        baseDatos.execSQL(crearTabla_Materiales);
        String sql = "SELECT * FROM Materiales;";
        cursor = baseDatos.rawQuery(sql, null);//Puede devolver 0, 1 o muchos registros
        //txtDatos.append("\nTamaño: "+ baseDatos.getPageSize());//Tamaño de la BD en bytes//Se le agrega al txtView
        //txtDatos.append("\nColumnas: "+ cursor.getColumnCount()); //Num columnas
        int renglones = cursor.getCount();//Num Renglones
        //int columnas = cursor.getColumnCount();
        //txtDatos.append("\nRenglones: "+ renglones);
        cursor.moveToFirst(); //Ir al primer registro
        //while (cursor.moveToNext()) {

        listaMateriales = new ArrayList<Materiales>(); //Crea la colección vacía

        for (int i = 0; i < renglones; i++) {
            final int _id_material = cursor.getInt(0);
            final int _id_material_proveedor = cursor.getInt(1);
            String nombre_material = cursor.getString(2);
            String decripcion = cursor.getString(3);
            String unidad_medida = cursor.getString(4);
            final int stock_base = cursor.getInt(5);
            final int stock_actual = cursor.getInt(6);
            final int precio = cursor.getInt(7);
            //txtDatos.append("\n" + matricula + " " + nombre + " " + semestre);
            //Llenar la colección con datos de la base de datos
            //notifyDataSetChanged();
            listaMateriales.add(new Materiales(_id_material, _id_material_proveedor, nombre_material, decripcion, unidad_medida, stock_base, stock_actual,precio));
            cursor.moveToNext();
            baseDatos.close();
        }

    }
}
