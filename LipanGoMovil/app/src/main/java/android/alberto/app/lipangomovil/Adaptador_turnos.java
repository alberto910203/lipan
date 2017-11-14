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
 * Created by AlBeRtO on 26/04/2017.
 */

public class Adaptador_turnos extends BaseAdapter {
   ArrayList<Turnos> listaturnos = null;
    SQLiteDatabase baseDatos = null;
    Cursor cursor = null;

    Activity actividad;
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getCount() {
        return listaturnos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaturnos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.renglon_turnos, null, true);

        TextView id_turno = (TextView) view.findViewById(R.id.id_turno);
        TextView nombre_usuario = (TextView) view.findViewById(R.id.nombre_usuario_a);
        //TextView apellido_usuario = (TextView) view.findViewById(R.id.apellido_usuario_a);
        TextView fecha_inicio = (TextView) view.findViewById(R.id.fecha_inicio_a);
        //TextView fecha_fin = (TextView) view.findViewById(R.id.fecha_fin_a);
        TextView hora_inicio = (TextView) view.findViewById(R.id.hora_inicio_a);
        //TextView hora_fin = (TextView) view.findViewById(R.id.hora_fin_a);
        TextView trabajadores = (TextView) view.findViewById(R.id.trabajadores_a);


        Turnos turno = listaturnos.get(position);
        id_turno.setText(Html.fromHtml("<i><big>Id_turno: "+ turno.getId_turno()+"</big></i>"));
        nombre_usuario.setText(Html.fromHtml("<tt><em><i><big>Nombre: <b><b>"+ turno.getNombre_usuario()+" "+ turno.getApellido_usuario()+"</big></i></em></b></b></tt>"));
        //apellido_usuario.setText(Html.fromHtml("<tt><b><em><i><big>Apellido:--.-----------------------"+ turno.getApellido_usuario()+"</big></i></em></b></tt>"));
        fecha_inicio.setText(Html.fromHtml("<tt><em><i><big>Fecha Inicio-Fin<b>: "+ turno.getFecha_inicio()+"</b> - "+ turno.getFecha_fin()+"</big></i></em></tt>"));
        //fecha_fin.setText(Html.fromHtml("<tt><b><em><i><big>Fecha Fin:-----------------------"+ turno.getFecha_fin()+"</big></i></em></b></tt>"));
        hora_inicio.setText(Html.fromHtml("<tt><em><i><big>Hora Inicio-Fin:<b> "+ turno.getHora_inicio()+"</b> - "+ turno.getHora_fin()+"</big></i></em></tt>"));
        //hora_fin.setText(Html.fromHtml("<tt><b><em><i><big>Hora Fin:-----------------------"+ turno.getHora_fin()+"</big></i></em></b></tt>"));
        trabajadores.setText(Html.fromHtml("<tt><em><i><big>Trabajadores: "+ turno.getTrabajadores()+"</big></i></em></tt>"));
        return view;

    }

    public Adaptador_turnos(Activity actividad) {
        this.actividad = actividad;
        baseDatos = actividad.openOrCreateDatabase("LipanDb", actividad.MODE_PRIVATE, null);
        String crearturno = "CREATE TABLE IF NOT EXISTS Turnos(id_turno INTEGER PRIMARY KEY AUTOINCREMENT, nombre_usuario TEXT,apellido_usuario TEXT,fecha_inicio DATETIME DEFAULT CURRENT_TIMESTAMP, fecha_fin DATETIME DEFAULT CURRENT_TIMESTAMP, hora_inicio DATETIME DEFAULT CURRENT_TIMESTAMP, hora_fin DATETIME DEFAULT CURRENT_TIMESTAMP, trabajadores TEXT )";
        //baseDatos.setForeignKeyConstraintsEnabled(true);
        baseDatos.execSQL(crearturno);
        String sql = "SELECT * FROM Turnos;";
        cursor = baseDatos.rawQuery(sql, null);//Puede devolver 0, 1 o muchos registros
        //txtDatos.append("\nTamaño: "+ baseDatos.getPageSize());//Tamaño de la BD en bytes//Se le agrega al txtView
        //txtDatos.append("\nColumnas: "+ cursor.getColumnCount()); //Num columnas
        int renglones = cursor.getCount();//Num Renglones
        //int columnas = cursor.getColumnCount();
        //txtDatos.append("\nRenglones: "+ renglones);
        cursor.moveToFirst(); //Ir al primer registro
        //while (cursor.moveToNext()) {

        listaturnos = new ArrayList<Turnos>(); //Crea la colección vacía

        for (int i = 0; i < renglones; i++) {
            final int id_turno = cursor.getInt(0);
            final String nombre_usuario = cursor.getString(1);
            final String apellido_usuario  = cursor.getString(2);
            String fecha_inicio = cursor.getString(3);
            String fecha_fin = cursor.getString(4);
            String hora_inicio = cursor.getString(5);
            String hora_fin = cursor.getString(6);
            String trabajadores = cursor.getString(7);



            //txtDatos.append("\n" + matricula + " " + nombre + " " + semestre);
            //Llenar la colección con datos de la base de datos
            listaturnos.add(new Turnos(id_turno, nombre_usuario, apellido_usuario,fecha_inicio,fecha_fin, hora_inicio, hora_fin, trabajadores));
            cursor.moveToNext();

            baseDatos.close();
        }


    }
}
