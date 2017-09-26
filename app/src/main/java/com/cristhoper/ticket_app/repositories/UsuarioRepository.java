package com.cristhoper.ticket_app.repositories;

import com.cristhoper.ticket_app.models.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alumno on 25/09/2017.
 */

public class UsuarioRepository {
    private static UsuarioRepository _INSTANCE = null;

    private UsuarioRepository(){}

    public static UsuarioRepository getInstance() {
        if(_INSTANCE == null)
            _INSTANCE = new UsuarioRepository();
        return _INSTANCE;
    }

    private List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> getUsuarios(){
        return this.usuarios;
    }

    public void addUser(Usuario usuario){
        this.usuarios.add(usuario);
    }
}
