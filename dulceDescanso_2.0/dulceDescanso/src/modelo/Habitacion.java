/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 @author OmarGuerra and Mauricio Chacana
 */
public class Habitacion {

    private int codHabitacion;
    private int valor;
    private String estado;
    private Date chek_in;
    private Date chek_out;
    private String tipoAlojamiento;
    private int rutPas;

    public Habitacion() {
    }

    public Habitacion(int codHabitacion, int valor, String estado, Date chek_in, Date chek_out, String tipoAlojamiento, int rutPas) {
        this.codHabitacion = codHabitacion;
        this.valor = valor;
        this.estado = estado;
        this.chek_in = chek_in;
        this.chek_out = chek_out;
        this.tipoAlojamiento = tipoAlojamiento;
        this.rutPas = rutPas;
    }

    public int getCodHabitacion() {
        return codHabitacion;
    }

    public void setCodHabitacion(int codHabitacion) {
        this.codHabitacion = codHabitacion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getChek_in() {
        return chek_in;
    }

    public void setChek_in(Date chek_in) {
        this.chek_in = chek_in;
    }

    public Date getChek_out() {
        return chek_out;
    }

    public void setChek_out(Date chek_out) {
        this.chek_out = chek_out;
    }

    public String getTipoAlojamiento() {
        return tipoAlojamiento;
    }

    public void setTipoAlojamiento(String tipoAlojamiento) {
        this.tipoAlojamiento = tipoAlojamiento;
    }

    public int getRutPas() {
        return rutPas;
    }

    public void setRutPas(int rutPas) {
        this.rutPas = rutPas;
    }


    @Override
    public String toString() {
        return "Habitacion{" + "codHabitacion=" + codHabitacion + ", valor=" + valor + ", estado=" + estado + ", chek_in=" + chek_in + ", chek_out=" + chek_out + ", tipoAlojamiento=" + tipoAlojamiento + ", vis=" + rutPas+ '}';
    }

    

}
