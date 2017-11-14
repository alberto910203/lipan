package android.alberto.app.lipangomovil;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button ir_menu;
    public EditText nombre,apellido, contrasena,nick;
    public static final String Key1= "Nombre";
    public static final String Key2= "Apellido";
    public static final int HIJORESULT = 0;
    private Cursor fila;
    SQLiteDatabase baseDatos = null;
    TextView emergencia;
     TextInputLayout textInputPassword;
     TextInputLayout textInputName;
     TextInputLayout textInputApe;
    TextInputLayout textInputNick;
     FloatingActionButton Administrador;

    //Alert Dialog Manager instancia
    AlertDialogManager alert = new AlertDialogManager();

    // Administrador de sesion Class
    Administrador_sesion session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Session Manager
        session = new Administrador_sesion(getApplicationContext());
        //Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();

        //nombre = (EditText) findViewById(R.id.name);
        //apellido = (EditText) findViewById(R.id.apellido);
        contrasena = (EditText) findViewById(R.id.pass);
        textInputPassword =(TextInputLayout) findViewById(R.id.text_input);
        nick =(EditText) findViewById(R.id.nick);
        textInputNick =(TextInputLayout) findViewById(R.id.text_input_layout_nick);

        //textInputName =(TextInputLayout) findViewById(R.id.text_input_layout_nom);
        //textInputApe =(TextInputLayout) findViewById(R.id.text_input_layout_ape);

        //Administrador = (FloatingActionButton) findViewById(R.id.Administrador);/////BOTON DE EMERGENCIA


        baseDatos = this.openOrCreateDatabase("LipanDb", MODE_PRIVATE, null);
        String crearTabla = "CREATE TABLE IF NOT EXISTS Usuarios (id integer primary key autoincrement, nombre text, apellido text,contrasena text, puesto text, perfilpuesto text, nombrecorto text, tipousuario text, nivelacceso int, status text, rfc text, curp text, nss text, domicilio text, telefono1 text, telefono2 text);";
        baseDatos.execSQL(crearTabla);
        //++++++++++++++++++++++++++++++++++++BOTON DE EMERGENCIA+++++++++++++++++++++++++++++++===
        /*Administrador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent eme = new Intent(Login.this, Administrador.class);
                Login.this.startActivity(eme);
            }
        });*/
        fila = baseDatos.rawQuery("SELECT COUNT(*) FROM Usuarios",null);

        if (fila!=null) {
            fila.moveToFirst();

            if (fila.getInt(0)== 0) {
                String insertar_admin = "INSERT INTO Usuarios(id,nombre,apellido,contrasena,nombrecorto,tipousuario,status)Values(null,'Mercedes','Carrillo Rocha','panolelk','mercedes','Produccion','A'); ";
                baseDatos.execSQL(insertar_admin);
                String insertar_admin1 = "INSERT INTO Usuarios(id,nombre,apellido,contrasena,nombrecorto,tipousuario,status)Values(null,'Victor Omar','Barron','osiriigl','omar','Produccion','A'); ";
                baseDatos.execSQL(insertar_admin1);
                String insertar_admin2 = "INSERT INTO Usuarios(id,nombre,apellido,contrasena,nombrecorto,tipousuario,status)Values(null,'Martin Gabriel','Cortes Lopez','onfere3i','martin','Produccion','A'); ";
                baseDatos.execSQL(insertar_admin2);
                String insertar_admin3 = "INSERT INTO Usuarios(id,nombre,apellido,contrasena,nombrecorto,tipousuario,status)Values(null,'Francisco','Baez Valtierra','radode9p','francisco','Produccion','A'); ";
                baseDatos.execSQL(insertar_admin3);
                String insertar_admin4 = "INSERT INTO Usuarios(id,nombre,apellido,contrasena,nombrecorto,tipousuario,status)Values(null,'Rafael','Flores Rayas','expansi5','rafael','Produccion','A'); ";
                baseDatos.execSQL(insertar_admin4);
                String insertar_admin5 = "INSERT INTO Usuarios(id,nombre,apellido,contrasena,nombrecorto,tipousuario,status)Values(null,'Carlos Alberto','Barron Castro','123','charly','Produccion','A'); ";
                baseDatos.execSQL(insertar_admin5);

            }
            else{

                //Toast.makeText(this,"hay registros",Toast.LENGTH_SHORT).show();
            }

        }
        else{
           // Toast.makeText(this,"no podemos hacer la comparacion de la DB",Toast.LENGTH_SHORT).show();
        }

    }
    private static void toggleTextInputLayoutError(@NonNull TextInputLayout textInputLayout,
                                                   String msg) {
        textInputLayout.setError(msg);
        if (msg == null) {
            textInputLayout.setErrorEnabled(false);
        } else {
            textInputLayout.setErrorEnabled(true);
        }
    }

    public void ingresar(View view) {

        //String crearTabla="CREATE TABLE IF NOT EXISTS Usuarios (nombre text, contrasena text);";
        //baseDatos.execSQL(crearTabla);
        String passError = null;
        //String Nombre = nombre.getText().toString();
        //String Apellido= apellido.getText().toString();
        String Contrasena = contrasena.getText().toString();
        String Nick = nick.getText().toString();

        if(TextUtils.isEmpty(Nick)){
            passError = getString(R.string.mandatory3);
        }
        toggleTextInputLayoutError(textInputNick, passError);

        if (TextUtils.isEmpty(Contrasena)) {
            passError = getString(R.string.mandatory2);
        }
        toggleTextInputLayoutError(textInputPassword, passError);



        //if (TextUtils.isEmpty(Nombre)) {
        //    passError = getString(R.string.mandatory);
        //}
        //toggleTextInputLayoutError(textInputName, passError);

       // if (TextUtils.isEmpty(Apellido)) {
       //     passError = getString(R.string.mandatory1);
        //}
        //toggleTextInputLayoutError(textInputApe, passError);


        fila = baseDatos.rawQuery("select  nombre, apellido,contrasena, status, tipousuario,nombrecorto from Usuarios where nombrecorto = '" + Nick + "'  and contrasena = '" + Contrasena + "'  ", null);


        if (fila.moveToFirst()) {
            String nom = fila.getString(0);
            String ape = fila.getString(1);
            String contra = fila.getString(2);
            String st = fila.getString(3);
            String tu = fila.getString(4);
            String nc = fila.getString(5);


          /* if (Nombre.matches(" ")&& Contrasena.matches("")){
                Toast.makeText(this, "No escribiste tu Nombre", Toast.LENGTH_SHORT).show();
            }*/


                if ( Contrasena.equals(contra) && Nick.equals(nc) && st.equals("A")&& tu.equals("Produccion")) {
                    session.createLoginSession(nom, ape);
                    Intent Produccion = new Intent(getApplicationContext(), Produccion.class);
                    //Produccion.putExtra(Key1, Nombre+"");
                    //Produccion.putExtra(Key2, Apellido+"");
                    startActivity(Produccion);
                    finish();
                    //Login.this.startActivity(Produccion);
                    Toast.makeText(this, "Ingreso  Exitoso", Toast.LENGTH_LONG).show();

                }
                else {
                    // username / password doesn't match
                    alert.showAlertDialog(Login.this, "Login failed..", "Username/Password is incorrect", false);
                }

                    if ( Nick.equals("admin") && Contrasena.equals("admin") ) {
                    Intent Admin = new Intent(this, Administrador.class);
                    startActivity(Admin);
                    Toast.makeText(this, "Ingreso  Exitoso", Toast.LENGTH_LONG).show();
                }

        }// fin del cursor

        else{
            //apellido.setText("");
            nick.setText("");
            contrasena.setText("");
            Toast.makeText(this, "Usuario o Contrasena, Incorrecta", Toast.LENGTH_LONG).show();
        }

    } // fin del if del cursor


}
