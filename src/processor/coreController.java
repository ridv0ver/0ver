package src.processor;
//import src.engine.core.*;

import src.engine.preguntaAlternativa;
import src.engine.preguntaRespuestaCortas;
import src.engine.preguntaToF;
import src.engine.core.Exam;
import src.engine.core.Pregunta;
import src.engine.core.RespCortasPregunta;
import src.engine.core.SelecMulPregunta;
import src.engine.core.TFpregunta;
import javax.swing.*;

public class coreController extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Exam cargaExamenTesteo(Exam unExamen){
        TFpregunta unaPregunta = new TFpregunta("esta es la pregunta 1",true,1);
        RespCortasPregunta unaPregunta2 = new RespCortasPregunta("esta es la pregunta 2","respuesta",1);
        TFpregunta unaPregunta3 = new TFpregunta("el sol es negro",false,1);
        unExamen.setNombreExamen("examen de prueba");
        unExamen.agregaPregunta(unaPregunta);
        unExamen.agregaPregunta(unaPregunta2);
        unExamen.agregaPregunta(unaPregunta3);
        return unExamen;
    }

    public Exam cargaPruebaMatematicas(Exam unExamen){
        unExamen.setNombreExamen("prueba de matemáticas");

        TFpregunta unaPregunta1 = new TFpregunta("¿la raiz, de la raiz cuadrada de 6.561 es 9?",true,1);
        RespCortasPregunta unaPregunta2 = new RespCortasPregunta("el valor de x en la siguiente ecuación es de: \n x/2=81/k","162/k",2);
        SelecMulPregunta unaPregunta3 = new SelecMulPregunta("Si podemos llevar una caja a la vez, teniendo en cuenta que tenemos que cargar 20k de material, es más eficiente llevarlo en cajas de: \na.-1kg \nb.-10kg\nc.-5kg\nd.-6kg",null,1,1);
        RespCortasPregunta unaPregunta4 = new RespCortasPregunta("el menor número primo ","2", 1);
        TFpregunta unaPregunta5 = new TFpregunta("con una derivada podemos obtener detalles de una curva tales como su volumen",false,1);
        TFpregunta unaPregunta6 = new TFpregunta("una derivada se puede realizar en trazos incontinuos si hacemos arreglos de límite",false,2);
        SelecMulPregunta unaPregunta7 = new SelecMulPregunta("el valor de la siguiente derivada:f(x)=x-27/sqrt81 es:\na.-1 - 3 \nb.- 3\nc.- x - 3\nd.- 1",null,3,1);

        unExamen.agregaPregunta(unaPregunta1);
        unExamen.agregaPregunta(unaPregunta2);
        unExamen.agregaPregunta(unaPregunta3);
        unExamen.agregaPregunta(unaPregunta4);
        unExamen.agregaPregunta(unaPregunta5);
        unExamen.agregaPregunta(unaPregunta6);
        unExamen.agregaPregunta(unaPregunta7);
        return unExamen;
    }

    public Exam cargaPruebaQuimica(Exam unExam){
        unExam.setNombreExamen("prueba de química");
        TFpregunta pregunta1 = new TFpregunta("el metano tiene 2 carbonos",false,1);
        RespCortasPregunta pregunta2 = new RespCortasPregunta("la fórmula CH4 corresponde al compuesto de nombre ", "metano", 1);
        RespCortasPregunta pregunta3 = new RespCortasPregunta("¿cuántos isómeros tiene un decano","75",2);
        TFpregunta pregunta4 = new TFpregunta("un nonano cuenta con 9 carbonos",true,1);
        SelecMulPregunta pregunta5 = new SelecMulPregunta("cuál de los siguientes es un metal:\na.-oro\nb.-silicio\nc.-estaño\nd.-carbono",null,0,1);
        SelecMulPregunta pregunta6 = new SelecMulPregunta("Cual es el símbolo químico del calcio:\na.-Cc\nb.-Cl\nc.-Ca\nd.-Co",null,2,1);
        TFpregunta pregunta7 = new TFpregunta("el boro es un metal",false,1);
        RespCortasPregunta pregunta8 = new RespCortasPregunta("qué elemento químico abunda en una estrella joven","hidrógeno",1);
        unExam.agregaPregunta(pregunta1);
        unExam.agregaPregunta(pregunta2);
        unExam.agregaPregunta(pregunta3);
        unExam.agregaPregunta(pregunta4);
        unExam.agregaPregunta(pregunta5);
        unExam.agregaPregunta(pregunta6);
        unExam.agregaPregunta(pregunta7);
        unExam.agregaPregunta(pregunta8);
        return unExam;
    }

    public void cargaPreguntaVentana(int indexPregunta, Exam unExamen){
        Pregunta unaPregunta = unExamen.retornaPregunta(indexPregunta);
        if(unaPregunta.retornaTipo()==1){
            dispose();
            preguntaRespuestaCortas ventana = new preguntaRespuestaCortas(unaPregunta.getText(),unExamen);
            ventana.setVisible(true);
        }else if(unaPregunta.retornaTipo()==2){
            dispose();
            preguntaAlternativa ventana = new preguntaAlternativa(unaPregunta.getText(),unExamen);
            ventana.setVisible(true);
        }else if(unaPregunta.retornaTipo()==3){
            dispose();
            preguntaToF ventana = new preguntaToF(unaPregunta.getText(),unExamen);
            ventana.setVisible(true);
        }
    }

    public void lanzaExamen(String usuarioActual,int examen){
        if(examen==1){
            Exam unExamen = new Exam();
            unExamen.setUsuario(usuarioActual);
            cargaPruebaMatematicas(unExamen);
            cargaPreguntaVentana(0, unExamen);
        }
        if(examen ==2){
            Exam unExamen = new Exam();
            unExamen.setUsuario(usuarioActual);
            cargaPruebaQuimica(unExamen);
            cargaPreguntaVentana(0, unExamen);
        }
        if(examen ==3){
            Exam unExamen = new Exam();
            unExamen.setUsuario(usuarioActual);
            cargaExamenTesteo(unExamen);
            cargaPreguntaVentana(0, unExamen);
        }
    }
}
