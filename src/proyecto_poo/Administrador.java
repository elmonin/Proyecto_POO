/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_poo;

import java.sql.Date;

/**
 *
 * @author Juan Camilo
 */
public class Administrador{
    private Date fechaUltimoLogin;

    public Administrador() {
    }

    public Administrador(Date fechaUltimoLogin) {
        this.fechaUltimoLogin = fechaUltimoLogin;
    }

    public Date getFechaUltimoLogin() {
        return fechaUltimoLogin;
    }

    public void setFechaUltimoLogin(Date fechaUltimoLogin) {
        this.fechaUltimoLogin = fechaUltimoLogin;
    }
    
    
}
