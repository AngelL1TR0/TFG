package org.example.service;

import org.example.dao.SubTareaDAO;
import org.example.entities.SubTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class SubTareaService {

    Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private SubTareaDAO subTareaDAO;

    public Optional<SubTarea> getById(Long id) {
        logger.info("Getting subTask by id: " + id);
        return subTareaDAO.findById(Math.toIntExact(id));
    }

    public List<SubTarea> getAll() {
        logger.info("Getting all subTasks");
        return subTareaDAO.findAll();
    }

    public void addSubTarea(SubTarea subTarea) {
        logger.info("Adding subTask: " + subTarea);
        subTareaDAO.save(subTarea);
    }

    public void updateSubTarea(SubTarea subTarea) {
        logger.info("Updating subTask: " + subTarea);
        subTareaDAO.save(subTarea);
    }

    public void deleteSubTarea(Long id) {
        logger.info("Deleting subTask by id: " + id);
        subTareaDAO.deleteById(Math.toIntExact(id));
    }
}
