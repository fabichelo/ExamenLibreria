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
public class Autor {
    private int idautor;
    private String nombres;
    private String apellidos;
    
    public String toString(){
        return this.nombres;
    }
}
