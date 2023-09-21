/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad86.entidades;

import java.time.LocalDate;

/**
 *
 * @author dea
 */
public class Alumno {
    private int idAlumno;
    private int dni;
    private String apellido;
    private String nombre;
    private LocalDate fechaD;
    private boolean estado;

    public Alumno() {
    }
    
    //no esta funcionandoo

    public Alumno(int idAlumno, int dni, String apellido, String nombre, LocalDate fechaD, boolean estado) {
        this.idAlumno = idAlumno;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaD = fechaD;
        this.estado = estado;
    }

    public Alumno(int dni, String apellido, String nombre, LocalDate fechaD, boolean estado) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaD = fechaD;
        this.estado = estado;
    }
    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
        System.out.println("holaa");
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaD() {
        return fechaD;
    }

    public void setFechaD(LocalDate fechaD) {
        this.fechaD = fechaD;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", fechaD=" + fechaD + ", estado=" + estado + '}';
    }
    
    
    //hola
    
}
