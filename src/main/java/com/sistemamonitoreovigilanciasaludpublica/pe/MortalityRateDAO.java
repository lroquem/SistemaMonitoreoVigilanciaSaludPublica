package com.sistemamonitoreovigilanciasaludpublica.pe;
// POR FALTA DE ACCESO A LA DDBB SE USARA UN ARCHIVO CSV PARA LEER LOS DATOS
/*
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MortalityRateDAO {

    ConnectionDefault cn = new ConnectionDefault();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<MortalityRate> all() {
        List<MortalityRate> listMortalityRates = new ArrayList<MortalityRate>();
        //String sql = "SELECT * FROM mortality_rates";
        String sql = "SELECT * FROM mortality_rates "
                + "INNER JOIN departments ON mortality_rates.deparment_id = departments.id "
                + "INNER JOIN genders ON mortality_rates.gender_id = genders.id "
                + "INNER JOIN diseases ON mortality_rates.disease_id = diseases.id "
                + "ORDER BY mortality_rates.year, departments.name";
        try {
            con = cn.openConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MortalityRate mortalityRate = new MortalityRate();
                mortalityRate.setId(rs.getInt("id"));
                mortalityRate.setYear(rs.getInt("year"));
                mortalityRate.setDepartment(rs.getString("departments.name"));
                mortalityRate.setGender(rs.getString("genders.name"));
                mortalityRate.setDisease(rs.getString("diseases.name"));
                mortalityRate.setNumberDeath(rs.getInt("number_death"));
                mortalityRate.setGrossRate(rs.getFloat("gross_rate"));
                mortalityRate.setAdjusmentRate(rs.getFloat("adjusment_rate"));
                mortalityRate.setError(rs.getFloat("error"));
                mortalityRate.setLowerLimit(rs.getFloat("lower_limit"));
                mortalityRate.setUpperLimit(rs.getFloat("upper_limit"));
                mortalityRate.setCluster(rs.getInt("cluster"));
                mortalityRate.setCreatedAt(rs.getString("created_at"));
                mortalityRate.setUpdatedAt(rs.getString("updated_at"));

                listMortalityRates.add(mortalityRate);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listMortalityRates;
    }
}
*/

// EMPEZAMOS CON LA LECTURA DE DATOS DESDE CSV

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MortalityRateDAO{
    public List<MortalityRate> all(){
        List<MortalityRate> listMortalityRates = new ArrayList<>();
        // Cargar el archivo
        File file = new File("D:\\eclipse-workspace\\SistemaMonitoreoVigilanciaSaludPublica\\doc\\data.csv");
        try {
            Scanner inputStream = new Scanner(file);
            // Leer cada linea
            // Cada linea tiene 11 campos
            String data = inputStream.next();
            while(inputStream.hasNext()){
                data = inputStream.next();
                
                // Separar campos
                String[] values = data.split(",");
                for (String value : values) {
                    System.out.println(value+"******");
                }
                
                MortalityRate mortalityRate = new MortalityRate();
                mortalityRate.setYear(Integer.parseInt(values[0]));
                mortalityRate.setDepartment(values[1]);
                mortalityRate.setGender(values[2]);
                mortalityRate.setDisease(values[3]);
                mortalityRate.setNumberDeath(Integer.parseInt(values[4]));
                mortalityRate.setGrossRate(Float.parseFloat(values[5]));
                mortalityRate.setAdjusmentRate(Float.parseFloat(values[6]));
                mortalityRate.setError(Float.parseFloat(values[7]));
                mortalityRate.setLowerLimit(Float.parseFloat(values[8]));
                mortalityRate.setUpperLimit(Float.parseFloat(values[9]));
                mortalityRate.setCluster(Integer.parseInt(values[10]));
                
                listMortalityRates.add(mortalityRate);
                
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
        }
        
        return listMortalityRates;
    }
}