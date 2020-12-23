package src.engine.core;
/**
 * Clase abstracta que contiene el objeto Pregunta.
 * @author Roberto Ignacio
 */
public abstract class Pregunta { //begin Pregunta.java
    int peso;
    String text;
    //metodos publicos
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    /**
     * Este metodo setea el puntaje en una pregunta.
     * @param unPeso Valor del peso a ingresar en la pregunta en cuestión.
     */
    public void setPeso(int unPeso){
        this.peso = unPeso;
    }
    //--------------------------------------------------------------------------
    /**
     * Este método retorna el peso de una pregunta en cuestión.
     * @return int
     */
    public int getPeso(){
        return this.peso;
    }
    //--------------------------------------------------------------------------
    /**
     * Este método setea el enunciado en una pregunta.
     * @param unTexto Esta variable cuenta con el enunciado de la pregunta.
     */
    public void setText(String unTexto){
        this.text = unTexto;
    }
    //--------------------------------------------------------------------------
    /**
     * Este método retorna el enunciado de una pregunta.
     * @return String
     */
    public String getText(){
        return this.text;
    }
    /**
     * Este método fuerza el cierre de la aplicación en caso de necesitarlo.
     */
    public void fuerzaCierre(){
        System.out.println("le recomiendo que vuelva a estudiar.");
        System.exit(0);
    }
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------        
    //metodos abstractos
    /**
     * Este método se le entrega el enunciado de una pregunta y evalúa al usuario en cuestión, retorna un booleano verdadero en caso de correcto o false en caso contrario.
     * @param enunciado Se le entrega el enunciado de la pregunta en cuestión para imprimirlo fácilmente en pantalla
     * @return boolean  
     */
    public abstract boolean buscar(String enunciado);
}//end Pregunta.Java
