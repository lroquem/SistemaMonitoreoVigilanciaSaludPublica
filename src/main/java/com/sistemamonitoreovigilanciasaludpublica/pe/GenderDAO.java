package com.sistemamonitoreovigilanciasaludpublica.pe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GenderDAO {

    ConnectionDefault cn = new ConnectionDefault();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean add(Gender gend) {
        String sql = "INSERT INTO genders(name) VALUES (?)";
        try {
            con = cn.openConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, gend.getName());
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

    public Gender searchByName(String name) {
        Gender gend = new Gender();
        String sql = "SELECT * FROM genders WHERE name = ?";
        try {
            con = cn.openConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                gend.setId(rs.getInt("id"));
                gend.setName(rs.getString("name"));
                gend.setCreatedAt(rs.getString("created_at"));
                gend.setUpdatedAt(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return gend;
    }

    public Gender searchById(Integer id) {
        Gender gend = new Gender();
        String sql = "SELECT * FROM genders WHERE id = ?";
        try {
            con = cn.openConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                gend.setId(rs.getInt("id"));
                gend.setName(rs.getString("name"));
                gend.setCreatedAt(rs.getString("created_at"));
                gend.setUpdatedAt(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return gend;
    }
    
    public List<Gender> all() {
        List<Gender> listGenders = new ArrayList<Gender>();
        String sql = "SELECT * FROM genders";
        try {
            con = cn.openConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Gender gender = new Gender();
                gender.setId(rs.getInt("id"));
                gender.setName(rs.getString("name"));
                gender.setCreatedAt(rs.getString("created_at"));
                gender.setUpdatedAt(rs.getString("updated_at"));
                
                listGenders.add(gender);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listGenders;
    }

}
