package es.indra.carrito;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        if(preferences.getString("user","n/a") != null && preferences.getString("password","n/a") != null){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, login.class);
            startActivity(intent);
        }



    }

    public void login(View view){
        Intent intent = new Intent(this, MainActivity.class);

        EditText etUser= findViewById(R.id.idCategoria2);
        EditText etpassword = findViewById(R.id.editText_password);
        String user = etUser.getText().toString();
        String password = etpassword.getText().toString();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("user", user);
        edit.putString("password", password);
        edit.commit();

        startActivity(intent);

    }
}

