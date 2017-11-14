package android.alberto.app.lipangomovil;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ver_registros_turno extends ListActivity {
    Button actualizar,Regresar_menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_registros_turno);
        setListAdapter(new Adaptador_turnos(this));
        Regresar_menu = (Button) findViewById(R.id.Regresar_menu);
        actualizar=(Button) findViewById(R.id.actualizar);

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent actualizar = new Intent(Ver_registros_turno.this,Ver_registros_turno.class);
                Ver_registros_turno.this.startActivity(actualizar);
            }
        });
        Regresar_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Regresar_menu  = new Intent(Ver_registros_turno.this,Produccion.class);
                Ver_registros_turno.this.startActivity(Regresar_menu);
            }
        });
    }
}
