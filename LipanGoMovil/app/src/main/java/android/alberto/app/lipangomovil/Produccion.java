package android.alberto.app.lipangomovil;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class Produccion extends AppCompatActivity  {

    TextView nombre_s,fecha,tHora;
    String nombreextra,apellidoextra;
    Button inicio,fin,editar_produccion,consultar_revision;
    int hora=0, minuto =0, segundo = 0;
    Thread iniReloj = null;
    Runnable r;
    boolean isUpdate = false;
    String sec, min, hor;
    String curTime;
    String Tfecha;
    //String hora_inicio;
    Button salir;
    public static final String Key3= "Nombre2";
    public static final String Key4= "Apellido2";
    public static final int HIJORESULT = 0;
    SQLiteDatabase baseDatos = null;
    private Cursor fila;
    String hora_inical;
    int offsetX = 50;
    int offsetY = 25;

    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    // Session Manager Class
    Administrador_sesion session;

    //Session Guardar Turnos
    Administracion_sesion_turnos session2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        session = new Administrador_sesion(getApplicationContext());
        session2 = new Administracion_sesion_turnos(getApplicationContext());

        //hora_inical = getIntent().getStringExtra("hora_inicial");
        //apellidoextra = getIntent().getStringExtra("Apellido");
        setContentView(R.layout.activity_producccion);
        nombre_s = (TextView) findViewById(R.id.textView5);
        fecha = (TextView) findViewById(R.id.textView3);
        tHora = (TextView) findViewById(R.id.textView4);
        inicio =(Button) findViewById(R.id.button);
        fin =(Button) findViewById(R.id.button3);
        editar_produccion =(Button) findViewById(R.id.button4);
        consultar_revision = (Button) findViewById(R.id.button5);
        salir =(Button) findViewById(R.id.button6);

        //Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(), "Status Turno: " + session2.isLoggedIn(), Toast.LENGTH_LONG).show();


        /**
         * Call this function whenever you want to check user login
         * This will redirect user to LoginActivity is he is not
         * logged in
         * */
        session.checkLogin();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        // name
        final String nombre = user.get(Administrador_sesion.KEY_NOMBRE);

        // email
        final String apellido = user.get(Administrador_sesion.KEY_APELLIDO);

        // displaying user data
        //nombre.setText(Html.fromHtml("Name: <b>" + name + "</b>"));
        //lblEmail.setText(Html.fromHtml("Email: <b>" + email + "</b>"));

        session.checkLogin();

        // get user data from session
        HashMap<String, String> turno = session2.getUserDetails();

        // name
        final String hora_inicio = turno.get(Administracion_sesion_turnos.KEY_HORA_INICIO);

        // email
        String hora_fin = turno.get(Administracion_sesion_turnos.KEY_HORA_FIN);




        nombre_s.setText(Html.fromHtml("<br>Bienvenido:<b> "+nombre+" "+apellido+"</br></b> </br><br></br>"));
        final Calendar c = Calendar.getInstance();
        final SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy", new Locale("es"));
        //final SimpleDateFormat formato2 = new SimpleDateFormat("HH-mm-ss", new Locale("es"));
        Tfecha= formato.format(c.getTime());
        //hora_fin =formato2.format(c.getTime());
        fecha.setText(Html.fromHtml("La fecha es:<b> "+Tfecha+"</b>"));
        r = new RefreshClock(); // variables para la parte del reloj
        iniReloj = new Thread(r);
        iniReloj.start();
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( hora_inicio==null) {
                    Intent Produccion = new Intent(Produccion.this, Iniciar_Turno.class);
                    Produccion.putExtra("Fecha", Tfecha + "");
                    Produccion.putExtra("Hora", curTime + "");
                    Produccion.this.startActivity(Produccion);
                }
               else{
                    Toast.makeText(getApplication(),"Ya creaste un turno",Toast.LENGTH_LONG).show();
               }
            }
        });

        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String timeIn = hora_inicio;
                String timeOut = curTime;
                //int nochange = hora_inicio.compareTo(curTime);
                if(hora_inicio != null) {
                    baseDatos = openOrCreateDatabase("LipanDb", MODE_PRIVATE, null);
                    String crearturno = "CREATE TABLE IF NOT EXISTS Turnos(id_turno INTEGER PRIMARY KEY AUTOINCREMENT,id_turno_produccion_pan_blanco INTEGER, nombre_usuario TEXT,apellido_usuario TEXT,fecha_inicio DATETIME DEFAULT CURRENT_TIMESTAMP, fecha_fin DATETIME DEFAULT CURRENT_TIMESTAMP, hora_inicio DATETIME DEFAULT CURRENT_TIMESTAMP, hora_fin DATETIME DEFAULT CURRENT_TIMESTAMP, trabajadores TEXT, produccion_final TEXT, comentarios TEXT )";
                    //baseDatos.setForeignKeyConstraintsEnabled(true);
                    //baseDatos.execSQL("PRAGMA_foreign_keys=ON");
                    String actualizacion = ("UPDATE Turnos SET  hora_fin = '" + timeOut + "' WHERE hora_inicio = '" + timeIn + "' ");
                    baseDatos.execSQL(actualizacion);
                    baseDatos.execSQL(crearturno);
                    Toast.makeText(getApplication(), "El turno se ha finalizado correctamente. ", Toast.LENGTH_LONG).show();
                    session2.logoutTurno();
                }
                else{

                    Toast.makeText(getApplicationContext(),"No hay un turno que concluir en este momento. ",Toast.LENGTH_LONG).show();

                }


            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.logoutUser();
                //Intent i = new Intent (Produccion.this, Login.class);
                //Produccion.this.startActivity(i);
            }
        });
        editar_produccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hora_inicio != null) {
                    Intent a = new Intent(Produccion.this, Editar_produccion.class);
                    //a.putExtra("Fecha",Tfecha+"");
                    //a.putExtra("Hora",curTime+"");
                    //a.putExtra(Key3,nombreextra+"");
                    //a.putExtra(Key4,apellidoextra+"");
                    a.putExtra("Fecha", Tfecha + "");
                    a.putExtra("Hora", curTime + "");
                    startActivityForResult(a, HIJORESULT);
                    Toast.makeText(getApplicationContext(),"Ya ha iniciado turno.",Toast.LENGTH_LONG).show();
                }
             else{
                    Toast.makeText(getApplicationContext(),"Se requiere iniciar un turno antes de poder editar. ",Toast.LENGTH_LONG).show();
                }

            }
        });
        consultar_revision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent consultar_revision = new Intent(Produccion.this,Consultar_revision.class);
                Produccion.this.startActivity(consultar_revision);
            }
        });

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
                    tHora.setText(Html.fromHtml("La hora es:<b><b>   " + curTime+"</b></b>"));

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
