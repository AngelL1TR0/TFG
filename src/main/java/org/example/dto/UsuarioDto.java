package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entities.Usuario;


import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto implements Serializable {


    private Long id;

    private String nombre;

    private String email;

    private String pass;

    public static UsuarioDto toDto(Usuario usuario){
        return new UsuarioDto(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getPass()
        );
    }

    public static Usuario toEntity (UsuarioDto dto){
        return new Usuario(
                dto.getId(),
                dto.getNombre(),
                dto.getEmail(),
                dto.getPass()
        );
    }
}
