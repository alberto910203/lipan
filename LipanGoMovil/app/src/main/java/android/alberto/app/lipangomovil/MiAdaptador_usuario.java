package android.alberto.app.lipangomovil;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AlBeRtO on 20/04/2017.
 */

public class MiAdaptador_usuario extends BaseAdapter {
    ArrayList<Usuarios> listaUsuarios = null;
    SQLiteDatabase baseDatos = null;
    Cursor cursor = null;

    Activity actividad;



    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getCount() {
        return listaUsuarios.size();

    }

    @Override
    public Object getItem(int position) {
        return listaUsuarios.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.renglon_usuarios, null, true);
        TextView id = (TextView) view.findViewById(R.id.id);
        TextView name_r = (TextView) view.findViewById(R.id.name_r);
        TextView apellido_r = (TextView) view.findViewById(R.id.apellido_r);
        TextView pass_r = (TextView) view.findViewById(R.id.pass_r);
        TextView puesto = (TextView) view.findViewById(R.id.puesto);
        TextView perfilpuesto = (TextView) view.findViewById(R.id.perfilpuesto);
        TextView nombre_corto = (TextView) view.findViewById(R.id.nombre_corto);
        TextView tipo_usuario = (TextView) view.findViewById(R.id.tipo_usuario);
        TextView nivel_acceso = (TextView) view.findViewById(R.id.nivel_acceso);
        TextView status = (TextView) view.findViewById(R.id.status);
        TextView rfc = (TextView) view.findViewById(R.id.rfc);
        TextView curp = (TextView) view.findViewById(R.id.curp);
        TextView nss = (TextView) view.findViewById(R.id.nss);
        TextView domicilio = (TextView) view.findViewById(R.id.domicilio_u);
        TextView telefono1 = (TextView) view.findViewById(R.id.telefono1);
        TextView telefono2 = (TextView) view.findViewById(R.id.telefono2);

        Usuarios usuario = listaUsuarios.get(position);
        id.setText("Id:------------- "+ usuario.get_id());
        name_r.setText("NOMBRE:----------"+ usuario.getNombre());
        apellido_r.setText("APELLLIDO:-----------"+ usuario.getApellido());
        pass_r.setText("CONTRASENA:---------"+ usuario.getContrasena());
        puesto.setText("PUESTO:----------" + usuario.getPuesto());
        perfilpuesto.setText("PERFIL PUESTO:------------" + usuario.getPerfilpuesto());
        nombre_corto.setText("NOMBRE CORTO:------------" + usuario.getNombre_corto());
        tipo_usuario.setText("TIPO USUARIO: ------------" + usuario.getTipo_usuario());
        nivel_acceso.setText("NIVEL DE ACCESO:-----------" + usuario.getNivel_acceso());
        status.setText("STATUS:----------" + usuario.getStatus());
        rfc.setText("RFC:-------------" + usuario.getRfc());
        curp.setText("CURP:-----------" + usuario.getCurp());
        nss.setText("NSS:----------"+ usuario.getNss());
        domicilio.setText("DOMICILIO:---------"+ usuario.getDomicilio());
        telefono1.setText("TELEFONO 1:------------"+usuario.getTelefono1());
        telefono2.setText("TELEFONO 2:---------------"+usuario.getTelefono2());

        return view;
    }

    public MiAdaptador_usuario(Activity actividad) {
        this.actividad = actividad;
        baseDatos = actividad.openOrCreateDatabase("LipanDb", actividad.MODE_PRIVATE, null);
        String crearTabla = "CREATE TABLE IF NOT EXISTS Usuarios (id integer primary key autoincrement, nombre text, apellido text,contrasena text, puesto text, perfilpuesto text, nombrecorto text, tipousuario text, nivelacceso int, status text, rfc text, curp text, nss text, domicilio text, telefono1 text, telefono2 text);";
        baseDatos.execSQL(crearTabla);
        String sql = "SELECT * FROM Usuarios;";
        cursor = baseDatos.rawQuery(sql, null);//Puede devolver 0, 1 o muchos registros
        //txtDatos.append("\nTamaño: "+ baseDatos.getPageSize());//Tamaño de la BD en bytes//Se le agrega al txtView
        //txtDatos.append("\nColumnas: "+ cursor.getColumnCount()); //Num columnas
        int renglones = cursor.getCount();//Num Renglones
        //int columnas = cursor.getColumnCount();
        //txtDatos.append("\nRenglones: "+ renglones);
        cursor.moveToFirst(); //Ir al primer registro
        //while (cursor.moveToNext()) {

        listaUsuarios = new ArrayList<Usuarios>(); //Crea la colección vacía

        for (int i = 0; i < renglones; i++) {
            final int _id = cursor.getInt(0);
            final String nombre = cursor.getString(1);
            final String apellido  = cursor.getString(2);
            String contrasena = cursor.getString(3);
            String puesto = cursor.getString(4);
            String perfilpuesto = cursor.getString(5);
            String nombre_corto = cursor.getString(6);
            String tipo_usuario = cursor.getString(7);
            int nivel_acceso = cursor.getInt(8);
            String status = cursor.getString(9);
            String rfc = cursor.getString(10);
            String curp = cursor.getString(11);
            String nss = cursor.getString(12);
            String domicilio = cursor.getString(13);
            String telefono1 = cursor.getString(14);
            String telefono2 = cursor.getString(15);

            //txtDatos.append("\n" + matricula + " " + nombre + " " + semestre);
            //Llenar la colección con datos de la base de datos
            listaUsuarios.add(new Usuarios(_id, nombre, apellido,contrasena, puesto, perfilpuesto, nombre_corto, tipo_usuario, nivel_acceso, status, rfc, curp, nss, domicilio, telefono1, telefono2));
            cursor.moveToNext();

            baseDatos.close();
        }

    }
}
