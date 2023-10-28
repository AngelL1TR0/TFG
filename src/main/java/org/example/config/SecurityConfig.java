package org.example.config;

import org.example.dao.UsuarioDAO;
import org.example.entities.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
    public class SecurityConfig {
    private final UsuarioDAO usuarioDAO;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UsuarioDAO usuarioDAO, PasswordEncoder passwordEncoder) {
        this.usuarioDAO = usuarioDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Usuario usuario = usuarioDAO.findByNombre(username);

            if (usuario == null) {
                throw new UsernameNotFoundException("Usuario no encontrado: " + username);
            }

            // Verifica la contraseña proporcionada por el usuario con la contraseña almacenada en la base de datos
            String contrasenaAlmacenada = usuario.getContraseña();

            /*
            TODO implementar el metodo para compribar las contraseñas
            // La contraseña proporcionada debe coincidir con la contraseña almacenada
            if (!passwordEncoder.matches(contrasenaProporcionada, contrasenaAlmacenada)) {
                throw new UsernameNotFoundException("Contraseña incorrecta para el usuario: " + username);
            }

             */

            // En este punto, la autenticación es exitosa
            return (UserDetails) usuario;
        };
    }
}