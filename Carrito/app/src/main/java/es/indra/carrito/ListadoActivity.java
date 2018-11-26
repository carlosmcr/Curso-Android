package es.indra.carrito;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import es.indra.carrito.models.Categoria;
import es.indra.carrito.rest.RestService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListadoActivity extends AppCompatActivity {

    ListView lista;
    ArrayList<String> listaArray = new ArrayList<>();
    ArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        lista = findViewById(R.id.listado);
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaArray);
        lista.setAdapter(adaptador);
        getCategorias();

    }


    private void getCategorias(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.60:8082")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestService rest = retrofit.create(RestService.class);

        Call<List<Categoria>> call = rest.getAllCategorias();

        call.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                for (int i = 0; i < response.body().size(); i++){
                    listaArray.add(response.body().get(i).getNombre());
                }
                adaptador.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
