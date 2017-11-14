package android.alberto.app.lipangomovil;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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

public class Modificar_materiales_add extends AppCompatActivity {

    String id_produccion_e,position,nombre_e,apellido_e,fecha_e,hora_e;
    String harina_guadalupe_azul_extra,  harina_guadalupe_roja_extra, harina_centenario_extra,  harina_indistinta_extra,  azucar_refinada_siglo_xxi_extra,  azucar_estandar_central_m_extra,  pasta_pastel_dawn_extra, coco_rayado_extra,  almidon_imsa_extra,  maicena_extra,  manteca_flor_jalisco_extra, margarina_san_antonio_extra,  margarina_utarella_extra,  relleno_fresa_san_antonio_extra, cobertura_chocolate_garfias_extra, polvo_para_hornear_puratos_extra, huevo_extra,  sal_de_mar_extra,  leche_extra, tupan_puratos_extra, royal_tupan_puratos_extra, chocolate_ganeche_extra, piloncillo_extra;
    EditText nombre_usuario,apellido_usuario;
    EditText harina_guadalupe_azul,  harina_guadalupe_roja, harina_centenario,  harina_indistinta,  azucar_refinada_siglo_xxi,  azucar_estandar_central_m,  pasta_pastel_dawn, coco_rayado,  almidon_imsa,  maicena,  manteca_flor_jalisco, margarina_san_antonio,  margarina_utarella,  relleno_fresa_san_antonio, cobertura_chocolate_garfias, polvo_para_hornear_puratos, huevo,  sal_de_mar,  leche, tupan_puratos, royal_tupan_puratos, chocolate_ganeche, piloncillo;
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
    TextView hora_actual;
    String permiso;
    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    // Session Manager Class
    Administrador_sesion session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_materiales_add);
        session = new Administrador_sesion(getApplicationContext());
        Intent a = getIntent();
        position = a.getStringExtra("Position");
        id_produccion_e = a.getStringExtra("Id_produccion");
        nombre_e = a.getStringExtra("Nombre");
        apellido_e = a.getStringExtra("Apellido");
        fecha_e = a.getStringExtra("Fecha_Inicial");
        hora_e = a.getStringExtra("Hora_Inicial");
        harina_guadalupe_azul_extra = a.getStringExtra("Harina_azul");
        harina_guadalupe_roja_extra = a.getStringExtra("Harina_roja");
        harina_centenario_extra = a.getStringExtra("Harina_centenario");
        harina_indistinta_extra = a.getStringExtra("Harina_indistinta");
        azucar_refinada_siglo_xxi_extra = a.getStringExtra("Azucar_refinada");
        azucar_estandar_central_m_extra = a.getStringExtra("Azucar_estandar");
        pasta_pastel_dawn_extra = a.getStringExtra("Pasta_dawn");
        coco_rayado_extra = a.getStringExtra("Coco_rayado");
        almidon_imsa_extra = a.getStringExtra("Almidon_imsa");
        maicena_extra = a.getStringExtra("Maicena");
        manteca_flor_jalisco_extra = a.getStringExtra("Manteca");
        margarina_san_antonio_extra = a.getStringExtra("Margarina_san_antonio");
        margarina_utarella_extra = a.getStringExtra("Margarina_utarella");
        relleno_fresa_san_antonio_extra =a.getStringExtra("Relleno_fresa");
        cobertura_chocolate_garfias_extra = a.getStringExtra("Cobertura");
        polvo_para_hornear_puratos_extra = a.getStringExtra("Polvo_puratos");
        huevo_extra = a.getStringExtra("Huevo");
        sal_de_mar_extra = a.getStringExtra("Sal");
        leche_extra = a.getStringExtra("Leche");
        tupan_puratos_extra = a.getStringExtra("Tupan");
        royal_tupan_puratos_extra = a.getStringExtra("Royal");
        chocolate_ganeche_extra = a.getStringExtra("Chocolate_ganache");
        piloncillo_extra =a.getStringExtra("Piloncillo");

        //id_produccion_panblanco =(EditText) findViewById(R.id.id_produccion_pb_m);
        hora_actual =(TextView) findViewById(R.id.hora_mod);
        //nombre_usuario =(EditText) findViewById(R.id.nombre_usuario_m);
        //apellido_usuario = (EditText) findViewById(R.id.apellido_usuario_m);
        harina_guadalupe_azul = (EditText) findViewById(R.id.harina_guadalupe_azul_m);
        harina_guadalupe_roja = (EditText) findViewById(R.id.harina_guadalupe_roja_m);
        harina_centenario = (EditText)findViewById(R.id.harina_centenario_m);
        harina_indistinta =(EditText) findViewById(R.id.harina_indistinta_m);
        azucar_refinada_siglo_xxi = (EditText) findViewById(R.id.azucar_refinada_m);
        azucar_estandar_central_m = (EditText) findViewById(R.id.azucar_estandar_m);
        pasta_pastel_dawn = (EditText) findViewById(R.id.pasta_dawn_m);
        coco_rayado = (EditText) findViewById(R.id.coco_rayado_m);
        almidon_imsa = (EditText) findViewById(R.id.almidon_imsa_m);
        maicena =(EditText) findViewById(R.id.maicena_m);
        manteca_flor_jalisco = (EditText) findViewById(R.id.manteca_m);
        margarina_san_antonio =(EditText) findViewById(R.id.margarina_san_antonio_m);
        margarina_utarella = (EditText) findViewById(R.id.margarina_utarella_m);
        relleno_fresa_san_antonio = (EditText) findViewById(R.id.relleno_fresa_m);
        cobertura_chocolate_garfias =(EditText) findViewById(R.id.cobertura_m);
        polvo_para_hornear_puratos = (EditText) findViewById(R.id.polvo_hornear_m);
        huevo =(EditText) findViewById(R.id.huevo_m);
        sal_de_mar =(EditText) findViewById(R.id.sal_m);
        leche =(EditText) findViewById(R.id.leche_m);
        tupan_puratos =(EditText) findViewById(R.id.tupan_m);
        royal_tupan_puratos =(EditText) findViewById(R.id.royal_tupan_m);
        chocolate_ganeche = (EditText) findViewById(R.id.chocolate_ganache_m);
        piloncillo =(EditText) findViewById(R.id.piloncillo_m);
        cancelar = (Button) findViewById(R.id.cancelar);




        r = new RefreshClock();
        iniReloj= new Thread(r);
        iniReloj.start();


        final Calendar c = Calendar.getInstance();
        final SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy", new Locale("es"));
        fecha_actual_a = formato.format(c.getTime());

        //fecha_actual.setText(""+fecha_actual_a);
        //nombre_usuario.setText(""+nombre_e);
        //apellido_usuario.setText(""+apellido_e);

        harina_guadalupe_azul.setText(""+harina_guadalupe_azul_extra);
        harina_guadalupe_roja.setText(""+harina_guadalupe_roja_extra);
        harina_centenario.setText(""+harina_centenario_extra);
        harina_indistinta.setText(""+harina_indistinta_extra);
        azucar_refinada_siglo_xxi.setText(""+azucar_refinada_siglo_xxi_extra);
        azucar_estandar_central_m.setText(""+azucar_estandar_central_m_extra);
        pasta_pastel_dawn.setText(""+pasta_pastel_dawn_extra);
        coco_rayado.setText(""+coco_rayado_extra);
        almidon_imsa.setText(""+almidon_imsa_extra);
        maicena.setText(""+maicena_extra);
        manteca_flor_jalisco.setText(""+manteca_flor_jalisco_extra);
        margarina_san_antonio.setText(""+margarina_san_antonio_extra);
        margarina_utarella.setText(""+margarina_utarella_extra);
        relleno_fresa_san_antonio.setText(""+relleno_fresa_san_antonio_extra);
        cobertura_chocolate_garfias.setText(""+cobertura_chocolate_garfias_extra);
        polvo_para_hornear_puratos.setText(""+polvo_para_hornear_puratos_extra);
        huevo.setText(""+huevo_extra);
        sal_de_mar.setText(""+sal_de_mar_extra);
        leche.setText(""+leche_extra);
        tupan_puratos.setText(""+tupan_puratos_extra);
        royal_tupan_puratos.setText(""+royal_tupan_puratos_extra);
        chocolate_ganeche.setText(""+chocolate_ganeche_extra);
        piloncillo.setText(""+piloncillo_extra);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Modificar_materiales_add.this, Agregar_materiales.class);
                Modificar_materiales_add.this.startActivity(i);
            }
        });

    }
    public void modificar_materiales(View view){
        try {

            int compare = curTime.compareTo(hora_e);
            int compare2 = fecha_actual_a.compareTo(fecha_e);
            //boolean compare2 = fecha_actual_a.equals(fecha_e);


            if (compare < 11 && compare2<1 )
            {


                baseDatos = openOrCreateDatabase("LipanDb", MODE_PRIVATE, null);
                Intent i = getIntent();
                String position = i.getStringExtra("Position");//recogemos el valor del intet
                //String ed_hora_s = ed_hora.getText().toString();
                String id_produccion = id_produccion_e;
                String ed_fecha_s = fecha_actual_a;
                String ed_hora_s = curTime;
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


                String sql1 = ("Update  Materiales_add set hora = '" + ed_hora_s + "', fecha ='" + ed_fecha_s + "',harina_guadalupe_azul='"+ harina_guadalupe_azul_s+"',harina_guadalupe_roja='"+harina_guadalupe_roja_s+"',  harina_centenario='"+harina_centenario_s+"', harina_indistinta='"+harina_indistinta_s+"',  azucar_refinada_siglo_xxi='"+azucar_refinada_s+"', azucar_estandar_central_m='"+azucar_estandar_s+"',  pasta_pastel_dawn='"+pasta_pastel_dawn_s+"',  coco_rayado='"+coco_rayado_s+"',  almidon_imsa='"+almidon_imsa_s+"',  maicena='"+maicena_s+"',  manteca_flor_jalisco='"+manteca_flor_jalisco_s+"', margarina_san_antonio='"+margarina_san_antonio_s+"',  margarina_utarella='"+margarina_utarella_s+"', relleno_fresa_san_antonio='"+relleno_fresa_san_antonio_s+"',  cobertura_chocolate_garfias='"+cobertura_chocolate_garfias_s+"',  polvo_para_hornear_puratos='"+polvo_para_hornear_puratos_s+"',  huevo='"+huevo_s+"',  sal_de_mar='"+sal_de_mar_s+"',  leche='"+leche_s+"',  tupan_puratos='"+tupan_puratos_s+"',  royal_tupan_puratos='"+royal_tupan_puratos_s+"',  chocolate_ganeche='"+chocolate_ganeche_s+"', piloncillo='"+piloncillo_s+"' where id_material_add =" + position);
                baseDatos.execSQL(sql1);
                Toast.makeText(this, "Actualizado", Toast.LENGTH_SHORT).show();
                Intent regresar = new Intent(Modificar_materiales_add.this, Agregar_materiales.class);
                startActivity(regresar);
            }
            else{
                Toast.makeText(this,"Ya no puedes Modificar se acabo tu teimpo.",Toast.LENGTH_SHORT).show();
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
                    hora_actual.setText(Html.fromHtml("La fecha-hora: <b>"+ fecha_actual_a+ " - " +curTime+"</b>"));

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
