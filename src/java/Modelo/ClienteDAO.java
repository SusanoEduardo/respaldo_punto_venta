package Modelo;

import com.mysql.jdbc.PreparedStatement;
import config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
                
    public Cliente buscar(String dni){
        Cliente c= new Cliente();
        String sql = "select * from cliente where Dni="+dni;
        try {
            con=cn.conexion();
            ps=(PreparedStatement) con.prepareStatement(sql);            
            rs=ps.executeQuery();
               while (rs.next()) {
                   c.setId(rs.getInt(1));                   
                   c.setDni(rs.getString(2));
                   c.setNom(rs.getString(3));
                   c.setDir(rs.getString(4));
                   c.setEs(rs.getString(5)); 
            }
        } catch (Exception e) {
        }
        return c;
    }
    
    
    
     //  OPERACIONES CRUD
    
    public List listar() {
        String sql = "select * from cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            con = cn.conexion();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getInt(1));
                cl.setDni(rs.getString(2));
                cl.setNom(rs.getString(3));
                cl.setDir(rs.getString(4));
                cl.setEs(rs.getString(5));                
                lista.add(cl);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    
    
    
}
