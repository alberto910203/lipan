package android.alberto.app.lipangomovil;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Consultar_Proveedores extends ListActivity {
    private Button Actualizar;
    private Button Regresar;
    SQLiteDatabase baseDatos = null;
    private EditText id_material_proveedor, nombre_proveedor, direccion, telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar__proveedores);
        //adaptador
        setListAdapter(new Adaptador_Proveedores(this));
        Actualizar = (Button) findViewById(R.id.actualizar);
        Regresar = (Button) findViewById(R.id.Regresar_menu);
        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(Consultar_Proveedores.this, Administrador.class);
                Consultar_Proveedores.this.startActivity(m);
            }
        });
        Actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(Consultar_Proveedores.this, Consultar_Proveedores.class);
                Consultar_Proveedores.this.startActivity(m);
            }
        });
    }

    public void Agregar_Proveedor(View view) {
        //LayoutInflater inflater = actividad.getLayoutInflater();
        //View viewe = inflater.inflate(R.layout.dialog_interface, null, true);
        //this.getLayoutInflater().inflate(R.layout.dialog_interface, null, true);
        View v = this.getLayoutInflater().inflate(R.layout.dialog_interface_add_proveedores, null);
        baseDatos = this.openOrCreateDatabase("LipanDb", MODE_PRIVATE, null);
        //String crearTabla_Materiales ="CREATE TABLE IF NOT EXISTS Materiales(id_material integer primary key autoincrement, id_material_proveedor integer, nombre_material text, descripcion text, unidad_medida text, stock_base integer, stock_actual integer, precio text)";
        String crearTabla_Proveedores = "CREATE TABLE IF NOT EXISTS Proveedores(id_proveedor integer primary key autoincrement, id_material_proveedor integer, nombre_proveedor text, telefono text, direccion text)";
        baseDatos.execSQL(crearTabla_Proveedores);


        id_material_proveedor = (EditText) v.findViewById(R.id.id_material_provedor_d);
        nombre_proveedor = (EditText) v.findViewById(R.id.nombre_proveedor_d);
        direccion = (EditText) v.findViewById(R.id.direccion_d);
        telefono = (EditText) v.findViewById(R.id.telefono_d);

        //final EditText nombre_material = new EditText(this);
        new AlertDialog.Builder(this)
                .setTitle("Agregar Proveedores")
                .setMessage("Llena los Campos")
                //.setView(nombre_material)
                .setView(v)
                //.setView(this.getLayoutInflater().inflate(R.layout.dialog_interface, null, true))
                .setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {

                        String id_material_provedor_s = id_material_proveedor.getText().toString();
                        String nombre_proveedor_s = nombre_proveedor.getText().toString();
                        String direccion_s = direccion.getText().toString();
                        String telefono_s = telefono.getText().toString();

                        String insert1 = "INSERT INTO Proveedores (id_proveedor, id_material_proveedor, nombre_proveedor, direccion, telefono) VALUES (null, '" + id_material_provedor_s + "','" + nombre_proveedor_s + "', '" + direccion_s + "','" + telefono_s + "');";
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
        //setListAdapter(new Adaptador_Materiales(this));
        Intent i = new Intent(this, Modificar_Status_Proveedor.class);
        position=position+1;
        i.putExtra("position", position+"");
        startActivityForResult(i,0);
    }

}