package es.indra.carrito;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void crearCategoria(View view) {

        Intent intent = new Intent(this, ListaCategorias.class);
        EditText et = findViewById(R.id.idCategoria2);
        String mensaje = et.getText().toString();
        //intent.putExtra("param1", mensaje);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("categoria", mensaje);
        edit.commit();

        startActivity(intent);

    }
}
