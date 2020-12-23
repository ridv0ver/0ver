package src.window;

import java.awt.*;
//import src.processor.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;

public class registraCuenta extends JFrame implements ActionListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // JRadioButton PoA1,PoA2;
    JLabel texto1, texto2, texto3;
    JTextField usuario;
    JPasswordField clave;
    JPasswordField confirmacionclave;
    JButton boton;
    JLabel marca;
    public registraCuenta(){
        setTitle("Over");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1200, 600);
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
        cargarComplementos();
    }
    private void cargarComplementos(){
        //copiado del código "Profesor inicia sesión"
        texto1 = new JLabel("Usuario");
        texto1.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,30));
        texto2 = new JLabel("Clave");
        texto2.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,30));
        texto1.setBounds(25,100,400,50);
        texto2.setBounds(25,250,400,50);
        //usuario
        usuario = new JTextField();
        usuario.setBounds(25,50,400,50);
        //clave
        clave = new JPasswordField();
        clave.setBounds(25,200,400,50);
        //fin codigo copiado
        //confirmación de la clave
        confirmacionclave = new JPasswordField();
        confirmacionclave.setBounds(25,350,400,50);
        //text 3
        texto3= new JLabel("Confirmación de la clave!");
        texto3.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,30));
        texto3.setBounds(25,400,400,50);
        //boton
        boton = new JButton("Crear!");
        boton.setBounds(800,300,300,200);
        boton.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,40));
        boton.addActionListener(this);
        
        /*
        PoA1 = new JRadioButton("Profesor");
        PoA1.setBounds(25,25,100,100);
        PoA2 = new JRadioButton("Alumno");
        PoA2.setBounds(25,100,100,100);*/
        //marca
        marca = new JLabel("Over 2020 v0.1");
        marca.setBounds(1075,500,100,100);
        marca.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,15));  
        //carga de complementos a la ventana
        //add(PoA1);
        //add(PoA2);
        add(marca);
        add(texto1);
        add(texto2);
        add(usuario);
        add(clave);
        add(confirmacionclave);
        add(texto3);
        add(boton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            dispose();
            ventanaPrincipal ventana = new ventanaPrincipal();
            ventana.setVisible(true);
        }catch(Exception err){
        
        }

    }
}
