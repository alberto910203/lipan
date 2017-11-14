package android.alberto.app.lipangomovil;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AlBeRtO on 29/04/2017.
 */

public class Adaptador_materiales_add extends BaseAdapter {
   ArrayList<Materiales_add> listamateriales = null;
    Activity actividad;
    Cursor cursor = null;
    SQLiteDatabase baseDatos = null;
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getCount() {
        return listamateriales.size();
    }

    @Override
    public Object getItem(int position) {
        return listamateriales.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.renglon_materiales_add,null,true);

        TextView id_materiales_add = (TextView) view.findViewById(R.id.id_materiales_add);
        TextView fecha = (TextView) view.findViewById(R.id.fecha_adaptador_add);
        TextView hora = (TextView) view.findViewById(R.id.hora_adaptador_add);
        TextView nombre_usuario = (TextView) view.findViewById(R.id.nombre_usuario_add);
        TextView apellido_usuario = (TextView) view.findViewById(R.id.apellido_usuario_add);
        TextView harina_azul = (TextView) view.findViewById(R.id.harina_azul_a);
        TextView harina_roja = (TextView) view.findViewById(R.id.harina_roja_a);
        TextView harina_centenario = (TextView) view.findViewById(R.id.harina_centenario_a);
        TextView harina_indistinta = (TextView) view.findViewById(R.id.harina_indistinta_a);
        TextView azucar_refinada = (TextView) view.findViewById(R.id.azucar_refinada_a);
        TextView azucar_estandar = (TextView) view.findViewById(R.id.azucar_estandar_a);
        TextView pasta_dawn = (TextView) view.findViewById(R.id.pasta_dawn_a);
        TextView coco_rayado = (TextView) view.findViewById(R.id.coco_rayado_a);
        TextView almidon_imsa = (TextView) view.findViewById(R.id.almidon_imsa_a);
        TextView maicena= (TextView) view.findViewById(R.id.maicena_a);
        TextView manteca = (TextView) view.findViewById(R.id.manteca_a);
        TextView margarina_san_antonio = (TextView) view.findViewById(R.id.margarina_san_antonio_a);
        TextView margarina_utarella = (TextView) view.findViewById(R.id.margarina_utarella_a);
        TextView relleno_fresa = (TextView) view.findViewById(R.id.relleno_fresa_a);
        TextView cobertura = (TextView) view.findViewById(R.id.cobertura_a);
        TextView polvo_puratos = (TextView) view.findViewById(R.id.polvo_puratos_a);
        TextView huevo = (TextView) view.findViewById(R.id.huevo_a);
        TextView sal = (TextView) view.findViewById(R.id.sal_a);
        TextView leche = (TextView) view.findViewById(R.id.leche_a);
        TextView tupan_puratos = (TextView) view.findViewById(R.id.tupan_a);
        TextView royal = (TextView) view.findViewById(R.id.royal_a);
        TextView chocolate_ganache = (TextView) view.findViewById(R.id.chocolate_ganache_a);
        TextView piloncillo = (TextView) view.findViewById(R.id.piloncillo_a);



        Materiales_add materiales_add = listamateriales.get(position);
        id_materiales_add.setText(Html.fromHtml("<tt><b><em><i><big>Id_materiales :------------ "+ materiales_add.getId_materiales_add()+"</big></i></em></b></tt>"));
        fecha.setText(Html.fromHtml("<tt><b><em><i><big>Fecha :------------ "+materiales_add.getFecha()+"</big></i></em></b></tt>"));
        hora.setText(Html.fromHtml("<tt><b><em><i><big>Hora :============ "+materiales_add.getHora()+"</big></i></em></b></tt>"));
        nombre_usuario.setText(Html.fromHtml("<tt><b><em><i><big>Nombre :============ "+materiales_add.getNombre_usuario()+"</big></i></em></b></tt>"));
        apellido_usuario.setText(Html.fromHtml("<tt><b><em><i><big>Apellido :========== "+materiales_add.getApellido_usuario()+"</big></i></em></b></tt>"));
        harina_azul.setText(Html.fromHtml("<tt><b><em><i><big>Harina Guadalupe Azul :========== "+materiales_add.getHarina_guadalupe_azul()+"</big></i></em></b></tt> Bulto(s)."));
        harina_roja.setText(Html.fromHtml("<tt><b><em><i><big>Harina Guadalupe Roja :========== "+materiales_add.getHarina_guadalupe_roja()+"</big></i></em></b></tt> Bulto(s)"));
        harina_centenario.setText(Html.fromHtml("<tt><b><em><i><big>Harina Centenario :========== "+materiales_add.getHarina_centenario()+"</big></i></em></b></tt> Bulto(s)"));
        harina_indistinta.setText(Html.fromHtml("<tt><b><em><i><big>Harina Indistinta  :========== "+materiales_add.getHarina_indistinta()+"</big></i></em></b></tt> Kg."));
        azucar_refinada.setText(Html.fromHtml("<tt><b><em><i><big>Azucar Refinada :========== "+materiales_add.getAzucar_refinada_siglo_xxi()+"</big></i></em></b></tt> Kg."));
        azucar_estandar.setText(Html.fromHtml("<tt><b><em><i><big>Azucar Estandar :========== "+materiales_add.getAzucar_estandar_central_m()+"</big></i></em></b></tt> Kg."));
        pasta_dawn.setText(Html.fromHtml("<tt><b><em><i><big>Pasta Dawn :========== "+materiales_add.getPasta_pastel_dawn()+"</big></i></em></b></tt> Kg."));
        coco_rayado.setText(Html.fromHtml("<tt><b><em><i><big>Coco Rayado :========== "+materiales_add.getCoco_rayado()+"</big></i></em></b></tt> Kg."));
        almidon_imsa.setText(Html.fromHtml("<tt><b><em><i><big>Almidon Imsa :========== "+materiales_add.getAlmidon_imsa()+"</big></i></em></b></tt> Kg."));
        maicena.setText(Html.fromHtml("<tt><b><em><i><big>Maicena :========== "+materiales_add.getMaicena()+"</big></i></em></b></tt> Kg."));
        manteca.setText(Html.fromHtml("<tt><b><em><i><big>Manteca Flor de Jalisco:========== "+materiales_add.getManteca_flor_jalisco()+"</big></i></em></b></tt> Kg."));
        margarina_san_antonio.setText(Html.fromHtml("<tt><b><em><i><big>Margarina San Antonio :========== "+materiales_add.getMargarina_san_antonio()+"</big></i></em></b></tt> Kg."));
        margarina_utarella.setText(Html.fromHtml("<tt><b><em><i><big>Margarina Utarella :========== "+materiales_add.getMargarina_utarella()+"</big></i></em></b></tt> Kg."));
        relleno_fresa.setText(Html.fromHtml("<tt><b><em><i><big>Relleno de Fresa :========== "+materiales_add.getRelleno_fresa_san_antonio()+"</big></i></em></b></tt> Kg."));
        cobertura.setText(Html.fromHtml("<tt><b><em><i><big>Cobertura :========== "+materiales_add.getCobertura_chocolate_garfias()+"</big></i></em></b></tt> Kg."));
        polvo_puratos.setText(Html.fromHtml("<tt><b><em><i><big>Polvo Puratos :========== "+materiales_add.getPolvo_para_hornear_puratos()+"</big></i></em></b></tt> Kg."));
        huevo.setText(Html.fromHtml("<tt><b><em><i><big>Huevo :========== "+materiales_add.getHuevo()+"</big></i></em></b></tt> Piezas."));
        sal.setText(Html.fromHtml("<tt><b><em><i><big>Sal :========== "+materiales_add.getSal_de_mar()+"</big></i></em></b></tt> Kg."));
        leche.setText(Html.fromHtml("<tt><b><em><i><big>Leche :========== "+materiales_add.getLeche()+"</big></i></em></b></tt> Litro(s)."));
        tupan_puratos.setText(Html.fromHtml("<tt><b><em><i><big>Tupan Puratos :========== "+materiales_add.getTupan_puratos()+"</big></i></em></b></tt> Kg."));
        royal.setText(Html.fromHtml("<tt><b><em><i><big>Royal :========== "+materiales_add.getRoyal_tupan_puratos()+"</big></i></em></b></tt> Kg."));
        chocolate_ganache.setText(Html.fromHtml("<tt><b><em><i><big>Chocolate Ganache :========== "+materiales_add.getChocolate_ganeche()+"</big></i></em></b></tt> Kg."));
        piloncillo.setText(Html.fromHtml("<tt><b><em><i><big>Piloncillo :========== "+materiales_add.getPiloncillo()+"</big></i></em></b></tt> Kg."));




        return view;

    }

    public Adaptador_materiales_add(Activity actividad) {
        this.actividad = actividad;
        baseDatos = actividad.openOrCreateDatabase("LipanDb", actividad.MODE_PRIVATE, null);
        String Tabla_materiales ="CREATE TABLE IF NOT EXISTS Materiales_add(id_material_add INTEGER PRIMARY KEY AUTOINCREMENT, fecha DATETIME DEFAULT CURRENT_TIMESTAMP, hora DATETIME DAFAULT CURRENT_TIMESTAMP, nombre_usuario TEXT, apellido_usuario TEXT,  harina_guadalupe_azul INTEGER,  harina_guadalupe_roja INTEGER,  harina_centenario INTEGER,  harina_indistinta INTEGER,  azucar_refinada_siglo_xxi INTEGER,  azucar_estandar_central_m INTEGER, pasta_pastel_dawn INTEGER,  coco_rayado INTEGER,  almidon_imsa INTEGER,  maicena INTEGER,  manteca_flor_jalisco INTEGER, margarina_san_antonio INTEGER,  margarina_utarella INTEGER,  relleno_fresa_san_antonio INTEGER, cobertura_chocolate_garfias INTEGER,  polvo_para_hornear_puratos INTEGER,  huevo INTEGER,  sal_de_mar INTEGER,  leche  INTEGER, tupan_puratos INTEGER,  royal_tupan_puratos INTEGER, chocolate_ganeche INTEGER,  piloncillo INTEGER)";
        baseDatos.execSQL(Tabla_materiales);

        String sql = "SELECT * FROM Materiales_add";
        cursor = baseDatos.rawQuery(sql,null);
        int renglones = cursor.getCount();

        cursor.moveToFirst();
        listamateriales= new ArrayList<Materiales_add>();
        for (int i = 0; i<renglones; i++){
            final int  id_materiales_add = cursor.getInt(0);
            String fecha = cursor.getString(1);
            String hora = cursor.getString(2);
            String nombre_usuario = cursor.getString(3);
            String apellido_usuario = cursor.getString(4);
            int harina_guadalupe_azul = cursor.getInt(5);
            int harina_guadalupe_roja = cursor.getInt(6);
            int harina_centenario = cursor.getInt(7);
            int harina_indistinta = cursor.getInt(8);
            int azucar_refinada_siglo_xxi = cursor.getInt(9);
            int azucar_estandar_central_m = cursor.getInt(10);
            int pasta_pastel_dawn = cursor.getInt(11);
            int coco_rayado = cursor.getInt(12);
            int almidon_imsa = cursor.getInt(13);
            int maicena = cursor.getInt(14);
            int manteca_flor_jalisco = cursor.getInt(15);
            int margarina_san_antonio = cursor.getInt(16);
            int margarina_utarella = cursor.getInt(17);
            int relleno_fresa_san_antonio = cursor.getInt(18);
            int cobertura_chocolate_garfias = cursor.getInt(19);
            int polvo_para_hornear_puratos = cursor.getInt(20);
            int huevo =cursor.getInt(21);
            int sal_de_mar = cursor.getInt(22);
            int leche = cursor.getInt(23);
            int tupan_puratos= cursor.getInt(24);
            int royal_tupan_puratos = cursor.getInt(25);
            int chocolate_ganeche = cursor.getInt(26);
            int piloncillo = cursor.getInt(27);

            listamateriales.add(new Materiales_add(id_materiales_add,fecha,hora,nombre_usuario,apellido_usuario,harina_guadalupe_azul,harina_guadalupe_roja,  harina_centenario, harina_indistinta,  azucar_refinada_siglo_xxi,  azucar_estandar_central_m,  pasta_pastel_dawn,  coco_rayado,  almidon_imsa,  maicena,  manteca_flor_jalisco,  margarina_san_antonio,  margarina_utarella,  relleno_fresa_san_antonio,  cobertura_chocolate_garfias,  polvo_para_hornear_puratos,  huevo, sal_de_mar, leche,  tupan_puratos,  royal_tupan_puratos,  chocolate_ganeche,  piloncillo)); // me qiuede aqui 3:34 del dia 19
            cursor.moveToNext();
        }

    }
}
