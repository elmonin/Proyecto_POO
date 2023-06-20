/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_poo;

/**
 *
 * @author Juan Camilo
 */
public class Persona {
    private String p_cedula;
    private String p_nombre;
    private String p_apellidos;
    private String p_direccion;
    private String p_email;
    private String p_celular;
    private String p_contraseña;
    private String p_estado;

    public Persona() {
    }

    public Persona(String p_cedula, String p_nombre, String p_apellidos, String p_direccion, String p_email, String p_celular, String p_contraseña, String p_estado) {
        this.p_cedula = p_cedula;
        this.p_nombre = p_nombre;
        this.p_apellidos = p_apellidos;
        this.p_direccion = p_direccion;
        this.p_email = p_email;
        this.p_celular = p_celular;
        this.p_contraseña = p_contraseña;
        this.p_estado = p_estado;
    }

    public String getP_cedula() {
        return p_cedula;
    }

    public void setP_cedula(String p_cedula) {
        this.p_cedula = p_cedula;
    }

    public String getP_nombre() {
        return p_nombre;
    }

    public void setP_nombre(String p_nombre) {
        this.p_nombre = p_nombre;
    }

    public String getP_apellidos() {
        return p_apellidos;
    }

    public void setP_apellidos(String p_apellidos) {
        this.p_apellidos = p_apellidos;
    }

    public String getP_direccion() {
        return p_direccion;
    }

    public void setP_direccion(String p_direccion) {
        this.p_direccion = p_direccion;
    }

    public String getP_email() {
        return p_email;
    }

    public void setP_email(String p_email) {
        this.p_email = p_email;
    }

    public String getP_celular() {
        return p_celular;
    }

    public void setP_celular(String p_celular) {
        this.p_celular = p_celular;
    }

    public String getP_contraseña() {
        return p_contraseña;
    }

    public void setP_contraseña(String p_contraseña) {
        this.p_contraseña = p_contraseña;
    }

    public String getP_estado() {
        return p_estado;
    }

    public void setP_estado(String p_estado) {
        this.p_estado = p_estado;
    }
    
    
}
