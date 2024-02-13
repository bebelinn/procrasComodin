package co.edu.procrascomodin.network;

import java.util.List;

import co.edu.procrascomodin.Comodin;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ComodinAPIService {
    @GET ("comodin")
    Call<List<Comodin>>getAll();
    @GET ("comodin/{id}")
    Call<Comodin> get(@Path("id")long id);
    @POST ("comodin")
    Call<Comodin> add (@Body Comodin comodin);
    @DELETE ("ficha/{id}")
    Call <Comodin> delete(@Path("id")long id, @Body Comodin comodin);
}
