package android.alberto.app.lipangomovil;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Registrar extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private int position;
    private String selection;
    //----------------------------Metodo para determinar la seleccion del valor para el spinner de la clase OnItemSelectedListener-------//
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Salvar la posición y valor del item actual
        this.position = position;
        selection = parent.getItemAtPosition(position).toString();

        //Mostramos la selección actual del Spinner
        Toast.makeText(this,"Selección actual: "+selection,Toast.LENGTH_SHORT).show();
    }
    //---------------------------------Metodo para determinar la seleccion nula de la clase OnItemSelectedListener--------------//
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    EditText name_r,apellido_r,pass_r,perfilpuesto,rfc,curp,nss,domicilio,telefono1,telefono2; //  declaracion de variables
    EditText puesto;
    EditText nombre_corto;
    EditText nivel_acceso;
    EditText status;
    Spinner tipo_usuario ;
    Button regresar_menu;
    static SQLiteDatabase baseDatos = null;
    Cursor cursor = null;
    protected ArrayAdapter<CharSequence> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        // asignar la variable al objeto con el id
        name_r = (EditText) findViewById(R.id.name_r);
        apellido_r = (EditText) findViewById(R.id.apellido_r);
        pass_r = (EditText) findViewById(R.id.pass_r);
        puesto = (EditText) findViewById(R.id.puesto);
        perfilpuesto = (EditText) findViewById(R.id.perfilpuesto);
        nombre_corto = (EditText) findViewById(R.id.nombre_corto);
        nivel_acceso = (EditText) findViewById(R.id.nivel_acceso);
        status = (EditText) findViewById(R.id.status);
        rfc = (EditText) findViewById(R.id.rfc);
        curp = (EditText) findViewById(R.id.curp);
        nss = (EditText) findViewById(R.id.nss);
        domicilio = (EditText) findViewById(R.id.domicilio);
        telefono1 = (EditText) findViewById(R.id.telefono1);
        telefono2 = (EditText) findViewById(R.id.telefono2);
        regresar_menu = (Button) findViewById(R.id.regresar_menu);
        //----------------------------------------Implementacion del Spiner para obtener el tipo de Usuarios--------//
        //Obtener instancia del spTipos
        tipo_usuario = (Spinner) findViewById(R.id.spTipos);
        //Asignas el origen de datos desde los recursos
        adapter = ArrayAdapter.createFromResource(this, R.array.tipos,
                android.R.layout.simple_spinner_item);
        //Asignas el layout a inflar para cada elemento
        // al momento de desplegar la lista
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //--------------------Para poner un select one option-----------------------------------

        //Seteas el adaptador(Aplicas el adaptor al spinner)
        tipo_usuario.setAdapter(adapter);
        //Asignado la escucha
        tipo_usuario.setOnItemSelectedListener(this);
        //tipo_usuario.setAdapter(
        //new NothingSelectedSpinnerAdapter(
        //adapter,
        //R.layout.contact_spinner_row_nothing_selected,
        //R.layout.contact_spinner_nothing_selected_dropdown, // Optional
        //this)
        //);
        //tipo_usuario.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);//Asiganr el escucha desde SpinnerActivity
        //------------------------------------------Intent para regresar del registro al menu Administrador--------------//
        regresar_menu.setOnClickListener(new View.OnClickListener() {  //metodo para ir de una clase a otra
            @Override
            public void onClick(View view) {   // contructor del metodo
                Intent rm = new Intent(Registrar.this, Administrador.class); // intent sirve para dar una accion, en este caso
                Registrar.this.startActivity(rm);                  // ir de una clase a otra
            }
        });
        //------------------------------------------Configuracion de la Base de Datos----------------------------------------//
        baseDatos = this.openOrCreateDatabase("LipanDb", MODE_PRIVATE, null); // configuracion de la base de datos
        String crearTabla = "CREATE TABLE IF NOT EXISTS Usuarios (id integer primary key autoincrement, nombre text, apellido text,contrasena text, puesto text, perfilpuesto text, nombrecorto text, tipousuario text, nivelacceso int, status text, rfc text, curp text, nss text, domicilio text, telefono1 text, telefono2 text);";
        String crearTabla_Materiales_Pb ="CREATE TABLE IF NOT EXISTS Materiales_pb(id_mat integer primary key autoincrement, id_usuario text, fecha DATETIME DEFAULT CURRENT_TIMESTAMP,  hora DATETIME DEFAULT CURRENT_TIMESTAMP, turno text, cant_harina integer, cant_azucar integer, cant_levadura integer, cant_sal integer,FOREIGN KEY(id_usuario) REFERENCES Usuarios(id) )";
        String crearTabla_Materiales = "CREATE TABLE IF NOT EXISTS Materiales (id_material integer primary key autoincrement, id_material_proveedor integer, nombre_material text, descripcion text, unidad_medida text, stock_base integer, stock_actual integer, precio text)";
        String crearTabla_Proveedor_Materiales = "CREATE TABLE IF NOT EXISTS Proveedores_Materiales(id_poveedores integer, id_material_proveedor integer, precio integer)  ";
        String crearTabla_Proveedores = "CREATE TABLE IF NOT EXISTS Proveedores(id_proveedor integer primary key autoincrement, id_material_proveedor integer, nombre_proveedor text, telefono text, direccion text)";
        //String insertar_admin="INSERT INTO Usuarios(id,nombre,apellido,contrasena)Values(null,'admin','admin','admin'); ";
        //baseDatos.execSQL(insertar_admin);
        baseDatos.execSQL(crearTabla);
        baseDatos.execSQL(crearTabla_Materiales_Pb);
        baseDatos.execSQL(crearTabla_Materiales);
        baseDatos.execSQL(crearTabla_Proveedor_Materiales);
        baseDatos.execSQL(crearTabla_Proveedores);

    }
    //------------------------------------Metodo para Insertar un nuevo usuario a la base de datos-------------------------------------------//
    public void insertar(View view) {
        try {
            String nombre = name_r.getText().toString();
            String apellido = apellido_r.getText().toString();
            String contrasena = pass_r.getText().toString();
            String puesto_s = puesto.getText().toString();
            String perfilpuesto_s = perfilpuesto.getText().toString();
            String nombre_corto_s = nombre_corto.getText().toString();
            String tipo_usuario_s = selection;
            String nivel_acceso_s = nivel_acceso.getText().toString();
            String status_s = status.getText().toString();
            String rfc_r = rfc.getText().toString();
            String curp_r = curp.getText().toString();
            String nss_r = nss.getText().toString();
            String domicilio_r = domicilio.getText().toString();
            String telefono1_r = telefono1.getText().toString();
            String telefono2_r = telefono2.getText().toString();
            String sql = "INSERT INTO Usuarios (id, nombre, apellido, contrasena, puesto, perfilpuesto,nombrecorto, tipousuario, nivelacceso, status,rfc,curp,nss,domicilio,telefono1,telefono2) VALUES (null, '" + nombre + "', '"+apellido+"','" + contrasena + "', " +
                    "'" + puesto_s + "','"+perfilpuesto_s+"' ,'" + nombre_corto_s + "', '" + tipo_usuario_s + "', '" + nivel_acceso_s + "','" + status_s + "','"+rfc_r+"','"+curp_r+"','"+nss_r+"','"+domicilio_r+"','"+telefono1_r+"','"+telefono2_r+"');";
            baseDatos.execSQL(sql);
            Toast.makeText(this, "Agregado", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error al insertar", Toast.LENGTH_SHORT).show();
        }//fin del try-catch

    }// fin del metodo insertar

}
