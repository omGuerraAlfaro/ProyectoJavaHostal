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
public class Usuario {

    private int idUsuario;
    private String clave;
    private int emp;

    public Usuario() {
    }

    public Usuario(int idUsuario, String clave, int emp) {
        this.idUsuario = idUsuario;
        this.clave = clave;
        this.emp = emp;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getEmp() {
        return emp;
    }

    public void setEmp(int emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", clave=" + clave + ", emp=" + emp + '}';
    }

}
