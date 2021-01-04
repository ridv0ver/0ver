package src.window;
import src.processor.dataBaseController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
public class resultadosAlumno extends JFrame implements ActionListener {
   
    /**
     *
     */
    String usuario;
    private static final long serialVersionUID = 1L;
    JButton anterior;
    JLabel marca;
    JTable tablilla;
    public resultadosAlumno(String alumno){
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
        // tablla 
        tablilla = new JTable();
        tablilla.setBounds(25, 25, 500, 500);
        dataBaseController m = new dataBaseController();
        //System.out.println(usuario);
        tablilla.setModel(m.resultadosTablaUsuario(usuario));
        //marca
        constantes n = new constantes();
        marca = n.generaMarca();
        //boton retornar menu anterior
        anterior = new JButton("Retornar menú anterior");
        anterior.setBounds(700,300,375,200);
        anterior.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,30));
        anterior.addActionListener(this);
        //carga de los complementos
        add(tablilla);
        add(anterior);
        add(marca);
    }

    public String getUsuario(){
        return(usuario);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        adminAlumno ventana = new adminAlumno(usuario);
        ventana.setVisible(true);
    }    
}
