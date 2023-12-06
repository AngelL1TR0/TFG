package org.example.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entities.SubTarea;
import org.example.entities.Tarea;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubTareaDto implements Serializable {


    private Long id;

    private String nombre;

    private Date fechaInicio;

    private String prioridad;

    private String ubicacion;

    private String descripcion;

    private boolean completada;

    private Tarea tarea;

    public static SubTareaDto toDto(SubTarea subTarea) {
        return new SubTareaDto(
                subTarea.getId(),
                subTarea.getNombre(),
                subTarea.getFechaInicio(),
                subTarea.getPrioridad(),
                subTarea.getUbicacion(),
                subTarea.getDescripcion(),
                subTarea.isCompletada(),
                subTarea.getTarea()
        );
    }

    public static SubTarea toEntity(SubTareaDto dto) {
        return new SubTarea(
                dto.getId(),
                dto.getNombre(),
                dto.getFechaInicio(),
                dto.getPrioridad(),
                dto.getUbicacion(),
                dto.getDescripcion(),
                dto.isCompletada(),
                dto.getTarea()
        );
    }
}
