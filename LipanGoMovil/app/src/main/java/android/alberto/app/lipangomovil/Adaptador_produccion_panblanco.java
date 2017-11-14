package android.alberto.app.lipangomovil;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by AlBeRtO on 03/04/2017.
 */

public class Adaptador_produccion_panblanco extends BaseAdapter {
ArrayList<Productos_panblanco> lista_produccion_panblanco = null;

    SQLiteDatabase baseDatos = null;
    Cursor cursor = null;

    Activity actividad;

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override
    public int getCount() {
        return lista_produccion_panblanco.size();
    }

    @Override
    public Object getItem(int position) {
        return lista_produccion_panblanco.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.reglon_produccion_pb,null,true);

        TextView id_produccion_panblanco =(TextView) view.findViewById(R.id.id_produccion_pb);
        TextView fecha =(TextView) view.findViewById(R.id.fecha_adaptador);
        TextView hora =(TextView) view.findViewById(R.id.hora_adaptador);
        TextView nombre_usuario =(TextView) view.findViewById(R.id.nombre_usuario);
        TextView apellido_usuario = (TextView) view.findViewById(R.id.apellido_usuario);
        TextView cant_bolillo = (TextView) view.findViewById(R.id.cant_bolillo);
        TextView cant_bolillo_chico = (TextView) view.findViewById(R.id.cant_bolillo_chico);
        TextView cant_bolillo_mignon = (TextView) view.findViewById(R.id.cant_bolillo_mignon);
        TextView cant_pan_acimo = (TextView) view.findViewById(R.id.cant_pan_acimo);
        TextView cant_pambazo = (TextView) view.findViewById(R.id.cant_pambazo);
        TextView cant_pambazo_grande = (TextView) view.findViewById(R.id.cant_pambazo_grande);
        TextView cant_telera = (TextView) view.findViewById(R.id.cant_telera_a);
        TextView cant_telera_grande =(TextView)view.findViewById(R.id.cant_telera_grande_a);
        TextView bola_leche =(TextView) view.findViewById(R.id.bola_leche_a);
        TextView cuernito_estandar=(TextView) view.findViewById(R.id.cuernito_estandar_a);
        TextView cuernito_chico =(TextView) view.findViewById(R.id.cuernito_chico_a);
        TextView cuernito_grande = (TextView) view.findViewById(R.id.cuernito_grande_a);
        TextView pan_dulce_estandar= (TextView) view.findViewById(R.id.pan_dulce_estandar_a);
        TextView pan_dulce_chico = (TextView) view.findViewById(R.id.pan_dulce_chico_a);
        TextView dona_especial = (TextView) view.findViewById(R.id.dona_especial_a);
        TextView dona_sencillo = (TextView) view.findViewById(R.id.dona_sencillo_a);
        TextView acambareno_grande = (TextView) view.findViewById(R.id.acambareno_grande_a);
        TextView concha_grande = (TextView) view.findViewById(R.id.concha_grande_a);
        TextView tortuga_grande = (TextView) view.findViewById(R.id.tortuga_grande_a);
        TextView pastel = (TextView) view.findViewById(R.id.pastel_a);
        TextView merengue_estandar = (TextView) view.findViewById(R.id.merengue_estandar_a);
        TextView merengue_cafe_chico = (TextView) view.findViewById(R.id.merengue_cafe_chico_a);
        TextView merengue_chico = (TextView) view.findViewById(R.id.merengue_chico_a);
        TextView pasta_hojaldra = (TextView) view.findViewById(R.id.pasta_hojaldra_a);
        TextView reposteria_1 = (TextView) view.findViewById(R.id.reposteria_1_a);
        TextView reposteria_2 = (TextView) view.findViewById(R.id.reposteria_2_a);
        TextView reposteria_3 = (TextView) view.findViewById(R.id.reposteria_3_a);
        TextView reposteria_4 = (TextView) view.findViewById(R.id.reposteria_4_a);
        TextView reposteria_5 = (TextView) view.findViewById(R.id.reposteria_5_a);
        TextView hamburguesa_estandar = (TextView) view.findViewById(R.id.hamburguesa_estandar_a);
        TextView hamburguesa_chica = (TextView) view.findViewById(R.id.hamburguesa_chica_a);
        TextView pizza_mini = (TextView) view.findViewById(R.id.pizza_mini_a);
        TextView pizza_chica = (TextView) view.findViewById(R.id.pizza_chica_a);
        TextView pizza_grande = (TextView) view.findViewById(R.id.pizza_grande_a);
        TextView pizza_mediana = (TextView) view.findViewById(R.id.pizza_mediana_a);
        TextView pizza_extra_grande = (TextView) view.findViewById(R.id.pizza_extra_grande_a);

        Productos_panblanco productos_panblanco = lista_produccion_panblanco.get(position);
        id_produccion_panblanco.setText("Id_produccion :------------ "+ productos_panblanco.getId_produccion_panblanco());
        fecha.setText("Fecha :------------ "+productos_panblanco.getFecha());
        hora.setText("Hora :============ "+productos_panblanco.getHora());
        nombre_usuario.setText("Nombre :============ "+productos_panblanco.getNombre_usuario());
        apellido_usuario.setText("Apellido :========== "+productos_panblanco.getApellido_usuario());
        cant_bolillo.setText("Cantidad de bolillo :========== "+productos_panblanco.getCant_bolillo());
        cant_bolillo_chico.setText("Cantidad de Bolillo Chico :========= "+productos_panblanco.getCant_bolillo_chico());
        cant_bolillo_mignon.setText("Cantiddad de Bolillo grande :==== "+productos_panblanco.getCant_bolillo_mignon());
        cant_pan_acimo.setText("Cantidad de Pan Acimo :====== "+productos_panblanco.getCant_pan_acimo());
        cant_pambazo.setText("Cantidad de Pambazo :======= "+productos_panblanco.getCant_pambazo());
        cant_pambazo_grande.setText("Cantidad de Pambazo Grande :====== "+productos_panblanco.getCant_pambazo_grande());
        cant_telera.setText("Piezas de Telere: ========= "+productos_panblanco.getCant_telera());
        cant_telera_grande.setText("Piezas de Telera Grande: ========= "+productos_panblanco.getCant_telera_grande());
        bola_leche.setText("Piezas de Bola Leche:=========="+productos_panblanco.getBola_leche());
        cuernito_estandar.setText("Piezas Cuernito Estandar: =========== "+productos_panblanco.getCuernito_estandar());
        cuernito_chico.setText("Piezas de Cuernito Chico: =========== "+productos_panblanco.getCuernito_chico());
        cuernito_grande.setText("Piezas de Cuernito Grande:======== "+productos_panblanco.getCuernito_grande());
        pan_dulce_estandar.setText("Piezas de Pan Dulce Estandar:===== "+productos_panblanco.getPan_dulce_estandar());
        pan_dulce_chico.setText("Piezas de Pan Dulce Chico:====== "+productos_panblanco.getPan_dulce_chico());
        dona_especial.setText("Piezas Dona especial:====== "+productos_panblanco.getDona_especial());
        dona_sencillo.setText("Piezas Dona sencilla:===== "+productos_panblanco.getDona_sencillo());
        acambareno_grande.setText("Piezas Acambareno: ===== "+productos_panblanco.getAcambareno_grande());
        concha_grande.setText("Piezas Concha Grande: ===== "+productos_panblanco.getConcha_grande());
        tortuga_grande.setText("Piezas Tortuga Grande: ====== "+productos_panblanco.getTortuga_grande());
        pastel.setText("Kilogramos de Paste pastel:===="+productos_panblanco.getPastel());
        merengue_estandar.setText("Piezas Merengue Estandar:======"+productos_panblanco.getMerengue_estandar());
        merengue_cafe_chico.setText("Piezas Mererengue Cafe Chico: ===== "+productos_panblanco.getMerengue_cafe_chico());
        merengue_chico.setText("Piezas Merengue Chico: ==== "+productos_panblanco.getMerengue_chico());
        pasta_hojaldra.setText("Piezas Pasta Hojaldra: ======== "+productos_panblanco.getPasta_hojaldra());
        reposteria_1.setText("Piezas reposteria 1: ====== "+productos_panblanco.getReposteria_1());
        reposteria_2.setText("Piezas reposteria 2: ====== "+productos_panblanco.getReposteria_2());
        reposteria_3.setText("Piezas reposteria 3: ====== "+productos_panblanco.getReposteria_3());
        reposteria_4.setText("Piezas reposteria 4: ====== "+productos_panblanco.getReposteria_4());
        reposteria_5.setText("Piezas reposteria 5: ====== "+productos_panblanco.getReposteria_5());
        hamburguesa_estandar.setText("Piezas Hamburguesa Estandar: ===== "+productos_panblanco.getHamburguesa_estandar());
        hamburguesa_chica.setText("Piezas Hamburguesa Chica: ===== "+productos_panblanco.getHamburguesa_chica());
        pizza_mini.setText("Piezas Pizza Mini: ======="+productos_panblanco.getPizza_estadar());
        pizza_chica.setText("Piezas Pizza Chica: ======="+productos_panblanco.getPizza_chica());
        pizza_grande.setText("Piezas Pizza Grande: ======="+productos_panblanco.getPizza_grande());
        pizza_mediana.setText("Piezas Pizza Mediana: ======="+productos_panblanco.getPizza_mediana());
        pizza_extra_grande.setText("Piezas Pizza Mediana: ======="+productos_panblanco.getPizza_extra_grande());

        return view;
    }


    public Adaptador_produccion_panblanco(Activity actividad) {
        this.actividad = actividad;
        baseDatos = actividad.openOrCreateDatabase("LipanDb", actividad.MODE_PRIVATE, null);
        String Tabla_produccion_panblanco ="CREATE TABLE IF NOT EXISTS Produccion_total(id_produccion_total INTEGER PRIMARY KEY AUTOINCREMENT, fecha DATETIME DEFAULT CURRENT_TIMESTAMP, hora DATETIME DAFAULT CURRENT_TIMESTAMP, nombre_usuario TEXT, apellido_usuario TEXT, cant_bolillo INTEGER, cant_bolillo_chico INTEGER, cant_bolillo_mignon INTEGER, cant_pan_acimo INTEGER, cant_pambazo INTEGER, cant_pambazo_grande INTEGER,cant_telera INTEGER,cant_telera_grande INTEGER,bola_leche INTEGER, cuernito_estandar INTEGER, cuernito_chico INTEGER, cuernito_grande INTEGER, pan_dulce_estandar INTEGER, pan_dulce_chico INTEGER, dona_especial INTEGER, dona_sencillo INTEGER, acambareno_grande INTEGER, concha_grande INTEGER, tortuga_grande INTEGER, pastel INTEGER, merengue_estandar INTEGER, merengue_cafe_chico INTEGER, merengue_chico INTEGER, pasta_hojaldra INTEGER,reposteria_1 INTEGER, reposteria_2 INTEGER, reposteria_3 INTEGER, reposteria_4 INTEGER, reposteria_5 INTEGER, hamburguesa_estandar INTEGER, hamburguesa_chica INTEGER, pizza_mini INTEGER, pizza_chica INTEGER, pizza_grande INTEGER, pizza_mediana INTEGER, pizza_extra_grande INTEGER)";
        baseDatos.execSQL(Tabla_produccion_panblanco);

        String sql = "SELECT * FROM Produccion_total";
        cursor = baseDatos.rawQuery(sql,null);
        int renglones = cursor.getCount();

        cursor.moveToFirst();
        lista_produccion_panblanco= new ArrayList<Productos_panblanco>();
        for (int i = 0; i<renglones; i++){
            final int  id_produccion_panblanco = cursor.getInt(0);
            String fecha = cursor.getString(1);
            String hora = cursor.getString(2);
            String nombre_usuario = cursor.getString(3);
            String apellido_usuario = cursor.getString(4);
            final int cant_bolillo = cursor.getInt(5);
            final int cant_bolillo_chico = cursor.getInt(6);
            final int cant_bolillo_mignon = cursor.getInt(7);
            final int cant_pan_acimo = cursor.getInt(8);
            final int cant_pambazo = cursor.getInt(9);
            final int cant_pambazo_grande = cursor.getInt(10);
            final int cant_telera=cursor.getInt(11);
            final int cant_telera_grande = cursor.getInt(12);
            final int bola_leche = cursor.getInt(13);
            final int cuernito_estandar = cursor.getInt(14);
            final int cuernito_chico = cursor.getInt(15);
            final int cuernito_grande = cursor.getInt(16);
            final int pan_dulce_estandar = cursor.getInt(17);
            final int pan_dulce_chico = cursor.getInt(18);
            final int dona_especial = cursor.getInt(19);
            final int dona_sencillo = cursor.getInt(20);
            final int acambareno_grande = cursor.getInt(21);
            final int concha_grande = cursor.getInt(22);
            final int tortuga_grande= cursor.getInt(23);
            final int pastel = cursor.getInt(24);
            final int merengue_estandar = cursor.getInt(25);
            final int merengue_cafe_chico = cursor.getInt(26);
            final int merengue_chico = cursor.getInt(27);
            final int pasta_hojaldra= cursor.getInt(28);
            final int reposteria_1 = cursor.getInt(29);
            final int reposteria_2 = cursor.getInt(30);
            final int reposteria_3 = cursor.getInt(31);
            final int reposteria_4 = cursor.getInt(32);
            final int reposteria_5 = cursor.getInt(33);
            final int hamburguesa_estandar = cursor.getInt(34);
            final int hamburguesa_chica = cursor.getInt(35);
            final int pizza_estadar = cursor.getInt(36);
            final int pizza_chica = cursor.getInt(37);
            final int pizza_grande = cursor.getInt(38);
            final int pizza_mediana = cursor.getInt(39);
            final int pizza_extra_grande = cursor.getInt(40);



            lista_produccion_panblanco.add(new Productos_panblanco(id_produccion_panblanco,fecha,hora,nombre_usuario,apellido_usuario,cant_bolillo,cant_bolillo_chico,cant_bolillo_mignon,cant_pan_acimo,cant_pambazo,cant_pambazo_grande,cant_telera,cant_telera_grande,bola_leche, cuernito_estandar, cuernito_chico, cuernito_grande, pan_dulce_estandar, pan_dulce_chico, dona_especial, dona_sencillo, acambareno_grande, concha_grande, tortuga_grande, pastel, merengue_estandar, merengue_cafe_chico, merengue_chico, pasta_hojaldra,reposteria_1, reposteria_2, reposteria_3, reposteria_4, reposteria_5, hamburguesa_estandar, hamburguesa_chica, pizza_estadar, pizza_chica, pizza_grande,pizza_mediana,pizza_extra_grande)); // me qiuede aqui 3:34 del dia 19
            cursor.moveToNext();
        }

    }
}
