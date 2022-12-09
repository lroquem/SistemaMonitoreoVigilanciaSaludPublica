package com.sistemamonitoreovigilanciasaludpublica.pe;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionPool {   
    private final String DB="w4dWH3DJs3";
    private final String URL="jdbc:mysql://sql.freedb.tech:3306/"+DB+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";;
    private final String USER="freedb_mquinam";
    private final String PASS="PfV2j?HGm56JJW%";
    
    public DataSource dataSource=null;
    
    public ConnectionPool(){

        inicializaDataSource();

    }

    /**
     * Metodo en el cual inicializamos un objeto que nos va a permitir establecer las respectivas conexiones con la base de datos.
     */
    private void inicializaDataSource() {

        try{

            BasicDataSource basicDataSource = new BasicDataSource();

            basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            basicDataSource.setUsername(USER);
            basicDataSource.setPassword(PASS);
            basicDataSource.setUrl(URL);
            basicDataSource.setMaxTotal(50);

            dataSource = basicDataSource;

            System.out.println("Conexion exitosa");
            
        }catch(Exception ex){
            System.out.println("error "+ex.getMessage());
        }

    } 
}
