package src.engine.core;

/**
 * Esta clase alberga el tipo de pregunta verdadero y falso y es una extensión de la clase original Pregunta
 * @author Roberto Ignacio
 */
public class TFpregunta extends Pregunta { //begin TFpregunta.java
    String respCorrecta;
    //--------------------------------------------------------------------------
    //metodo constructor
    /**
     * Genera un nuevo objeto de tipo TFpregunta.
     * @param enunciado Este string contiene el enunciado a almacenar en la pregunta.
     * @param respuestaCorrecta Este booleano almacena la respuesta correcta a la pregunta
     * @param puntaje  Este entero almacena el peso de la pregunta
     */
    public TFpregunta(String enunciado, Boolean respuestaCorrecta, int puntaje) {
        if(respuestaCorrecta == true){
            respCorrecta = "t";
        }else{
            respCorrecta = "f";
        }
        this.text = enunciado;
        this.peso = puntaje;
    }
    //--------------------------------------------------------------------------
    //metodos heredados
    @Override
    public boolean buscar(String respuesta) {
        if(respCorrecta.equalsIgnoreCase(respuesta)==true){
            System.out.println("Respuesta correcta!");
            return true;            
        }else{
            System.out.println("Respuesta erronea, la respuesta correcta era: "+respCorrecta);
            return false;
        }
    }

    @Override
    public int retornaTipo() {
        return 3;
    }
}//end TFpregunta.java 
