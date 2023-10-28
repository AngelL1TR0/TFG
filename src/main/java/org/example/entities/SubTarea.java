package org.example.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subtarea")
public class SubTarea implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_inicio")
    private Date fecha_inicio;

    @Column(name = "prioridad")
    private String prioridad;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "completada")
    private boolean completada;

    @Column(name = "id_tarea")
    private Tarea tarea;

}
