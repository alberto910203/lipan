package android.alberto.app.lipangomovil;

import android.content.Intent;
import android.preference.EditTextPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class Editar_produccion extends AppCompatActivity {
    String usuarionombre, usuarioapellido, Fecha, Hora;
    Button  irmenu;
    TextView usuario,fechahora;
    ImageView produccion_panblanco, produccion_pandulce, agregar_material;
    public static final int HIJORESULT2 = 1;
    public static final String Key5 = "Nombre3";
    public static final String Key6 = "Apellido3";
    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    // Session Manager Class
    Administrador_sesion session;

    int hora = 0, minuto = 0, segundo = 0;
    Thread iniReloj = null;
    Runnable r;
    boolean isUpdate = false;
    String sec, min, hor;
    String curTime;
    String Tfecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_producccion);
        session = new Administrador_sesion(getApplicationContext());
        //usuarionombre = getIntent().getStringExtra("Nombre2");   // variables que van a la Db
        //usuarioapellido = getIntent().getStringExtra("Apellido2");//


        agregar_material = (ImageView) findViewById(R.id.agregar_material);
        //produccion_panblanco = (ImageView) findViewById(R.id.panblanco);
        produccion_pandulce = (ImageView) findViewById(R.id.pandulce);

        usuario = (TextView) findViewById(R.id.dataextra1);
        fechahora = (TextView) findViewById(R.id.dataextra2);
        irmenu = (Button) findViewById(R.id.irmenu);
        //Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();
        session.checkLogin();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        // name
        final String nombre = user.get(Administrador_sesion.KEY_NOMBRE);

        // email
        final String apellido = user.get(Administrador_sesion.KEY_APELLIDO);

        usuario.setText(Html.fromHtml("Usuario: <b>" + nombre + " " + apellido+"</b>"));

        final Calendar c = Calendar.getInstance();
        final SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy", new Locale("es"));
        Tfecha = formato.format(c.getTime());

        r = new RefreshClock(); // variables para la parte del reloj
        iniReloj = new Thread(r);
        iniReloj.start();

        agregar_material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Editar_produccion.this, Agregar_materiales.class);
                Editar_produccion.this.startActivity(a);
            }
        });
       /* produccion_panblanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Editar_produccion.this, Produccion_panblanco.class);
                startActivity(a);
            }
        });*/
        produccion_pandulce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Editar_produccion.this, Produccion_total.class);
                Editar_produccion.this.startActivity(a);
            }
        });
        irmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Editar_produccion.this, Produccion.class);
                Editar_produccion.this.startActivity(i);
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
                    //tHora.setText("La Hora es: " + curTime);
                    fechahora.setText(Html.fromHtml("Fecha y hora:<b> " + Tfecha+ "   -   "+curTime+" <br> "));

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