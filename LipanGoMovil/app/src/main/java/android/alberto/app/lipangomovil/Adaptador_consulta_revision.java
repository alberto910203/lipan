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

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by AlBeRtO on 02/05/2017.
 */

public class Adaptador_consulta_revision extends BaseAdapter {
    ArrayList<Consulta_revision> listconsultarevision = null;
    Activity actividad;
    SQLiteDatabase baseDatos = null;
    Cursor cursor = null;
    @Override
    public int getCount() {
        return listconsultarevision.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public Object getItem(int position) {
        return listconsultarevision.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.reglon_consulta_revision,null,true);

        TextView id_produccion_panblanco =(TextView) view.findViewById(R.id.id_produccion_panblanco_r);
        TextView id_turno_produccion_pan_blanco =(TextView) view.findViewById(R.id.id_turno_produccion_pan_blanco_r);
        TextView fecha =(TextView) view.findViewById(R.id.fecha_r);
        TextView hora =(TextView) view.findViewById(R.id.hora_r);
        TextView nombre_usuario =(TextView) view.findViewById(R.id.nombre_usuario_r);
        TextView apellido_usuario = (TextView) view.findViewById(R.id.apellido_usuario_r);
        TextView cant_bolillo = (TextView) view.findViewById(R.id.cant_bolillo_r);
        TextView cant_bolillo_chico = (TextView) view.findViewById(R.id.cant_bolillo_chico_r);
        TextView cant_bolillo_mignon = (TextView) view.findViewById(R.id.cant_bolillo_mignon_r);
        TextView cant_pan_acimo = (TextView) view.findViewById(R.id.cant_pan_acimo_r);
        TextView cant_pambazo = (TextView) view.findViewById(R.id.cant_pambazo_r);
        TextView cant_pambazo_grande = (TextView) view.findViewById(R.id.cant_pambazo_grande_r);
        TextView trabajadores = (TextView) view.findViewById(R.id.trabajadores_r);
        TextView  comentarios =(TextView) view.findViewById(R.id.comentarios_r);

        Consulta_revision consulta_revision = listconsultarevision.get(position);
        id_produccion_panblanco.setText(Html.fromHtml("<tt><b><em><i><big>Id_produccion_blanco :------------ "+ consulta_revision.getId_produccion_pan_blanco()+"</big></i></em></b></tt>"));
        id_turno_produccion_pan_blanco.setText(Html.fromHtml("<tt><b><em><i><big>Id_produccion_blanco_turno :------------ "+ consulta_revision.getId_turnos_produccion_pan_blanco()+"</big></i></em></b></tt>"));
        fecha.setText(Html.fromHtml("<tt><b><em><i><big>Fecha:------------ "+ consulta_revision.getFecha()+"</big></i></em></b></tt>"));
        hora.setText(Html.fromHtml("<tt><b><em><i><big>Hora :------------ "+ consulta_revision.getHora()+"</big></i></em></b></tt>"));
        nombre_usuario.setText(Html.fromHtml("<tt><b><em><i><big>Nombre :------------ "+ consulta_revision.getNombre()+"</big></i></em></b></tt>"));
        apellido_usuario.setText(Html.fromHtml("<tt><b><em><i><big>Apellido :------------ "+ consulta_revision.getApellido()+"</big></i></em></b></tt>"));
        cant_bolillo.setText(Html.fromHtml("<tt><b><em><i><big>Cantidad de Bolillo :------------ "+ consulta_revision.getCant_bolillo()+"</big></i></em></b></tt>"));
        cant_bolillo_chico.setText(Html.fromHtml("<tt><b><em><i><big>Cantidad de Bolillo Chico :------------ "+ consulta_revision.getCant_bolillo_chico()+"</big></i></em></b></tt>"));
        cant_bolillo_mignon.setText(Html.fromHtml("<tt><b><em><i><big>Cantidad de Bolillo Mignon :------------ "+ consulta_revision.getCant_bolillo_mignon()+"</big></i></em></b></tt>"));
        cant_pan_acimo.setText(Html.fromHtml("<tt><b><em><i><big>Cantidad de Pan Acimo :------------ "+ consulta_revision.getCant_pan_acimo()+"</big></i></em></b></tt>"));
        cant_pambazo.setText(Html.fromHtml("<tt><b><em><i><big>Cantidad Pambazo :------------ "+ consulta_revision.getCant_pambazo()+"</big></i></em></b></tt>"));
        cant_pambazo_grande.setText(Html.fromHtml("<tt><b><em><i><big>Cantidad Pambazo Grande :------------ "+ consulta_revision.getCant_pambazo_grande()+"</big></i></em></b></tt>"));
        trabajadores.setText(Html.fromHtml("<tt><b><em><i><big>Trabajadores :------------ "+ consulta_revision.getTrabajadores()+"</big></i></em></b></tt>"));
        comentarios.setText(Html.fromHtml("<tt><b><em><i><big>Comentarios :------------ "+ consulta_revision.getComentarios()+"</big></i></em></b></tt>"));



 return view;
    }

    public Adaptador_consulta_revision(Activity actividad) {
        this.actividad = actividad;
        baseDatos = actividad.openOrCreateDatabase("LipanDb", actividad.MODE_PRIVATE, null);
        String Tabla_produccion_panblanco ="CREATE TABLE IF NOT EXISTS Produccion_panblanco(id_produccion_panblanco INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, fecha DATETIME DEFAULT CURRENT_TIMESTAMP, hora DATETIME DAFAULT CURRENT_TIMESTAMP, nombre_usuario TEXT NOT NULL, apellido_usuario TEXT, cant_bolillo INTEGER, cant_bolillo_chico INTEGER, cant_bolillo_mignon INTEGER, cant_pan_acimo INTEGER, cant_pambazo INTEGER, cant_pambazo_grande INTEGER)";
        baseDatos.execSQL(Tabla_produccion_panblanco);
        String crearturno = "CREATE TABLE IF NOT EXISTS Turnos(id_turno INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,id_turno_produccion_pan_blanco INTEGER NOT NULL AUTOINCREMENT,  nombre_usuario TEXT,apellido_usuario TEXT,fecha_inicio DATETIME DEFAULT CURRENT_TIMESTAMP, fecha_fin DATETIME DEFAULT CURRENT_TIMESTAMP, hora_inicio DATETIME DEFAULT CURRENT_TIMESTAMP, hora_fin DATETIME DEFAULT CURRENT_TIMESTAMP, trabajadores TEXT, produccion_final TEXT, comentarios TEXT, FOREIGN KEY(id_turno_produccion_pan_blanco) REFERENCES Produccion_panblanco(id_produccion_panblanco) )";
        //baseDatos.setForeignKeyConstraintsEnabled(true);
        baseDatos.execSQL("PRAGMA foreign_keys = ON;");
        baseDatos.execSQL(crearturno);
        String sql = "SELECT id_produccion_panblanco,fecha,hora FROM Produccion_panblanco INNER JOIN Turnos ON Produccion_panblanco.id_produccion_panblanco = Turnos.id_turno_produccion_pan_blanco;";
        cursor = baseDatos.rawQuery(sql,null);
        int renglones = cursor.getCount();

        cursor.moveToFirst();
        listconsultarevision= new ArrayList<Consulta_revision>();
        for (int i = 0; i<renglones; i++){
            final int  id_produccion_panblanco = cursor.getInt(0);
            final int  id_turno_produccion_pan_blanco = cursor.getInt(1);
            String fecha = cursor.getString(2);
            String hora = cursor.getString(3);
            String nombre_usuario = cursor.getString(4);
            String apellido_usuario = cursor.getString(5);
            final int cant_bolillo = cursor.getInt(6);
            final int cant_bilillo_chico = cursor.getInt(7);
            final int cant_bolillo_mignon = cursor.getInt(8);
            final int cant_pan_acimo = cursor.getInt(9);
            final int cant_pambazo = cursor.getInt(10);
            final int cant_pambazo_grande = cursor.getInt(11);
            String trabajadores = cursor.getString(12);
            String comentarios = cursor.getString(12);


            listconsultarevision.add(new Consulta_revision(id_produccion_panblanco,id_turno_produccion_pan_blanco,fecha,hora,nombre_usuario,apellido_usuario,cant_bolillo,cant_bilillo_chico,cant_bolillo_mignon,cant_pan_acimo,cant_pambazo,cant_pambazo_grande, trabajadores,comentarios)); // me qiuede aqui 3:34 del dia 19
            cursor.moveToNext();
        }

    }
}
