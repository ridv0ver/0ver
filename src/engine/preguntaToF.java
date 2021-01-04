package src.engine;

import javax.swing.*;

import src.engine.core.Exam;
import src.processor.coreController;
import src.window.adminAlumno;
import src.window.constantes;
import src.window.ventanaPrincipal;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class preguntaToF extends JFrame implements ActionListener {
    JLabel enunciado;
    JButton T,F;
    String enunciadoS;
    JLabel marca;
    Exam unExamen; 
    //int preguntaActual;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public preguntaToF(String enunciadoPregunta, Exam unExam){
        this.unExamen = unExam;
        this.enunciadoS = enunciadoPregunta;
        setTitle("Over");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1200, 600);
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/icon2.png")).getImage());
        PreguntaToF();
    }  
    public void PreguntaToF(){
        //marca
        constantes n = new constantes();
        marca = n.generaMarca();
        T = new JButton("V");
        F = new JButton("F");
        T.setBounds(200, 350, 100, 100);
        T.addActionListener(this);
        F.setBounds(400, 350, 100, 100);
        F.addActionListener(this);
        enunciado = new JLabel(enunciadoS);
        enunciado.setBounds(25,25,1000,250);
        enunciado.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,20));
        add(enunciado);
        add(T);
        add(F);
        add(marca);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==T){
            unExamen.sumaPuntaje(unExamen.evaluaPregunta("t"));
            dispose();
            coreController m = new coreController();
            unExamen.aumentaContador();
            if(unExamen.isFinal()==1){
                adminAlumno ventana = new adminAlumno(unExamen.getUsuario());
                ventana.setVisible(true);
            }else{
                m.cargaPreguntaVentana(unExamen.getContador(),unExamen);
            }
        }else if(e.getSource()==F){
            unExamen.sumaPuntaje(unExamen.evaluaPregunta("f"));
            dispose();
            coreController m = new coreController();
            unExamen.aumentaContador();
            if(unExamen.isFinal()==1){
                ventanaPrincipal ventana = new ventanaPrincipal();
                ventana.setVisible(true);
            }else{
                m.cargaPreguntaVentana(unExamen.getContador(),unExamen);
            }
        }
    }
    
}