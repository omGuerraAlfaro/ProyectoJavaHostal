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
public class Pasajero {

    private String rutPas;
    private String nombrePas;
    private String apellidoPas;    
    private String telefonoPas;
    private String genero;
    private String correoPas;
    private int codhab;
   

    public Pasajero() {
    }

    public Pasajero(String rutPas, String nombrePas, String apellidoPas, String telefonoPas, String genero, String correoPas, int codhab) {
        this.rutPas = rutPas;
        this.nombrePas = nombrePas;
        this.apellidoPas = apellidoPas;
        this.telefonoPas = telefonoPas;
        this.genero = genero;
        this.correoPas = correoPas;
        this.codhab = codhab;
    }

    public String getRutPas() {
        return rutPas;
    }

    public void setRutPas(String rutPas) {
        this.rutPas = rutPas;
    }

    public String getNombrePas() {
        return nombrePas;
    }

    public void setNombrePas(String nombrePas) {
        this.nombrePas = nombrePas;
    }

    public String getApellidoPas() {
        return apellidoPas;
    }

    public void setApellidoPas(String apellidoPas) {
        this.apellidoPas = apellidoPas;
    }

    public String getTelefonoPas() {
        return telefonoPas;
    }

    public void setTelefonoPas(String telefonoPas) {
        this.telefonoPas = telefonoPas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreoPas() {
        return correoPas;
    }

    public void setCorreoPas(String correoPas) {
        this.correoPas = correoPas;
    }

    public int getCodhab() {
        return codhab;
    }

    public void setCodhab(int codhab) {
        this.codhab = codhab;
    }

    @Override
    public String toString() {
        return "Pasajero{" + "rutPas=" + rutPas + ", nombrePas=" + nombrePas + ", apellidoPas=" + apellidoPas + ", telefonoPas=" + telefonoPas + ", genero=" + genero + ", correoPas=" + correoPas + ", codhab=" + codhab + '}';
    }

    

}
