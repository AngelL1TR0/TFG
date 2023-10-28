package org.example.dao;

import org.example.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {


}
