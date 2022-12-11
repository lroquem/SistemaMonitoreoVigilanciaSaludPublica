package com.sistemamonitoreovigilanciasaludpublica.pe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDefault {
    /*private final String DB="freedb_health_data";
    private final String URL="jdbc:mysql://sql.freedb.tech:3306/"+DB+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";;
    private final String USER="freedb_mquinam";
    private final String PASS="PfV2j?HGm56JJW%";*/
    
    private final String DB="bd_health_data";
    private final String URL="jdbc:mysql://127.0.0.1/"+DB+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";;
    private final String USER="root";
    private final String PASS="";
 
    public Connection openConnection() {
        
        Connection connect = null;
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect=(Connection) DriverManager.getConnection(URL,USER,PASS);    
            System.out.println("Conexión exitosa");            
            return connect;
            
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("error "+ex.getMessage());
        }
        return null;
        
    }    
    
    
    public void closeConnection(Connection connect){
        try {
            connect.close();
            System.out.println("Conexión Cerrada Exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDefault.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
