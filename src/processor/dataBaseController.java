package src.processor;

import java.io.*;
import javax.swing.JOptionPane;

public class dataBaseController {
    private static final String rutaUsuarios = "src/engine/data/usuarios.txt";
    private int cantidadTotal;
    int cantidadProfesores;
    int cantidadAlumnos;

    public int conteoUsuarios(){
        File archivo;
        FileReader fr;
        BufferedReader br;
        cantidadTotal = 0;
        try {
            archivo = new File(rutaUsuarios);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            while((br.readLine())!=null){
                cantidadTotal=cantidadTotal+1;
            }
            System.out.println(cantidadTotal);           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error leyendo archivo\n"+e);
        }    
        return cantidadTotal;
    }
}
