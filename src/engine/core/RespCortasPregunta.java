package src.engine.core;
/**
 * Este clase alberga el tipo de pregunta de respuestas cortas y es una extensión de la clase Pregunta
 * @author Roberto Ignacio
 */
public class RespCortasPregunta extends Pregunta { //begin RespCortasPregunta.java
    String respCorrecta;
    //metodo constructor
    /**
     * Genera un objeto del tipo RespCortasPregunta 
     * @param enunciado Este String almacena el enunciado de la pregunta.
     * @param respuestaCorrecta Este String almacena la respuesta correcta de la pregunta.
     * @param puntaje Este entero almacena el peso de la pregunta.
     */
    public RespCortasPregunta(String enunciado, String respuestaCorrecta, int puntaje) {
        this.peso = puntaje;
        this.respCorrecta = respuestaCorrecta;
        this.text = enunciado;
        
    }
    
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
        return 1;
    }
    
}//end RespCortasPregunta.java
