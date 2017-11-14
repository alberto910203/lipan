package android.alberto.app.lipangomovil;

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
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class Produccion_total extends AppCompatActivity {
    Button modificar_produccion,refrescar,regresar,registrar_produccion;
    String nombre;// variable donde guardo el valor del intent para el nombre
    String apellido;// variable donde guardo el valor del intent para el nombre
    SQLiteDatabase baseDatos = null; // Inicializar la variable para cargar/acceso la base de datos
    EditText cant_bolillo,cant_bolillo_chico,cant_bolillo_mignon,cant_pan_acimo,cant_pambazo,cant_pambazo_grande;
    EditText cant_telera,cant_telera_grande,cant_bola_leche,cant_cuernito_estandar,cant_cuernito_chico,cant_cuernito_grande,cant_pan_dulce_estandar,cant_pan_dulce_chico;
    EditText cant_dona_especial,cant_dona_sencillo,cant_acambareno_grande,cant_concha_grande,cant_tortuga_grande,cant_pastel,cant_merengue_estandar,cant_merengue_cafe_chico;
    EditText cant_merengue_chico,cant_pasta_hojaldra,cant_reposteria_1,cant_reposteria_2,cant_reposteria_3,cant_reposteria_4,cant_reposteria_5,cant_hamburguesa_estandar;
    EditText cant_hamburguesa_chica,cant_pizza_mini,cant_pizza_chica,cant_pizza_grande,cant_pizza_mediana,cant_pizza_extra_grande;

    TextView nombre_usuario;
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
        setContentView(R.layout.activity_produccion_total);
        session = new Administrador_sesion(getApplicationContext());
        regresar =(Button) findViewById(R.id.regresar_edicion);
        modificar_produccion= (Button) findViewById(R.id.ver_registros);
        registrar_produccion = (Button) findViewById(R.id.modificar_produccion_total);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent refrescar = new Intent(Produccion_total.this, Editar_produccion.class);
                Produccion_total.this.startActivity(refrescar);

            }
        });
        modificar_produccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ver_registros = new Intent(Produccion_total.this, Produccion_pandulce.class);
                Produccion_total.this.startActivity(ver_registros);
            }
        });


//        id_produccion_panblanco =(EditText) v.findViewById(R.id.id_produccion_pb_d);
        //fecha =(TextView) v.findViewById(R.id.fecha_d_pd);
        thora =(TextView) findViewById(R.id.hora_e);
        nombre_usuario =(TextView) findViewById(R.id.nombre_e);
        //apellido_usuario = (TextView) findViewById(R.id.apellido_usuario_e);

        cant_bolillo = (EditText) findViewById(R.id.bolillo_e);
        cant_bolillo_chico = (EditText) findViewById(R.id.bolillo_chico_e);
        cant_bolillo_mignon = (EditText) findViewById(R.id.bolillo_mignon_e);
        cant_pan_acimo = (EditText) findViewById(R.id.pan_acimo_e);
        cant_pambazo = (EditText) findViewById(R.id.pambazo_e);
        cant_pambazo_grande = (EditText) findViewById(R.id.pambazo_grande_e);
        cant_telera =(EditText) findViewById(R.id.telera_e);
        cant_telera_grande = (EditText) findViewById(R.id.telera_grande_e);
        cant_bola_leche = (EditText) findViewById(R.id.bola_leche_e);
        cant_cuernito_estandar = (EditText) findViewById(R.id.cuernito_estandar_e);
        cant_cuernito_chico = (EditText) findViewById(R.id.cuernito_chico_e);
        cant_cuernito_grande = (EditText) findViewById(R.id.cuernito_grande_e);
        cant_pan_dulce_estandar = (EditText) findViewById(R.id.pan_dulce_estandar_e);
        cant_pan_dulce_chico = (EditText) findViewById(R.id.pan_dulce_chico_e);
        cant_dona_especial = (EditText) findViewById(R.id.dona_especial_e);
        cant_dona_sencillo = (EditText) findViewById(R.id.dona_sencilla_e);
        cant_acambareno_grande = (EditText) findViewById(R.id.acambarero_grande_e);
        cant_concha_grande = (EditText) findViewById(R.id.concha_grande_e);
        cant_tortuga_grande = (EditText) findViewById(R.id.tortuga_grande_e);
        cant_pastel =(EditText) findViewById(R.id.pastel_e);
        cant_merengue_estandar = (EditText) findViewById(R.id.merengue_estandar_e);
        cant_merengue_cafe_chico = (EditText) findViewById(R.id.merengue_cafe_chico_e);
        cant_merengue_chico = (EditText) findViewById(R.id.merengue_chico_e);
        cant_pasta_hojaldra = (EditText) findViewById(R.id.pasta_hojaldra_e);
        cant_reposteria_1 = (EditText) findViewById(R.id.reposteria_1_e);
        cant_reposteria_2 = (EditText) findViewById(R.id.reposteria_2_e);
        cant_reposteria_3 = (EditText) findViewById(R.id.reposteria_3_e);
        cant_reposteria_4 = (EditText) findViewById(R.id.reposteria_4_e);
        cant_reposteria_5 = (EditText) findViewById(R.id.reposteria_5_e);
        cant_hamburguesa_estandar = (EditText) findViewById(R.id.hamburguesa_estandar_e);
        cant_hamburguesa_chica = (EditText) findViewById(R.id.hamburguesa_chica_e);
        cant_pizza_mini = (EditText) findViewById(R.id.pizza_mini_e);
        cant_pizza_chica = (EditText) findViewById(R.id.pizza_chica_e);
        cant_pizza_grande = (EditText) findViewById(R.id.pizza_grande_e);
        cant_pizza_mediana = (EditText) findViewById(R.id.pizza_mediana_e);
        cant_pizza_extra_grande = (EditText) findViewById(R.id.pizza_extra_grande_e);
        session.checkLogin();

        baseDatos = openOrCreateDatabase("LipanDb", MODE_PRIVATE, null);
        String Tabla_produccion_panblanco ="CREATE TABLE IF NOT EXISTS Produccion_total(id_produccion_total INTEGER PRIMARY KEY AUTOINCREMENT, fecha DATETIME DEFAULT CURRENT_TIMESTAMP, hora DATETIME DAFAULT CURRENT_TIMESTAMP, nombre_usuario TEXT, apellido_usuario TEXT, cant_bolillo INTEGER, cant_bolillo_chico INTEGER, cant_bolillo_mignon INTEGER, cant_pan_acimo INTEGER, cant_pambazo INTEGER, cant_pambazo_grande INTEGER,cant_telera INTEGER,cant_telera_grande INTEGER,bola_leche INTEGER, cuernito_estandar INTEGER, cuernito_chico INTEGER, cuernito_grande INTEGER, pan_dulce_estandar INTEGER, pan_dulce_chico INTEGER, dona_especial INTEGER, dona_sencillo INTEGER, acambareno_grande INTEGER, concha_grande INTEGER, tortuga_grande INTEGER, pastel INTEGER, merengue_estandar INTEGER, merengue_cafe_chico INTEGER, merengue_chico INTEGER, pasta_hojaldra INTEGER,reposteria_1 INTEGER, reposteria_2 INTEGER, reposteria_3 INTEGER, reposteria_4 INTEGER, reposteria_5 INTEGER, hamburguesa_estandar INTEGER, hamburguesa_chica INTEGER, pizza_mini INTEGER, pizza_chica INTEGER, pizza_grande INTEGER, pizza_mediana INTEGER, pizza_extra_grande INTEGER )";
        baseDatos.execSQL(Tabla_produccion_panblanco);
        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        // name
        nombre = user.get(Administrador_sesion.KEY_NOMBRE);

        // email
        apellido = user.get(Administrador_sesion.KEY_APELLIDO);



        nombre_usuario.setText(Html.fromHtml("<b>"+nombre+" "+apellido+"</b>"));
        //apellido_usuario.setText(""+apellido);
        //cant_bolillo_chico_modificar = cant_bolillo_chico.getText().toString();


        Calendar c = Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy", new Locale("es"));
        Tfecha = formato.format(c.getTime());
        //fecha.setText(Tfecha);
        r = new RefreshClock(); // variables para la parte del reloj
        iniReloj = new Thread(r);
        iniReloj.start();



    }

public void Registrar(View view) {
try {


    String fecha_s = Tfecha;
    String hora_s = curTime;
    String nombre_usuario_s = nombre;
    String apellido_usuario_s = apellido;
    String cant_bolillo_s = cant_bolillo.getText().toString();
    String cant_bolillo_chico_s = cant_bolillo_chico.getText().toString();
    String cant_bolillo_mignon_s = cant_bolillo_mignon.getText().toString();
    String cant_pan_acimo_s = cant_pan_acimo.getText().toString();
    String cant_pambazo_s = cant_pambazo.getText().toString();
    String cant_pambazo_grande_s = cant_pambazo_grande.getText().toString();
    String cant_telera_estandar_s = cant_telera.getText().toString();
    String cant_telera_grande_s = cant_telera_grande.getText().toString();
    String cant_bola_leche_s = cant_bola_leche.getText().toString();
    String cant_cuernito_estandar_s = cant_cuernito_estandar.getText().toString();
    String cant_cuernito_chico_s = cant_cuernito_chico.getText().toString();
    String cant_cuernito_grande_s = cant_cuernito_grande.getText().toString();
    String cant_pan_dulce_estandar_s = cant_pan_dulce_estandar.getText().toString();
    String cant_pan_dulce_chico_s = cant_pan_dulce_chico.getText().toString();
    String cant_dona_especial_s = cant_dona_especial.getText().toString();
    String cant_dona_sencillo_s = cant_dona_sencillo.getText().toString();
    String cant_acambareno_grande_s = cant_acambareno_grande.getText().toString();
    String cant_concha_grande_s = cant_concha_grande.getText().toString();
    String cant_tortuga_grande_s = cant_tortuga_grande.getText().toString();
    String cant_pastel_s = cant_pastel.getText().toString();
    String cant_merengue_estandar_s = cant_merengue_estandar.getText().toString();
    String cant_merengue_cafe_chico_s = cant_merengue_cafe_chico.getText().toString();
    String cant_merengue_chico_s = cant_merengue_chico.getText().toString();
    String cant_pasta_hojaldra_s = cant_pasta_hojaldra.getText().toString();
    String cant_reposteria_1_s = cant_reposteria_1.getText().toString();
    String cant_reposteria_2_s = cant_reposteria_2.getText().toString();
    String cant_reposteria_3_s = cant_reposteria_3.getText().toString();
    String cant_reposteria_4_s = cant_reposteria_4.getText().toString();
    String cant_reposteria_5_s = cant_reposteria_5.getText().toString();
    String cant_hamburguesa_estandar_s = cant_hamburguesa_estandar.getText().toString();
    String cant_hamburguesa_chica_s = cant_hamburguesa_chica.getText().toString();
    String cant_pizza_estadar_s = cant_pizza_mini.getText().toString();
    String cant_pizza_chica_s = cant_pizza_chica.getText().toString();
    String cant_pizza_grande_s = cant_pizza_grande.getText().toString();
    String cant_pizza_mediana_s = cant_pizza_mediana.getText().toString();
    String cant_pizza_extra_grande_s = cant_pizza_extra_grande.getText().toString();
    String insert1 = "INSERT INTO Produccion_total(id_produccion_total, fecha, hora, nombre_usuario, apellido_usuario, cant_bolillo, cant_bolillo_chico, cant_bolillo_mignon, cant_pan_acimo, cant_pambazo, cant_pambazo_grande,cant_telera,cant_telera_grande,bola_leche, cuernito_estandar, cuernito_chico, cuernito_grande, pan_dulce_estandar, pan_dulce_chico, dona_especial, dona_sencillo, acambareno_grande, concha_grande, tortuga_grande, pastel, merengue_estandar, merengue_cafe_chico, merengue_chico, pasta_hojaldra,reposteria_1, reposteria_2, reposteria_3, reposteria_4, reposteria_5, hamburguesa_estandar, hamburguesa_chica,pizza_mini, pizza_chica, pizza_grande,pizza_mediana,pizza_extra_grande) VALUES (null,'" + fecha_s + "', '" + hora_s + "','" + nombre_usuario_s + "','" + apellido_usuario_s + "','" + cant_bolillo_s + "','" + cant_bolillo_chico_s + "','" + cant_bolillo_mignon_s + "','" + cant_pan_acimo_s + "','"+ cant_pambazo_s+"','"+cant_pambazo_grande_s+"','"+cant_telera_estandar_s+"','"+cant_telera_grande_s+"','"+cant_bola_leche_s+"','"+cant_cuernito_estandar_s+"','"+cant_cuernito_chico_s+"','"+ cant_cuernito_grande_s+"','"+cant_pan_dulce_estandar_s+"','"+cant_pan_dulce_chico_s+"','"+cant_dona_especial_s+"','"+cant_dona_sencillo_s+"','"+cant_acambareno_grande_s+"','"+cant_concha_grande_s+"','"+cant_tortuga_grande_s+"','"+cant_pastel_s+"','"+cant_merengue_estandar_s+"','"+cant_merengue_cafe_chico_s+"','"+cant_merengue_chico_s+"','"+cant_pasta_hojaldra_s+"','"+cant_reposteria_1_s+"','"+cant_reposteria_2_s+"','"+cant_reposteria_3_s+"','"+cant_reposteria_4_s+"','"+cant_reposteria_5_s+"','"+cant_hamburguesa_estandar_s+"','"+cant_hamburguesa_chica_s+"','"+cant_pizza_estadar_s+"','"+cant_pizza_chica_s+"','"+cant_pizza_grande_s+"','"+cant_pizza_mediana_s+"','"+cant_pizza_extra_grande_s+"');";
    baseDatos.execSQL(insert1);
    Intent extra = new Intent(Produccion_total.this,Produccion_pandulce.class);
    //extra.putExtra("Nombre",nombre_usuario_s+"");

    Produccion_total.this.startActivity(extra);
    Toast.makeText(this, "Registrado Correctamente", Toast.LENGTH_LONG).show();
}
catch (Exception e)
{
Toast.makeText(this,"Registro Rechazado", Toast.LENGTH_LONG).show();
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
