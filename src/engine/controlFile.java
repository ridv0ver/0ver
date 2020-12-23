package src.engine;

import java.io.*;
import javax.swing.JOptionPane;


public class controlFile {
    private static final String rutaUsuarios = "src/engine/data/usuarios.txt";
    private static final String rutaContrasenas = "src/engine/data/contraseñas.txt";

    public void readUserList(){
        File archivo;
        FileReader fr;
        BufferedReader br;
        try {
            archivo = new File(rutaUsuarios);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String buffer;
            while((buffer = br.readLine())!=null){
                System.out.println(buffer);
            }           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error leyendo archivo\n"+e);
        }
    }

    public void readPasswordList(){
        File archivo;
        FileReader fr;
        BufferedReader br;
        try {
            archivo = new File(rutaContrasenas);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String buffer;
            while((buffer = br.readLine())!=null){
                System.out.println(buffer);
            }           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error leyendo archivo\n"+e);
        }
    }
}
