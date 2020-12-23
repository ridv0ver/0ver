package src.engine.core;

/**
 * Esta clase alberga los métodos relacionados con la evaluación de las preguntas.
 * @author Roberto Ignacio
 */
public class Exam {//begin Exam.java
    Pregunta[] examen;
    int MAX_ARRAY = 10;
    int nPreguntas;
    int puntaje_MAX;
    
    //metodo constructor
    /**
     * Genera un objeto de tipo Exam con su número de preguntas y puntaje máximo en 0 así como el arreglo de preguntas vacío.
     */
    public Exam() {
        examen = new Pregunta[MAX_ARRAY];
        nPreguntas = 0;
        puntaje_MAX = 0;
    }
    //metodos publicos
    /**
     * Este método agrega la pregunta entregada al final del arreglo de preguntas examen[].
     * @param unaPregunta Esta pregunta será la añadida al final del examen.
     */
    public void agregaPregunta(Pregunta unaPregunta){
        examen[nPreguntas]= unaPregunta;
        nPreguntas = nPreguntas + 1;
        puntaje_MAX = puntaje_MAX + unaPregunta.getPeso();    
    }
    /**
     * Este método toma el examen[] almacenado en un objeto de tipo Exam y lo evalúa al usuario.
     * @return int
     */
    public int darExam(){
        double puntajeFinal = 0;
        int contador=0;
        int contadorCorrectas = 0;
        while(contador<nPreguntas){
            if(examen[contador].buscar(examen[contador].getText())==true){
                puntajeFinal = puntajeFinal + examen[contador].getPeso();
                //System.out.println(puntajeFinal);
                contador = contador + 1;
                System.out.println("\n");
                contadorCorrectas = contadorCorrectas+1;
            }else{
                //System.out.println(puntajeFinal);
                contador = contador + 1;
                System.out.println("\n");
            }
        }
        int porcentaje = (int) ((puntajeFinal/puntaje_MAX)*100);
        System.out.println(contadorCorrectas+" Respuestas correctas de "+nPreguntas);
        return porcentaje;
    }
}//end Exam.java
