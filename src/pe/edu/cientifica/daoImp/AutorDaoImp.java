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
import pe.edu.cientifica.model.Autor;
/**
 *
 * @author Alumno
 */
public class AutorDaoImp implements Operaciones<Autor>{
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;

    @Override
    
    public int create(Autor t) {
        String SQL = "INSERT INTO autor (nombres, apellidos) VALUES(?,?)";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps  = cx.prepareStatement(SQL);
            ps.setString(1, t.getNombres());
            ps.setString(2, t.getApellidos());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int update(Autor t) {
        String SQL = "UPDATE autor SET nombres=?, apellidos=? WHERE idautor=?";
        int x = 0;
        try{
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, t.getNombres());
            ps.setString(2, t.getApellidos());
            ps.setInt(3, t.getIdautor());
            x= ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM autor WHERE idautor=?";
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
    public Autor read(int id) {
        String SQL = "select *from autor where idautor=?";
        Autor au = new Autor();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                au.setIdautor(rs.getInt("idautor"));
                au.setNombres(rs.getString("nombres"));
                au.setApellidos(rs.getString("apellidos"));            
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return au;
    }

    @Override
    public List<Autor> readAll() {
        String SQL = "SELECT *FROM autor";
        List<Autor> lista = new ArrayList<>();
        try{
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs= ps.executeQuery();
            while(rs.next()){
                lista.add(new Autor(rs.getInt(1),rs.getString(2),rs.getString(3)));
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
