package src.window;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminAlumno extends JFrame implements ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    String usuario;
    JButton btn1, btn2, btn3, btn4;
    JButton salir;
    JLabel marca;
    
    public adminAlumno(String nombreUsuario){
        this.usuario = nombreUsuario;
        setTitle("Over");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1200, 600);
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
        cargarComplementos();
    }
    private void cargarComplementos(){
        //btn1 ver las evaluaciones
        btn1 = new JButton("Ver evaluaciones");
        btn1.setBounds(25,25,500,75);
        btn1.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,30));
        btn1.addActionListener(this);
        //btn2 realiza evaluacion
        btn2 = new JButton("realiza evaluación");
        btn2.setBounds(25,150,500,75);
        btn2.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,30));
        btn2.addActionListener(this);
        //btn3 modifica evaluación
        btn3 = new JButton("ver resultados evaluaciones");
        btn3.setBounds(25,275,500,75);
        btn3.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,30));
        btn3.addActionListener(this);
        //boton para cerrar la sesión
        salir = new JButton("Salir!");
        salir.setBounds(800,300,300,200);
        salir.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,40));
        salir.addActionListener(this);
        //marca
        constantes n = new constantes();
        marca = n.generaMarca();
        //cargar los complementos a la ventana
        add(btn1);
        add(btn2);
        add(btn3);
        add(marca);
        add(salir);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==salir){//volvemos al principio
            dispose();
            ventanaPrincipal ventana = new ventanaPrincipal();
            ventana.setVisible(true);
        }else if(e.getSource()==btn2){
            dispose();
            cargaPruebas ventana = new cargaPruebas(usuario);
            ventana.setVisible(true);
        }else if(e.getSource()==btn1){
            dispose();
            AlumnoResultadosYPruebas ventana = new AlumnoResultadosYPruebas(usuario);
            ventana.setVisible(true);
        }else if(e.getSource()==btn3){
            //System.out.println(usuario);
            dispose();
            resultadosAlumno ventana = new resultadosAlumno(getUsuario());
            ventana.setVisible(true);
        }
    }
    private String getUsuario(){
        return usuario;
    }
}

