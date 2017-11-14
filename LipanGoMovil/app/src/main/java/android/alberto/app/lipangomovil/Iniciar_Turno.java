package android.alberto.app.lipangomovil;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class Iniciar_Turno extends AppCompatActivity {
    String hora_extra,fecha_extra,usuarionombreextra,usuarioapellidoextra;
    TextView dataextra_hora_fecha,fecha,Thora,dataextra_nombre_apellido;
    int hora=0, minuto =0, segundo = 0;
    Thread iniReloj = null;
    Runnable r;
    boolean isUpdate = false;
    String sec, min, hor;
    String curTime;
    String Tfecha;
    String nombre,apellido;
    CheckBox nombremarcado1,nombremarcado2,nombremarcado3,nombremarcado4,nombremarcado5,nombremarcado6,nombremarcado7,nombremarcado8,nombremarcado9;
    String nombre1 = "Juan Carlos";
    String nombre2 = "Carlos Alberto";
    String nombre3 = "Jose Luis";
    String nombre4 = "Miguel Luis";
    public String nomark  = "";
    //String nombre_trabajador_1;
    protected String[] trabajadores = new String[4];
    TextView Trabajadores,instructivo;
    Button ver_registros;
    SQLiteDatabase baseDatos = null;
    private Cursor fila;
    EditText produccion,comentarios;
    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    // Session Manager Class
    Administrador_sesion session;

    //Session Guardar Tuuno
    Administracion_sesion_turnos session2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar__turno);
        session = new Administrador_sesion(getApplicationContext());
        session2 = new Administracion_sesion_turnos(getApplicationContext());
        fecha_extra = getIntent().getStringExtra("Fecha"); // fecha de inicio
        hora_extra = getIntent().getStringExtra("Hora");   // hora de inicio
        usuarionombreextra = getIntent().getStringExtra("Usuario");  // nombre de usuario
        usuarioapellidoextra = getIntent().getStringExtra("Usuario2"); // apellido de usuario
        fecha = (TextView) findViewById(R.id.getfecha);   //variables para meterlas en la base de datos fecha actual
        Thora = (TextView) findViewById(R.id.gethora);    //variables para meterlas en la base de datos  hora actual
        dataextra_hora_fecha = (TextView) findViewById(R.id.dataextra1);
        dataextra_nombre_apellido = (TextView) findViewById(R.id.dataextra2);
        Trabajadores = (TextView) findViewById(R.id.trabajadores);
        instructivo = (TextView) findViewById(R.id.instructivo);
        //produccion = (EditText) findViewById(R.id.produccion);
        //comentarios =(EditText) findViewById(R.id.comentarios);
        //ver_registros = (Button) findViewById(R.id.ver_registros);
        instructivo.setText(Html.fromHtml("<ul><li>Selecciona los trabajadores que laborarán.<li><br></br>Posteriormente confirma el inicio de turno.<br></br> <li>Puedes optar por cancelar y no se registrarán los trabajadores ni el nuevo turno.</ul>"));
        //Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(), "Status Turnos: " + session2.isLoggedIn(), Toast.LENGTH_LONG).show();
//+++++++++++++++++++++++++++++++++++++++ VER REGISTROS ++++++++++++++++++++++++++++++++++++++++++++++
       /* ver_registros.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent ver_registros = new Intent(Iniciar_Turno.this,Ver_registros_turno.class);
              Iniciar_Turno.this.startActivity(ver_registros);
          }
      });*/

        /**
         * Call this function whenever you want to check user login
         * This will redirect user to LoginActivity is he is not
         * logged in
         * */
        session.checkLogin();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        // name
        nombre = user.get(Administrador_sesion.KEY_NOMBRE);

        // email
        apellido = user.get(Administrador_sesion.KEY_APELLIDO);


        final Calendar c = Calendar.getInstance();
        final SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy", new Locale("es"));
        Tfecha = formato.format(c.getTime());
        fecha.setText(Html.fromHtml("La fecha es:<b> " + Tfecha + "</b>"));
        r = new Iniciar_Turno.RefreshClock(); // variables para la parte del reloj
        iniReloj = new Thread(r);
        iniReloj.start();


        //dataextra_hora_fecha.setText(" "+fecha_extra+" "+hora_extra+" ");
        dataextra_nombre_apellido.setText(Html.fromHtml("Usuario:<b> " + nombre + " " + apellido + "</b>"));
        baseDatos = this.openOrCreateDatabase("LipanDb", MODE_PRIVATE, null);
        nombremarcado1 = (CheckBox) findViewById(R.id.nombre1);
        nombremarcado2= (CheckBox)findViewById(R.id.nombre2);
        nombremarcado3 = (CheckBox) findViewById(R.id.nombre3);
        nombremarcado4 = (CheckBox) findViewById(R.id.nombre4);
        nombremarcado5 = (CheckBox) findViewById(R.id.nombre5);
        nombremarcado6 = (CheckBox) findViewById(R.id.nombre6);
        //nombremarcado7= (CheckBox)findViewById(R.id.nombre7);
        nombremarcado8 = (CheckBox) findViewById(R.id.nombre8);
        nombremarcado9 = (CheckBox) findViewById(R.id.nombre9);

        String crearTabla = "CREATE TABLE IF NOT EXISTS Trabajadores (id_trabajador integer primary key autoincrement,nombre_trabajador text);";
        baseDatos.execSQL(crearTabla);

        fila = baseDatos.rawQuery("SELECT COUNT(*) FROM Trabajadores", null);
        if (fila != null) {
            fila.moveToFirst();

            if (fila.getInt(0) == 0) {

                String insertar_admin = "INSERT INTO Trabajadores(id_trabajador,nombre_trabajador)Values(null,'Abraham Estrada'); ";
                String insertar_admin1 = "INSERT INTO Trabajadores(id_trabajador,nombre_trabajador)Values(null,'Arturo Flores'); ";
                String insertar_admin2 = "INSERT INTO Trabajadores(id_trabajador,nombre_trabajador)Values(null,'Eugenio Perez'); ";
                String insertar_admin3 = "INSERT INTO Trabajadores(id_trabajador,nombre_trabajador)Values(null,'Francisco Baez'); ";
                String insertar_admin4 = "INSERT INTO Trabajadores(id_trabajador,nombre_trabajador)Values(null,'Ignacio Cortes'); ";
                String insertar_admin5 = "INSERT INTO Trabajadores(id_trabajador,nombre_trabajador)Values(null,'Martin Cortes'); ";
                //String insertar_admin6 = "INSERT INTO Trabajadores(id_trabajador,nombre_trabajador)Values(null,'Pedro Barron'); ";
                String insertar_admin7 = "INSERT INTO Trabajadores(id_trabajador,nombre_trabajador)Values(null,'Rafael Flores'); ";
                String insertar_admin8 = "INSERT INTO Trabajadores(id_trabajador,nombre_trabajador)Values(null,'Rafael Medrano'); ";


                baseDatos.execSQL(insertar_admin);
                baseDatos.execSQL(insertar_admin1);
                baseDatos.execSQL(insertar_admin2);
                baseDatos.execSQL(insertar_admin3);
                baseDatos.execSQL(insertar_admin4);
                baseDatos.execSQL(insertar_admin5);
                //baseDatos.execSQL(insertar_admin6);
                baseDatos.execSQL(insertar_admin7);
                baseDatos.execSQL(insertar_admin8);
            } else {

                //Toast.makeText(getApplicationContext(), "hay registros", Toast.LENGTH_SHORT).show();
            }
        } else {
            //Toast.makeText(getApplicationContext(),"no podemos hacer la comparacion de la DB",Toast.LENGTH_SHORT).show();
        }


        nombremarcado1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                boolean isChecked = ((CheckBox) view).isChecked();
                if (isChecked) {
                    fila = baseDatos.rawQuery("select nombre_trabajador from Trabajadores where id_trabajador = '1'  ", null);
                    if (fila.moveToFirst()) {
                        String nombre_trabajador_1 = fila.getString(0);
                        nombremarcado1.setText(nombre_trabajador_1);
                        Trabajadores.append(" " + nombre_trabajador_1 + ", ");

                    }

                } else {
                    nombremarcado1.setText("Abraham Estrada");
                    Trabajadores.setText("");
                }
            }
            //Trabajadores.append(""+nombre_trabajador_1+"");
        });

        //Trabajadores.append(""+nombre_trabajador_1+"");


        nombremarcado2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isChecked = ((CheckBox) view).isChecked();

                        if (isChecked) {

                            fila = baseDatos.rawQuery("select nombre_trabajador from Trabajadores where id_trabajador = '2'  ", null);
                            if (fila.moveToFirst()) {
                                final String nombre_trabajador_2 = fila.getString(0);
                                nombremarcado2.setText(nombre_trabajador_2 );
                                Trabajadores.append(""+nombre_trabajador_2+", ");
                            }
                        } else {
                            nombremarcado2.setText("Arturo Flores");
                            Trabajadores.setText("");
                        }

                    }
                });

        nombremarcado3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isChecked = ((CheckBox) view).isChecked();

                if (isChecked) {
                    fila = baseDatos.rawQuery("select nombre_trabajador from Trabajadores where id_trabajador = '3'  ", null);
                    if (fila.moveToFirst()) {
                        final String nombre_trabajador_3 = fila.getString(0);
                        nombremarcado3.setText(nombre_trabajador_3);
                        Trabajadores.append("" + nombre_trabajador_3 + ", ");
                    }
                } else {
                    nombremarcado3.setText("Eugenio Perez");
                    Trabajadores.setText("");

                }

            }
        });

        nombremarcado4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isChecked = ((CheckBox) view).isChecked();

                if (isChecked) {
                    fila = baseDatos.rawQuery("select nombre_trabajador from Trabajadores where id_trabajador = '4'  ", null);
                    if (fila.moveToFirst()) {
                        final String nombre_trabajador_4 = fila.getString(0);
                        nombremarcado4.setText(nombre_trabajador_4);
                        Trabajadores.append("" + nombre_trabajador_4 + ", ");
                    }

                } else {
                    nombremarcado4.setText("Francisco Baez");
                    Trabajadores.setText("");

                }

            }
        });
        nombremarcado5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                boolean isChecked = ((CheckBox) view).isChecked();
                if (isChecked) {
                    fila = baseDatos.rawQuery("select nombre_trabajador from Trabajadores where id_trabajador = '5'  ", null);
                    if (fila.moveToFirst()) {
                        String nombre_trabajador_5 = fila.getString(0);
                        nombremarcado5.setText(nombre_trabajador_5);
                        Trabajadores.append(" " + nombre_trabajador_5 + ", ");

                    }

                } else {
                    nombremarcado5.setText("Ignacio Cortes");
                    Trabajadores.setText("");
                }
            }
            //Trabajadores.append(""+nombre_trabajador_1+"");
        });

        nombremarcado6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                boolean isChecked = ((CheckBox) view).isChecked();
                if (isChecked) {
                    fila = baseDatos.rawQuery("select nombre_trabajador from Trabajadores where id_trabajador = '6'  ", null);
                    if (fila.moveToFirst()) {
                        String nombre_trabajador_6 = fila.getString(0);
                        nombremarcado6.setText(nombre_trabajador_6);
                        Trabajadores.append(" " + nombre_trabajador_6 + ", ");

                    }

                } else {
                    nombremarcado6.setText("Martin Cortes");
                    Trabajadores.setText("");
                }
            }
            //Trabajadores.append(""+nombre_trabajador_1+"");
        });

        /*nombremarcado7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                boolean isChecked = ((CheckBox) view).isChecked();
                if (isChecked) {
                    fila = baseDatos.rawQuery("select nombre_trabajador from Trabajadores where id_trabajador = '7'  ", null);
                    if (fila.moveToFirst()) {
                        String nombre_trabajador_7 = fila.getString(0);
                        nombremarcado7.setText(nombre_trabajador_7);
                        Trabajadores.append(" "+nombre_trabajador_7+", ");

                    }

                } else {
                    nombremarcado7.setText("Pedro Barron");
                    Trabajadores.setText("");
                }
            }
            //Trabajadores.append(""+nombre_trabajador_1+"");
        });
*/
        nombremarcado8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                boolean isChecked = ((CheckBox) view).isChecked();
                if (isChecked) {
                    fila = baseDatos.rawQuery("select nombre_trabajador from Trabajadores where id_trabajador = '7'  ", null);
                    if (fila.moveToFirst()) {
                        String nombre_trabajador_8 = fila.getString(0);
                        nombremarcado8.setText(nombre_trabajador_8);
                        Trabajadores.append(" " + nombre_trabajador_8 + ", ");

                    }

                } else {
                    nombremarcado8.setText("Rafael Flores");
                    Trabajadores.setText("");
                }
            }
            //Trabajadores.append(""+nombre_trabajador_1+"");
        });

        nombremarcado9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                boolean isChecked = ((CheckBox) view).isChecked();
                if (isChecked) {
                    fila = baseDatos.rawQuery("select nombre_trabajador from Trabajadores where id_trabajador = '8'  ", null);
                    if (fila.moveToFirst()) {
                        String nombre_trabajador_9 = fila.getString(0);
                        nombremarcado9.setText(nombre_trabajador_9);
                        Trabajadores.append(" " + nombre_trabajador_9 + ", ");

                    }

                } else {
                    nombremarcado9.setText("Rafael Medrano");
                    Trabajadores.setText("");
                }
            }
            //Trabajadores.append(""+nombre_trabajador_1+"");
        });
    }
public void limpiar (View view){
   nombremarcado1.setChecked(false);
    nombremarcado2.setChecked(false);
    nombremarcado3.setChecked(false);
    nombremarcado4.setChecked(false);
    nombremarcado5.setChecked(false);
    nombremarcado6.setChecked(false);
    //nombremarcado7.setChecked(false);
    nombremarcado8.setChecked(false);
    nombremarcado9.setChecked(false);
    Trabajadores.setText("Trabajadores");
}



  public void registrar_turno(View view){
      // Guardo los datos del turno con un insert
      baseDatos = this.openOrCreateDatabase("LipanDb", MODE_PRIVATE, null);
      String crearturno = "CREATE TABLE IF NOT EXISTS Turnos(id_turno INTEGER PRIMARY KEY AUTOINCREMENT, nombre_usuario TEXT,apellido_usuario TEXT,fecha_inicio DATETIME DEFAULT CURRENT_TIMESTAMP, fecha_fin DATETIME DEFAULT CURRENT_TIMESTAMP, hora_inicio DATETIME DEFAULT CURRENT_TIMESTAMP, hora_fin DATETIME DEFAULT CURRENT_TIMESTAMP, trabajadores TEXT )";
      //baseDatos.setForeignKeyConstraintsEnabled(true);
      //baseDatos.execSQL("PRAGMA_foreign_keys=ON");
      baseDatos.execSQL(crearturno);

      String nombre_s = nombre;
      String apellido_s = apellido;
      String fecha_inicio = fecha_extra;
      String fecha_fin =  Tfecha;
      String hora_inicio = curTime;
      String hora_fin = curTime;
      String trabajadores = Trabajadores.getText().toString();
      //String produccion_s = produccion.getText().toString();
      //String comentarios_s = comentarios.getText().toString();
      String guardar_turno = "INSERT INTO Turnos(id_turno,nombre_usuario,apellido_usuario,fecha_inicio,fecha_fin,hora_inicio,hora_fin,trabajadores)Values(null,'"+ nombre_s +"','"+apellido_s+"','"+fecha_inicio+"','"+fecha_fin+"','"+hora_inicio+"','"+hora_fin+"','"+trabajadores+"');"; // aqui me quede pendiente, ya tengo sueno...1:14am
      //baseDatos.setForeignKeyConstraintsEnabled(true);
     // baseDatos.execSQL("PRAGMA_foreign_keys=ON");
      baseDatos.execSQL(guardar_turno);
      session2.createLoginSession(hora_inicio, hora_fin);
      Toast.makeText(this,"El turno se ha registrado, ya puedes introducir datos de producción.",Toast.LENGTH_LONG).show();
      Intent produccion = new Intent(getApplicationContext(),Produccion.class);
      //produccion.putExtra("hora_inicial",hora_inicio+"");
      // produccion.putExtra("fecha inicial",hora_fin+"");
      startActivity(produccion);
      finish();

  }
  public void cancelar(View view){
      Intent cancelar = new Intent(Iniciar_Turno.this, Produccion.class);
      Iniciar_Turno.this.startActivity(cancelar);
      Toast.makeText(this,"El turno no se registró, deberás iniciar un turno nuevo.",Toast.LENGTH_LONG).show();
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
                    Thora.setText(Html.fromHtml("La Hora Actual es:<b> "+ curTime+"</b>"));

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
