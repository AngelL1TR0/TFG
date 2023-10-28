package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entities.Usuario;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto implements Serializable {

    @NotNull
    @Positive
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String email;

    @NotBlank
    private String contraseña;

    public static UsuarioDto toDto(Usuario usuario){
        return new UsuarioDto(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getContraseña()
        );
    }

    public static Usuario toEntity (UsuarioDto dto){
        return new Usuario(
                dto.getId(),
                dto.getNombre(),
                dto.getEmail(),
                dto.getContraseña()
        );
    }
}
