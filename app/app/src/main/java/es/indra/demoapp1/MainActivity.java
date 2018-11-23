package es.indra.demoapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void recibirDatos(View view) {
        EditText et = findViewById(R.id.idText);
        String mensaje = et.getText().toString();
        //SToast.makeText(getApplicationContext(), getString(R.string.toast) .concat(mensaje), Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("param1", mensaje);
        startActivity(i);


    }

}
