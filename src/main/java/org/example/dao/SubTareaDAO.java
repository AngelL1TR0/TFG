package org.example.dao;

import org.example.entities.SubTarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTareaDAO extends JpaRepository <SubTarea, Integer> {
}
