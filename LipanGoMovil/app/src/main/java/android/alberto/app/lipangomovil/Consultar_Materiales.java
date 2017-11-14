package android.alberto.app.lipangomovil;

import android.app.Activity;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Consultar_Materiales extends ListActivity {
    private Button Regresar;
    private Button Actualizar;
    //private Button Agregar_Material;
    SQLiteDatabase baseDatos = null;
    EditText id_material_proveedor;
    EditText nombre_material;
    EditText decripcion;
    EditText unidad_medida;
    EditText stock_base;
    EditText stock_actual;
    EditText precio;
    Cursor cursor = null;
    Activity actividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar__materiales);
        setListAdapter(new Adapatador_Materiales(this));
        //Adaptador_Materiales.notifyDataSetChanged();
        Actualizar = (Button) findViewById(R.id.actualizar);
        //Agregar_Material=(Button) findViewById(R.id.Agregar_Material);
        Regresar = (Button) findViewById(R.id.Regresar_menu);
        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m =new Intent(Consultar_Materiales.this, Administrador.class);
                Consultar_Materiales.this.startActivity(m);
            }
        });

        Actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m =new Intent(Consultar_Materiales.this, Consultar_Materiales.class);
                Consultar_Materiales.this.startActivity(m);
            }
        });
    }
    public void Agregar_Material(View view){
        //LayoutInflater inflater = actividad.getLayoutInflater();
        //View viewe = inflater.inflate(R.layout.dialog_interface, null, true);
        //this.getLayoutInflater().inflate(R.layout.dialog_interface, null, true);
        View v = this.getLayoutInflater().inflate(R.layout.dialog_interface_materiales, null);
        baseDatos = this.openOrCreateDatabase("LipanDb", MODE_PRIVATE, null);
        String crearTabla_Materiales ="CREATE TABLE IF NOT EXISTS Materiales(id_material integer primary key autoincrement, id_material_proveedor integer, nombre_material text, descripcion text, unidad_medida text, stock_base integer, stock_actual integer, precio text)";
        baseDatos.execSQL(crearTabla_Materiales);


        id_material_proveedor = (EditText) v.findViewById(R.id.id_material_provedor);
        nombre_material = (EditText) v.findViewById(R.id.nombre_material_s);
        decripcion = (EditText) v.findViewById(R.id.descripcion);
        unidad_medida = (EditText) v.findViewById(R.id.unidad_medida_s);
        stock_base = (EditText) v.findViewById(R.id.stock_base_s);
        stock_actual= (EditText) v.findViewById(R.id.stock_actual_s);
        precio = (EditText) v.findViewById(R.id.Precio_s);




        //final EditText nombre_material = new EditText(this);
        new AlertDialog.Builder(this)
                .setTitle("Agregar Material")
                .setMessage("Llena los Campos")
                //.setView(nombre_material)
                .setView(v)
                //.setView(this.getLayoutInflater().inflate(R.layout.dialog_interface, null, true))
                .setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {

                        String id_material_provedor_s = id_material_proveedor.getText().toString();
                        String nombre_material_s = nombre_material.getText().toString();
                        String descripcion_s = decripcion.getText().toString();
                        String unidad_medida_s = unidad_medida.getText().toString();
                        String stock_base_s = stock_base.getText().toString();
                        String stock_actual_s = stock_actual.getText().toString();
                        String precio_s = precio.getText().toString();

                        String insert1 = "INSERT INTO Materiales (id_material, id_material_proveedor, nombre_material, descripcion, unidad_medida, stock_base, stock_actual, precio) VALUES (null, '" + id_material_provedor_s + "','" + nombre_material_s + "', '" + descripcion_s + "','" + unidad_medida_s + "','" + stock_actual_s + "','" + stock_base_s + "','" + precio_s + "');";
                        baseDatos.execSQL(insert1);

                    }
                })
                .setNegativeButton("Cancelar", null)
                .show();
        //return builder.show();
    }

    protected void onListItemClick(ListView listView, View view, int position, long id ){
        super.onListItemClick(listView, view, position, id);
        Object o = getListAdapter().getItem(position);
        Toast.makeText(this, "Seleccion: " + Integer.toString(position) + " - " + o.toString(), Toast.LENGTH_SHORT).show();
        setListAdapter(new Adapatador_Materiales(this));
        Intent i = new Intent(this, Modificar_materiales.class);
        position=position+1;
        i.putExtra("position", position+"");
        startActivityForResult(i,0);
    }


}
