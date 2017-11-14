package android.alberto.app.lipangomovil;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
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

public class Produccion_pandulce extends ListActivity {
    Button registrar_produccion,refrescar,regresar;
    String nombre;// variable donde guardo el valor del intent para el nombre
    String apellido;// variable donde guardo el valor del intent para el nombre
    SQLiteDatabase baseDatos = null; // Inicializar la variable para cargar/acceso la base de datos
    EditText cant_bolillo,cant_bolillo_chico,cant_bolillo_mignon,cant_pan_acimo,cant_pambazo,cant_pambazo_grande;
    EditText cant_telera,cant_telera_grande,cant_bola_leche,cant_cuernito_estandar,cant_cuernito_chico,cant_cuernito_grande,cant_pan_dulce_estandar,cant_pan_dulce_chico;
    EditText cant_dona_especial,cant_dona_sencillo,cant_acambareno_grande,cant_concha_grande,cant_tortuga_grande,cant_pastel,cant_merengue_estandar,cant_merengue_cafe_chico;
    EditText cant_merengue_chico,cant_pasta_hojaldra,cant_reposteria_1,cant_reposteria_2,cant_reposteria_3,cant_reposteria_4,cant_reposteria_5,cant_hamburguesa_estandar;
    EditText cant_hamburguesa_chica,cant_pizza_mini,cant_pizza_chica,cant_pizza_grande,cant_pizza_mediana,cant_pizza_extra_grande;

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
        setContentView(R.layout.activity_produccion_pandulce);
        setListAdapter(new Adaptador_produccion_panblanco(this));
        session = new Administrador_sesion(getApplicationContext());







        refrescar = (Button) findViewById(R.id.refrescar);
        regresar =(Button) findViewById(R.id.regresar);
        registrar_produccion = (Button) findViewById(R.id.registra_produccion);
        refrescar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent refrescar = new Intent(Produccion_pandulce.this, Produccion_pandulce.class);
                Produccion_pandulce.this.startActivity(refrescar);
            }
        });
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent refrescar = new Intent(Produccion_pandulce.this, Produccion_total.class);
                Produccion_pandulce.this.startActivity(refrescar);

            }
        });

    }

    /*public void registrar_produccion_pandulce (View view){
        View v = this.getLayoutInflater().inflate(R.layout.dialog_interface_add_produccion_pd, null);
        // Aqui me quede 03/04/2017 5:10
        baseDatos = openOrCreateDatabase("LipanDb", MODE_PRIVATE, null);
        String Tabla_produccion_panblanco ="CREATE TABLE IF NOT EXISTS Produccion_total(id_produccion_total INTEGER PRIMARY KEY AUTOINCREMENT, fecha DATETIME DEFAULT CURRENT_TIMESTAMP, hora DATETIME DAFAULT CURRENT_TIMESTAMP, nombre_usuario TEXT, apellido_usuario TEXT, cant_bolillo INTEGER, cant_bolillo_chico INTEGER, cant_bolillo_mignon INTEGER, cant_pan_acimo INTEGER, cant_pambazo INTEGER, cant_pambazo_grande INTEGER,cant_telera INTEGER,cant_telera_grande INTEGER,bola_leche INTEGER, cuernito_estandar INTEGER, cuernito_chico INTEGER, cuernito_grande INTEGER, pan_dulce_estandar INTEGER, pan_dulce_chico INTEGER, dona_especial INTEGER, dona_sencillo INTEGER, acambareno_grande INTEGER, concha_grande INTEGER, tortuga_grande INTEGER, pastel INTEGER, merengue_estandar INTEGER, merengue_cafe_chico INTEGER, merengue_chico INTEGER, pasta_hojaldra INTEGER,reposteria_1 INTEGER, reposteria_2 INTEGER, reposteria_3 INTEGER, reposteria_4 INTEGER, reposteria_5 INTEGER, hamburguesa_estandar INTEGER, hamburguesa_chica INTEGER, pizza_mini INTEGER, pizza_chica INTEGER, pizza_grande INTEGER, pizza_mediana INTEGER, pizza_extra_grande INTEGER )";
        baseDatos.execSQL(Tabla_produccion_panblanco);

//        id_produccion_panblanco =(EditText) v.findViewById(R.id.id_produccion_pb_d);
        //fecha =(TextView) v.findViewById(R.id.fecha_d_pd);
        thora =(TextView) v.findViewById(R.id.hora_d_pd);
        nombre_usuario =(TextView) v.findViewById(R.id.nombre_usuario_d_pd);
        //apellido_usuario = (TextView) v.findViewById(R.id.apellido_usuario_d_pd);

        cant_bolillo = (EditText) v.findViewById(R.id.cant_bolillo_d_pd);
        cant_bolillo_chico = (EditText) v.findViewById(R.id.cant_bolillo_chico_d_pd);
        cant_bolillo_mignon = (EditText) v.findViewById(R.id.cant_bolillo_mignon_d_pd);
        cant_pan_acimo = (EditText) v.findViewById(R.id.cant_pan_acimo_d_pd);
        cant_pambazo = (EditText) v.findViewById(R.id.cant_pambazo_d_pd);
        cant_pambazo_grande = (EditText) v.findViewById(R.id.cant_pambazo_grande_d_pd);
        cant_telera =(EditText) v.findViewById(R.id.cant_telera_estandar_d_pd);
        cant_telera_grande = (EditText) v.findViewById(R.id.cant_telera_grande_d_pd);
        cant_bola_leche = (EditText) v.findViewById(R.id.cant_bola_leche_d_pd);
        cant_cuernito_estandar = (EditText) v.findViewById(R.id.cant_cuernito_estandar_d_pd);
        cant_cuernito_chico = (EditText) v.findViewById(R.id.cant_cuernito_chico_d_pd);
        cant_cuernito_grande = (EditText) v.findViewById(R.id.cant_cuernito_mignon_d_pd);
        cant_pan_dulce_estandar = (EditText) v.findViewById(R.id.cant_pan_dulce_estandar_d_pd);
        cant_pan_dulce_chico = (EditText) v.findViewById(R.id.cant_pan_dulce_chico_d_pd);
        cant_dona_especial = (EditText) v.findViewById(R.id.cant_dona_especial_d_pd);
        cant_dona_sencillo = (EditText) v.findViewById(R.id.cant_dona_sencilla_d_pd);
        cant_acambareno_grande = (EditText) v.findViewById(R.id.cant_acambareno_grande_d_pd);
        cant_concha_grande = (EditText) v.findViewById(R.id.cant_concha_grande_d_pd);
        cant_tortuga_grande = (EditText) v.findViewById(R.id.cant_tortuga_grande_d_pd);
        cant_pastel =(EditText) v.findViewById(R.id.cant_pastel_d_pd);
        cant_merengue_estandar = (EditText) v.findViewById(R.id.cant_merengue_estandar_d_pd);
        cant_merengue_cafe_chico = (EditText) v.findViewById(R.id.cant_merengue_cafe_chico_d_pd);
        cant_merengue_chico = (EditText) v.findViewById(R.id.cant_merengue_chico_d_pd);
        cant_pasta_hojaldra = (EditText) v.findViewById(R.id.cant_pasta_hojaldra_d_pd);
        cant_reposteria_1 = (EditText) v.findViewById(R.id.cant_reposteria_1_d_pd);
        cant_reposteria_2 = (EditText) v.findViewById(R.id.cant_reposteria_2_pd);
        cant_reposteria_3 = (EditText) v.findViewById(R.id.cant_reposteria_3_d_pd);
        cant_reposteria_4 = (EditText) v.findViewById(R.id.cant_reposteria_4_d_pd);
        cant_reposteria_5 = (EditText) v.findViewById(R.id.cant_reposteria_5_d_pd);
        cant_hamburguesa_estandar = (EditText) v.findViewById(R.id.cant_hamburguesa_estandar_d_pd);
        cant_hamburguesa_chica = (EditText) v.findViewById(R.id.cant_hamburguesa_chica_d_pd);
        cant_pizza_mini = (EditText) v.findViewById(R.id.cant_pizza_mini_d_pd);
        cant_pizza_chica = (EditText) v.findViewById(R.id.cant_pizza_chica_d_pd);
        cant_pizza_grande = (EditText) v.findViewById(R.id.cant_pizza_grande_d_pd);
        cant_pizza_mediana = (EditText) v.findViewById(R.id.cant_pizza_mediana_d_pd);
        cant_pizza_extra_grande = (EditText) v.findViewById(R.id.cant_pizza_extra_grande_d_pd);
        session.checkLogin();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        // name
        final String nombre = user.get(Administrador_sesion.KEY_NOMBRE);

        // email
        final String apellido = user.get(Administrador_sesion.KEY_APELLIDO);
        nombre_usuario.setText(Html.fromHtml("<b>"+nombre+" "+apellido+"</b>"));
        Calendar c = Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy", new Locale("es"));
        Tfecha = formato.format(c.getTime());
        //fecha.setText(Tfecha);
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
                        String cant_telera_estandar_s = cant_telera.getText().toString();
                        String cant_telera_grande_s = cant_telera_grande.getText().toString();
                        String cant_bola_leche_s =cant_bola_leche.getText().toString();
                        String cant_cuernito_estandar_s = cant_cuernito_estandar.getText().toString();
                        String cant_cuernito_chico_s =cant_cuernito_chico.getText().toString();
                        String cant_cuernito_grande_s = cant_cuernito_grande.getText().toString();
                        String cant_pan_dulce_estandar_s = cant_pan_dulce_estandar.getText().toString();
                        String cant_pan_dulce_chico_s = cant_pan_dulce_chico.getText().toString();
                        String cant_dona_especial_s = cant_dona_especial.getText().toString();
                        String cant_dona_sencillo_s = cant_dona_sencillo.getText().toString();
                        String cant_acambareno_grande_s =cant_acambareno_grande.getText().toString();
                        String cant_concha_grande_s = cant_concha_grande.getText().toString();
                        String cant_tortuga_grande_s = cant_tortuga_grande.getText().toString();
                        String cant_pastel_s = cant_pastel.getText().toString();
                        String cant_merengue_estandar_s =cant_merengue_estandar.getText().toString();
                        String cant_merengue_cafe_chico_s = cant_merengue_cafe_chico.getText().toString();
                        String cant_merengue_chico_s =cant_merengue_chico.getText().toString();
                        String cant_pasta_hojaldra_s = cant_pasta_hojaldra.getText().toString();
                        String cant_reposteria_1_s = cant_reposteria_1.getText().toString();
                        String cant_reposteria_2_s = cant_reposteria_2.getText().toString();
                        String cant_reposteria_3_s = cant_reposteria_3.getText().toString();
                        String cant_reposteria_4_s = cant_reposteria_4.getText().toString();
                        String cant_reposteria_5_s = cant_reposteria_5.getText().toString();
                        String cant_hamburguesa_estandar_s = cant_hamburguesa_estandar.getText().toString();
                        String cant_hamburguesa_chica_s = cant_hamburguesa_chica.getText().toString();
                        String cant_pizza_estadar_s = cant_pizza_mini.getText().toString();
                        String cant_pizza_chica_s =cant_pizza_chica.getText().toString();
                        String cant_pizza_grande_s =cant_pizza_grande.getText().toString();
                        String cant_pizza_mediana_s = cant_pizza_mediana.getText().toString();
                        String cant_pizza_extra_grande_s = cant_pizza_extra_grande.getText().toString();


                        //Intent extra = new Intent(Produccion_panblanco.this,Produccion_panblanco.class);
                        //extra.putExtra("Nombre",nombre_usuario_s+"");

                        //startActivity(extra);

                        String insert1 = "INSERT INTO Produccion_total(id_produccion_total, fecha, hora, nombre_usuario, apellido_usuario, cant_bolillo, cant_bolillo_chico, cant_bolillo_mignon, cant_pan_acimo, cant_pambazo, cant_pambazo_grande,cant_telera,cant_telera_grande,bola_leche, cuernito_estandar, cuernito_chico, cuernito_grande, pan_dulce_estandar, pan_dulce_chico, dona_especial, dona_sencillo, acambareno_grande, concha_grande, tortuga_grande, pastel, merengue_estandar, merengue_cafe_chico, merengue_chico, pasta_hojaldra,reposteria_1, reposteria_2, reposteria_3, reposteria_4, reposteria_5, hamburguesa_estandar, hamburguesa_chica,pizza_mini, pizza_chica, pizza_grande,pizza_mediana,pizza_extra_grande) VALUES (null,'" + fecha_s + "', '" + hora_s + "','" + nombre_usuario_s + "','" + apellido_usuario_s + "','" + cant_bolillo_s + "','" + cant_bolillo_chico_s + "','" + cant_bolillo_mignon_s + "','" + cant_pan_acimo_s + "','"+ cant_pambazo_s+"','"+cant_pambazo_grande_s+"','"+cant_telera_estandar_s+"','"+cant_telera_grande_s+"','"+cant_bola_leche_s+"','"+cant_cuernito_estandar_s+"','"+cant_cuernito_chico_s+"','"+ cant_cuernito_grande_s+"','"+cant_pan_dulce_estandar_s+"','"+cant_pan_dulce_chico_s+"','"+cant_dona_especial_s+"','"+cant_dona_sencillo_s+"','"+cant_acambareno_grande_s+"','"+cant_concha_grande_s+"','"+cant_tortuga_grande_s+"','"+cant_pastel_s+"','"+cant_merengue_estandar_s+"','"+cant_merengue_cafe_chico_s+"','"+cant_merengue_chico_s+"','"+cant_pasta_hojaldra_s+"','"+cant_reposteria_1_s+"','"+cant_reposteria_2_s+"','"+cant_reposteria_3_s+"','"+cant_reposteria_4_s+"','"+cant_reposteria_5_s+"','"+cant_hamburguesa_estandar_s+"','"+cant_hamburguesa_chica_s+"','"+cant_pizza_estadar_s+"','"+cant_pizza_chica_s+"','"+cant_pizza_grande_s+"','"+cant_pizza_mediana_s+"','"+cant_pizza_extra_grande_s+"');";
                        baseDatos.execSQL(insert1);

                    }
                })
                .setNegativeButton("Cancelar", null)
                .show();


    }*/





    protected void onListItemClick(ListView listView, View view, int position, long id){
        super.onListItemClick(listView, view, position, id);
        //Object o = getListAdapter().getItem(position);
        //Toast.makeText(this, "Seleccion: " + Integer.toString(position) + " - " + o.toString(), Toast.LENGTH_SHORT).show();
        position = position + 1;
        session.checkLogin();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();


        //nombre
        final String nombre = user.get(Administrador_sesion.KEY_NOMBRE);

        // apellido
        final String apellido = user.get(Administrador_sesion.KEY_APELLIDO);

//debe ir aqui la condicion para que solo edite el usuario
        baseDatos = this.openOrCreateDatabase("LipanDb", MODE_PRIVATE, null);
        fila = baseDatos.rawQuery("select  cant_bolillo, cant_bolillo_chico, cant_bolillo_mignon, cant_pan_acimo, cant_pambazo, cant_pambazo_grande,cant_telera,cant_telera_grande,bola_leche, cuernito_estandar, cuernito_chico, cuernito_grande, pan_dulce_estandar, pan_dulce_chico, dona_especial, dona_sencillo, acambareno_grande, concha_grande, tortuga_grande, pastel, merengue_estandar, merengue_cafe_chico, merengue_chico, pasta_hojaldra,reposteria_1, reposteria_2, reposteria_3, reposteria_4, reposteria_5, hamburguesa_estandar, hamburguesa_chica, pizza_mini, pizza_chica, pizza_grande,pizza_mediana,pizza_extra_grande, fecha, hora,nombre_usuario,apellido_usuario from Produccion_total where id_produccion_total = '" + position + "' ", null);
        if (fila.moveToFirst()) {
            String cant_bolillo = fila.getString(0);
            String cant_bolillo_chico = fila.getString(1);
            String cant_bolillo_mignon = fila.getString(2);
            String cant_pan_acimo = fila.getString(3);
            String cant_pambazo = fila.getString(4);
            String cant_pambazo_grande = fila.getString(5);
            String cant_telera=fila.getString(6);
            String cant_telera_grande = fila.getString(7);
            String bola_leche = fila.getString(8);
            String cuernito_estandar = fila.getString(9);
            String cuernito_chico = fila.getString(10);
            String cuernito_grande = fila.getString(11);
            String pan_dulce_estandar = fila.getString(12);
            String pan_dulce_chico = fila.getString(13);
            String dona_especial = fila.getString(14);
            String dona_sencillo = fila.getString(15);
            String acambareno_grande = fila.getString(16);
            String concha_grande = fila.getString(17);
            String tortuga_grande= fila.getString(18);
            String pastel = fila.getString(19);
            String merengue_estandar = fila.getString(20);
            String merengue_cafe_chico = fila.getString(21);
            String merengue_chico = fila.getString(22);
            String pasta_hojaldra= fila.getString(23);
            String reposteria_1 = fila.getString(24);
            String reposteria_2 = fila.getString(25);
            String reposteria_3 = fila.getString(26);
            String reposteria_4 = fila.getString(27);
            String reposteria_5 = fila.getString(28);
            String hamburguesa_estandar = fila.getString(29);
            String hamburguesa_chica = fila.getString(30);
            String pizza_estadar = fila.getString(31);
            String pizza_chica = fila.getString(32);
            String pizza_grande = fila.getString(33);
            String pizza_mediana = fila.getString(34);
            String pizza_extra_grande = fila.getString(35);
            String fecha_s = fila.getString(36);
            String hora_s = fila.getString(37);
            String nombre_s =fila.getString(38);
            String apellido_s=fila.getString(39);

if ( nombre_s.equals(nombre) && apellido_s.equals(apellido)) {

    Intent i = new Intent(Produccion_pandulce.this, Modificar_produccion_pandulce.class);


    i.putExtra("Position", position + "");
    //i.putExtra("Id_produccion", id_produccion);
    i.putExtra("Nombre", nombre_s + "");
    i.putExtra("Apellido", apellido_s + "");
    i.putExtra("Cant_bolillo_modificar", cant_bolillo + "");
    i.putExtra("Cant_bolillo_chico_modificar", cant_bolillo_chico + "");
    i.putExtra("Cant_bolillo_mignon_modificar", cant_bolillo_mignon + "");
    i.putExtra("Cant_pan_acimo_modificar", cant_pan_acimo + "");
    i.putExtra("Cant_pambazo_modificar", cant_pambazo + "");
    i.putExtra("Cant_pambazo_grande_modificar", cant_pambazo_grande + "");
    i.putExtra("Fecha_Inicial", fecha_s + "");
    i.putExtra("Hora_Inicial", hora_s + "");
    i.putExtra("Cant_telera", cant_telera + "");
    i.putExtra("Cant_telera_grande", cant_telera_grande + "");
    i.putExtra("Cant_bola_leche", bola_leche + "");
    i.putExtra("Cant_cuernito_estandar", cuernito_estandar + "");
    i.putExtra("Cant_cuernito_chico", cuernito_chico + "");
    i.putExtra("Cant_cuernito_grande", cuernito_grande + "");
    i.putExtra("Cant_pan_dulce_estandar", pan_dulce_estandar + "");
    i.putExtra("Cant_pan_dulce_chico", pan_dulce_chico + "");
    i.putExtra("Cant_dona_especial", dona_especial + "");
    i.putExtra("Cant_dona_sencilla", dona_sencillo + "");
    i.putExtra("Cant_acambareno_grande", acambareno_grande + "");
    i.putExtra("Cant_concha_grande", concha_grande + "");
    i.putExtra("Can_tortuga", tortuga_grande + "");
    i.putExtra("Can_pastel", pastel + "");
    i.putExtra("Cant_merengue_estandar", merengue_estandar + "");
    i.putExtra("Cant_merengue_cafe_chico", merengue_cafe_chico + "");
    i.putExtra("Cant_merengue_chico", merengue_chico + "");
    i.putExtra("Cant_pasta_hojaldra", pasta_hojaldra + "");
    i.putExtra("Cant_resposteria_1", reposteria_1 + "");
    i.putExtra("Cant_resposteria_2", reposteria_2 + "");
    i.putExtra("Cant_resposteria_3", reposteria_3 + "");
    i.putExtra("Cant_resposteria_4", reposteria_4 + "");
    i.putExtra("Cant_resposteria_5", reposteria_5 + "");
    i.putExtra("Cant_hamburguesa_estandar", hamburguesa_estandar + "");
    i.putExtra("Cant_hamburguesa_chica", hamburguesa_chica + "");
    i.putExtra("Cant_pizza_estandar", pizza_estadar + "");
    i.putExtra("Cant_pizza_chica", pizza_chica + "");
    i.putExtra("Cant_pizza_grande", pizza_grande + "");
    i.putExtra("Cant_pizza_mediana", pizza_mediana + "");
    i.putExtra("Cant_pizza_extra_grande", pizza_extra_grande + "");

    startActivityForResult(i, 3);
}
else{
    Toast.makeText(this, "No puedes editar la lista de otro usuario.", Toast.LENGTH_SHORT).show();
}
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
                    thora.setText(Html.fromHtml("La fecha-hora: <b>"+ Tfecha+ " - " +curTime+"</b>"));

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
