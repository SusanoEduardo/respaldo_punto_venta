package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    Connection con;
    //String url  = "jdbc:mysql://localhost/pruebas_bd_ventas";
    String url  = "jdbc:mysql://localhost/bd_ventas";
    String user = "root"; 
    String pass = "";           
       public Connection conexion(){
                  try{
          Class.forName("com.mysql.jdbc.Driver");          
          con=DriverManager.getConnection(url, user, pass);       
     if(con!=null){
           System.out.println("Conexión abierta");
      }
       }catch(ClassNotFoundException CNE){
          JOptionPane.showMessageDialog(null,"CLASS NOT FOUND EXCEPTION"+CNE);
          System.err.print(CNE.getMessage());
                        }
                  finally{
            return con;
       }
       }
       public void getClose(){
        try {
            con.close();
           System.out.println("Conexión cerrada");
        } catch (SQLException SQL) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "SQL EXCEPTION"+SQL);
        }
    }
    
}
