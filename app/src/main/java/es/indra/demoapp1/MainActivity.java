package es.indra.demoapp1;

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

    public void recibirDatos(View view) {
        EditText et = findViewById(R.id.idText);
        String mensaje = et.getText().toString();
        System.out.println(mensaje);
    }

}
