package org.example.service;

import org.example.dao.UsuarioDAO;
import org.example.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registrarUsuario(Usuario usuario) {
        String contrasenaEncriptada = passwordEncoder.encode(usuario.getContraseña());
        usuario.setContraseña(contrasenaEncriptada);

        usuarioDAO.save(usuario);
    }

    public boolean existeUsuario(String nombreUsuario) {
        // Utiliza el DAO para buscar un usuario por nombre de usuario
        Usuario usuario = usuarioDAO.findByNombre(nombreUsuario);

        // Si se encuentra un usuario con el nombre de usuario proporcionado, significa que ya existe
        return usuario != null;
    }

    public boolean existeEmailUsuario(String email) {
        Usuario usuario = usuarioDAO.findByEmail(email);
        return usuario != null;
    }

    public boolean autenticarUsuario(String nombreUsuario, String contrasena) {
        // Consulta el usuario en la base de datos por nombre de usuario
        Usuario usuario = usuarioDAO.findByNombre(nombreUsuario);

        if (usuario == null) {
            return false; // El usuario no existe
        }

        // Verifica la contraseña almacenada en la base de datos
        String contrasenaAlmacenada = usuario.getContraseña();

        // Compara la contraseña proporcionada con la almacenada (usando el encoder)
        return passwordEncoder.matches(contrasena, contrasenaAlmacenada);
    }
}
