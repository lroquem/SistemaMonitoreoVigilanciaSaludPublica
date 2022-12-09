package com.sistemamonitoreovigilanciasaludpublica.pe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDefault {
    private final String DB="freedb_health_data";
    private final String URL="jdbc:mysql://sql.freedb.tech:3306/"+DB+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";;
    private final String USER="freedb_mquinam";
    private final String PASS="PfV2j?HGm56JJW%";
    
    public void openConnection() {
        
        Connection connect = null;
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect=(Connection) DriverManager.getConnection(URL,USER,PASS);
            
            if(connect!=null){
                System.out.println("Conexión exitosa");            
            }else{
                System.out.println("Conexión Fallida");            
            }
            
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("error "+ex.getMessage());
        }
        
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
