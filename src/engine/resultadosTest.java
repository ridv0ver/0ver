package src.engine;

import javax.swing.*;

import src.processor.dataBaseController;
import src.window.adminProfesor;
import src.window.constantes;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class resultadosTest extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JButton anterior;
    JLabel marca;
    JTable tablilla;
    public resultadosTest(){
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
        tablilla.setModel(m.resultadosTabla());
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
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        adminProfesor ventana = new adminProfesor();
        ventana.setVisible(true);
    }
    
}
