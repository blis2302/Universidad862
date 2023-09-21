/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad86;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import universidad86.AccesoADatos.AlumnoData;
import universidad86.AccesoADatos.Conexion;
import universidad86.entidades.Alumno;

/**
 *
 * @author dea
 */
public class Universidad86 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection con=Conexion.getConexion();
        Alumno juan= new Alumno(238421221,"Lopez","Juan",LocalDate.of(2000, 5, 7),true);
        AlumnoData alu= new AlumnoData();
        alu.guardarAlumno(juan);
    }
    
}
