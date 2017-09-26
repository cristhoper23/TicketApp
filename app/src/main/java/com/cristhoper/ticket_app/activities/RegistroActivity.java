package com.cristhoper.ticket_app.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.cristhoper.ticket_app.R;
import com.cristhoper.ticket_app.models.Usuario;
import com.cristhoper.ticket_app.repositories.UsuarioRepository;

public class RegistroActivity extends AppCompatActivity {

    EditText etUser, etPass;
    Spinner spinnerRol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        etUser = (EditText) findViewById(R.id.etUser);
        etPass = (EditText) findViewById(R.id.etPass);

        spinnerRol = (Spinner) findViewById(R.id.spinnerRol);
    }

    public void signUp (View view) {
        String user = etUser.getText().toString();
        String pass = etPass.getText().toString();
        String rol = spinnerRol.getSelectedItem().toString();

        Usuario usuario = new Usuario(user, pass, rol);
        UsuarioRepository userRep = UsuarioRepository.getInstance();
        userRep.addUser(usuario);

        finish();
    }
}
