package android.alberto.app.lipangomovil;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ModificarStatus extends AppCompatActivity {
    EditText ed_status;
    Button btn_actualizar;
    SQLiteDatabase baseDatos = null;
    ImageButton Return;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_status);
        ed_status = (EditText) findViewById(R.id.ed_status);
        btn_actualizar = (Button) findViewById(R.id.btn_actualizar);
        Return = (ImageButton) findViewById(R.id.ret);
        baseDatos = this.openOrCreateDatabase("LipanDb", MODE_PRIVATE, null);
        //String crearTabla = "CREATE TABLE IF NOT EXISTS Usuarios (id integer primary key autoincrement, nombre text, apellido text,contrasena text, puesto text, perfilpuesto text, nombrecorto text, tipousuario text, nivelacceso int, status text, rfc text, curp text, nss text, domicilio text, telefono1 text, telefono2 text);";
        //baseDatos.execSQL(crearTabla);
        //btn_actualizar.setOnClickListener(this);

        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ret = new Intent(ModificarStatus.this, Consultar.class);
                ModificarStatus.this.startActivity(ret);
            }
        });
    }

    public void actualizar(View view) {
        try {
            Intent i = getIntent();
            String position = i.getStringExtra("position");//recogemos el valor del intet
            String ed_status_s = ed_status.getText().toString();
            String sql1 = ("Update Usuarios set status = '" + ed_status_s + "' where id =" + position);
            baseDatos.execSQL(sql1);
            Toast.makeText(this,"Actualizado",Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            Toast.makeText(this,"Error al Actualizar",Toast.LENGTH_SHORT).show();
        }
    }

}

