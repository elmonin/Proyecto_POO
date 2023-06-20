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
public class Cuenta {
    private String c_saldo;
    private String c_celular;

    public Cuenta() {
    }

    public Cuenta(String c_saldo, String c_celular) {
        this.c_saldo = c_saldo;
        this.c_celular = c_celular;
    }

    public String getC_saldo() {
        return c_saldo;
    }

    public void setC_saldo(String c_saldo) {
        this.c_saldo = c_saldo;
    }

    public String getC_celular() {
        return c_celular;
    }

    public void setC_celular(String c_celular) {
        this.c_celular = c_celular;
    }
    
    
}
