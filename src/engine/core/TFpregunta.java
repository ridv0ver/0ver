package src.engine.core;
import java.util.Scanner;

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
    public boolean buscar(String enunciado) {
        System.out.println(enunciado);
        String respuesta;
        System.out.println("ingrese la sentencia que ud crea correcta entre t para verdadero y f para falso a continuación.");
        Scanner text = new Scanner(System.in);
        respuesta = text.nextLine();
        int contador = 0;
        while(respuesta.equalsIgnoreCase("t") == false && respuesta.equalsIgnoreCase("f") == false && contador<4){
            System.out.println("por favor ingrese una opción entre t o f.");
            text = new Scanner(System.in);
            respuesta = text.nextLine();
            contador = contador + 1;
        }
        if(contador>=4){
            fuerzaCierre();
        }
        if(respCorrecta.equalsIgnoreCase(respuesta)==true){
            System.out.println("Respuesta correcta!");
            text.close();
            return true;            
        }else{
            System.out.println("Respuesta erronea, la respuesta correcta era: "+respCorrecta);
            text.close();
            return false;
        }
    }
}//end TFpregunta.java 
