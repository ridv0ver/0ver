package src.engine;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import src.engine.core.Exam;
import src.processor.coreController;
import src.window.adminAlumno;
import src.window.constantes;

public class preguntaRespuestaCortas extends JFrame implements ActionListener{
    JLabel enunciado;
    JTextField respuesta;
    String enunciadoS;
    JLabel marca;
    JButton continua;
    Exam unExamen;
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    public preguntaRespuestaCortas(String enunciadoPregunta, Exam unExam){
        this.unExamen = unExam;
        this.enunciadoS = enunciadoPregunta;
        setTitle("Over");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1200, 600);
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/icon2.png")).getImage());
        cargaDatos();
    }
    public void cargaDatos(){
        enunciado = new JLabel(enunciadoS);
        enunciado.setBounds(25,25,1000,250);
        enunciado.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,20));
        respuesta = new JTextField();
        respuesta.setBounds(25,350,400,200);
        constantes n = new constantes();
        marca = n.generaMarca();
        continua = new JButton("continuar");
        continua.setBounds(900,300,200,200);
        continua.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,35));
        continua.addActionListener(this);
        add(marca);
        add(respuesta);
        add(enunciado);
        add(continua);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        unExamen.sumaPuntaje(unExamen.evaluaPregunta(respuesta.getText()));
        dispose();
        coreController m = new coreController();
        unExamen.aumentaContador();
        if(unExamen.isFinal()==1){
            adminAlumno ventana = new adminAlumno(unExamen.getUsuario());
            ventana.setVisible(true);
        }else{
            m.cargaPreguntaVentana(unExamen.getContador(),unExamen);    
        }
    }
    
}
