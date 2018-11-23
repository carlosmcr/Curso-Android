package es.indra.carrito;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ListaCategorias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_categorias);

        Intent intent = getIntent();
        //String mensaje = intent.getStringExtra("param1");
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String mensaje = preferences.getString("categoria","n/a");
        TextView tv = findViewById(R.id.nombreCategoria2);
        tv.setText(mensaje);
    }
}
