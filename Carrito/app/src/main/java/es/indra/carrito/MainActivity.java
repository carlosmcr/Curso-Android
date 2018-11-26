package es.indra.carrito;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import es.indra.carrito.models.Categoria;
import es.indra.carrito.rest.RestService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void createCategoria(View view) {

        EditText et = findViewById(R.id.idCategoria2);
        String nombre = et.getText().toString();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.60:8082")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RestService rest = retrofit.create(RestService.class);
        Categoria categoria = new Categoria();
        categoria.setNombre(nombre);

        Call retorno = rest.createCategoria(categoria);
        retorno.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                System.out.println("ok" + response.code());
                Intent intent = new Intent(getApplicationContext(), ListadoActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                t.printStackTrace();
            }
        });




    }

    public void listaCategorias(View view){
        Intent intent2 = new Intent(getApplicationContext(), ListadoActivity.class);
        startActivity(intent2);
    }
}
