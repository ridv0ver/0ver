package src.window;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaPrincipal extends JFrame implements ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JButton botonprofesor;
    JButton botonalumno;
    JButton debug;
    JLabel marca;

    public ventanaPrincipal(){
        setTitle("Over");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1200, 600);
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
        cargarComplementos();
    }
    /**
     *
     */
    private void cargarComplementos(){
        //botón profesor
          botonprofesor = new JButton("Profesor");
          botonprofesor.setBounds(50,50,800,150);
          botonprofesor.setFont(new Font("Yu Gothic UI Semilight",Font.BOLD,110));
          botonprofesor.setForeground(Color.WHITE);
          botonprofesor.setBackground(Color.RED);
          botonprofesor.addActionListener(this);
          //botonprofesor.setMixingCutoutShape(Shape.curve);
        //botón alumno
          botonalumno = new JButton("Alumno");
          botonalumno.setBounds(50,250,800,150);
          botonalumno.setFont(new Font("Yu Gothic UI Semilight",Font.BOLD,110));
          botonalumno.setForeground(Color.WHITE);
          botonalumno.setBackground(Color.RED);
          botonalumno.addActionListener(this);
        //boton debug
        debug = new JButton("dev");
        debug.setBounds(500, 500, 200, 50);
        debug.addActionListener(this);
        debug.setFont(new Font("Yu Gothic UI Semilight",Font.BOLD,20));
        //marca
        constantes n = new constantes();
        marca = n.generaMarca();  
        //carga de complementos a la ventana  
          add(marca);
          add(botonprofesor);
          add(botonalumno);
          add(debug);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonprofesor){
            dispose();
            profesorIniciaSesion ventana = new profesorIniciaSesion();
            ventana.setVisible(true);
        }else if(e.getSource()==botonalumno){
            dispose();
            alumnoIniciaSesion ventana = new alumnoIniciaSesion();
            ventana.setVisible(true);
        }else if(e.getSource()==debug){
            dispose();
            ventanaDebug ventana = new ventanaDebug();
            ventana.debugger();
        }
    }
    
}
