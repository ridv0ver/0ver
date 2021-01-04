package src.window;

import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlumnoResultadosYPruebas extends JFrame implements ActionListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static final String ruta = "src/engine/data/pruebas";
    String usuario;
    JTable tablilla;
    JButton retornar;
    JLabel marca;
    public AlumnoResultadosYPruebas(String alumno) {
        this.usuario = alumno;
        setTitle("Over");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1200, 600);
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
        cargaComplementos();
    }

    private void cargaComplementos(){
        //marca
        constantes n = new constantes();
        marca = n.generaMarca();
        //tablilla
        tablilla = new JTable();
        tablilla.setBounds(25, 25, 500, 500);
        tablilla.setModel(leeArchivoPruebas(ruta));
        //boton retornar
        retornar = new JButton("Retornar menú anterior");
        retornar.setBounds(700,300,375,200);
        retornar.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,30));
        retornar.addActionListener(this);
        //carga de complementos
        add(tablilla);
        add(retornar);
        add(marca);
    }
    /*
     * public void leeFile(String nombreArchivo) throws IOException { BufferedReader
     * br = new BufferedReader(new FileReader(nombreArchivo)); String linea; Exam
     * unExamen = new Exam(); String enunciado, alternativaCorrecta; int
     * peso,contador; while((linea = br.readLine())!=null){
     * if(linea.startsWith(";P;a;")){ ArrayList String ArrayList = new
     * ArrayList(String); ArrayList.add("") enunciado = linea.substring(5);
     * SelecMulPregunta unaPregunta = new SelecMulPregunta(enunciado,ArrayList,0,0);
     * unExamen.agregaPregunta(unaPregunta);
     * 
     * }else if(linea.startsWith(";R;")){
     * 
     * }
     * 
     * } br.close(); }
     */
    public DefaultTableModel leeArchivoPruebas(String rutaFichero) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaFichero));
            String linea;
            String nombre;
            String[] registros = new String[1];
            String[] nombresColumnas = {"nombre Prueba"};
            DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
            while((linea=br.readLine())!=null){
                if(linea.startsWith(";N;")){
                    nombre = linea.substring(3);
                    registros[0] = nombre;
                    modelo.addRow(registros);

                }
            }
            br.close();
            return modelo;
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error papaaaaaaa "+e);
        }
        return null;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        adminAlumno ventana = new adminAlumno(usuario);
        ventana.setVisible(true);

    }
    
}
