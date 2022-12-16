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
import pe.edu.cientifica.model.Libro;

/**
 *
 * @author Alumno
 */
public class LibroDaoImp implements Operaciones<Libro> {
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Libro t) {
        String SQL = "INSERT INTO libro (titulo, npaginas, edicion,fecha_publicacion,ididioma,ideditorial,idautor) VALUES(?,?,?,?,?,?,?)";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps  = cx.prepareStatement(SQL);
            ps.setString(1, t.getTitulo());
            ps.setString(2, t.getNpaginas());
            ps.setString(3, t.getEdicion());
            ps.setString(4, t.getFecha_publicacion());
            ps.setInt(5, t.getIdidioma());
            ps.setInt(6, t.getIdeditorial());
            ps.setInt(7, t.getIdautor());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int update(Libro t) {
        String SQL = "UPDATE libro SET titulo=?, npaginas=?, edicion=?, fecha_publicacion=?, ididioma=?, ideditorial=?, idautor=? WHERE idlibro=?";
        int x = 0;
        try{
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, t.getTitulo());
            ps.setString(2, t.getNpaginas());
            ps.setString(3, t.getEdicion());
            ps.setString(4, t.getFecha_publicacion());
            ps.setInt(5, t.getIdidioma());
            ps.setInt(6, t.getIdeditorial());
            ps.setInt(7, t.getIdautor());
            ps.setInt(8, t.getIdlibro());
            x= ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM libro WHERE idlibro=?";
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
    public Libro read(int id) {
        String SQL = "SELECT *FROM libro WHERE idlibro=?";
        Libro c =  new Libro();
        try{
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){ 
                c.setIdlibro(rs.getInt("idlibro"));
                c.setTitulo(rs.getString("titulo"));
                c.setNpaginas(rs.getString("npaginas"));
                c.setEdicion(rs.getString("edicion"));
                c.setFecha_publicacion(rs.getString("fecha_publicacion"));
                c.setIdidioma(rs.getInt("ididioma"));
                c.setIdeditorial(rs.getInt("ideditorial"));
                c.setIdautor(rs.getInt("idautor"));
                
            }
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }
        return c;
    }

    @Override
    public List<Libro> readAll() {
        String SQL = "SELECT *FROM libro";
        List<Libro> lista = new ArrayList<>();
        try{
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs= ps.executeQuery();
            while(rs.next()){
                Libro c =  new Libro();
                c.setIdlibro(rs.getInt("idlibro"));
                c.setTitulo(rs.getString("titulo"));
                c.setNpaginas(rs.getString("npaginas"));
                c.setEdicion(rs.getString("edicion"));
                c.setFecha_publicacion(rs.getString("fecha_publicacion"));
                c.setIdidioma(rs.getInt("ididioma"));
                c.setIdeditorial(rs.getInt("ideditorial"));
                c.setIdautor(rs.getInt("idautor"));
                lista.add(c);
            }
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }   
        return lista;
    }

    @Override
    public List<Map<String, Object>> readAll2() {
        String SQL = "SELECT c.ideditorial , c.nombre as editorial , c.direccion , c.email ,d.idlibro , d.titulo as libro ,d.npaginas , d.edicion , d.fecha_publicacion , d.ididioma , d.idautor FROM libro as d " +
                     "inner join editorial as c on d.ideditorial = c.ideditorial";
                
        List<Map<String, Object>> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Map<String, Object> map = new HashMap();
                map.put("ideditorial", rs.getInt("ideditorial"));
                map.put("editorial", rs.getString("editorial"));
                map.put("direccion", rs.getString("direccion"));
                map.put("email", rs.getString("email"));
                map.put("idlibro", rs.getInt("idlibro"));
                map.put("libro", rs.getString("libro"));
                map.put("npaginas", rs.getString("npaginas"));
                map.put("edicion", rs.getString("edicion"));
                map.put("fecha_publicacion", rs.getString("fecha_publicacion"));
                map.put("ididioma", rs.getString("ididioma"));
                map.put("idautor", rs.getString("idautor"));
                lista.add(map);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }
    public List<Map<String, Object>> readAll3() {
        String SQL ="SELECT c.ididioma , c.nombre as idioma , d.idlibro FROM libro as d "+
                    "inner join idioma as c on d.ididioma = c.ididioma";
        List<Map<String, Object>> lista2 = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Map<String, Object> map = new HashMap();
                map.put("ididioma", rs.getInt("ididioma"));
                map.put("idioma", rs.getString("idioma"));
                map.put("idlibro", rs.getInt("idlibro"));
                lista2.add(map);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista2; 
    }
    public List<Map<String, Object>> readAll4() {
        String SQL ="SELECT c.idautor , c.nombres as autor , c.apellidos , d.idlibro  FROM libro as d "+
                    "inner join autor as c on d.idautor = c.idautor ";
        List<Map<String, Object>> lista3 = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Map<String, Object> map = new HashMap();
                map.put("idautor", rs.getInt("idautor"));
                map.put("autor", rs.getString("autor"));
                map.put("apellidos", rs.getString("apellidos"));
                map.put("idlibro", rs.getInt("idlibro"));
                lista3.add(map);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista3; 
    }
}
