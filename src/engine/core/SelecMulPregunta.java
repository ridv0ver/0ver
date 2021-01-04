package src.engine.core;
import java.util.ArrayList;

/**
 * Esta clase alberga el tipo de pregunta de selección múltiple y es una extensión de la clase Pregunta.
 * @author Roberto Ignacio
 */
public class SelecMulPregunta extends Pregunta{ //begin SelecMulPregunta.java
    ArrayList<String> conjuntoSolucion;
    int respuestaCorrecta;
    String alternativaCorrecta;
    //metodo constructor
    /**
     * Genera un nuevo objeto de tipo SelecMulPregunta. 
     * @param enunciado String que almacena el enunciado de la pregunta.
     * @param conjuntoRespuestas ArrayList que almacena el conjunto solución de posibles respuestas.
     * @param respCorrecta Index de la posición en el arraylist de la respuesta correcta.
     * @param puntaje Entero que almacena el peso de la pregunta.
     */
    public SelecMulPregunta(String enunciado, ArrayList<String> conjuntoRespuestas, int respCorrecta, int puntaje) {
        this.text = enunciado;
        this.conjuntoSolucion = conjuntoRespuestas;
        this.respuestaCorrecta = respCorrecta;
        this.peso = puntaje;
        this.alternativaCorrecta = conversorAlternativa.conversor(respuestaCorrecta+1);
    }
    /**
     * Este método compara la respuesta del usuario con las posibles dentro del conjunto solución, retorna true en caso de estar dentro del conjunto, false caso contrario.
     * @param respuesta String que almacena la respuesta del usuario
     * @return boolean
     */
    public boolean esValido(String respuesta){
        int contador = 1;
        while(contador<=conjuntoSolucion.size()){
            if(conversorAlternativa.conversor(contador).equalsIgnoreCase(respuesta) == true){
                return true;
            }else{
                contador= contador + 1;
            }
        }
        return false;
    }
    //metodo heredado
    @Override
    public boolean buscar(String respuesta) {
        if(alternativaCorrecta.equalsIgnoreCase(respuesta)==true){
            System.out.println("Respuesta correcta!");
            return true;
        }else{
            System.out.println("Respuesta errónea,la alternativa correcta era: "+alternativaCorrecta);
            return false;
        }
    }

    @Override
    public int retornaTipo() {
        return 2;
    }
    
}//end SelecMulPregunta.java
