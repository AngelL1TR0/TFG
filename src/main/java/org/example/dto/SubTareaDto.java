package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entities.SubTarea;
import org.example.entities.Tarea;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubTareaDto implements Serializable {

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
    private Tarea tarea;

    public static SubTareaDto toDto(SubTarea subTarea) {
        return new SubTareaDto(
                subTarea.getId(),
                subTarea.getNombre(),
                subTarea.getFecha_inicio(),
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
                dto.getFecha_inicio(),
                dto.getPrioridad(),
                dto.getUbicacion(),
                dto.getDescripcion(),
                dto.isCompletada(),
                dto.getTarea()
        );
    }
}
