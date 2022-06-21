/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Habitacion;
import modelo.Pasajero;
import java.sql.Types;


/**
 *
 * @author OmarGuerra and Mauricio Chacana
 */
public class Registro {

    public Registro() {
    }

    //agregar producto
    public boolean iniciarSesion(String Rut, String contrasena) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT  emp.rutEmp, user.clave from empleado emp join usuario user on emp.idUsuario=user.idUsuario";
            PreparedStatement stmt = cnx.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                if ((Rut.equalsIgnoreCase(rs.getString(1))) & (contrasena.equalsIgnoreCase(rs.getString(2)))) {
                    return true;
                }
            }
            rs.close();
            stmt.close();
            cnx.close();

            return false;
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar Habitación" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar Habitación" + e.getMessage());
            return false;
        }
    }

    public boolean agregarHabitacion(Habitacion hab) {
        Date checkIn, checkOut;
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "INSERT INTO producto(codHabitacion, valor, estado, chek_in, check_out, tipoAlojamiento, rutPas) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, hab.getCodHabitacion());
            stmt.setInt(2, hab.getValor());
            stmt.setString(3, hab.getEstado());
            checkIn = hab.getChek_in();
            stmt.setDate(4, new java.sql.Date(checkIn.getTime())); //actual
            checkOut = hab.getChek_out();
            stmt.setDate(5, new java.sql.Date(checkOut.getTime())); //hasta cuando
            stmt.setString(6, hab.getTipoAlojamiento());
            stmt.setInt(7, hab.getRutPas());

            stmt.executeUpdate();//insert
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar Habitación" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar Habitación" + e.getMessage());
            return false;
        }
    }

    public List<Habitacion> buscarTodos() {
        List<Habitacion> lista = new ArrayList<>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT * FROM habitacion order by codHabitacion";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Habitacion hab = new Habitacion();
                hab.setCodHabitacion(rs.getInt("codHabitacion"));
                hab.setValor(rs.getInt("valor"));
                hab.setEstado(rs.getString("estado"));
                hab.setChek_in(rs.getDate("chek_in"));
                hab.setChek_out(rs.getDate("check_out"));
                hab.setTipoAlojamiento(rs.getString("tipoAlojamiento"));
                hab.setRutPas(rs.getInt("rutPas"));

                lista.add(hab);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar habitaciones " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar habitaciones " + e.getMessage());
        }
        return lista;
    }

    //Buscar Por Estado
    public List<Habitacion> buscarPorEstado(String estado) {
        List<Habitacion> lista = new ArrayList<>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT * FROM habitacion WHERE estado = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, estado);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Habitacion hab = new Habitacion();
                hab.setCodHabitacion(rs.getInt("codHabitacion"));
                hab.setValor(rs.getInt("valor"));
                hab.setEstado(rs.getString("estado"));
                hab.setChek_in(rs.getDate("chek_in"));
                hab.setChek_out(rs.getDate("check_out"));
                hab.setTipoAlojamiento(rs.getString("tipoAlojamiento"));
                hab.setRutPas(rs.getInt("rutPas"));
                lista.add(hab);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar habitaciones por estado " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar habitaciones por estado " + e.getMessage());
        }
        return lista;
    }

    //Metodo Cargar Habitacion
    public List<Habitacion> cargarHabitacion(String estado) {
        List<Habitacion> lista = new ArrayList<>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT * FROM habitacion WHERE codHabitacion = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, estado);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Habitacion hab = new Habitacion();
                hab.setValor(rs.getInt("valor"));
                hab.setTipoAlojamiento(rs.getString("tipoAlojamiento"));
                lista.add(hab);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar habitaciones por estado " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar habitaciones por estado " + e.getMessage());
        }
        return lista;
    }

    //Metodo Buscar Pasajero
    public boolean buscarPasajero(String estado) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT * FROM pasajero WHERE rutPas = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, estado);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar habitaciones por estado " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar habitaciones por estado " + e.getMessage());
        }
        return false;
    }

    //Metodo Ingresar Pasajero
    public boolean ingresarPasajero(Pasajero vis, Date checkin, Date checkout, String num) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cn = conexion1.obtenerConexion();

            String query = "INSERT INTO pasajero(rutPas, nombrePas, apellidoPas, telefonoPas, genero, correoPas, codHabitacion) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = cn.prepareStatement(query);
            stmt.setString(1, vis.getRutPas());
            stmt.setString(2, vis.getNombrePas());
            stmt.setString(3, vis.getApellidoPas());
            stmt.setString(4, vis.getTelefonoPas());
            stmt.setString(5, vis.getGenero());
            stmt.setString(6, vis.getCorreoPas());
            stmt.setInt(7, vis.getCodhab());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error SQL al listar habitaciones por estado " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar habitaciones por estado " + e.getMessage());
        }
        try {
            Conexion conexion1 = new Conexion();
            Connection cn = conexion1.obtenerConexion();
            String query2 = "UPDATE habitacion SET estado = 'Ocupado' ,chek_in = ? , check_out = ? , rutPas =? WHERE codHabitacion = ?";
            PreparedStatement stmt2 = cn.prepareStatement(query2);
            stmt2.setDate(1, new java.sql.Date(checkin.getTime()));
            stmt2.setDate(2, new java.sql.Date(checkout.getTime()));
            stmt2.setString(3, vis.getRutPas());
            stmt2.setInt(4, vis.getCodhab());
            stmt2.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error SQL al listar habitaciones por estado " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al listar habitaciones por estado " + e.getMessage());
            return false;

        }

        return true;
    }

    public boolean eliminarHabitacionOcupada(int codHab) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "DELETE FROM habitacion WHERE codHabitacion=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, codHab);
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error SQL al eliminar habitación" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al eliminar habitación" + e.getMessage());
            return false;
        }
    }

    public boolean eliminarHabitacionDisponible(int codHab, String rut) {

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "DELETE FROM habitacion WHERE codHabitacion=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, codHab);
            stmt.executeUpdate();
            stmt.close();

            String query2 = "DELETE FROM pasajero WHERE rutPas=?";
            PreparedStatement stmt2 = cnx.prepareStatement(query);
            stmt2.setString(1, rut);
            stmt2.executeUpdate();
            stmt2.close();

            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al eliminar habitación" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al eliminar habitación" + e.getMessage());
            return false;
        }
    }

    public boolean buscarHabitacion(int codHab) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT * FROM habitacion WHERE codHabitacion = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, codHab);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar habitaciones por estado " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar habitaciones por estado " + e.getMessage());
        }
        return false;
    }

    public boolean ingresarHabitacion(int codHab, String valor, String tipo) {

        try {
            Conexion conexion1 = new Conexion();
            Connection cn = conexion1.obtenerConexion();

            String query = "INSERT INTO Habitacion(codHabitacion, valor, estado, chek_in, check_out, tipoAlojamiento, rutPas) VALUES (?,?,'Disponible','1970-01-01','1970-01-01',?,?)";
            PreparedStatement stmt = cn.prepareStatement(query);
            stmt.setInt(1, codHab);
            stmt.setString(2, valor);
            stmt.setString(3, tipo);
            stmt.setNull(4, Types.VARCHAR );
            
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al listar habitaciones por estado " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al listar habitaciones por estado " + e.getMessage());
            return false;

        }
    }
    public void actualizarPrecioHab(int valor, int codHab) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "UPDATE habitacion SET valor = ? WHERE codHabitacion = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, valor);
            stmt.setInt(2, codHab);

            stmt.executeUpdate();
            
            stmt.close(); 
            cnx.close();
            
        } catch (SQLException e) {
            System.out.println("Error SQL al listar habitaciones por estado " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar habitaciones por estado " + e.getMessage());
        }

    }
            
}
