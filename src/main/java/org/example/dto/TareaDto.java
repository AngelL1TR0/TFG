package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entities.Tarea;
import org.example.entities.Usuario;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaDto implements Serializable {

    @NotNull
    @Min(1)
    private Long id;

    @NotBlank
    private String nombre;

    @NotNull
    private Date fecha_inicio;

    @NotBlank
    private String prioridad;

    @NotBlank
    private String ubicacion;

    @NotBlank
    private String descripcion;

    private boolean completada;

    @NotNull
    private Usuario usuario;

    public static TareaDto toDto(Tarea tarea) {
        return new TareaDto(
                tarea.getId(),
                tarea.getNombre(),
                tarea.getFecha_inicio(),
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
                dto.getFecha_inicio(),
                dto.getPrioridad(),
                dto.getUbicacion(),
                dto.getDescripcion(),
                dto.isCompletada(),
                dto.getUsuario()
        );
    }
}

