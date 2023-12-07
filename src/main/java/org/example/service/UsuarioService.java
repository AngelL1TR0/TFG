package org.example.service;

import org.example.dao.UsuarioDAO;
import org.example.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UsuarioService {

    Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean checkPassword(String username, String inputPassword) {
        Usuario usuario = usuarioDAO.findByNombre(username);

        if (usuario != null) {
            String savedPassword = usuario.getPass();
            logger.info("Password saved: " + savedPassword);

            if (passwordEncoder.matches(inputPassword, savedPassword)) {
                logger.info("Password match");
                return true;
            }
        }
        logger.info("Password does not match");
        return false;
    }

    public Optional<Usuario> getById(Long id) {
        logger.info("Getting user by id: " + id);
        return usuarioDAO.findById(Math.toIntExact(id));
    }

    public List<Usuario> getAll() {
        logger.info("Getting all users");
        return usuarioDAO.findAll();
    }

    public void addUsuario(Usuario usuario) {
        logger.info("Adding user: " + usuario);
        usuario.setPass(passwordEncoder.encode(usuario.getPass()));
        usuarioDAO.save(usuario);
    }

    public void updateUsuario(Usuario usuario) {
        logger.info("Updating user: " + usuario);
        usuarioDAO.save(usuario);
    }

    public void deleteUsuario(Long id) {
        logger.info("Deleting user by id: " + id);
        usuarioDAO.deleteById(Math.toIntExact(id));
    }
}