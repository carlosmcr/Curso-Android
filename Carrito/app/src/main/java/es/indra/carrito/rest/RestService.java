package es.indra.carrito.rest;

import java.util.List;

import es.indra.carrito.models.Categoria;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestService {

    String API_ROUTE="/categoria";

    @GET(API_ROUTE)
    Call<List<Categoria>> getAllCategorias();

    @POST(API_ROUTE)
    Call<Void> createCategoria(@Body Categoria categoria);
}
