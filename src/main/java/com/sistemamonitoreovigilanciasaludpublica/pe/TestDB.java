package com.sistemamonitoreovigilanciasaludpublica.pe;

public class TestDB {
    public static void main(String[] args) {
        //ConnectionDefault conectar = new ConnectionDefault();
        //ConexionPool conectar = new ConexionPool();  
        //conectar.dataSource.getConnection();
        //conectar.openConnection();
        
        /*Department dep = new Department();
        dep.setName("Lima");*/
        
        
        
        MortalityRateDAO mortalityRateDAO = new MortalityRateDAO();
        mortalityRateDAO.all().forEach(System.out::println);
        
      
        
        
        
    }
}
