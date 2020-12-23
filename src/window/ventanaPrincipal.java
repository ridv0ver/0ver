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
        //marca
          marca = new JLabel("Over 2020 v0.1");
          marca.setBounds(1075,500,100,100);
          marca.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,15));  
        //carga de complementos a la ventana  
          add(marca);
          add(botonprofesor);
          add(botonalumno);
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
        }
    }
    
}
