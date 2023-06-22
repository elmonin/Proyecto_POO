/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_poo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//hola que se dice
/**
 *
 * @author Juan Camilo
 */
public class Conexion {

    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/bd_proyecto";
    private final String usuario = "root";
    private final String contrasenia = "";
    private Connection conexion;

    public boolean getConexion() {
        try {
            Class.forName(driver);
            conexion = (Connection) DriverManager.getConnection(url, usuario, contrasenia);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int agregarPersona(Persona unaPersona) {
        int filasAfectadas = 0;
        try {
            PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO persona VALUES (?, ?, ?, ?, ?, ?, ?, 1)");
            sentencia.setString(1, unaPersona.getP_cedula());
            sentencia.setString(2, unaPersona.getP_nombre());
            sentencia.setString(3, unaPersona.getP_apellidos());
            sentencia.setString(4, unaPersona.getP_direccion());
            sentencia.setString(5, unaPersona.getP_email());
            sentencia.setString(6, unaPersona.getP_celular());
            sentencia.setString(7, unaPersona.getP_contraseña());
            filasAfectadas = sentencia.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return filasAfectadas;
    }

    public String verificarUsuario(String celular, String contrasenia) {
        String tipoUsuario = "";
        ResultSet rs = null;
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM persona p INNER JOIN administrador a ON p.p_celular = a.a_celular WHERE p.p_celular = ? AND p.p_contrasenia = ?");
            sentencia.setString(1, celular);
            sentencia.setString(2, contrasenia);
            rs = sentencia.executeQuery();
            if (rs.next()) {
                tipoUsuario = "ADMINISTRADOR";
            } else {
                sentencia = conexion.prepareStatement("SELECT * FROM persona p INNER JOIN cliente c ON p.p_celular = c.c_celular WHERE p.p_celular = ? AND p.p_contrasenia = ?");
                sentencia.setString(1, celular);
            sentencia.setString(2, contrasenia);
                rs = sentencia.executeQuery();
                if (rs.next()) {
                        tipoUsuario = "CLIENTE";
                }else{
                    tipoUsuario = "NO_EXISTE";
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tipoUsuario;
    }
    
    public Object[][] getTablaPersonas(){
        Object[][] arrayPersona = null;
        ResultSet rs = null;
        try {
            PreparedStatement sentencia = conexion.prepareCall("SELECT * FROM persona");
            rs = sentencia.executeQuery();
            rs.last();
            int filas = rs.getRow();
            if (filas > 0) {
                arrayPersona = new Object[filas][8];
                rs.first();
                int poscion = 0;
                do {
                    arrayPersona[poscion][0] = rs.getString(1);
                    arrayPersona[poscion][1] = rs.getString(2);
                    arrayPersona[poscion][2] = rs.getString(3);
                    arrayPersona[poscion][3] = rs.getString(4);
                    arrayPersona[poscion][4] = rs.getString(5);
                    arrayPersona[poscion][5] = rs.getString(6);
                    arrayPersona[poscion][6] = rs.getString(7);
                    arrayPersona[poscion][7] = rs.getString(8);
                    poscion++;
                } while (rs.next());  
            }else {
                arrayPersona = null;
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return arrayPersona;
    }
    
    public int actualizarPersona(Persona unPersona){
        int filasAfectadas = 0;
        try {
            PreparedStatement sentencia = conexion.prepareCall("UPDATE persona SET p_cedula=?, p_nombre=?, p_apellidos=?, p_direccion=?, p_email=?,p_contrasenia=?,p_estado=? WHERE p_celular=?");
            sentencia.setString(1, unPersona.getP_cedula());
            sentencia.setString(2, unPersona.getP_nombre());
            sentencia.setString(3, unPersona.getP_apellidos());
            sentencia.setString(4, unPersona.getP_direccion());
            sentencia.setString(5, unPersona.getP_email());
            sentencia.setString(6, unPersona.getP_contraseña());
            sentencia.setString(7, unPersona.getP_estado());
            sentencia.setString(8, unPersona.getP_celular());
            filasAfectadas = sentencia.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return filasAfectadas;
    }
    
}
