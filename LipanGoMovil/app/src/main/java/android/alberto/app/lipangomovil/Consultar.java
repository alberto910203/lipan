package android.alberto.app.lipangomovil;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Consultar extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);
        setListAdapter(new MiAdaptador_usuario(this));
        Button Regresar = (Button) findViewById(R.id.Regresar_menu);
        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m =new Intent(Consultar.this, Administrador.class);
                Consultar.this.startActivity(m);
            }
        });


    }
    protected void onListItemClick(ListView listView, View view, int position, long id ){
        super.onListItemClick(listView, view, position, id);
        Object o = getListAdapter().getItem(position);
        Toast.makeText(this, "Seleccion: " + Integer.toString(position) + " - " + o.toString(), Toast.LENGTH_SHORT).show();
        setListAdapter(new MiAdaptador_usuario(this));
        Intent i = new Intent(this, ModificarStatus.class);
        position=position+1;
        i.putExtra("position", position+"");
        startActivityForResult(i,0);
    }
}
