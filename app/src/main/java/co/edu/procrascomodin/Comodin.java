package co.edu.procrascomodin;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.List;
import co.edu.procrascomodin.network.ComodinAPICliente;
import co.edu.procrascomodin.network.ComodinAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Comodin extends AppCompatActivity {

    private TextView comodinesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comodinesTextView = findViewById(R.id.comodinesTextView);

        ComodinAPIService service = ComodinAPICliente.getComodinInstance();

        Call<List<Comodin>> call = service.getAll();

        call.enqueue(new Callback<List<Comodin>>() {
            @Override
            public void onResponse(Call<List<Comodin>> call, Response<List<Comodin>> response) {
                if (response.isSuccessful()) {
                    List<Comodin> comodines = response.body();
                    int cantidadComodines = comodines.size();
                    comodinesTextView.setText("Cantidad de comodines: " + cantidadComodines);
                } else {
                    // Manejar errores de la respuesta
                }
            }

            @Override
            public void onFailure(Call<List<Comodin>> call, Throwable t) {
                // Manejar errores de la solicitud
            }
        });
    }
}
