package org.example.dao;

import org.example.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaDAO extends JpaRepository<Tarea, Integer> {
}
