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

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Detalle_produccion extends AppCompatActivity {
    String id_produccion_e,position,nombre_e,apellido_e,fecha_e,hora_e,cant_bolillo_extra,cant_bolillo_chico_extra,cant_bolillo_mignon_extra,cant_pan_acimo_extra,cant_pambazo_extra,cant_pambazo_grande_extra;
    String cant_telera_extra,cant_telera_grande_extra,bola_leche_extra, cuernito_estandar_extra, cuernito_chico_extra, cuernito_grande_extra, pan_dulce_estandar_extra, pan_dulce_chico_extra, dona_especial_extra, dona_sencillo_extra, acambareno_grande_extra, concha_grande_extra, tortuga_grande_extra, pastel_extra, merengue_estandar_extra, merengue_cafe_chico_extra, merengue_chico_extra, pasta_hojaldra_extra,reposteria_1_extra, reposteria_2_extra, reposteria_3_extra, reposteria_4_extra, reposteria_5_extra, hamburguesa_estandar_extra, hamburguesa_chica_extra, pizza_estandar_extra, pizza_chica_extra, pizza_grande_extra,pizza_mediana_extra,pizza_extra_grande_extra;
    TextView id_produccion_panblanco,nombre_usuario,apellido_usuario,cant_bolillo,cant_bolillo_chico,cant_bolillo_mignon,cant_pan_acimo,cant_pambazo,cant_pambazo_grande;
    SQLiteDatabase baseDatos = null;
    TextView cant_telera,cant_telera_grande,bola_leche, cuernito_estandar, cuernito_chico, cuernito_grande, pan_dulce_estandar, pan_dulce_chico, dona_especial, dona_sencillo, acambareno_grande, concha_grande, tortuga_grande, pastel, merengue_estandar, merengue_cafe_chico, merengue_chico, pasta_hojaldra,reposteria_1, reposteria_2, reposteria_3, reposteria_4, reposteria_5, hamburguesa_estandar, hamburguesa_chica, pizza_estandar, pizza_chica, pizza_grande,pizza_mediana,pizza_extra_grande;
    Button cancelar_1;
    TextView fecha_inicial,hora_inicial;
    String nombre_usuario_extra,apellido_extra;
    String  harina_guadalupe_azul_extra, harina_guadalupe_roja_extra,harina_centenario_extra, harina_indistinta_extra,azucar_refinada_siglo_xxi_extra,azucar_estandar_central_m_extra,pasta_pastel_dawn_extra,coco_rayado_extra,almidon_imsa_extra,maicena_extra, manteca_flor_jalisco_extra,margarina_san_antonio_extra,margarina_utarella_extra, relleno_fresa_san_antonio_extra,cobertura_chocolate_garfias_extra,polvo_para_hornear_puratos_extra,huevo_extra,sal_de_mar_extra,leche_extra,tupan_puratos_extra,royal_tupan_puratos_extra,chocolate_ganeche_extra,piloncillo_extra;
    TextView harina_guadalupe_azul, harina_guadalupe_roja,harina_centenario, harina_indistinta,azucar_refinada_siglo_xxi,azucar_estandar_central_m,pasta_pastel_dawn,coco_rayado,almidon_imsa,maicena, manteca_flor_jalisco,margarina_san_antonio,margarina_utarella, relleno_fresa_san_antonio,cobertura_chocolate_garfias,polvo_para_hornear_puratos,huevo,sal_de_mar_,leche_,tupan_puratos,royal_tupan_puratos,chocolate_ganeche,piloncillo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_produccion);
        Intent a = getIntent();
        position = a.getStringExtra("Position");
        id_produccion_e = a.getStringExtra("Id_produccion");
        nombre_usuario_extra = a.getStringExtra("Nombre_usuario");
        apellido_extra= a.getStringExtra("Apellido_usuario");
        //nombre_e = e.getStringExtra("Nombre");
        //apellido_e = e.getStringExtra("Apellido");
                     //Produccion
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



        cancelar_1 = (Button) findViewById(R.id.regresar_consultar);
        nombre_usuario = (TextView) findViewById(R.id.nombre_usuario_detalle);
        //apellido_usuario = (TextView) findViewById(R.id.apellido_usuario_detalle);
        fecha_inicial = (TextView) findViewById(R.id.fecha_inicial_detalle);
        //hora_inicial = (TextView) findViewById(R.id.hora_inicial_detalle);
        cant_bolillo = (TextView) findViewById(R.id.cant_bolillo_detalle);
        cant_bolillo_chico = (TextView) findViewById(R.id.cant_bolillo_chico_detalle);
        cant_bolillo_mignon = (TextView) findViewById(R.id.cant_bolillo_mignon_detalle);
        cant_pan_acimo = (TextView) findViewById(R.id.cant_pan_acimo_detalle);
        cant_pambazo = (TextView) findViewById(R.id.cant_pambazo_detalle);
        cant_pambazo_grande = (TextView) findViewById(R.id.cant_pambazo_grande_detalle);
        cant_telera = (TextView) findViewById(R.id.cant_telera_detalle);
        cant_telera_grande =(TextView) findViewById(R.id.cant_telera_grande_detalle);
        bola_leche =(TextView) findViewById(R.id.bola_leche_detalle);
        cuernito_estandar  = (TextView) findViewById(R.id.cuernito_estandar_detalle);
        cuernito_chico = (TextView) findViewById(R.id.cuernito_chico_detalle);
        cuernito_grande =(TextView) findViewById(R.id.cuernito_grande_detalle);
        pan_dulce_estandar =(TextView) findViewById(R.id.pan_dulce_estandar_detalle);
        pan_dulce_chico =(TextView) findViewById(R.id.pan_dulce_chico_detalle);
        dona_especial =(TextView) findViewById(R.id.dona_especial_detalle);
        dona_sencillo =(TextView) findViewById(R.id.dona_sencilla_detalle);
        acambareno_grande =(TextView) findViewById(R.id.acambarero_grande_detalle);
        concha_grande =(TextView) findViewById(R.id.concha_grande_detalle);
        tortuga_grande = (TextView) findViewById(R.id.tortuga_grande_detalle);
        pastel=(TextView) findViewById(R.id.pastel_detalle);
        merengue_estandar=(TextView) findViewById(R.id.merengue_estandar_detalle);
        merengue_cafe_chico =(TextView) findViewById(R.id.merengue_cafe_chico_detalle);
        merengue_chico =(TextView) findViewById(R.id.merengue_chico_detalle);
        pasta_hojaldra =(TextView) findViewById(R.id.pasta_hojaldra_detalle);
        reposteria_1=(TextView) findViewById(R.id.reposteria_1_detalle);
        reposteria_2=(TextView) findViewById(R.id.reposteria_2_detalle);
        reposteria_3=(TextView) findViewById(R.id.reposteria_3_detalle);
        reposteria_4=(TextView) findViewById(R.id.reposteria_4_detalle);
        reposteria_5=(TextView) findViewById(R.id.reposteria_5_detalle);
        hamburguesa_estandar =(TextView) findViewById(R.id.hamburguesa_estandar_detalle);
        hamburguesa_chica =(TextView) findViewById(R.id.hamburguesa_chica_detalle);
        pizza_estandar =(TextView) findViewById(R.id.pizza_mini_detalle);
        pizza_chica =(TextView) findViewById(R.id.pizza_chica_detalle);
        pizza_grande =(TextView) findViewById(R.id.pizza_grande_detalle);
        pizza_mediana =(TextView) findViewById(R.id.pizza_mediana_detalle);
        pizza_extra_grande= (TextView) findViewById(R.id.pizza_extra_grande_detalle);

                                         //Materiales
        harina_guadalupe_azul_extra = a.getStringExtra("Harina_azul");
        harina_guadalupe_roja_extra = a.getStringExtra("Harina_roja");
        harina_centenario_extra = a.getStringExtra("Harina_centenario");
        harina_indistinta_extra = a.getStringExtra("Harina_indistinta");
        azucar_refinada_siglo_xxi_extra = a.getStringExtra("Azucar_refinada");
        azucar_estandar_central_m_extra = a.getStringExtra("Azucar_estandar");
        pasta_pastel_dawn_extra = a.getStringExtra("Pasta_dawn");
        coco_rayado_extra = a.getStringExtra("Coco_rayado");
        almidon_imsa_extra=a.getStringExtra("Almidon_imsa");
        maicena_extra= a.getStringExtra("Maicena");
        manteca_flor_jalisco_extra =a.getStringExtra("Manteca");
        margarina_san_antonio_extra = a.getStringExtra("Margarina_san_antonio");
        margarina_utarella_extra= a.getStringExtra("Margarina_utarella");
        relleno_fresa_san_antonio_extra= a.getStringExtra("Relleno_fresa");
        cobertura_chocolate_garfias_extra = a.getStringExtra("Cobertura");
        polvo_para_hornear_puratos_extra = a.getStringExtra("Polvo_puratos");
        huevo_extra = a.getStringExtra("Huevo");
        sal_de_mar_extra=a.getStringExtra("Sal");
        leche_extra=a.getStringExtra("Leche");
        tupan_puratos_extra=a.getStringExtra("Tupan");
        royal_tupan_puratos_extra=a.getStringExtra("Royal");
        chocolate_ganeche_extra=a.getStringExtra("Chocolate_ganache");
        piloncillo_extra=a.getStringExtra("Piloncillo");

        harina_guadalupe_azul = (TextView) findViewById(R.id.harina_guadalupe_azul_detalle);
        harina_guadalupe_roja = (TextView) findViewById(R.id.harina_guadalupe_roja_detalle);
        harina_centenario =(TextView) findViewById(R.id.harina_centenario_detalle);
        harina_indistinta = (TextView) findViewById(R.id.harina_indistinta_detalle);
        azucar_refinada_siglo_xxi = (TextView) findViewById(R.id.azucar_refinada_detalle);
        azucar_estandar_central_m = (TextView) findViewById(R.id.azucar_estandar_detalle);
        pasta_pastel_dawn = (TextView) findViewById(R.id.pasta_dawn_detalle);
        coco_rayado =(TextView) findViewById(R.id.coco_rayado_detalle);
        almidon_imsa = (TextView) findViewById(R.id.almidon_imsa_detalle);
        maicena = (TextView) findViewById(R.id.maicena_detalle);
        manteca_flor_jalisco = (TextView) findViewById(R.id.manteca_detalle);
        margarina_san_antonio = (TextView) findViewById(R.id.margarina_san_antonio_detalle);
        margarina_utarella = (TextView) findViewById(R.id.margarina_san_utarella_detalle);
        relleno_fresa_san_antonio =(TextView) findViewById(R.id.relleno_fresa_detalle);
        cobertura_chocolate_garfias = (TextView) findViewById(R.id.cobertura_detalle);
        polvo_para_hornear_puratos =(TextView) findViewById(R.id.polvo_hornear_detalle);
        huevo =(TextView) findViewById(R.id.huevo_detalle);
        sal_de_mar_ = (TextView) findViewById(R.id.sal_detalle);
        leche_ =(TextView) findViewById(R.id.leche_detalle);
        tupan_puratos =(TextView) findViewById(R.id.tupan_detalle);
        royal_tupan_puratos =(TextView) findViewById(R.id.royal_tupan_detalle);
        chocolate_ganeche = (TextView) findViewById(R.id.chocolate_ganache_detalle);
        piloncillo = (TextView) findViewById(R.id.piloncillo_detalle);



        //session.checkLogin();

        // get user data from session
        //HashMap<String, String> user = session.getUserDetails();

        // name
        //final String nombre = user.get(Administrador_sesion.KEY_NOMBRE);

        // email
        //final String apellido = user.get(Administrador_sesion.KEY_APELLIDO);


        nombre_usuario.setText(Html.fromHtml("Nombre: <b>"+nombre_usuario_extra+" "+apellido_extra +"</b>"));
        fecha_inicial.setText(Html.fromHtml("Fecha y hora: <b>"+fecha_e+" - "+hora_e +"</b>"));
        cant_bolillo.setText(Html.fromHtml("Cantidad bolillo <b>"+cant_bolillo_extra+" </b>"));
        cant_bolillo_chico.setText(Html.fromHtml("Cantidad bolillo chico: <b>"+cant_bolillo_chico_extra+"</b> "));
        cant_bolillo_mignon.setText(Html.fromHtml("cantidad bolillo mignon: "+cant_bolillo_mignon_extra+"</b> "));
        cant_pan_acimo.setText(Html.fromHtml("Cantidad pan acimo:"+cant_pan_acimo_extra+"</b> "));
        cant_pambazo.setText(Html.fromHtml("Cantidad  pambazo: <b>"+cant_pambazo_extra+"</b> "));
        cant_pambazo_grande.setText(Html.fromHtml("Cantidad pambazo grande: <b>"+cant_pambazo_grande_extra+"</b>"));
        cant_telera.setText(Html.fromHtml("Cantidad telera: <b>"+cant_telera_extra+"</b>"));
        cant_telera_grande.setText(Html.fromHtml("Cantidad telera grande: <b>"+cant_telera_grande_extra+"</b>"));
        bola_leche.setText(Html.fromHtml("Cantidad bola leche: <b>"+bola_leche_extra+"</b>"));
        cuernito_estandar.setText(Html.fromHtml("Cantidad cuernito estandar: <b>"+cuernito_estandar_extra+"</b>"));
        cuernito_chico.setText(Html.fromHtml("Cantidad cuernito chico: <b>"+cuernito_chico_extra+"</b>"));
        cuernito_grande.setText(Html.fromHtml("Cantidad cuernito grande; <b>"+cuernito_grande_extra+"</b>"));
        pan_dulce_estandar.setText(Html.fromHtml("Cantidad pan dulce estandar: <b>"+pan_dulce_estandar_extra+"</b>"));
        pan_dulce_chico.setText(Html.fromHtml("Cantidade pan dulce chico: <b>"+pan_dulce_chico_extra+"</b>"));
        dona_especial.setText(Html.fromHtml("Cantidad dona especial: <b>"+dona_especial_extra+"</b>"));
        dona_sencillo.setText(Html.fromHtml("Cantidad dona sencilla: <b>"+dona_sencillo_extra+"</b>"));
        acambareno_grande.setText(Html.fromHtml("Cantidad acambarero grande: <b>"+acambareno_grande_extra+"</b>"));
        concha_grande.setText(Html.fromHtml("Cantidad concha grande: <b>"+concha_grande_extra+"</b>"));
        tortuga_grande.setText(Html.fromHtml("Cantidad tortuga grande: <b>"+tortuga_grande_extra+"</b>"));
        pastel.setText(Html.fromHtml("Cantidad pastel: <b>"+pastel_extra+"</b>"));
        merengue_estandar.setText(Html.fromHtml("Cantidad merengue estandar: <b>"+merengue_estandar_extra+"</b>"));
        merengue_cafe_chico.setText(Html.fromHtml("Cantidad merengue cafe chico: <b>"+merengue_cafe_chico_extra+"</b>"));
        merengue_chico.setText(Html.fromHtml("Cantidad merengue chico: <b>"+merengue_chico_extra+"</b>"));
        pasta_hojaldra.setText(Html.fromHtml("Cantidad pasta hojaldra: <b>"+pasta_hojaldra_extra+"</b>"));
        reposteria_1.setText(Html.fromHtml("Cantidad resposteria 1: <b>"+reposteria_1_extra+"</b>"));
        reposteria_2.setText(Html.fromHtml("Cantidad reposteria 2: <b>"+reposteria_2_extra+"</b>"));
        reposteria_3.setText(Html.fromHtml("Cantidad reposteria 3: <b>"+reposteria_3_extra+"</b>"));
        reposteria_4.setText(Html.fromHtml("Cantidad reposteria 4: <b>"+reposteria_4_extra+"</b>"));
        reposteria_5.setText(Html.fromHtml("Cantidad reposteria 5: <b>"+reposteria_5_extra+"</b>"));
        hamburguesa_estandar.setText(Html.fromHtml("Cantidad hamburguesa estandar: <b>"+hamburguesa_estandar_extra+"</b>"));
        hamburguesa_chica.setText(Html.fromHtml("Cantidad hamburguesa chica: <b>"+hamburguesa_chica_extra+"</b>"));
        pizza_estandar.setText(Html.fromHtml("Cantidad pizza estandar: <b>"+pizza_estandar_extra+"</b>"));
        pizza_chica.setText(Html.fromHtml("Cantidad pizza chica: <b>"+pizza_chica_extra+"</b>"));
        pizza_grande.setText(Html.fromHtml("Cantidad pizza grande: <b>"+pizza_grande_extra+"</b>"));
        pizza_mediana.setText(Html.fromHtml("Cantidad pizza mediana: <b>"+pizza_mediana_extra+"</b>"));
        pizza_extra_grande.setText(Html.fromHtml("Cantidad pizza extra grande: <b>"+pizza_extra_grande_extra+"</b>"));

        harina_guadalupe_azul.setText(Html.fromHtml("Cantidad harina gdlpe. azul : <b>"+harina_guadalupe_azul_extra+"</b> Bulto(s)."));
        harina_guadalupe_roja.setText(Html.fromHtml("Cantidad harina gdlpe. roja : <b>"+harina_guadalupe_roja_extra+"</b> Bulto(s)."));
        harina_centenario.setText(Html.fromHtml("Cantidad harina centenario : <b>"+harina_centenario_extra+"</b> Bulto(s)."));
        harina_indistinta.setText(Html.fromHtml("Cantidad harina indistinta : <b>"+harina_indistinta_extra+"</b> Kg."));
        azucar_refinada_siglo_xxi.setText(Html.fromHtml("Cantidad azucar refinada : <b>"+azucar_refinada_siglo_xxi_extra+"</b> Kg."));
        azucar_estandar_central_m.setText(Html.fromHtml("Cantidad estandar : <b>"+azucar_estandar_central_m_extra+"</b> Kg."));
        pasta_pastel_dawn.setText(Html.fromHtml("Cantidad pasta dawn : <b>"+pasta_pastel_dawn_extra+"</b> Kg."));
        coco_rayado.setText(Html.fromHtml("Cantidad coco rayado : <b>"+coco_rayado_extra+"</b> Kg."));
        almidon_imsa.setText(Html.fromHtml("Cantidad almidon imsa : <b>"+almidon_imsa_extra+"</b> Kg."));
        maicena.setText(Html.fromHtml("Cantidad maicena : <b>"+maicena_extra+"</b> Kg."));
        manteca_flor_jalisco.setText(Html.fromHtml("Cantidad manteca flor de jalisco : <b>"+manteca_flor_jalisco_extra+"</b> Kg."));
        margarina_san_antonio.setText(Html.fromHtml("Cantidad margarina san antonio : <b>"+margarina_san_antonio_extra+"</b> Kg."));
        margarina_utarella.setText(Html.fromHtml("Cantidad margarina utarella : <b>"+margarina_utarella_extra+"</b> Kg."));
        relleno_fresa_san_antonio.setText(Html.fromHtml("Cantidad relleno fresa : <b>"+relleno_fresa_san_antonio_extra+"</b> Kg."));
        cobertura_chocolate_garfias.setText(Html.fromHtml("Cantidad cobertura chocolate  : <b>"+cobertura_chocolate_garfias_extra+"</b> Kg."));
        polvo_para_hornear_puratos.setText(Html.fromHtml("Cantidad polvo para hornear  : <b>"+polvo_para_hornear_puratos_extra+"</b> Kg."));
        huevo.setText(Html.fromHtml("Cantidad huevo : <b>"+huevo_extra+"</b> Pieza(s)."));
        sal_de_mar_.setText(Html.fromHtml("Cantidad sal : <b>"+sal_de_mar_extra+"</b> Kg."));
        leche_.setText(Html.fromHtml("Cantidad de leche : <b>"+leche_extra+"</b> Litro(s)"));
        tupan_puratos.setText(Html.fromHtml("Cantidad tupan puratos : <b>"+tupan_puratos_extra+"</b> Kg."));
        royal_tupan_puratos.setText(Html.fromHtml("Cantidad royal  tupan puratos : <b>"+royal_tupan_puratos_extra+"</b> Kg."));
        chocolate_ganeche.setText(Html.fromHtml("Cantidad chocolate ganache : <b>"+chocolate_ganeche_extra+"</b> Kg."));
        piloncillo.setText(Html.fromHtml("Cantidad piloncillo : <b>"+piloncillo_extra+"</b> Kg."));






        cancelar_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Detalle_produccion.this, Consultar_revision.class);
                Detalle_produccion.this.startActivity(i);
            }
        });



    }
}
