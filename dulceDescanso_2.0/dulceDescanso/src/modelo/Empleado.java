/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author OmarGuerra and Mauricio Chacana
 */
public class Empleado {
    private int rutEmp;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String hostal;
    private int usu;

    public Empleado() {
    }

    public Empleado(int rutEmp, String nombre, String apellido, String telefono, String correo, String hostal, int usu) {
        this.rutEmp = rutEmp;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.hostal = hostal;
        this.usu = usu;
    }

    public int getRutEmp() {
        return rutEmp;
    }

    public void setRutEmp(int rutEmp) {
        this.rutEmp = rutEmp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getHostal() {
        return hostal;
    }

    public void setHostal(String hostal) {
        this.hostal = hostal;
    }

    public int getUsu() {
        return usu;
    }

    public void setUsu(int usu) {
        this.usu = usu;
    }

    @Override
    public String toString() {
        return "Empleado{" + "rutEmp=" + rutEmp + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", correo=" + correo + ", hostal=" + hostal + ", usu=" + usu + '}';
    }

    
    
   
    
}
