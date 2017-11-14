package android.alberto.app.lipangomovil;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.zip.Inflater;

public class Produccion_panblanco extends ListActivity {
   // variables locales de registro
    Button registrar_produccion,refrescar,regresar;
    String nombre;// variable donde guardo el valor del intent para el nombre
    String apellido;// variable donde guardo el valor del intent para el nombre
    SQLiteDatabase baseDatos = null; // Inicializar la variable para cargar/acceso la base de datos
    EditText id_produccionpanblanco,cant_bolillo,cant_bolillo_chico,cant_bolillo_mignon,cant_pan_acimo,cant_pambazo,cant_pambazo_grande;
    TextView fecha,nombre_usuario,apellido_usuario;
    String Tfecha;
    public String cant_bolillo_chico_modificar,cant_bolillo_mediano_modificar, cant_bolillo_grande_modificar,cant_telera_modificar;
    //----------------variables para el hilo del reloj-------
    int hora=0, minuto =0, segundo = 0;
    Thread iniReloj = null;
    Runnable r;
    boolean isUpdate = false;
    String sec, min, hor;
    String curTime;
    TextView thora;
    //--------------------------------------------------------
private Cursor fila;
    //Alert Dialog Manager instancia
    AlertDialogManager alert = new AlertDialogManager();

    // Administrador de sesion Class
    Administrador_sesion session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produccion_panblanco);
        setListAdapter(new Adaptador_produccion_panblanco(this));
        session = new Administrador_sesion(getApplicationContext());
        //Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();



        refrescar = (Button) findViewById(R.id.refrescar);
        regresar =(Button) findViewById(R.id.regresar);
        registrar_produccion = (Button) findViewById(R.id.registra_produccion);

        refrescar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent refrescar = new Intent(Produccion_panblanco.this, Produccion_panblanco.class);
                Produccion_panblanco.this.startActivity(refrescar);
            }
        });
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent refrescar = new Intent(Produccion_panblanco.this, Editar_produccion.class);
                Produccion_panblanco.this.startActivity(refrescar);

            }
        });

    }

    public void registrar_produccion_panblanco (View view){
        View v = this.getLayoutInflater().inflate(R.layout.dialog_interface_add_produccion_pb, null);
        // Aqui me quede 03/04/2017 5:10
        baseDatos = openOrCreateDatabase("LipanDb", MODE_PRIVATE, null);
        String Tabla_produccion_panblanco ="CREATE TABLE IF NOT EXISTS Produccion_panblanco(id_produccion_panblanco INTEGER PRIMARY KEY AUTOINCREMENT, fecha DATETIME DEFAULT CURRENT_TIMESTAMP, hora DATETIME DAFAULT CURRENT_TIMESTAMP, nombre_usuario TEXT, apellido_usuario TEXT, cant_bolillo INTEGER, cant_bolillo_chico INTEGER, cant_bolillo_mignon INTEGER, cant_pan_acimo INTEGER, cant_pambazo INTEGER, cant_pambazo_grande INTEGER)";
        baseDatos.execSQL(Tabla_produccion_panblanco);

//        id_produccion_panblanco =(EditText) v.findViewById(R.id.id_produccion_pb_d);
        fecha =(TextView) v.findViewById(R.id.fecha_d_pb);
        //thora =(TextView) v.findViewById(R.id.hora_d_pb);
        nombre_usuario =(TextView) v.findViewById(R.id.nombre_usuario_d_pb);
        //apellido_usuario = (TextView) v.findViewById(R.id.apellido_usuario_d_pb);

        cant_bolillo = (EditText) v.findViewById(R.id.cant_bolillo_d_pb);
        cant_bolillo_chico = (EditText) v.findViewById(R.id.cant_bolillo_chico_d_pb);
        cant_bolillo_mignon = (EditText) v.findViewById(R.id.cant_bolillo_mignon_d_pb);
        cant_pan_acimo = (EditText) v.findViewById(R.id.cant_pan_acimo_d_pb);
        cant_pambazo = (EditText) v.findViewById(R.id.cant_pambazo_d_pb);
        cant_pambazo_grande = (EditText) v.findViewById(R.id.cant_pambazo_grande_d_pb);


        session.checkLogin();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        // name
        final String nombre = user.get(Administrador_sesion.KEY_NOMBRE);

        // email
        final String apellido = user.get(Administrador_sesion.KEY_APELLIDO);



        nombre_usuario.setText(""+nombre+" "+apellido);
        //apellido_usuario.setText(""+apellido);
        cant_bolillo_chico_modificar = cant_bolillo_chico.getText().toString();


        Calendar c = Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy", new Locale("es"));
        Tfecha = formato.format(c.getTime());
        //fecha.setText(Html.fromHtml("Fecha y hora:<b> "+Tfecha+" - "+curTime+"</b>"));
        r = new RefreshClock(); // variables para la parte del reloj
        iniReloj = new Thread(r);
        iniReloj.start();


        new AlertDialog.Builder(this)
                .setTitle("Ingresar la Produccion")
                .setMessage("Llena los Campos")
                //.setView(nombre_material)
                .setView(v)
                //.setView(this.getLayoutInflater().inflate(R.layout.dialog_interface, null, true))
                .setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {

                       // crear cadenas para insertar en la base de datos
                        // String id_produccion_s = id_produccion_panblanco.getText().toString();
                        String fecha_s = Tfecha;
                        String hora_s = curTime;
                        final String nombre_usuario_s = nombre;
                        String apellido_usuario_s = apellido;
                        String cant_bolillo_s = cant_bolillo.getText().toString();
                        String cant_bolillo_chico_s = cant_bolillo_chico.getText().toString();
                        String cant_bolillo_mignon_s = cant_bolillo_mignon.getText().toString();
                        String cant_pan_acimo_s = cant_pan_acimo.getText().toString();
                        String cant_pambazo_s = cant_pambazo.getText().toString();
                        String cant_pambazo_grande_s = cant_pambazo_grande.getText().toString();


                        //Intent extra = new Intent(Produccion_panblanco.this,Produccion_panblanco.class);
                        //extra.putExtra("Nombre",nombre_usuario_s+"");

                        //startActivity(extra);

                        String insert1 = "INSERT INTO Produccion_panblanco(id_produccion_panblanco, fecha, hora, nombre_usuario, apellido_usuario, cant_bolillo, cant_bolillo_chico, cant_bolillo_mignon, cant_pan_acimo, cant_pambazo, cant_pambazo_grande) VALUES (null,'" + fecha_s + "', '" + hora_s + "','" + nombre_usuario_s + "','" + apellido_usuario_s + "','" + cant_bolillo_s + "','" + cant_bolillo_chico_s + "','" + cant_bolillo_mignon_s + "','" + cant_pan_acimo_s + "','"+ cant_pambazo_s+"','"+cant_pambazo_grande_s+"');";
                        baseDatos.execSQL(insert1);

                    }
                })
                .setNegativeButton("Cancelar", null)
                .show();


    }

    protected void onListItemClick(ListView listView, View view, int position, long id){
        super.onListItemClick(listView, view, position, id);
        Object o = getListAdapter().getItem(position);
        Toast.makeText(this, "Seleccion: " + Integer.toString(position) + " - " + o.toString(), Toast.LENGTH_SHORT).show();
        position = position + 1;

        baseDatos = this.openOrCreateDatabase("LipanDb", MODE_PRIVATE, null);
        fila = baseDatos.rawQuery("select cant_bolillo, cant_bolillo_chico, cant_bolillo_mignon, cant_pan_acimo, cant_pambazo, cant_pambazo_grande, fecha, hora from Produccion_panblanco where id_produccion_panblanco = '" + position + "' ", null);
        if (fila.moveToFirst()) {
            String cant_bolillo = fila.getString(0);
            String cant_bolillo_chico = fila.getString(1);
            String cant_bolillo_mignon = fila.getString(2);
            String cant_pan_acimo = fila.getString(3);
            String cant_pambazo = fila.getString(4);
            String cant_pambazo_grande = fila.getString(5);
            String fecha_s = fila.getString(6);
            String hora_s = fila.getString(7);



                Intent i = new Intent(Produccion_panblanco.this, Modificar_produccion_panblanco.class);


                i.putExtra("Position", position + "");
                //i.putExtra("Id_produccion", id_produccion);
                i.putExtra("Nombre", nombre + "");
                i.putExtra("Apellido", apellido + "");
                i.putExtra("Cant_bolillo_modificar", cant_bolillo + "");
                i.putExtra("Cant_bolillo_chico_modificar", cant_bolillo_chico + "");
                i.putExtra("Cant_bolillo_mignon_modificar", cant_bolillo_mignon + "");
                i.putExtra("Cant_pan_acimo_modificar", cant_pan_acimo + "");
                i.putExtra("Cant_pambazo_modificar", cant_pambazo + "");
                i.putExtra("Cant_pambazo_grande_modificar", cant_pambazo_grande + "");
                i.putExtra("Fecha_Inicial", fecha_s+"");
                i.putExtra("Hora_Inicial", hora_s+"");

                startActivityForResult(i, 3);

            }
        else{
            Toast.makeText(this, "no seleccionaste nada", Toast.LENGTH_SHORT).show();
        }
    }

    private void initClock() {
        runOnUiThread(new Runnable() {
            public void run() {
                try{

                    if(isUpdate){
                        settingNewClock();
                    } else {
                        updateTime();
                    }
                    curTime =hor+ hora + min + minuto + sec + segundo;
                    fecha.setText(Html.fromHtml("Fecha y hora:<b> "+Tfecha+" - "+curTime+"</b>"));

                }catch (Exception e) {}
            }
        });
    }

    class RefreshClock implements Runnable{
        // @Override
        @SuppressWarnings("unused")
        public void run() {
            while(!Thread.currentThread().isInterrupted()){
                try {
                    initClock();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }catch(Exception e){
                }
            }
        }
    }


    private void updateTime(){

        Calendar c = Calendar.getInstance();
        hora = c.get(Calendar.HOUR_OF_DAY);
        minuto = c.get(Calendar.MINUTE);
        segundo = c.get(Calendar.SECOND);
        setZeroClock();

    }


    private void setZeroClock(){
        if(hora >=0 & hora <=9){
            hor = "0";
        }else{
            hor = "";
        }

        if(minuto >=0 & minuto <=9){
            min = ":0";
        }else{
            min = ":";
        }

        if(segundo >=0 & segundo <=9){
            sec = ":0";

        }else{
            sec = ":";
        }
    }


    private void settingNewClock(){
        segundo +=1;

        setZeroClock();

        if(segundo >=0 & segundo <=59){

        }else {
            segundo = 0;
            minuto +=1;
        }
        if(minuto >=0 & minuto <=59){

        }else{
            minuto = 0;
            hora +=1;
        }
        if(hora >= 0 & hora <= 24){

        }else{
            hora = 0;
        }

    }

}
