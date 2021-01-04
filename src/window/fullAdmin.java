package src.window;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fullAdmin extends JFrame implements ActionListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JButton btnBorrar;
    JButton btnBorrar2;
    JButton btnBorrar3;
    JButton Salir;
    JLabel marca;
    public fullAdmin(){
        setTitle("Over");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1200, 600);
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/icon2.png")).getImage());
        cargarComplementos();
    }
    private void cargarComplementos(){
        //boton borrar resultados
        btnBorrar = new JButton("Borrar los resultados");
        btnBorrar.setBounds(25, 25, 500, 75);
        btnBorrar.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,30));
        btnBorrar.addActionListener(this);
        //boton borrar usuarios
        btnBorrar2 = new JButton("borrar los usuarios y contraseñas");
        btnBorrar2.setBounds(25, 150 , 500, 75);
        btnBorrar2.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,30));
        btnBorrar2.addActionListener(this);
        //boton borrar todo
        btnBorrar3 = new JButton("NUKE");
        btnBorrar3.setBounds(25, 275, 500, 75);
        btnBorrar3.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,30));
        btnBorrar3.addActionListener(this);
        //Salir
        Salir = new JButton("Salir");
        Salir.setBounds(25, 400, 500, 75);
        Salir.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,30));
        Salir.addActionListener(this);
        //marca
        constantes n = new constantes();
        marca = n.generaMarca();
        //carga de los complementos
        add(btnBorrar);
        add(btnBorrar2);
        add(btnBorrar3);
        add(marca);
        add(Salir);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Salir){
            dispose();
            ventanaPrincipal ventana = new ventanaPrincipal();
            ventana.setVisible(true);
        }
    }
    
}