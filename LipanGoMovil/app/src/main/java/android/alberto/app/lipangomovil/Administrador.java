package android.alberto.app.lipangomovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Administrador extends AppCompatActivity {
    Button regresar,consultar,registrar,consultar_m,consultar_p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);
        regresar = (Button) findViewById(R.id.regresar);
        consultar = (Button) findViewById(R.id.consultar);
        registrar = (Button) findViewById(R.id.registrar);
        consultar_m = (Button) findViewById(R.id.consultar_m);
        consultar_p = (Button) findViewById(R.id.consultar_p);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Administrador.this, Registrar.class);
                Administrador.this.startActivity(c);
            }
        });

        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Administrador.this, Consultar.class);
                Administrador.this.startActivity(c);
            }
        });

        consultar_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cm = new Intent(Administrador.this, Consultar_Materiales.class);
                Administrador.this.startActivity(cm);
            }
        });
        consultar_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cp = new Intent(Administrador.this,Consultar_Proveedores.class);
                Administrador.this.startActivity(cp);
            }
        });
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent re = new Intent(Administrador.this, Login.class);
                Administrador.this.startActivity(re);
            }
        });



    }
}
