/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facam.app.com;



import javax.faces.bean.ManagedBean;
import org.hibernate.Session;

/**
 *
 * @author Helio
 */
@ManagedBean
public class ManagerBean {
    private String username;
    private String password;

    /**
     * @return the username
     */
    public String login(){
       
        
        Session session = UsuarioHibernate.getSessionFactory().openSession();
            org.hibernate.Query consulta = session.createQuery("from Usuario where" + " username = :username and password = :password");
            consulta.setString("username", username);
            consulta.setString("password", password);
            
                if(consulta.list()!=null&&consulta.list().size()==1){
                    System.out.println("Conectado");
                    return "Cadsucesso.xhtml";
                    
                }else{
                    System.out.println("Erro");
                     return null;
                }
            
           
    }
    
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
