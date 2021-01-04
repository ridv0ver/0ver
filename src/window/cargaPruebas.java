package src.window;

import javax.swing.*;

import src.processor.coreController;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cargaPruebas extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JButton btn1,btn2,btn3;
    JLabel marca;
    String usuario;
    public cargaPruebas(String alumno){
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
        //boton prueba matemáticas
        btn1 = new JButton("Prueba matemáticas");
        btn1.setBounds(25,25,500,75);
        btn1.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,30));
        btn1.addActionListener(this);
        //boton prueba química
        btn2 = new JButton("Prueba química");
        btn2.setBounds(25,150,500,75);
        btn2.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,30));
        btn2.addActionListener(this);
        //boton prueba de testeo
        btn3 = new JButton("Examen de prueba");
        btn3.setBounds(25,275,500,75);
        btn3.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,30));
        btn3.addActionListener(this);
        //carga de complementos
        add(btn1);
        add(btn2);
        add(btn3);
        add(marca);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn3){
            dispose();
            coreController m = new coreController();
            m.lanzaExamen(usuario,3);
        }else if(e.getSource()==btn1){
            dispose();
            coreController m = new coreController();
            m.lanzaExamen(usuario,1);
        }else if(e.getSource()==btn2){
            dispose();
            coreController m = new coreController();
            m.lanzaExamen(usuario, 2);
        }

    }
    
}
