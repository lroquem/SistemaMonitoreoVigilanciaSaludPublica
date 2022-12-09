package com.sistemamonitoreovigilanciasaludpublica.pe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DepartmentDAO {

    ConnectionDefault cn = new ConnectionDefault();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean add(Department dep) {
        String sql = "INSERT INTO departments(name) VALUES (?)";
        try {
            con = cn.openConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dep.getName());
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

    public Department searchByName(String name) {
        Department dept = new Department();
        String sql = "SELECT * FROM departments WHERE name = ?";
        try {
            con = cn.openConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                dept.setId(rs.getInt("id"));
                dept.setName(rs.getString("name"));
                dept.setCreatedAt(rs.getString("created_at"));
                dept.setUpdatedAt(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return dept;
    }

    public Department searchById(Integer id) {
        Department dept = new Department();
        String sql = "SELECT * FROM departments WHERE id = ?";
        try {
            con = cn.openConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                dept.setId(rs.getInt("id"));
                dept.setName(rs.getString("name"));
                dept.setCreatedAt(rs.getString("created_at"));
                dept.setUpdatedAt(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return dept;
    }

    public List<Department> all() {
        List<Department> listDepartments = new ArrayList<Department>();
        String sql = "SELECT * FROM departments";
        try {
            con = cn.openConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                department.setCreatedAt(rs.getString("created_at"));
                department.setUpdatedAt(rs.getString("updated_at"));
                
                listDepartments.add(department);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listDepartments;
    }
}
