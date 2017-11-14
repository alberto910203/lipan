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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class Modificar_produccion_pandulce extends AppCompatActivity {
    String id_produccion_e,position,nombre_e,apellido_e,fecha_e,hora_e,cant_bolillo_extra,cant_bolillo_chico_extra,cant_bolillo_mignon_extra,cant_pan_acimo_extra,cant_pambazo_extra,cant_pambazo_grande_extra;
    String cant_telera_extra,cant_telera_grande_extra,bola_leche_extra, cuernito_estandar_extra, cuernito_chico_extra, cuernito_grande_extra, pan_dulce_estandar_extra, pan_dulce_chico_extra, dona_especial_extra, dona_sencillo_extra, acambareno_grande_extra, concha_grande_extra, tortuga_grande_extra, pastel_extra, merengue_estandar_extra, merengue_cafe_chico_extra, merengue_chico_extra, pasta_hojaldra_extra,reposteria_1_extra, reposteria_2_extra, reposteria_3_extra, reposteria_4_extra, reposteria_5_extra, hamburguesa_estandar_extra, hamburguesa_chica_extra, pizza_estandar_extra, pizza_chica_extra, pizza_grande_extra,pizza_mediana_extra,pizza_extra_grande_extra;
    EditText id_produccion_panblanco,nombre_usuario,apellido_usuario,cant_bolillo,cant_bolillo_chico,cant_bolillo_mignon,cant_pan_acimo,cant_pambazo,cant_pambazo_grande;
    SQLiteDatabase baseDatos = null;
    EditText cant_telera,cant_telera_grande,bola_leche, cuernito_estandar, cuernito_chico, cuernito_grande, pan_dulce_estandar, pan_dulce_chico, dona_especial, dona_sencillo, acambareno_grande, concha_grande, tortuga_grande, pastel, merengue_estandar, merengue_cafe_chico, merengue_chico, pasta_hojaldra,reposteria_1, reposteria_2, reposteria_3, reposteria_4, reposteria_5, hamburguesa_estandar, hamburguesa_chica, pizza_estandar, pizza_chica, pizza_grande,pizza_mediana,pizza_extra_grande;
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
    TextView fecha_actual,hora_actual;
    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    // Session Manager Class
    Administrador_sesion session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_produccion_pandulce);
        session = new Administrador_sesion(getApplicationContext());
        Intent a = getIntent();
        position = a.getStringExtra("Position");
        id_produccion_e = a.getStringExtra("Id_produccion");
        nombre_e = a.getStringExtra("Nombre");
        apellido_e = a.getStringExtra("Apellido");
        fecha_e = a.getStringExtra("Fecha_Inicial");
        hora_e = a.getStringExtra("Hora_Inicial");
        cant_bolillo_extra = a.getStringExtra("Cant_bolillo_modificar");
        cant_bolillo_chico_extra = a.getStringExtra("Cant_bolillo_chico_modificar");
        cant_bolillo_mignon_extra = a.getStringExtra("Cant_bolillo_mignon_modificar");
        cant_pan_acimo_extra = a.getStringExtra("Cant_pan_acimo_modificar");
        cant_pambazo_extra = a.getStringExtra("Cant_pambazo_modificar");
        cant_pambazo_grande_extra = a.getStringExtra("Cant_pambazo_grande_modificar");
        cant_telera_extra = a.getStringExtra("Cant_telera");
        cant_telera_grande_extra = a.getStringExtra("Cant_telera_grande");
        bola_leche_extra = a.getStringExtra("Cant_bola_leche");
        cuernito_estandar_extra= a.getStringExtra("Cant_cuernito_estandar");
        cuernito_chico_extra = a.getStringExtra("Cant_cuernito_chico");
        cuernito_grande_extra = a.getStringExtra("Cant_cuernito_grande");
        pan_dulce_estandar_extra = a.getStringExtra("Cant_pan_dulce_estandar");
        pan_dulce_chico_extra = a.getStringExtra("Cant_pan_dulce_chico");
        dona_especial_extra = a.getStringExtra("Cant_dona_especial");
        dona_sencillo_extra = a.getStringExtra("Cant_dona_sencilla");
        acambareno_grande_extra = a.getStringExtra("Cant_acambareno_grande");
        concha_grande_extra = a.getStringExtra("Cant_concha_grande");
        tortuga_grande_extra = a.getStringExtra("Can_tortuga");
        pastel_extra = a.getStringExtra("Can_pastel");
        merengue_estandar_extra = a.getStringExtra("Cant_merengue_estandar");
        merengue_cafe_chico_extra = a.getStringExtra("Cant_merengue_cafe_chico");
        merengue_chico_extra = a.getStringExtra("Cant_merengue_chico");
        pasta_hojaldra_extra = a.getStringExtra("Cant_pasta_hojaldra");
        reposteria_1_extra = a.getStringExtra("Cant_resposteria_1");
        reposteria_2_extra = a.getStringExtra("Cant_resposteria_2");
        reposteria_3_extra = a.getStringExtra("Cant_resposteria_3");
        reposteria_4_extra = a.getStringExtra("Cant_resposteria_4");
        reposteria_5_extra = a.getStringExtra("Cant_resposteria_5");
        hamburguesa_estandar_extra = a.getStringExtra("Cant_hamburguesa_estandar");
        hamburguesa_chica_extra = a.getStringExtra("Cant_hamburguesa_chica");
        pizza_estandar_extra=a.getStringExtra("Cant_pizza_estandar");
        pizza_chica_extra=a.getStringExtra("Cant_pizza_chica");
        pizza_grande_extra =a.getStringExtra("Cant_pizza_grande");
        pizza_mediana_extra = a.getStringExtra("Cant_pizza_mediana");
        pizza_extra_grande_extra = a.getStringExtra("Cant_pizza_extra_grande");

        //id_produccion_panblanco =(EditText) findViewById(R.id.id_produccion_pb_m);
        fecha_actual = (TextView) findViewById(R.id.fecha_m);
        hora_actual =(TextView) findViewById(R.id.hora_m);
        //nombre_usuario =(EditText) findViewById(R.id.nombre_usuario_m);
        //apellido_usuario = (EditText) findViewById(R.id.apellido_usuario_m);
        cant_bolillo = (EditText) findViewById(R.id.cant_bolillo_m);
        cant_bolillo_chico = (EditText) findViewById(R.id.cant_bolillo_chico_m);
        cant_bolillo_mignon = (EditText) findViewById(R.id.cant_bolillo_mignon_m);
        cant_pan_acimo = (EditText) findViewById(R.id.cant_pan_acimo_m);
        cant_pambazo = (EditText) findViewById(R.id.cant_pambazo_m);
        cant_pambazo_grande = (EditText) findViewById(R.id.cant_pambazo_grande_m);
        cant_telera = (EditText) findViewById(R.id.cant_telera_m);
        cant_telera_grande =(EditText) findViewById(R.id.cant_telera_grande_m);
        bola_leche =(EditText) findViewById(R.id.bola_leche_m);
        cuernito_estandar  = (EditText) findViewById(R.id.cuernito_estandar_m);
        cuernito_chico = (EditText) findViewById(R.id.cuernito_chico_m);
        cuernito_grande =(EditText) findViewById(R.id.cuernito_grande_m);
        pan_dulce_estandar =(EditText) findViewById(R.id.pan_dulce_estandar_m);
        pan_dulce_chico =(EditText) findViewById(R.id.pan_dulce_chico_m);
        dona_especial =(EditText) findViewById(R.id.dona_especial_m);
        dona_sencillo =(EditText) findViewById(R.id.dona_sencilla_m);
        acambareno_grande =(EditText) findViewById(R.id.acambarero_grande_m);
        concha_grande =(EditText) findViewById(R.id.concha_grande_m);
        tortuga_grande = (EditText) findViewById(R.id.tortuga_grande_m);
        pastel=(EditText) findViewById(R.id.pastel_m);
        merengue_estandar=(EditText) findViewById(R.id.merengue_estandar_m);
        merengue_cafe_chico =(EditText) findViewById(R.id.merengue_cafe_chico_m);
        merengue_chico =(EditText) findViewById(R.id.merengue_chico_m);
        pasta_hojaldra =(EditText) findViewById(R.id.pasta_hojaldra_m);
        reposteria_1=(EditText) findViewById(R.id.reposteria_1_m);
        reposteria_2=(EditText) findViewById(R.id.reposteria_2_m);
        reposteria_3=(EditText) findViewById(R.id.reposteria_3_m);
        reposteria_4=(EditText) findViewById(R.id.reposteria_4_m);
        reposteria_5=(EditText) findViewById(R.id.reposteria_5_m);
        hamburguesa_estandar =(EditText) findViewById(R.id.hamburguesa_estandar_m);
        hamburguesa_chica =(EditText) findViewById(R.id.hamburguesa_chica_m);
        pizza_estandar =(EditText) findViewById(R.id.pizza_mini_m);
        pizza_chica =(EditText) findViewById(R.id.pizza_chica_m);
        pizza_grande =(EditText) findViewById(R.id.pizza_grande_m);
        pizza_mediana =(EditText) findViewById(R.id.pizza_mediana_m);
        pizza_extra_grande= (EditText) findViewById(R.id.pizza_extra_grande_m);


        cancelar = (Button) findViewById(R.id.cancelar);



        r = new RefreshClock();
        iniReloj= new Thread(r);
        iniReloj.start();


        final Calendar c = Calendar.getInstance();
        final SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy", new Locale("es"));
        fecha_actual_a = formato.format(c.getTime());

        fecha_actual.setText(""+fecha_actual_a+"");
        //nombre_usuario.setText(""+nombre_e);
        //apellido_usuario.setText(""+apellido_e);
        cant_bolillo.setText(""+cant_bolillo_extra);
        cant_bolillo_chico.setText(""+cant_bolillo_chico_extra);
        cant_bolillo_mignon.setText(""+cant_bolillo_mignon_extra);
        cant_pan_acimo.setText(""+cant_pan_acimo_extra);
        cant_pambazo.setText(""+cant_pambazo_extra);
        cant_pambazo_grande.setText(""+cant_pambazo_grande_extra);
        cant_telera.setText(""+cant_telera_extra);
        cant_telera_grande.setText(""+cant_telera_grande_extra);
        bola_leche.setText(""+bola_leche_extra);
        cuernito_estandar.setText(""+cuernito_estandar_extra);
        cuernito_chico.setText(""+cuernito_chico_extra);
        cuernito_grande.setText(""+cuernito_grande_extra);
        pan_dulce_estandar.setText(""+pan_dulce_estandar_extra);
        pan_dulce_chico.setText(""+pan_dulce_chico_extra);
        dona_especial.setText(""+dona_especial_extra);
        dona_sencillo.setText(""+dona_sencillo_extra);
        acambareno_grande.setText(""+acambareno_grande_extra);
        concha_grande.setText(""+concha_grande_extra);
        tortuga_grande.setText(""+tortuga_grande_extra);
        pastel.setText(""+pastel_extra);
        merengue_estandar.setText(""+merengue_estandar_extra);
        merengue_cafe_chico.setText(""+merengue_cafe_chico_extra);
        merengue_chico.setText(""+merengue_chico_extra);
        pasta_hojaldra.setText(""+pasta_hojaldra_extra);
        reposteria_1.setText(""+reposteria_1_extra);
        reposteria_2.setText(""+reposteria_2_extra);
        reposteria_3.setText(""+reposteria_3_extra);
        reposteria_4.setText(""+reposteria_4_extra);
        reposteria_5.setText(""+reposteria_5_extra);
        hamburguesa_estandar.setText(""+hamburguesa_estandar_extra);
        hamburguesa_chica.setText(""+hamburguesa_chica_extra);
        pizza_estandar.setText(""+pizza_estandar_extra);
        pizza_chica.setText(""+pizza_chica_extra);
        pizza_grande.setText(""+pizza_grande_extra);
        pizza_mediana.setText(""+pizza_mediana_extra);
        pizza_extra_grande.setText(""+pizza_extra_grande_extra);





        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Modificar_produccion_pandulce.this, Produccion_pandulce.class);
                Modificar_produccion_pandulce.this.startActivity(i);
            }
        });
    }

    public void modificar (View view){



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
                String ed_cant_bolillo = cant_bolillo.getText().toString();
                String ed_cant_bolillo_chico = cant_bolillo_chico.getText().toString();
                String ed_cant_bolillo_mignon = cant_bolillo_mignon.getText().toString();
                String ed_cant_pan_acimo = cant_pan_acimo.getText().toString();
                String ed_cant_pambazo = cant_pambazo.getText().toString();
                String ed_cant_pambazo_grande = cant_pambazo_grande.getText().toString();
                String ed_cant_telera = cant_telera.getText().toString();
                String ed_cant_telera_grande = cant_telera_grande.getText().toString();
                String ed_bola_leche = bola_leche.getText().toString();
                String ed_cuernito_estandar = cuernito_estandar.getText().toString();
                String ed_cuernito_chico = cuernito_estandar.getText().toString();
                String ed_cuernito_grande = cuernito_grande.getText().toString();
                String ed_pan_dulce_estandar = pan_dulce_estandar.getText().toString();
                String ed_pan_dulce_chico = pan_dulce_chico.getText().toString();
                String ed_dona_especial = dona_especial.getText().toString();
                String ed_dona_sencillo = dona_sencillo.getText().toString();
                String ed_acambareno_grande = acambareno_grande.getText().toString();
                String ed_concha_grande = concha_grande.getText().toString();
                String ed_tortuga_grande = tortuga_grande.getText().toString();
                String ed_pastel= pastel.getText().toString();
                String ed_merengue_estandar= merengue_estandar.getText().toString();
                String ed_merengue_cafe_chico= merengue_cafe_chico.getText().toString();
                String ed_merengue_chico = merengue_chico.getText().toString();
                String ed_pasta_hojaldra = pasta_hojaldra.getText().toString();
                String ed_reposteria_1 = reposteria_1.getText().toString();
                String ed_reposteria_2 = reposteria_2.getText().toString();
                String ed_reposteria_3 = reposteria_3.getText().toString();
                String ed_reposteria_4 = reposteria_4.getText().toString();
                String ed_reposteria_5 = reposteria_5.getText().toString();
                String ed_hamburguesa_estandar =hamburguesa_estandar.getText().toString();
                String ed_hamburguesa_chica = hamburguesa_chica.getText().toString();
                String ed_pizza_estandar = pizza_estandar.getText().toString();
                String ed_pizza_chica = pizza_chica.getText().toString();
                String ed_pizza_grande = pizza_grande.getText().toString();
                String ed_pizza_mediana = pizza_mediana.getText().toString();
                String ed_pizza_extra_grande = pizza_extra_grande.getText().toString();

                String sql1 = ("Update  Produccion_total set hora = '" + ed_hora_s + "', fecha ='" + ed_fecha_s + "', cant_bolillo = '" + ed_cant_bolillo + "' , cant_bolillo_chico ='" + ed_cant_bolillo_chico + "', cant_bolillo_mignon = '" + ed_cant_bolillo_mignon + "', cant_pan_acimo = '" + ed_cant_pan_acimo + "',cant_pambazo = '" + ed_cant_pambazo + "',cant_pambazo_grande = '" + ed_cant_pambazo_grande + "',cant_telera='"+ed_cant_telera+"', cant_telera_grande='"+ed_cant_telera_grande+"', bola_leche='"+ed_bola_leche+"', cuernito_estandar='"+ed_cuernito_estandar+"', cuernito_chico='"+ed_cuernito_chico+"', cuernito_grande='"+ed_cuernito_grande+"', pan_dulce_estandar='"+ed_pan_dulce_estandar+"', pan_dulce_chico='"+ed_pan_dulce_chico+"', dona_especial='"+ed_dona_especial+"', dona_sencillo='"+ed_dona_sencillo+"', acambareno_grande = '"+ed_acambareno_grande+"', concha_grande='"+ed_concha_grande+"', tortuga_grande='"+ed_tortuga_grande+"', pastel='"+ed_pastel+"', merengue_estandar='"+ed_merengue_estandar+"', merengue_cafe_chico='"+ed_merengue_cafe_chico+"', merengue_chico='"+ed_merengue_chico+"', pasta_hojaldra='"+ed_pasta_hojaldra+"',reposteria_1='"+ed_reposteria_1+"', reposteria_2='"+ed_reposteria_2+"',reposteria_3='"+ed_reposteria_3+"',reposteria_4='"+ed_reposteria_4+"',reposteria_5='"+ed_reposteria_5+"', hamburguesa_estandar='"+ed_hamburguesa_estandar+"', hamburguesa_chica='"+ed_hamburguesa_chica+"' ,pizza_mini='"+ed_pizza_estandar+"', pizza_chica='"+ed_pizza_chica+"', pizza_grande='"+ed_pizza_grande+"',pizza_mediana='"+ed_pizza_mediana+"',pizza_extra_grande='"+ed_pizza_extra_grande+"' where id_produccion_total =" + position);
                baseDatos.execSQL(sql1);
                Toast.makeText(this, "Actualizado", Toast.LENGTH_SHORT).show();
                Intent regresar = new Intent(Modificar_produccion_pandulce.this, Produccion_panblanco.class);
                startActivity(regresar);
            }
            else{
                Toast.makeText(this,"Ya no puedes Modificar",Toast.LENGTH_SHORT).show();
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
