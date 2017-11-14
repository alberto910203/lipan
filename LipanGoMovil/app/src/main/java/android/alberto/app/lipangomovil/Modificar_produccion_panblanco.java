package android.alberto.app.lipangomovil;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class Modificar_produccion_panblanco extends AppCompatActivity {
String id_produccion_e,position,nombre_e,apellido_e,fecha_e,hora_e,cant_bolillo_extra,cant_bolillo_chico_extra,cant_bolillo_mignon_extra,cant_pan_acimo_extra,cant_pambazo_extra,cant_pambazo_grande_extra;
EditText id_produccion_panblanco,fecha_actual,hora_actual,nombre_usuario,apellido_usuario,cant_bolillo,cant_bolillo_chico,cant_bolillo_mignon,cant_pan_acimo,cant_pambazo,cant_pambazo_grande;
    SQLiteDatabase baseDatos = null;
    int hora=0, minuto =0, segundo = 0;
    //Intent i;
    Thread iniReloj = null;
    Runnable r;
    boolean isUpdate = false;
    String sec, min, hor;
    String curTime;
    String fecha_actual_a;
    Button cancelar;
    String permiso;
    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    // Session Manager Class
    Administrador_sesion session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_produccion_panblanco);
        session = new Administrador_sesion(getApplicationContext());
        Intent a = getIntent();
        position = a.getStringExtra("Position");
        id_produccion_e = a.getStringExtra("Id_produccion");
        //nombre_e = e.getStringExtra("Nombre");
        //apellido_e = e.getStringExtra("Apellido");
        fecha_e = a.getStringExtra("Fecha_Inicial");
        hora_e = a.getStringExtra("Hora_Inicial");
        cant_bolillo_extra = a.getStringExtra("Cant_bolillo_modificar");
        cant_bolillo_chico_extra = a.getStringExtra("Cant_bolillo_chico_modificar");
        cant_bolillo_mignon_extra = a.getStringExtra("Cant_bolillo_mignon_modificar");
        cant_pan_acimo_extra = a.getStringExtra("Cant_pan_acimo_modificar");
        cant_pambazo_extra = a.getStringExtra("Cant_pambazo_modificar");
        cant_pambazo_grande_extra = a.getStringExtra("Cant_pambazo_grande_modificar");

        //id_produccion_panblanco =(EditText) findViewById(R.id.id_produccion_pb_m);
        fecha_actual = (EditText) findViewById(R.id.fecha_m);
        hora_actual =(EditText) findViewById(R.id.hora_m);
        //nombre_usuario =(EditText) findViewById(R.id.nombre_usuario_m);
        //apellido_usuario = (EditText) findViewById(R.id.apellido_usuario_m);
        cant_bolillo = (EditText) findViewById(R.id.cant_bolillo_m);
        cant_bolillo_chico = (EditText) findViewById(R.id.cant_bolillo_chico_m);
        cant_bolillo_mignon = (EditText) findViewById(R.id.cant_bolillo_mignon_m);
        cant_pan_acimo = (EditText) findViewById(R.id.cant_pan_acimo_m);
        cant_pambazo = (EditText) findViewById(R.id.cant_pambazo_m);
        cant_pambazo_grande = (EditText) findViewById(R.id.cant_pambazo_grande_m);
        cancelar = (Button) findViewById(R.id.cancelar);
        //session.checkLogin();

        // get user data from session
        //HashMap<String, String> user = session.getUserDetails();

        // name
        //final String nombre = user.get(Administrador_sesion.KEY_NOMBRE);

        // email
        //final String apellido = user.get(Administrador_sesion.KEY_APELLIDO);


        r = new RefreshClock();
        iniReloj= new Thread(r);
        iniReloj.start();


        final Calendar c = Calendar.getInstance();
        final SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy", new Locale("es"));
        fecha_actual_a =formato.format(c.getTime());

        fecha_actual.setText(""+fecha_actual_a);
        //nombre_usuario.setText(""+nombre_e);
        //apellido_usuario.setText(""+apellido_e);
        cant_bolillo.setText(""+cant_bolillo_extra);
        cant_bolillo_chico.setText(""+cant_bolillo_chico_extra);
        cant_bolillo_mignon.setText(""+cant_bolillo_mignon_extra);
        cant_pan_acimo.setText(""+cant_pan_acimo_extra);
        cant_pambazo.setText(""+cant_pambazo_extra);
        cant_pambazo_grande.setText(""+cant_pambazo_grande_extra);



        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Modificar_produccion_panblanco.this, Produccion_panblanco.class);
                Modificar_produccion_panblanco.this.startActivity(i);
            }
        });


    }
    public void modificar (View view){
        try {
              int compare = curTime.compareTo(hora_e);
              int compare2 = fecha_actual_a.compareTo(fecha_e);


            if (compare < 11 && compare2<1)
            {
                baseDatos = openOrCreateDatabase("LipanDb", MODE_PRIVATE, null);
                Intent i = getIntent();
                String position = i.getStringExtra("Position");//recogemos el valor del intet
                //String ed_hora_s = ed_hora.getText().toString();
                String id_produccion = id_produccion_e;
                String ed_fecha_s = fecha_actual_a;
                String ed_hora_s = curTime;
                String ed_cant_bolillo = cant_bolillo.getText().toString();
                String ed_cant_bolillo_chico = cant_bolillo_chico.getText().toString();
                String ed_cant_bolillo_mignon = cant_bolillo_mignon.getText().toString();
                String ed_cant_pan_acimo = cant_pan_acimo.getText().toString();
                String ed_cant_pambazo = cant_pambazo.getText().toString();
                String ed_cant_pambazo_grande = cant_pambazo_grande.getText().toString();

                String sql1 = ("Update  Produccion_panblanco set hora = '" + ed_hora_s + "', fecha ='" + ed_fecha_s + "', cant_bolillo = '" + ed_cant_bolillo + "' , cant_bolillo_chico ='" + ed_cant_bolillo_chico + "', cant_bolillo_mignon = '" + ed_cant_bolillo_mignon + "', cant_pan_acimo = '" + ed_cant_pan_acimo + "',cant_pambazo = '" + ed_cant_pambazo + "',cant_pambazo_grande = '" + ed_cant_pambazo_grande + "' where id_produccion_panblanco =" + position);
                baseDatos.execSQL(sql1);
                Toast.makeText(this, "Actualizado", Toast.LENGTH_SHORT).show();
                Intent regresar = new Intent(Modificar_produccion_panblanco.this, Produccion_panblanco.class);
                startActivity(regresar);
            }
            else{
                Toast.makeText(this,"Ya no puedes Modificar",Toast.LENGTH_SHORT).show();
            }
        }catch(Exception e){
            Toast.makeText(this,"Error al Actualizar",Toast.LENGTH_SHORT).show();
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
                    hora_actual.setText(""+curTime);

                }catch (Exception e) {}
            }
        });
    }



    /**
     Esta clase hace uso de la interface Runnable la cual es la encargada de estar
     refrescando cada 1000 milisegundos es decir, un segudo, no tiene gran ciencia
     @SuppressWarnings("unused") es para decirle al compilador que obvie la advertencia
     que se genera, pero la verdad no afecta en nada el funcionamiento del mismo

     */
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

    /**
     Este es el metodo inicial del reloj, a partir de el es que se muestra la hora
     cada segundo es la encargada Java.Util.Calendar
     */

    private void updateTime(){

        Calendar c = Calendar.getInstance();
        hora = c.get(Calendar.HOUR_OF_DAY);
        minuto = c.get(Calendar.MINUTE);
        segundo = c.get(Calendar.SECOND);
        setZeroClock();

    }
    /**
     setZeroClock es para que se nos ponga el numero 0 en aquellos valores menores a
     10, pero no he podido resolver un pequeño inconveniente al momento de la llegada
     de 0:0:0 y por ende en sus derivadas, aunque no es por falta de logica, he revisado
     muy bien, pero si le encuentran arreglo me hacen el favor y me avisan de como
     solucionarlo
     */
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


    /**
     Que puedo decir de este metodo mas que es el encargado de parsear la hora de una
     manera que al llegar a 24:59:59 esta retome los valores de 00:00:00 aunque en la practica
     como mencionaba en un comentario anterior esta se pone en 0:0:0, pero luego se restaura a
     00:00:01
     */
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
