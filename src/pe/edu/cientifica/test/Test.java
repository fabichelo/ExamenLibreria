/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pe.edu.cientifica.test;

import pe.edu.cientifica.config.Conexion;

public class Test {
//private Gson gson = new Gson();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         if(Conexion.getConexion()!=null){
            System.out.println("Conectado");
        }else{
            System.out.println("no esta conectado");
        }
       //LibroDaoImp cdi =  new LibroDaoImp();
        //System.out.println(cdi.readAll3()); 
    }
    
}
