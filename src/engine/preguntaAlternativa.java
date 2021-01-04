package src.engine;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import src.engine.core.Exam;
import src.processor.coreController;
import src.window.adminAlumno;
import src.window.constantes;

public class preguntaAlternativa extends JFrame implements ActionListener {
    JTextArea enunciado;
    JButton a,b,c,d;
    String enunciadoS;
    JLabel marca;
    Exam unExamen;
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public preguntaAlternativa(String enunciadoPregunta, Exam unExam){
        this.unExamen = unExam;
        this.enunciadoS = enunciadoPregunta;
        setTitle("Over");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1200, 600);
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/icon2.png")).getImage());
        preguntaAlternativaCarga();
    }

    public void preguntaAlternativaCarga(){
         //marca
         constantes n = new constantes();
         marca = n.generaMarca();
         a = new JButton("A");
         b = new JButton("B");
         c = new JButton("C");
         d = new JButton("D");
         a.setBounds(200, 250, 100, 100);
         a.addActionListener(this);
         b.setBounds(350, 250, 100, 100);
         b.addActionListener(this);
         c.setBounds(200,400,100,100);
         c.addActionListener(this);
         d.setBounds(350,400,100,100);
         d.addActionListener(this);
         enunciado = new JTextArea(enunciadoS);
         enunciado.setBounds(25,25,1000,200);
         enunciado.setFont(new Font("Yu Gothic UI Semilight",Font.PLAIN,20));
         enunciado.setEditable(false);
         add(enunciado);
         add(a);
         add(b);
         add(c);
         add(d);
         add(marca);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==a){
            unExamen.sumaPuntaje(unExamen.evaluaPregunta("a"));
            dispose();
            coreController m = new coreController();
            unExamen.aumentaContador();
            if(unExamen.isFinal()==1){
                adminAlumno ventana = new adminAlumno(unExamen.getUsuario());
                ventana.setVisible(true);
            }else{
                m.cargaPreguntaVentana(unExamen.getContador(),unExamen);
            }
        }else if(e.getSource()==b){
            unExamen.sumaPuntaje(unExamen.evaluaPregunta("b"));
            dispose();
            coreController m = new coreController();
            unExamen.aumentaContador();
            if(unExamen.isFinal()==1){
                adminAlumno ventana = new adminAlumno(unExamen.getUsuario());
                ventana.setVisible(true);
            }else{
                m.cargaPreguntaVentana(unExamen.getContador(),unExamen);
            }
        }else if(e.getSource()==c){
            unExamen.sumaPuntaje(unExamen.evaluaPregunta("c"));
            dispose();
            coreController m = new coreController();
            unExamen.aumentaContador();
            if(unExamen.isFinal()==1){
                adminAlumno ventana = new adminAlumno(unExamen.getUsuario());
                ventana.setVisible(true);
            }else{
                m.cargaPreguntaVentana(unExamen.getContador(),unExamen);
            }
        }else if(e.getSource()==d){
            unExamen.sumaPuntaje(unExamen.evaluaPregunta("d"));
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
    
}
