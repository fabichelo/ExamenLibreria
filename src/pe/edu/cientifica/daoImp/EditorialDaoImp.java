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
import pe.edu.cientifica.model.Editorial;

/**
 *
 * @author Alumno
 */
public class EditorialDaoImp implements Operaciones<Editorial> {
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    
    @Override
    public int create(Editorial t) {
        String SQL = "INSERT INTO editorial (nombre,direccion,email) VALUES(?,?,?)";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps  = cx.prepareStatement(SQL);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getDireccion());
            ps.setString(3, t.getEmail());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int update(Editorial t) {
        String SQL = "UPDATE editorial SET nombre=?, direccion=?, email=? WHERE ideditorial=?";
        int x = 0;
        try{
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getDireccion());
            ps.setString(3, t.getEmail());
            ps.setInt(4, t.getIdeditorial());
            x= ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM editorial WHERE ideditorial=?";
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
    public Editorial read(int id) {
        String SQL = "SELECT *FROM editorial WHERE ideditorial=?";
        Editorial c =  new Editorial();
        try{
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){ 
                c.setIdeditorial(rs.getInt("ideditorial"));
                c.setNombre(rs.getString("nombre"));
                c.setDireccion(rs.getString("direccion"));
                c.setEmail(rs.getString("email"));
            }
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }
        return c;
    }

    @Override
    public List<Editorial> readAll() {
    String SQL = "SELECT *FROM editorial";
        List<Editorial> lista = new ArrayList<>();
        try{
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs= ps.executeQuery();
            while(rs.next()){
                Editorial c =  new Editorial();
                c.setIdeditorial(rs.getInt("ideditorial"));
                c.setNombre(rs.getString("nombre"));
                c.setDireccion(rs.getString("direccion"));
                c.setEmail(rs.getString("email"));
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