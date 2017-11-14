package android.alberto.app.lipangomovil;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Modificar_materiales extends AppCompatActivity {
    private Button Return;
    SQLiteDatabase baseDatos = null;
    EditText ed_stock_base;
    EditText ed_stock_actual;
    Button Actualizar;
    Button Proveedores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_materiales);
        ed_stock_base = (EditText) findViewById(R.id.ed_stock_base);
        ed_stock_actual = (EditText) findViewById(R.id.ed_stock_actual);
        Return = (Button) findViewById(R.id.ret);
        baseDatos = this.openOrCreateDatabase("LipanDb", MODE_PRIVATE, null);

        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ret = new Intent(Modificar_materiales.this, Consultar_Materiales.class);
                Modificar_materiales.this.startActivity(ret);
            }
        });
    }
    public void Ver_Proveedores (View view){
        //Intent i = getIntent();
        //String position = i.getStringExtra("position");//recogemos el valor del intet
        Intent e = new Intent(this, VerProveedor.class);
        //position=position+1;
        //e.putExtra("position_new", position+"");
        //startActivityForResult(i,0);
        this.startActivity(e);

    }

    public void Actualizar_Stocks (View view){
        try {
            Intent i = getIntent();
            String position = i.getStringExtra("position");//recogemos el valor del intet
            String ed_stock_base_s = ed_stock_base.getText().toString();
            String ed_stock_actual_s = ed_stock_actual.getText().toString();
            String sql1 = ("Update Materiales set stock_base = '" + ed_stock_base_s + "', stock_actual = '" +ed_stock_actual_s+ "' where id_material =" + position);
            baseDatos.execSQL(sql1);
            Toast.makeText(this,"Actualizado",Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            Toast.makeText(this,"Error al Actualizar",Toast.LENGTH_SHORT).show();
        }

    }

}
