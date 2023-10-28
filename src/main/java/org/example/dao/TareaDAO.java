package org.example.dao;

import org.example.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaDAO extends JpaRepository<Tarea, Integer> {
}
