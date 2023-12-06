package org.example.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entities.Tarea;
import org.example.entities.Usuario;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaDto implements Serializable {


    private Long id;

    private String nombre;

    private Date fechaInicio;

    private String prioridad;

    private String ubicacion;

    private String descripcion;

    private boolean completada;

    private Usuario usuario;

    public static TareaDto toDto(Tarea tarea) {
        return new TareaDto(
                tarea.getId(),
                tarea.getNombre(),
                tarea.getFechaInicio(),
                tarea.getPrioridad(),
                tarea.getUbicacion(),
                tarea.getDescripcion(),
                tarea.isCompletada(),
                tarea.getUsuario()
        );
    }

    public static Tarea toEntity(TareaDto dto) {
        return new Tarea(
                dto.getId(),
                dto.getNombre(),
                dto.getFechaInicio(),
                dto.getPrioridad(),
                dto.getUbicacion(),
                dto.getDescripcion(),
                dto.isCompletada(),
                dto.getUsuario()
        );
    }
}

