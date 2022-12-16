/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.cientifica.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pe.edu.cientifica.config.Conexion;
import pe.edu.cientifica.dao.Operaciones;
import pe.edu.cientifica.model.Idioma;

/**
 *
 * @author Alumno
 */
public class IdiomaDaoImp implements Operaciones<Idioma> {
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Idioma t) {
        String SQL = "INSERT INTO idioma (nombre) VALUES(?)";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps  = cx.prepareStatement(SQL);
            ps.setString(1, t.getNombre());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int update(Idioma t) {
        String SQL = "UPDATE idioma SET nombre=? WHERE ididioma=?";
        int x = 0;
        try{
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, t.getNombre());
            ps.setInt(2, t.getIdidioma());
            x= ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM idioma WHERE ididioma=?";
        int x=0;
        try{
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1,id);
            x=ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public Idioma read(int id) {
        String SQL = "SELECT *FROM idioma WHERE ididioma=?";
        Idioma c =  new Idioma();
        try{
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){ 
                c.setIdidioma(rs.getInt("ididioma"));
                c.setNombre(rs.getString("nombre"));
            }
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }
        return c;
    }

    @Override
    public List<Idioma> readAll() {
        String SQL = "SELECT *FROM idioma";
        List<Idioma> lista = new ArrayList<>();
        try{
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs= ps.executeQuery();
            while(rs.next()){
                Idioma c =  new Idioma();
                c.setIdidioma(rs.getInt("ididioma"));
                c.setNombre(rs.getString("nombre"));              
                lista.add(c);
            }
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }   
        return lista;
    }

    @Override
    public List<Map<String, Object>> readAll2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }
    
}
