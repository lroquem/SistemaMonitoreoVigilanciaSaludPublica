package com.sistemamonitoreovigilanciasaludpublica.pe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DiseaseDAO {

    ConnectionDefault cn = new ConnectionDefault();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean add(Disease disease) {
        String sql = "INSERT INTO diseases(name) VALUES (?)";
        try {
            con = cn.openConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, disease.getName());
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public Disease searchByName(String name) {
        Disease disease = new Disease();
        String sql = "SELECT * FROM diseases WHERE name = ?";
        try {
            con = cn.openConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                disease.setId(rs.getInt("id"));
                disease.setName(rs.getString("name"));
                disease.setCreatedAt(rs.getString("created_at"));
                disease.setUpdatedAt(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return disease;
    }

    public Disease searchById(Integer id) {
        Disease disease = new Disease();
        String sql = "SELECT * FROM diseases WHERE id = ?";
        try {
            con = cn.openConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                disease.setId(rs.getInt("id"));
                disease.setName(rs.getString("name"));
                disease.setCreatedAt(rs.getString("created_at"));
                disease.setUpdatedAt(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return disease;
    }
    
    public List<Disease> all() {
        List<Disease> listDiseases = new ArrayList<Disease>();
        String sql = "SELECT * FROM diseases";
        try {
            con = cn.openConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Disease disease = new Disease();
                disease.setId(rs.getInt("id"));
                disease.setName(rs.getString("name"));
                disease.setCreatedAt(rs.getString("created_at"));
                disease.setUpdatedAt(rs.getString("updated_at"));
                
                listDiseases.add(disease);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listDiseases;
    }

}
