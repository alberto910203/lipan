package android.alberto.app.lipangomovil;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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

public class Agregar_materiales extends ListActivity {
    // variables locales de registro
    Button registrar_produccion,refrescar,regresar;
    String nombre;// variable donde guardo el valor del intent para el nombre
    String apellido;// variable donde guardo el valor del intent para el nombre
    SQLiteDatabase baseDatos = null; // Inicializar la variable para cargar/acceso la base de datos
    EditText harina_guadalupe_azul,  harina_guadalupe_roja, harina_centenario,  harina_indistinta,  azucar_refinada_siglo_xxi,  azucar_estandar_central_m,  pasta_pastel_dawn, coco_rayado,  almidon_imsa,  maicena,  manteca_flor_jalisco, margarina_san_antonio,  margarina_utarella,  relleno_fresa_san_antonio, cobertura_chocolate_garfias, polvo_para_hornear_puratos, huevo,  sal_de_mar,  leche, tupan_puratos, royal_tupan_puratos, chocolate_ganeche, piloncillo;
    String Tfecha;
    public String cant_bolillo_chico_modificar,cant_bolillo_mediano_modificar, cant_bolillo_grande_modificar,cant_telera_modificar;
    //----------------variables para el hilo del reloj-------
    int hora=0, minuto =0, segundo = 0;
    Thread iniReloj = null;
    Runnable r;
    boolean isUpdate = false;
    String sec, min, hor;
    String curTime;
    TextView thora,nombre_usuario;

    //--------------------------------------------------------
    private Cursor fila;
    //Alert Dialog Manager instancia
    AlertDialogManager alert = new AlertDialogManager();

    // Administrador de sesion Class
    Administrador_sesion session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_materiales);
        setListAdapter(new Adaptador_materiales_add(this));
        session = new Administrador_sesion(getApplicationContext());
        //Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();
        refrescar = (Button) findViewById(R.id.refrescar);
        regresar =(Button) findViewById(R.id.regresar);
        registrar_produccion = (Button) findViewById(R.id.registra_produccion);

        refrescar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent refrescar = new Intent(Agregar_materiales.this, Agregar_materiales.class);
                Agregar_materiales.this.startActivity(refrescar);
            }
        });
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresar = new Intent(Agregar_materiales.this, Editar_produccion.class);
                Agregar_materiales.this.startActivity(regresar);

            }
        });
    }
    public void registrar_materiales(View view){
        View v = this.getLayoutInflater().inflate(R.layout.dialog_interface_add_materiales,null);
        // Aqui me quede 03/04/2017 5:10
        baseDatos = openOrCreateDatabase("LipanDb", MODE_PRIVATE, null);
        String Tabla_materiales ="CREATE TABLE IF NOT EXISTS Materiales_add(id_material_add INTEGER PRIMARY KEY AUTOINCREMENT, fecha DATETIME DEFAULT CURRENT_TIMESTAMP, hora DATETIME DAFAULT CURRENT_TIMESTAMP, nombre_usuario TEXT, apellido_usuario TEXT,  harina_guadalupe_azul INTEGER,  harina_guadalupe_roja INTEGER,  harina_centenario INTEGER,  harina_indistinta INTEGER,  azucar_refinada_siglo_xxi INTEGER,  azucar_estandar_central_m INTEGER, pasta_pastel_dawn INTEGER,  coco_rayado INTEGER,  almidon_imsa INTEGER,  maicena INTEGER,  manteca_flor_jalisco INTEGER, margarina_san_antonio INTEGER,  margarina_utarella INTEGER,  relleno_fresa_san_antonio INTEGER, cobertura_chocolate_garfias INTEGER,  polvo_para_hornear_puratos INTEGER,  huevo INTEGER,  sal_de_mar INTEGER,  leche  INTEGER, tupan_puratos INTEGER,  royal_tupan_puratos INTEGER, chocolate_ganeche INTEGER,  piloncillo INTEGER)";
                baseDatos.execSQL(Tabla_materiales);

//        id_produccion_panblanco =(EditText) v.findViewById(R.id.id_produccion_pb_d);
        thora =(TextView) v.findViewById(R.id.nombre_usuario_add_ma);
        nombre_usuario =(TextView) v.findViewById(R.id.hora_add_ma);

        harina_guadalupe_azul = (EditText) v.findViewById(R.id.harina_guadalupe_azul_d);
        harina_guadalupe_roja = (EditText) v.findViewById(R.id.harina_guadalupe_roja_d);
        harina_centenario = (EditText) v.findViewById(R.id.harina_centenario_d);
        harina_indistinta =(EditText) v.findViewById(R.id.harina_indistinta_d);
        azucar_refinada_siglo_xxi = (EditText) v.findViewById(R.id.azucar_refinada_d);
        azucar_estandar_central_m = (EditText) v.findViewById(R.id.azucar_estandar_d);
        pasta_pastel_dawn = (EditText) v.findViewById(R.id.pasta_dawn_d);
        coco_rayado = (EditText) v.findViewById(R.id.coco_rayado_d);
        almidon_imsa = (EditText) v.findViewById(R.id.almidon_imsa_d);
        maicena =(EditText) v.findViewById(R.id.maicena_d);
        manteca_flor_jalisco = (EditText) v.findViewById(R.id.manteca_d);
        margarina_san_antonio =(EditText) v.findViewById(R.id.margarina_san_antonio_d);
        margarina_utarella = (EditText) v.findViewById(R.id.margarina_utarella_d);
        relleno_fresa_san_antonio = (EditText) v.findViewById(R.id.relleno_fresa_d);
        cobertura_chocolate_garfias =(EditText) v.findViewById(R.id.cobertura_d);
        polvo_para_hornear_puratos = (EditText) v.findViewById(R.id.polvo_hornear_d);
        huevo =(EditText) v.findViewById(R.id.huevo_d);
        sal_de_mar =(EditText) v.findViewById(R.id.sal_d);
        leche =(EditText) v.findViewById(R.id.leche_d);
        tupan_puratos =(EditText) v.findViewById(R.id.tupan_d);
        royal_tupan_puratos =(EditText) v.findViewById(R.id.royal_tupan_d);
        chocolate_ganeche = (EditText) v.findViewById(R.id.chocolate_ganache_d);
        piloncillo =(EditText) v.findViewById(R.id.piloncillo_d);



        session.checkLogin();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        // name
        final String nombre = user.get(Administrador_sesion.KEY_NOMBRE);

        // email
        final String apellido = user.get(Administrador_sesion.KEY_APELLIDO);


        nombre_usuario.setText(Html.fromHtml("<b>"+nombre+" "+apellido+"</b>"));

        //cant_bolillo_chico_modificar = cant_bolillo_chico.getText().toString();


        Calendar c = Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy", new Locale("es"));
        Tfecha =  formato.format(c.getTime());
        //fecha.setText(Tfecha);
        r = new RefreshClock(); // variables para la parte del reloj
        iniReloj = new Thread(r);
        iniReloj.start();


        new AlertDialog.Builder(this)
                //.setTitle("Ingresar los Materiales")
                //.setMessage("Llena los Campos")
                //.setView(nombre_material)
                .setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {

                        // crear cadenas para insertar en la base de datos
                        // String id_produccion_s = id_produccion_panblanco.getText().toString();
                        String fecha_s = Tfecha;
                        String hora_s = curTime;
                        final String nombre_usuario_s = nombre;
                        String apellido_usuario_s = apellido;
                        String harina_guadalupe_azul_s = harina_guadalupe_azul.getText().toString();
                        String harina_guadalupe_roja_s = harina_guadalupe_roja.getText().toString();
                        String harina_centenario_s = harina_centenario.getText().toString();
                        String harina_indistinta_s = harina_indistinta.getText().toString();
                        String azucar_refinada_s = azucar_refinada_siglo_xxi.getText().toString();
                        String azucar_estandar_s = azucar_estandar_central_m.getText().toString();
                        String pasta_pastel_dawn_s = pasta_pastel_dawn.getText().toString();
                        String coco_rayado_s = coco_rayado.getText().toString();
                        String almidon_imsa_s = almidon_imsa.getText().toString();
                        String  maicena_s = maicena.getText().toString();
                        String manteca_flor_jalisco_s =manteca_flor_jalisco.getText().toString();
                        String margarina_san_antonio_s = margarina_san_antonio.getText().toString();
                        String margarina_utarella_s = margarina_utarella.getText().toString();
                        String relleno_fresa_san_antonio_s = relleno_fresa_san_antonio.getText().toString();
                        String cobertura_chocolate_garfias_s = cobertura_chocolate_garfias.getText().toString();
                        String polvo_para_hornear_puratos_s = polvo_para_hornear_puratos.getText().toString();
                        String huevo_s = huevo.getText().toString();
                        String sal_de_mar_s = sal_de_mar.getText().toString();
                        String leche_s = leche.getText().toString();
                        String tupan_puratos_s = tupan_puratos.getText().toString();
                        String royal_tupan_puratos_s = royal_tupan_puratos.getText().toString();
                        String chocolate_ganeche_s = chocolate_ganeche.getText().toString();
                        String  piloncillo_s = piloncillo.getText().toString();


                        //Intent extra = new Intent(Produccion_panblanco.this,Produccion_panblanco.class);
                        //extra.putExtra("Nombre",nombre_usuario_s+"");

                        //startActivity(extra);

                        String insert1 = "INSERT INTO Materiales_add(id_material_add, fecha, hora, nombre_usuario, apellido_usuario,  harina_guadalupe_azul, harina_guadalupe_roja,  harina_centenario, harina_indistinta,  azucar_refinada_siglo_xxi,  azucar_estandar_central_m,  pasta_pastel_dawn,  coco_rayado,  almidon_imsa,  maicena,  manteca_flor_jalisco, margarina_san_antonio,  margarina_utarella, relleno_fresa_san_antonio,  cobertura_chocolate_garfias,  polvo_para_hornear_puratos,  huevo,  sal_de_mar,  leche,  tupan_puratos,  royal_tupan_puratos,  chocolate_ganeche, piloncillo ) VALUES (null,'" + fecha_s + "', '" + hora_s + "','" + nombre_usuario_s + "','" + apellido_usuario_s + "','" +  harina_guadalupe_azul_s + "', '"+ harina_guadalupe_roja_s+"', '"+ harina_centenario_s+"',  '"+harina_indistinta_s+"', '"+azucar_refinada_s+"', '"+azucar_estandar_s+"',  '"+pasta_pastel_dawn_s+"', '"+coco_rayado_s+"',  '"+almidon_imsa_s+"', '"+maicena_s+"',  '"+manteca_flor_jalisco_s+"',  '"+margarina_san_antonio_s+"',  '"+margarina_utarella_s+"',  '"+relleno_fresa_san_antonio_s+"',  '"+cobertura_chocolate_garfias_s+"',  '"+polvo_para_hornear_puratos_s+"', '"+huevo_s+"',  '"+sal_de_mar_s+"', '"+leche_s+"',  '"+tupan_puratos_s+"', '"+royal_tupan_puratos_s+"',  '"+chocolate_ganeche_s+"', '"+piloncillo_s+"');";
                        baseDatos.execSQL(insert1);

                    }
                })
                .setNegativeButton("Cancelar", null)
                .setView(v)
                //.setView(this.getLayoutInflater().inflate(R.layout.dialog_interface, null, true))


                .show();


    }

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

        baseDatos = this.openOrCreateDatabase("LipanDb", MODE_PRIVATE, null);
        fila = baseDatos.rawQuery("SELECT  harina_guadalupe_azul,  harina_guadalupe_roja,  harina_centenario,  harina_indistinta,  azucar_refinada_siglo_xxi,  azucar_estandar_central_m,  pasta_pastel_dawn,  coco_rayado, almidon_imsa,  maicena,  manteca_flor_jalisco,  margarina_san_antonio,  margarina_utarella, relleno_fresa_san_antonio,  cobertura_chocolate_garfias,  polvo_para_hornear_puratos,  huevo,  sal_de_mar,  leche,  tupan_puratos,  royal_tupan_puratos,  chocolate_ganeche,  piloncillo, fecha, hora,nombre_usuario, apellido_usuario FROM Materiales_add WHERE id_material_add = '" + position + "' ", null);
        if (fila.moveToFirst()) {
            String harina_guadalupe_azul = fila.getString(0);
            String harina_guadalupe_roja =fila.getString(1);
            String harina_centenario =fila.getString(2);
            String harina_indistinta = fila.getString(3);
            String azucar_refinada_siglo_xxi = fila.getString(4);
            String azucar_estandar_central_m = fila.getString(5);
            String pasta_pastel_dawn = fila.getString(6);
            String coco_rayado = fila.getString(7);
            String almidon_imsa = fila.getString(8);
            String maicena = fila.getString(9);
            String manteca_flor_jalisco = fila.getString(10);
            String margarina_san_antonio = fila.getString(11);
            String margarina_utarella = fila.getString(12);
            String relleno_fresa_san_antonio = fila.getString(13);
            String cobertura_chocolate_garfias = fila.getString(14);
            String polvo_para_hornear_puratos = fila.getString(15);
            String huevo = fila.getString(16);
            String sal_de_mar = fila.getString(17);
            String leche = fila.getString(18);
            String tupan_puratos = fila.getString(19);
            String royal_tupan_puratos = fila.getString(20);
            String chocolate_ganeche = fila.getString(21);
            String piloncillo = fila.getString(22);
            String fecha_s = fila.getString(23);
            String hora_s = fila.getString(24);
            String nombre_s =fila.getString(25);
            String apellido_s=fila.getString(26);

if(nombre_s.equals(nombre) && apellido_s.equals(apellido)) {

    Intent i = new Intent(Agregar_materiales.this, Modificar_materiales_add.class);


    i.putExtra("Position", position + "");
    //i.putExtra("Id_produccion", id_produccion);
    i.putExtra("Nombre", nombre_s + "");
    i.putExtra("Apellido", apellido_s + "");
    i.putExtra("Harina_azul", harina_guadalupe_azul + "");
    i.putExtra("Harina_roja", harina_guadalupe_roja + "");
    i.putExtra("Harina_centenario", harina_centenario + "");
    i.putExtra("Harina_indistinta", harina_indistinta + "");
    i.putExtra("Azucar_refinada", azucar_refinada_siglo_xxi + "");
    i.putExtra("Azucar_estandar", azucar_estandar_central_m + "");
    i.putExtra("Pasta_dawn", pasta_pastel_dawn + "");
    i.putExtra("Coco_rayado", coco_rayado + "");
    i.putExtra("Almidon_imsa", almidon_imsa + "");
    i.putExtra("Maicena", maicena + "");
    i.putExtra("Manteca", manteca_flor_jalisco + "");
    i.putExtra("Margarina_san_antonio", margarina_san_antonio + "");
    i.putExtra("Margarina_utarella", margarina_utarella + "");
    i.putExtra("Relleno_fresa", relleno_fresa_san_antonio + "");
    i.putExtra("Cobertura", cobertura_chocolate_garfias + "");
    i.putExtra("Polvo_puratos", polvo_para_hornear_puratos + "");
    i.putExtra("Huevo", huevo + "");
    i.putExtra("Sal", sal_de_mar + "");
    i.putExtra("Leche", leche + "");
    i.putExtra("Tupan", tupan_puratos + "");
    i.putExtra("Royal", royal_tupan_puratos + "");
    i.putExtra("Chocolate_ganache", chocolate_ganeche + "");
    i.putExtra("Piloncillo", piloncillo + "");

    i.putExtra("Fecha_Inicial", fecha_s + "");
    i.putExtra("Hora_Inicial", hora_s + "");

    startActivityForResult(i, 3);
}
else{
    Toast.makeText(this, "No puedes editar la lista de otro usuario. ", Toast.LENGTH_SHORT).show();
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
