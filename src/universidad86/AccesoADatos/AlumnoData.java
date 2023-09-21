/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad86.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidad86.entidades.Alumno;

/**
 *
 * @author HP
 */
public class AlumnoData {
    private Connection con=null;
    
    public AlumnoData(){
        con=Conexion.getConexion();
    }
    
    public void guardarAlumno(Alumno alumno){
        String sql= "INSERT INTO alumno(dni,apellido,nombre,fechad,estado) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaD()));
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno añadido con exito");  
            }
            ps.close(); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno"+ex.getMessage());
        }
    }
    public Alumno buscarAlumno (int id){
        Alumno alumno=null;
        String sql= "SELECT dni, apellido, nombre, fechad FROM alumno WHERE idAlumno = ? AND estado = 1";
        PreparedStatement ps=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                alumno= new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaD(rs.getDate("fechaD").toLocalDate());
                alumno.setEstado(true);
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe el alumno");
                ps.close();
            }
            
        }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno"+ex.getMessage());
                    }
        return alumno;
    }
    public Alumno buscarAlumnoPorDni (int dni){
        Alumno alumno=null;
        String sql= "SELECT dni, apellido, nombre, fechad FROM alumno WHERE dni = ? AND estado = 1";
        PreparedStatement ps=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                alumno= new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                //Por que rs.getInt
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaD(rs.getDate("fechaD").toLocalDate());
                alumno.setEstado(true);
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe el alumno");
                ps.close();
            }
            
        }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno"+ex.getMessage());
                    }
        return alumno;
    }
    public List<Alumno> listarAlumnos(){
        List <Alumno> alumnos=new ArrayList<>();
    try{
    String sql = "SELECT * FROM alumno WHERE estado=1";
    PreparedStatement ps= con.prepareStatement(sql);
    ResultSet rs= ps.executeQuery();
    while (rs.next()){
        Alumno alumno= new Alumno();
         alumno.setIdAlumno(rs.getInt("idAlumno"));
                //Por que rs.getInt
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaD(rs.getDate("fechaD").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                alumnos.add(alumno);
    }
    ps.close();
}catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno"+ex.getMessage());
                    }
        return alumnos;
    }
    public void modificarAlumno(Alumno alumno){
        String sql="UPDATE alumno SET dni=?,apellido=?,nombre=?,fechaD=? WHERE idAlumno=?";
        PreparedStatement ps=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaD()));
            ps.setInt(5, alumno.getIdAlumno());
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Modicado");
            }else{
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Eror al acceder a la tabla Alumno"+ex.getMessage());
        }
    }
    public void eliminarAlumno(int id){
        try{
            String sql="UPDATE alumno SET estado=0 WHERE idAlumno=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila=ps.executeUpdate();
            if(fila==1){
               JOptionPane.showMessageDialog(null, "Se elimino el alumno"); 
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Eror al acceder a la tabla Alumno");
        }
    }
}
