/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.cientifica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Alumno
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
    private int idlibro;
    private String titulo;
    private String npaginas;
    private String edicion;
    private String fecha_publicacion;
    private int ididioma;
    private int ideditorial;
    private int idautor;
}
