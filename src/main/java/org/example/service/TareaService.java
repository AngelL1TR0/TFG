package org.example.service;

import org.example.dao.TareaDAO;
import org.example.entities.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service

public class TareaService {

    Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private TareaDAO tareaDAO;

    public Optional<Tarea> getById(Long id) {
        logger.info("Getting task by id: " + id);
        return tareaDAO.findById(Math.toIntExact(id));
    }

    public List<Tarea> getAll() {
        logger.info("Getting all tasks");
        return tareaDAO.findAll();
    }

    public void addTarea(Tarea tarea) {
        logger.info("Adding task: " + tarea);
        tareaDAO.save(tarea);
    }

    public void updateTarea(Tarea tarea) {
        logger.info("Updating task: " + tarea);
        tareaDAO.save(tarea);
    }

    public void deleteTarea(Long id) {
        logger.info("Deleting task by id: " + id);
        tareaDAO.deleteById(Math.toIntExact(id));
    }
}
