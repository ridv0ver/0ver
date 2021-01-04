package src.processor;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import src.engine.databaseMysql;

public class dataBaseController {
    //private static final String rutaUsuarios = "src/engine/data/usuarios.txt";
    int cantidadTotal;
    int cantidadProfesores;
    int cantidadAlumnos;
    private static String adminUser = "admin";
    private static String adminPassword = "admin";

    public int isAdmin(String user, String password){
        if(user.equalsIgnoreCase(adminUser)&&password.equalsIgnoreCase(adminPassword)){
            return 1;
        }else{
            return 0;
        }        
    }

    public int isValid(String user, String password, int PoA){
        if(isAdmin(user,password)==1){
            return 1;
        }
        databaseMysql m = new databaseMysql();
        try {
            ResultSet rs;
            Statement stm = (Statement) m.generaConexion().createStatement();
            rs = stm.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                if(rs.getString(2).equalsIgnoreCase(user)&&rs.getString(3).equalsIgnoreCase(password)&&PoA==rs.getInt(4)){
                    return 1;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error SQL "+e);
        }
        return 0;
    }

    public void agregaUsuario(String nombre, String clave, int PoA){
        databaseMysql m = new databaseMysql();
        try {
            int id = cuentaTotalUsuarios() + 1;
            PreparedStatement rs = m.generaConexion().prepareStatement("INSERT INTO usuarios VALUES (?,?,?,?)");
            rs.setInt(1, id);
            rs.setString(2, nombre);
            rs.setString(3, clave);
            rs.setInt(4, PoA);
            rs.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error SQL "+e);
        }
    }

    public int cuentaTotalUsuarios(){
        databaseMysql m = new databaseMysql();
        cantidadTotal = 0;
        try{
        ResultSet rs;
            Statement stm = (Statement) m.generaConexion().createStatement();
            rs = stm.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                cantidadTotal = cantidadTotal+1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error contando usuarios "+e);
        }
        return cantidadTotal;
    }
    public int cuentaTotalResultados(){
        databaseMysql m = new databaseMysql();
        cantidadTotal = 0;
        try{
        ResultSet rs;
            Statement stm = (Statement) m.generaConexion().createStatement();
            rs = stm.executeQuery("SELECT * FROM resultados");
            while(rs.next()){
                cantidadTotal = cantidadTotal+1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error contando usuarios "+e);
        }
        return cantidadTotal;
    }
    public int cuentaProfesores(){
        cantidadProfesores = 0;
        databaseMysql m = new databaseMysql();
        try{
        ResultSet rs;
            Statement stm = (Statement) m.generaConexion().createStatement();
            rs = stm.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                if(rs.getInt(4)==1){
                    cantidadProfesores = cantidadProfesores + 1;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error contando usuarios "+e);
        }    
        return cantidadProfesores;
    }

    public int cuentaAlumnos(){
        cantidadProfesores = 0;
        databaseMysql m = new databaseMysql();
        try{
        ResultSet rs;
            Statement stm = (Statement) m.generaConexion().createStatement();
            rs = stm.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                if(rs.getInt(4)==0){
                    cantidadProfesores = cantidadProfesores + 1;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error contando usuarios "+e);
        }    
        return cantidadProfesores;
    }

    public DefaultTableModel resultadosTabla(){
        Statement st;
        ResultSet rs;
        databaseMysql m = new databaseMysql();
        String []  nombresColumnas = {"id","Usuario","nombrePrueba","porcentaje"};
        String [] registros = new String[4];
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas); 
         try {
             st=m.generaConexion().createStatement();
         String sql = "SELECT * FROM resultados";
             rs=st.executeQuery(sql);
             while(rs.next()){
                 registros[0] = rs.getString(1);
                 registros[1] = rs.getString(2);
                 registros[2] = rs.getString(3);
                 registros[3] = rs.getString(4);
                 modelo.addRow(registros);
             }
         } catch (Exception e) {
         }
         return modelo;
    }

    public DefaultTableModel resultadosTablaUsuario(String usuario){
        Statement st;
        ResultSet rs;
        databaseMysql m = new databaseMysql();
        String []  nombresColumnas = {"id","Usuario","nombrePrueba","porcentaje"};
        String [] registros = new String[4];
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas); 
         try {
             st=m.generaConexion().createStatement();
         String sql = "SELECT * FROM resultados WHERE Usuario = '"+usuario+"'";
             rs=st.executeQuery(sql);
             while(rs.next()){
                 registros[0] = rs.getString(1);
                 registros[1] = rs.getString(2);
                 registros[2] = rs.getString(3);
                 registros[3] = rs.getString(4);
                 modelo.addRow(registros);
             }
         } catch (Exception e) {
         }
         return modelo;
    }

}
