package Modelo;

import com.mysql.jdbc.PreparedStatement;
import config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductoDAO {
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
        String sql = "select * from producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.conexion();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto pr = new Producto();
                pr.setId(rs.getInt(1));
                pr.setNom(rs.getString(2));
                pr.setPre(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
                pr.setEstado(rs.getString(5));                
                lista.add(pr);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    
    
    
     public int agregar(Producto p){
        String sql = "insert into producto (Nombres, Precio, Stock, Estado) values(?,?,?,?)";
        try {
            con=cn.conexion();
            ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setString(1,p.getNom());
            ps.setDouble(2,p.getPre());
            ps.setInt(3,p.getStock());
            ps.setString(4,p.getEstado());            
              ps.executeUpdate();               
        } catch (Exception e) {
        }
        return  r;        
    }
    
    
    
     public Producto listarId(int id){
        Producto pr= new Producto();
        String sql = "select * from producto where IdProducto="+id;
        try {
            con=cn.conexion();
            ps=(PreparedStatement) con.prepareStatement(sql);            
             rs=ps.executeQuery();
               while (rs.next()) {
                   pr.setId(rs.getInt(1));
                   pr.setNom(rs.getString(2));
                   pr.setPre(rs.getDouble(3));
                   pr.setStock(rs.getInt(4));
                   pr.setEstado(rs.getString(5));                                      
            }
        } catch (Exception e) {
        }
        return  pr;
    }
     
     
      public int actualizar(Producto em){
        String sql = "update producto set Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
        try {
            con=cn.conexion();
            ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setString(1,em.getNom());
            ps.setDouble(2,em.getPre());
            ps.setInt(3,em.getStock());
            ps.setString(4,em.getEstado());            
            ps.setInt(5,em.getId());
              ps.executeUpdate();               
        } catch (Exception e) {
        }
        return  r;        
    }
        
    
    public void delete(int id){
        String sql = "delete from producto where IdProducto="+id;
       try {
            con=cn.conexion();
            ps=(PreparedStatement) con.prepareStatement(sql);                        
              ps.executeUpdate();               
        } catch (Exception e) {
        }
    }
    
}
