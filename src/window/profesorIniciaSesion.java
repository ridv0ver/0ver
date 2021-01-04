package src.window;

import javax.swing.*;
import src.processor.dataBaseController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class profesorIniciaSesion extends JFrame implements ActionListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JTextField usuario;
    JPasswordField clave;
    JLabel texto1, texto2;
    JButton creaCuenta;
    JButton continuar;
    JLabel marca;
    JButton retornar;

    public profesorIniciaSesion(){
        setTitle("Over");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1200, 600);
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
        cargarComplementos();
    }
    private void cargarComplementos(){
        //texto 1 y 2
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
        //boton continuar
        continuar = new JButton("Continuar");
        continuar.setBounds(900,300,200,200);
        continuar.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,35));
        continuar.addActionListener(this);
        //boton creaCuenta
        creaCuenta = new JButton("¿no está registrado? hágalo aquí!");
        creaCuenta.setBounds(25,450,500,50);
        creaCuenta.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,30));
        creaCuenta.addActionListener(this);
        //marca
        constantes n = new constantes();
        marca = n.generaMarca();
        //boton retornar
        retornar = new JButton("retornar");
        retornar.setBounds(25,300,300,50);
        retornar.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,30));
        retornar.addActionListener(this);
        //carga de complementos a la ventana
        add(retornar);
        add(creaCuenta);
        add(continuar);
        add(texto1);
        add(texto2);
        add(clave);
        add(usuario);
        add(marca);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==creaCuenta){
            dispose();
            registraCuenta ventana = new registraCuenta(1);
            ventana.setVisible(true);
        }else if(e.getSource()==continuar){
            dataBaseController m = new dataBaseController();
            if(m.isValid(usuario.getText(), clave.getText(),1)==1){
                //operación exitosa
                dispose();
                adminProfesor ventana = new adminProfesor();
                ventana.setVisible(true);
            }
        }else if(e.getSource()==retornar){
            dispose();
            ventanaPrincipal ventana = new ventanaPrincipal();
            ventana.setVisible(true);
        }

    }

}
