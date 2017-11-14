package android.alberto.app.lipangomovil;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Consultar_revision extends ListActivity {
SQLiteDatabase baseDatos = null;
    Cursor fila = null;
    Cursor fila2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_revision);
        //setListAdapter(new Adaptador_consulta_revision(this));
        setListAdapter(new Adaptador_turnos(this));
        Button Regresar = (Button) findViewById(R.id.Regresar_menu);
        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m =new Intent(Consultar_revision.this, Produccion.class);
                Consultar_revision.this.startActivity(m);
            }
        });

    }
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);
        Object o = getListAdapter().getItem(position);
        Toast.makeText(this, "Seleccion: " + Integer.toString(position) + " - " + o.toString(), Toast.LENGTH_SHORT).show();
        position = position + 1;

        baseDatos = this.openOrCreateDatabase("LipanDb", MODE_PRIVATE, null);
        fila = baseDatos.rawQuery("select cant_bolillo, cant_bolillo_chico, cant_bolillo_mignon, cant_pan_acimo, cant_pambazo, cant_pambazo_grande,cant_telera,cant_telera_grande,bola_leche, cuernito_estandar, cuernito_chico, cuernito_grande, pan_dulce_estandar, pan_dulce_chico, dona_especial, dona_sencillo, acambareno_grande, concha_grande, tortuga_grande, pastel, merengue_estandar, merengue_cafe_chico, merengue_chico, pasta_hojaldra,reposteria_1, reposteria_2, reposteria_3, reposteria_4, reposteria_5, hamburguesa_estandar, hamburguesa_chica, pizza_mini, pizza_chica, pizza_grande,pizza_mediana,pizza_extra_grande, fecha, hora,nombre_usuario,apellido_usuario from Produccion_total where id_produccion_total = '" + position + "' ", null);
        if (fila.moveToFirst()) {
            String cant_bolillo = fila.getString(0);
            String cant_bolillo_chico = fila.getString(1);
            String cant_bolillo_mignon = fila.getString(2);
            String cant_pan_acimo = fila.getString(3);
            String cant_pambazo = fila.getString(4);
            String cant_pambazo_grande = fila.getString(5);
            String cant_telera = fila.getString(6);
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
            String tortuga_grande = fila.getString(18);
            String pastel = fila.getString(19);
            String merengue_estandar = fila.getString(20);
            String merengue_cafe_chico = fila.getString(21);
            String merengue_chico = fila.getString(22);
            String pasta_hojaldra = fila.getString(23);
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
            String nombre_usuario_s = fila.getString(38);
            String apellido_usuario_s = fila.getString(39);

            fila2 = baseDatos.rawQuery("SELECT  harina_guadalupe_azul,  harina_guadalupe_roja,  harina_centenario,  harina_indistinta,  azucar_refinada_siglo_xxi,  azucar_estandar_central_m,  pasta_pastel_dawn,  coco_rayado, almidon_imsa,  maicena,  manteca_flor_jalisco,  margarina_san_antonio,  margarina_utarella, relleno_fresa_san_antonio,  cobertura_chocolate_garfias,  polvo_para_hornear_puratos,  huevo,  sal_de_mar,  leche,  tupan_puratos,  royal_tupan_puratos,  chocolate_ganeche,  piloncillo FROM Materiales_add WHERE id_material_add = '" + position + "' ", null);
            if (fila2.moveToFirst()) {
                String harina_guadalupe_azul = fila2.getString(0);
                String harina_guadalupe_roja = fila2.getString(1);
                String harina_centenario = fila2.getString(2);
                String harina_indistinta = fila2.getString(3);
                String azucar_refinada_siglo_xxi = fila2.getString(4);
                String azucar_estandar_central_m = fila2.getString(5);
                String pasta_pastel_dawn = fila2.getString(6);
                String coco_rayado = fila2.getString(7);
                String almidon_imsa = fila2.getString(8);
                String maicena = fila2.getString(9);
                String manteca_flor_jalisco = fila2.getString(10);
                String margarina_san_antonio = fila2.getString(11);
                String margarina_utarella = fila2.getString(12);
                String relleno_fresa_san_antonio = fila2.getString(13);
                String cobertura_chocolate_garfias = fila2.getString(14);
                String polvo_para_hornear_puratos = fila2.getString(15);
                String huevo = fila2.getString(16);
                String sal_de_mar = fila2.getString(17);
                String leche = fila2.getString(18);
                String tupan_puratos = fila2.getString(19);
                String royal_tupan_puratos = fila2.getString(20);
                String chocolate_ganeche = fila2.getString(21);
                String piloncillo = fila2.getString(22);


                Intent i = new Intent(Consultar_revision.this, Detalle_produccion.class);


                i.putExtra("Position", position + "");
                //i.putExtra("Id_produccion", id_produccion);
                //i.putExtra("Nombre", nombre + "");
                //i.putExtra("Apellido", apellido + "");
                i.putExtra("Cant_bolillo_modificar", cant_bolillo + "");
                i.putExtra("Cant_bolillo_chico_modificar", cant_bolillo_chico + "");
                i.putExtra("Cant_bolillo_mignon_modificar", cant_bolillo_mignon + "");
                i.putExtra("Cant_pan_acimo_modificar", cant_pan_acimo + "");
                i.putExtra("Cant_pambazo_modificar", cant_pambazo + "");
                i.putExtra("Cant_pambazo_grande_modificar", cant_pambazo_grande + "");
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
                i.putExtra("Nombre_usuario",nombre_usuario_s+"");
                i.putExtra("Apellido_usuario",apellido_usuario_s+"");
                i.putExtra("Fecha_Inicial", fecha_s + "");
                i.putExtra("Hora_Inicial", hora_s + "");


                //MATERIALES
                i.putExtra("Harina_azul", harina_guadalupe_azul  + "");
                i.putExtra("Harina_roja", harina_guadalupe_roja + "");
                i.putExtra("Harina_centenario", harina_centenario + "");
                i.putExtra("Harina_indistinta", harina_indistinta + "");
                i.putExtra("Azucar_refinada", azucar_refinada_siglo_xxi + "");
                i.putExtra("Azucar_estandar", azucar_estandar_central_m+ "");
                i.putExtra("Pasta_dawn", pasta_pastel_dawn+ "");
                i.putExtra("Coco_rayado", coco_rayado+ "");
                i.putExtra("Almidon_imsa",almidon_imsa + "");
                i.putExtra("Maicena", maicena+ "");
                i.putExtra("Manteca", manteca_flor_jalisco+ "");
                i.putExtra("Margarina_san_antonio", margarina_san_antonio+ "");
                i.putExtra("Margarina_utarella", margarina_utarella + "");
                i.putExtra("Relleno_fresa", relleno_fresa_san_antonio+ "");
                i.putExtra("Cobertura", cobertura_chocolate_garfias+ "");
                i.putExtra("Polvo_puratos", polvo_para_hornear_puratos+ "");
                i.putExtra("Huevo", huevo+ "");
                i.putExtra("Sal", sal_de_mar+ "");
                i.putExtra("Leche", leche+ "");
                i.putExtra("Tupan", tupan_puratos+ "");
                i.putExtra("Royal", royal_tupan_puratos+ "");
                i.putExtra("Chocolate_ganache", chocolate_ganeche+ "");
                i.putExtra("Piloncillo", piloncillo+ "");


                startActivityForResult(i, 3);

            } else {
                Toast.makeText(this, "No hay un registro de produccion para este turno. ", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "No hay un registro de produccion para este turno. ", Toast.LENGTH_SHORT).show();
        }
        }

}
