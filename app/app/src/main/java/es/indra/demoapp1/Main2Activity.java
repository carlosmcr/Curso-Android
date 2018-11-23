package es.indra.demoapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        String mensaje = i.getStringExtra("param1");
        Toast.makeText(this, "Recibido :" .concat(mensaje), Toast.LENGTH_SHORT).show();

    }
}
