package com.cristhoper.ticket_app.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cristhoper.ticket_app.R;
import com.cristhoper.ticket_app.models.Usuario;
import com.cristhoper.ticket_app.repositories.UsuarioRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etUser, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = (EditText) findViewById(R.id.etUser);
        etPass = (EditText) findViewById(R.id.etPass);

        etUser.setText("");
        etPass.setText("");
    }

    public void logIn (View view) {
        String user = etUser.getText().toString();
        String pass = etPass.getText().toString();

        if (user.isEmpty() || pass.isEmpty()){
            Toast.makeText(this, "Complete los campos, por favor", Toast.LENGTH_SHORT).show();
        }else{
            UsuarioRepository userRep = UsuarioRepository.getInstance();
            List<Usuario> usuarios = userRep.getUsuarios();

            boolean check = true;
            for (Usuario usuario : usuarios){
                if (user.equals(usuario.getUsername()) && pass.equals(usuario.getPassword())) {
                    check = true;
                    startActivity(new Intent(MainActivity.this, UserActivity.class));
                    break;
                }else{
                    check = false;
                }
            }

            if (!check) {
                Toast.makeText(this, "La cuenta no existe", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void signUp(View view){
        startActivity(new Intent(MainActivity.this, RegistroActivity.class));

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                etUser.setText("");
                etPass.setText("");
            }
        }, 1000);
    }
}
